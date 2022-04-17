package findpatient;

import home.HomeTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.FindPatientPage;
import pages.RegisterPage;

public class FindPatientTests extends HomeTests {
    private FindPatientPage findPatientPage;
    @Test
    @DisplayName("TC022 - Find successful")
    public void testFindPatientSuccessful() {
        findPatientPage = this.homePage.clickFindPatientBtn();
        String keyWord = "given middle family";
        findPatientPage.setPatientSearch(keyWord);
        Assertions.assertFalse(findPatientPage.getFirstRecord().contains("No matching records found"),"Matching");
    }

    @Test
    @DisplayName("TC023 -Find Patient Fail with incorrect input")
    public void testFindPatientFailWithIncorrectInput() {
        findPatientPage = this.homePage.clickFindPatientBtn();
        String keyWord = "#@#@#";
        findPatientPage.setPatientSearch(keyWord);
        Assertions.assertTrue(findPatientPage.getFirstRecord().contains("No matching records found"),"No Matching");
    }

    @Test
    @DisplayName("TC026 - Find Patient Fail with no input")
    public void testFindPatientFailNoInput() {
        findPatientPage = this.homePage.clickFindPatientBtn();
        String keyWord = "";
        findPatientPage.setPatientSearch(keyWord);
        Assertions.assertTrue(findPatientPage.getFirstRecord().contains("No matching records found"),"No Matching");
    }

}
