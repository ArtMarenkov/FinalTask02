package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class HeadphonesPage {

    @FindBy(xpath = "//div[@class = 'tamef']") // Путь к общему содержимому формы
    WebElement mainform;

    @FindBy(css = "input[id='glpricefrom']") // //Путь к полю "Цена от"
    WebElement pricefrom; // цена от

    @FindBy(xpath = "//div/span[text() = 'Beats']") //Путь к полю производитель = "Beats"
    WebElement beats;

    @FindBy(xpath = "//button//span[contains(text(),'48')]") //Путь к полю количества элементов к выдаче
    public WebElement shownItems;

    @FindBy(xpath = "//article")
    public List<WebElement> countShownItems;

    @FindBy(xpath = "//article[1]")
    public WebElement firstElement;

    @FindBy(xpath = "//article[1]//a/span")
    public WebElement firstElementName;

    @FindBy(xpath = "//input[@id = 'header-search']")
    public WebElement searchRow;

    @FindBy(xpath = "//button[@type = 'submit']")
    public WebElement searchButton;

    @FindBy(xpath = "(//div[@data-zone-name = 'snippetList']/article)[1]")
    public WebElement firstElementAfterSearch;

    public void beatsClick() {  //Выбор производителя = "Beats"
        beats.click();
    }

    public int getCountItems() {
        return countShownItems.size();
    }

    public String getFirstElementName() {
        return firstElementName.getText();
    }

    public void search(String text) {
        searchRow.sendKeys(text);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public HeadphonesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void setFilter(String price) {
        pricefrom.sendKeys(price);
    }

    public String getActualFirstElementName() {
        String text0 = firstElementAfterSearch.findElements(By.xpath(".//a[@title]/span")).stream().map(element -> element.getText()).collect(Collectors.joining());
        return text0;
    }

}
