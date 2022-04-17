package bookappointment;

import home.HomeTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.BookAppointmentPage;
import pages.FindPatientPage;
import pages.HomePage;
import pages.PatientInfoPage;

public class BookAppointTests extends HomeTests {
    private FindPatientPage findPatientPage;
    private PatientInfoPage patientInfoPage;
    BookAppointmentPage bookAppointmentPage;
    @Test
    @DisplayName("TC029 - Book Appointment Successful")
    public void testBookAppointmentSuccessful() {
        findPatientPage = this.homePage.clickFindPatientBtn();
        String name = "middle";
        patientInfoPage = findPatientPage.clickPatientRecord(name);

        bookAppointmentPage = patientInfoPage.clickRequestAppointment();

        bookAppointmentPage.setAppointmentType("Dermatology");
        bookAppointmentPage.setProvider("Jake Smith");
        bookAppointmentPage.setMinTime("1");
        bookAppointmentPage.setMaxTime("5");
        bookAppointmentPage.setMinTimeOptions("Week(s)");
        bookAppointmentPage.setMaxTimeOptions("Week(s)");
        bookAppointmentPage.setNotesArea("Note bla bla");

        patientInfoPage =  bookAppointmentPage.clickSaveBtn();
        Assertions.assertFalse(patientInfoPage == null);
    }

    @Test
    @DisplayName("TC030 - Book Appointment Pass with only Appointment type")
    public void testBookAppointmentPassWithOnlyAppointType() {
        findPatientPage = this.homePage.clickFindPatientBtn();
        String name = "middle";
        patientInfoPage = findPatientPage.clickPatientRecord(name);

        bookAppointmentPage = patientInfoPage.clickRequestAppointment();

        bookAppointmentPage.setAppointmentType("Dermatology");
        patientInfoPage =  bookAppointmentPage.clickSaveBtn();
        Assertions.assertFalse(patientInfoPage == null);
    }

    @Test
    @DisplayName("TC031 - Book Appointment Fail with all Empty")
    public void testBookAppointmentFailWithAllEmpty() {
        findPatientPage = this.homePage.clickFindPatientBtn();
        String name = "middle";
        patientInfoPage = findPatientPage.clickPatientRecord(name);

        bookAppointmentPage = patientInfoPage.clickRequestAppointment();
        Assertions.assertTrue(bookAppointmentPage.getSaveBtnState());
    }

    @Test
    @DisplayName("TC032 - Book Appointment Fail with Appointment Type Empty")
    public void testBookAppointmentFailWithAppointmentTypeEmpty() {
        findPatientPage = this.homePage.clickFindPatientBtn();
        String name = "middle";
        patientInfoPage = findPatientPage.clickPatientRecord(name);

        bookAppointmentPage = patientInfoPage.clickRequestAppointment();
        bookAppointmentPage.setProvider("Jake Smith");
        bookAppointmentPage.setMinTime("1");
        bookAppointmentPage.setMaxTime("5");
        bookAppointmentPage.setMinTimeOptions("Week(s)");
        bookAppointmentPage.setMaxTimeOptions("Week(s)");
        bookAppointmentPage.setNotesArea("Note bla bla");
        Assertions.assertTrue(bookAppointmentPage.getSaveBtnState());
    }
}
