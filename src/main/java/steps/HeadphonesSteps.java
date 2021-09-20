package steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pages.HeadphonesPage;


public class HeadphonesSteps extends BaseSteps {

    private HeadphonesPage headphonesPage;

    public HeadphonesSteps() {
        headphonesPage = new HeadphonesPage(testService.getInitDriver());
    }

    @Step
    public void setFilter(String price) {
        headphonesPage.setFilter(price);
    }

    @Step
    public void beatsChoose() {
        headphonesPage.beatsClick();
    }

    @Step
    public void checkItemCount (int count) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(count, headphonesPage.getCountItems());
    }

    @Step
    public void checkFirstItem () {
        String name = headphonesPage.getFirstElementName();
        headphonesPage.search(name);
        headphonesPage.clickSearchButton();
        String expected = name.replaceAll("\\s+","");
        String actual = headphonesPage.getActualFirstElementName().replaceAll("\\s+","");
        Assertions.assertEquals(expected, actual);

    }

}
