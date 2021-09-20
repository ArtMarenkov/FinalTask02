package steps;

import io.qameta.allure.Step;
import pages.ElectronicsPage;


public class ElectronicsSteps extends BaseSteps {

    private ElectronicsPage electronicsPage;

    public ElectronicsSteps() {
        electronicsPage = new ElectronicsPage(testService.getInitDriver());
    }

    @Step("нажатие Наушники и Bluetooth-гарнитуры")
    public void stepHeadphonesButtonClick() {
        electronicsPage.electronicsClick();
    }
}
