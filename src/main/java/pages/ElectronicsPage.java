package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElectronicsPage {

    @FindBy(xpath = "//div/div/a[contains(text(),'Наушники и Bluetooth-гарнитуры')]") // //Путь к кнопке "Наушники и Bluetooth-гарнитуры"
    public WebElement headphonesButton;

    public ElectronicsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public void electronicsClick () {
        headphonesButton.click();
    }

}
