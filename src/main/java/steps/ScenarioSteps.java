package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import util.TestService;

public class ScenarioSteps {

    TestService testService = new TestService();{
        testService.getInitDriver().get(testService.getBaseURL());
    }
    private WebDriver driver = testService.getInitDriver();
    private MainSteps mainSteps;
    private MarketSteps marketSteps;
    private ElectronicsSteps electronicsSteps;
    private HeadphonesSteps headphonesSteps;

    @When("^выбран сервис Маркет$")
    public void stepMarketMenu() {
        mainSteps = new MainSteps();
        mainSteps.stepMarketMenu();
    }

    @When("^выбрана категория Электроника$")
    public void stepElectronic() {
        marketSteps = new MarketSteps();
        marketSteps.stepElectonics();
    }

    @When("^выбрана категория Наушники")
    public void stepHeadphonesButtonClick() {
        electronicsSteps = new ElectronicsSteps();
        electronicsSteps.stepHeadphonesButtonClick();
    }


    @When("^установлен фильтра по цене =\"(.+)\"$")
    public void setFilterStep(String menuItem) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        headphonesSteps = new HeadphonesSteps();
        headphonesSteps.setFilter(menuItem);
    }

    @When("^установлен производитель Beats")
    public void beatsChoose() {
        headphonesSteps.beatsChoose();
    }

    @When("^количество элементов на странице\"(.+)\"$")
    public void checkItemsCount (int count) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        headphonesSteps.checkItemCount(count);
    }

    @Then("^наименование найденного товара соответствует запомненному значению$")
    public void checkFirstItemWithSearch () {
        headphonesSteps.checkFirstItem();
    }

    @After
    public void tearDown() {
        testService.getInitDriver().quit();
    }

}
