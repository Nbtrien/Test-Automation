package register;

import home.HomeTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PatientInfoPage;
import pages.RegisterPage;
@DisplayName("TC04 - Register Testing")
public class RegisterTests extends HomeTests {
    private RegisterPage registerPage;
    @Test
    @DisplayName("TC04 - Register successful")
    public void testRegisterSuccessful() {
        registerPage = this.homePage.clickRegisterButton();

        registerPage.setGivenName("given");
        registerPage.setFamilyName("family");
        registerPage.setMiddleName("middle");

        registerPage.clickNextButton();

        registerPage.setGender("Male");

        registerPage.clickNextButton();

        registerPage.setBirthDay("1");
        registerPage.setBirthMonth("January");
        registerPage.setBirthYear("2001");

        registerPage.clickNextButton();

        registerPage.setAddress1("6, Le Dinh Chinh, Hoa Quy, Ngu Hanh Son");
        registerPage.setCityVillage("Da Nang");
        registerPage.setStateProvince("Da Nang");
        registerPage.setCountry("Viet Nam");
        registerPage.setPostalCode("5555");

        registerPage.clickNextButton();

        registerPage.setPhoneNumber("0123456789");

        registerPage.clickNextButton();

        registerPage.setRelationship("Patient");
        registerPage.setRelationshipName("Relation");

        registerPage.clickNextButton();
        PatientInfoPage patientInfoPage = registerPage.clickConfirmButton();

        Assertions.assertFalse(patientInfoPage == null);
    }

    @Test
    @DisplayName("TC09 - Register pass with Unidentified Patient")
    public void testRegisterPassWithUnidentifiedPatient() {
        registerPage = this.homePage.clickRegisterButton();

        registerPage.clickUnPatientBtn();
        registerPage.setGender("Male");
        registerPage.clickNextButton();
        PatientInfoPage patientInfoPage = registerPage.clickConfirmButton();
        Assertions.assertFalse(patientInfoPage == null);
    }

    @Test
    @DisplayName("TC010 - Register fail with Unidentified Patient And Gender Is Empty")
    public void testRegisterFailWithUnPatientAndGenderEmpty() {
        registerPage = this.homePage.clickRegisterButton();

        registerPage.clickUnPatientBtn();
        registerPage.clickNextButton();
        String message = registerPage.getGenderErr();
        Assertions.assertTrue(message.contains("Required"));
    }

    @Test
    @DisplayName("TC011 - Register fail with Given Name Is Empty")
    public void testRegisterFailWithGivenNameEmpty() {
        registerPage = this.homePage.clickRegisterButton();

        registerPage.setGivenName("");
        registerPage.setFamilyName("family");
        registerPage.setMiddleName("middle");

        registerPage.clickNextButton();
        String message = registerPage.getGivenNameErr();
        Assertions.assertTrue(message.contains("Required"));
    }

    @Test
    @DisplayName("TC012 - Register fail with Family Name Is Empty")
    public void testRegisterFailWithFamilyNameEmpty() {
        registerPage = this.homePage.clickRegisterButton();

        registerPage.setGivenName("given");
        registerPage.setFamilyName("");
        registerPage.setMiddleName("middle");

        registerPage.clickNextButton();
        String message = registerPage.getFamilyNameErr();
        Assertions.assertTrue(message.contains("Required"));
    }

    @Test
    @DisplayName("TC013 - Register pass with Middle Name Is Empty")
    public void testRegisterPassWithMiddleNameEmpty() {
        registerPage = this.homePage.clickRegisterButton();

        registerPage.setGivenName("given");
        registerPage.setFamilyName("family");
        registerPage.setMiddleName("");

        registerPage.clickNextButton();

        registerPage.setGender("Male");

        registerPage.clickNextButton();

        registerPage.setBirthDay("1");
        registerPage.setBirthMonth("January");
        registerPage.setBirthYear("2001");

        registerPage.clickNextButton();

        registerPage.setAddress1("6, Le Dinh Chinh, Hoa Quy, Ngu Hanh Son");
        registerPage.setCityVillage("Da Nang");
        registerPage.setStateProvince("Da Nang");
        registerPage.setCountry("Viet Nam");
        registerPage.setPostalCode("5555");

        registerPage.clickNextButton();

        registerPage.setPhoneNumber("0123456789");

        registerPage.clickNextButton();

        registerPage.setRelationship("Patient");
        registerPage.setRelationshipName("Relation");

        registerPage.clickNextButton();
        PatientInfoPage patientInfoPage = registerPage.clickConfirmButton();

        Assertions.assertFalse(patientInfoPage == null);
    }

    @Test
    @DisplayName("TC014 - Register fail with Gender Is Empty")
    public void testRegisterFailWithGenderEmpty() {
        registerPage = this.homePage.clickRegisterButton();

        registerPage.setGivenName("given");
        registerPage.setFamilyName("family");
        registerPage.setMiddleName("middle");

        registerPage.clickNextButton();
        registerPage.clickNextButton();
        String message = registerPage.getGenderErr();
        Assertions.assertTrue(message.contains("Required"));
    }

    @Test
    @DisplayName("TC015 - Register fail with Birthday Is Empty")
    public void testRegisterFailWithBirthdayEmpty() {
        registerPage = this.homePage.clickRegisterButton();

        registerPage.setGivenName("given");
        registerPage.setFamilyName("family");
        registerPage.setMiddleName("");

        registerPage.clickNextButton();

        registerPage.setGender("Male");

        registerPage.clickNextButton();
        registerPage.clickNextButton();
        String message = registerPage.getBirthDayErr();
        Assertions.assertTrue(message.contains("Required"));

    }

