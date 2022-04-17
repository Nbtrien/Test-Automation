package capturevitals;

import home.HomeTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CaptureVitalsPage;
import pages.FindPatientPage;
import pages.PatientInfoPage;
import pages.VisitsPage;

public class CaptureVitalsTests extends HomeTests {
    private FindPatientPage findPatientPage;
    private PatientInfoPage patientInfoPage;

    @Test
    @DisplayName("TC033 - Capture Vitals successful")
    public void testCaptureVitalsSuccessful()
    {
        findPatientPage = this.homePage.clickFindPatientBtn();
        String name = "middle";
        patientInfoPage = findPatientPage.clickPatientRecord(name);
        CaptureVitalsPage captureVitalsPage;
        if (patientInfoPage.clickVisitBtn()) {
            VisitsPage visitsPage = patientInfoPage.clickConfirmVisitBtn();
            captureVitalsPage = visitsPage.clickCaptureVitalsBtn();
        } else {
            captureVitalsPage = patientInfoPage.clickCaptureVitalsBtn();
        }
        captureVitalsPage.setHeight("100");
        captureVitalsPage.clickNextBtn();

        captureVitalsPage.setWeight("10");
        captureVitalsPage.clickNextBtn();
        captureVitalsPage.clickNextBtn();

        captureVitalsPage.setTemperature("36.5");
        captureVitalsPage.clickNextBtn();

        captureVitalsPage.setPulse("34");
        captureVitalsPage.clickNextBtn();

        captureVitalsPage.setRespiratoryRate("23");
        captureVitalsPage.clickNextBtn();

        captureVitalsPage.setBloodPressureMin("75");
        captureVitalsPage.setBloodPressureMax("105");

        captureVitalsPage.clickNextBtn();

        captureVitalsPage.setOxygenSaturation("50");

        captureVitalsPage.clickNextBtn();
        VisitsPage visitsPage = captureVitalsPage.clickSaveBtn();
        Assertions.assertFalse(visitsPage == null);

    }

    @Test
    @DisplayName("TC034 - Capture Vitals fail with empty value")
    public void testCaptureVitalsFailWithEmptyValue()
    {
        findPatientPage = this.homePage.clickFindPatientBtn();
        String name = "middle";
        patientInfoPage = findPatientPage.clickPatientRecord(name);
        VisitsPage visitsPage;
        CaptureVitalsPage captureVitalsPage;
        if (patientInfoPage.clickVisitBtn()) {
            visitsPage = patientInfoPage.clickConfirmVisitBtn();
            captureVitalsPage = visitsPage.clickCaptureVitalsBtn();
        } else {
            captureVitalsPage = patientInfoPage.clickCaptureVitalsBtn();
        }

        captureVitalsPage.clickConfirmTab();

        String message = captureVitalsPage.getErr();
        System.out.println(message);
        Assertions.assertTrue(message.contains("Please enter at least one observation"));
    }

    @Test
    @DisplayName("TC035 - Capture Vitals pass with only height is not empty")
    public void testCaptureVitalsPassWithHeightNotEmpty()
    {
        findPatientPage = this.homePage.clickFindPatientBtn();
        String name = "middle";
        patientInfoPage = findPatientPage.clickPatientRecord(name);
        CaptureVitalsPage captureVitalsPage;
        if (patientInfoPage.clickVisitBtn()) {
            VisitsPage visitsPage = patientInfoPage.clickConfirmVisitBtn();
            captureVitalsPage = visitsPage.clickCaptureVitalsBtn();
        } else {
            captureVitalsPage = patientInfoPage.clickCaptureVitalsBtn();
        }

        captureVitalsPage.setHeight("123");
        captureVitalsPage.clickConfirmTab();

        VisitsPage visitsPage = captureVitalsPage.clickSaveBtn();
        Assertions.assertFalse(visitsPage == null);
    }
}
