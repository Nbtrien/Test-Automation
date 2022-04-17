package patientinformation;

import home.HomeTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BookAppointmentPage;
import pages.FindPatientPage;
import pages.PatientInfoPage;

public class ViewPatientTests extends HomeTests {
    private FindPatientPage findPatientPage;
    private PatientInfoPage patientInfoPage;
    @Test
    @DisplayName("TC027 - View Patient successful")
    public void testViewPatientSuccessful() {
        findPatientPage = this.homePage.clickFindPatientBtn();
        String name = "middle";
        patientInfoPage = findPatientPage.clickPatientRecord(name);
    }
}