    @Test
    @DisplayName("TC016 - Register fail with Day Is Empty")
    public void testRegisterFailWithDayEmpty() {
        registerPage = this.homePage.clickRegisterButton();

        registerPage.setGivenName("given");
        registerPage.setFamilyName("family");
        registerPage.setMiddleName("");

        registerPage.clickNextButton();

        registerPage.setGender("Male");

        registerPage.clickNextButton();

        registerPage.setBirthDay("");
        registerPage.setBirthMonth("January");
        registerPage.setBirthYear("2001");

        registerPage.clickNextButton();
        String message = registerPage.getBirthDayErr();
        Assertions.assertTrue(message.contains("You need to inform a valid date"));

    }
    @Test
    @DisplayName("TC017 - Register fail with Month Is Empty")
    public void testRegisterFailWithMonthEmpty() {
        registerPage = this.homePage.clickRegisterButton();

        registerPage.setGivenName("given");
        registerPage.setFamilyName("family");
        registerPage.setMiddleName("");

        registerPage.clickNextButton();

        registerPage.setGender("Male");

        registerPage.clickNextButton();

        registerPage.setBirthDay("1");
        registerPage.setBirthYear("2001");

        registerPage.clickNextButton();
        String message = registerPage.getBirthDayErr();
        Assertions.assertTrue(message.contains("You need to inform a valid date"));
    }

    @Test
    @DisplayName("TC018 - Register fail with year Is Empty")
    public void testRegisterFailWithYearEmpty() {
        registerPage = this.homePage.clickRegisterButton();

        registerPage.setGivenName("given");
        registerPage.setFamilyName("family");
        registerPage.setMiddleName("");

        registerPage.clickNextButton();

        registerPage.setGender("Male");

        registerPage.clickNextButton();

        registerPage.setBirthDay("1");
        registerPage.setBirthMonth("January");
        registerPage.setBirthYear("");

        registerPage.clickNextButton();
        String message = registerPage.getBirthDayErr();
        Assertions.assertTrue(message.contains("You need to inform a valid date"));
    }

    @Test
    @DisplayName("TC019 - Register fail with Address Is Empty")
    public void testRegisterFailWithAddressEmpty() {
        registerPage = this.homePage.clickRegisterButton();

        registerPage.setGivenName("given");
        registerPage.setFamilyName("family");
        registerPage.setMiddleName("middle");

        registerPage.clickNextButton();

        registerPage.setGender("Male");

        registerPage.clickNextButton();

        registerPage.setBirthDay("1");
        registerPage.setBirthMonth("January");
        registerPage.setBirthYear("2001");

        registerPage.clickNextButton();

        registerPage.clickNextButton();
        String message = registerPage.getAddressErr();
        Assertions.assertTrue(message.contains("You need to provide a value for at least one field"));

    }

    @Test
    @DisplayName("TC020 - Register Pass with Phone Number Is Empty")
    public void testRegisterPassWithPhoneNumberEmpty() {
        registerPage = this.homePage.clickRegisterButton();

        registerPage.setGivenName("given");
        registerPage.setFamilyName("family");
        registerPage.setMiddleName("middle");

        registerPage.clickNextButton();

        registerPage.setGender("Male");

        registerPage.clickNextButton();

        registerPage.setBirthDay("1");
        registerPage.setBirthMonth("January");
        registerPage.setBirthYear("2001");

        registerPage.clickNextButton();

        registerPage.setAddress1("6, Le Dinh Chinh, Hoa Quy, Ngu Hanh Son");
        registerPage.setCityVillage("Da Nang");
        registerPage.setStateProvince("Da Nang");
        registerPage.setCountry("Viet Nam");
        registerPage.setPostalCode("5555");

        registerPage.clickNextButton();

        registerPage.clickNextButton();

        registerPage.setRelationship("Patient");
        registerPage.setRelationshipName("Relation");

        registerPage.clickNextButton();
        PatientInfoPage patientInfoPage = registerPage.clickConfirmButton();

        Assertions.assertFalse(patientInfoPage == null);

    }

    @Test
    @DisplayName("TC021 - Register Pass with Relatives Is Empty")
    public void testRegisterPassWithRelativesEmpty() {
        registerPage = this.homePage.clickRegisterButton();

        registerPage.setGivenName("given");
        registerPage.setFamilyName("family");
        registerPage.setMiddleName("middle");

        registerPage.clickNextButton();

        registerPage.setGender("Male");

        registerPage.clickNextButton();

        registerPage.setBirthDay("1");
        registerPage.setBirthMonth("January");
        registerPage.setBirthYear("2001");

        registerPage.clickNextButton();

        registerPage.setAddress1("6, Le Dinh Chinh, Hoa Quy, Ngu Hanh Son");
        registerPage.setCityVillage("Da Nang");
        registerPage.setStateProvince("Da Nang");
        registerPage.setCountry("Viet Nam");
        registerPage.setPostalCode("5555");

        registerPage.clickNextButton();

        registerPage.setPhoneNumber("0123456789");

        registerPage.clickNextButton();

        registerPage.clickNextButton();
        PatientInfoPage patientInfoPage = registerPage.clickConfirmButton();

        Assertions.assertFalse(patientInfoPage == null);

    }
}
