package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    private WebDriver driver;

    //full name
    private By givenNametxt = By.name("givenName");
    private By givenErr = By.xpath("/html/body/div/div[3]/form/section[1]/div/fieldset[1]/div[1]/p[1]/span[2]");
    private By middleNametxt = By.name("middleName");
    private By familyNametxt = By.name("familyName");

    private By familyErr = By.xpath("/html/body/div/div[3]/form/section[1]/div/fieldset[1]/div[1]/p[3]/span[2]");

    private By unidentifiedPatientButton = By.id("checkbox-unknown-patient");

    //gender & birthday
    private By genderOptions = By.id("gender-field");
    private By genderErr = By.xpath("/html/body/div/div[3]/form/section[1]/div/fieldset[2]/p/span");
    private By birthDaytxt = By.name("birthdateDay");
    private By birthMonthOptions = By.name("birthdateMonth");
    private By birthYeartxt = By.name("birthdateYear");

    private By birthDayErr = By.xpath("/html/body/div/div[3]/form/section[1]/div/fieldset[3]/p[1]/span");

    //address
    private By address1txt = By.id("address1");
    private By cityVillagetxt = By.id("cityVillage");
    private By stateProvincetxt = By.id("stateProvince");
    private By countrytxt = By.id("country");
    private By postalCodetxt = By.id("postalCode");

    private By addressErr = By.xpath("/html/body/div/div[3]/form/section[2]/div/fieldset[1]/span");

    //phone number
    private By phoneNumbertxt = By.name("phoneNumber");

    //relatives
    private By relationshipOptions = By.id("relationship_type");
    private By relationshipNametxt = By.xpath("//input[@placeholder='Person Name']");

    private By nextBtn = By.id("next-button");
    private By cancelBtn = By.id("cancelSubmission");
    private By confirmBtn = By.id("submit");

    private By unidentifiedPatientBtn = By.id("checkbox-unknown-patient");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNextButton() {
        driver.findElement(nextBtn).click();
    }
    public void clickCancelButton() {
        driver.findElement(cancelBtn).click();
    }
    public PatientInfoPage clickConfirmButton() {
        driver.findElement(confirmBtn).click();
        return new PatientInfoPage(driver);
    }

    public void clickUnPatientBtn() {
        driver.findElement(unidentifiedPatientBtn).click();
    }

    public void setGivenName(String givenName) {
        driver.findElement(givenNametxt).sendKeys(givenName);
    }

    public void setMiddleName(String middleName) {
        driver.findElement(middleNametxt).sendKeys(middleName);
    }

    public void setFamilyName(String familyName) {
        driver.findElement(familyNametxt).sendKeys(familyName);
    }

    public void setGender(String gender) {
        Select genders = new Select(driver.findElement(genderOptions));
        genders.selectByVisibleText(gender);
    }

    public void setBirthDay(String birthDay) {
        driver.findElement(birthDaytxt).sendKeys(birthDay);
    }

    public void setBirthMonth(String birthMonth) {
        Select months = new Select(driver.findElement(birthMonthOptions));
        months.selectByVisibleText(birthMonth);
    }

    public void setBirthYear(String birthYear) {
        driver.findElement(birthYeartxt).sendKeys(birthYear);
    }

    public void setAddress1(String address1) {
        driver.findElement(address1txt).sendKeys(address1);
    }

    public void setCityVillage(String cityVillage) {
        driver.findElement(cityVillagetxt).sendKeys(cityVillage);
    }

    public void setStateProvince(String stateProvince) {
        driver.findElement(stateProvincetxt).sendKeys(stateProvince);
    }

    public void setCountry(String country) {
        driver.findElement(countrytxt).sendKeys(country);
    }

    public void setPostalCode(String postalCode) {
        driver.findElement(postalCodetxt).sendKeys(postalCode);
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumbertxt).sendKeys(phoneNumber);
    }

    public void setRelationship(String relationship) {
        Select relationships = new Select(driver.findElement(relationshipOptions));
        relationships.selectByVisibleText(relationship);
    }

    public void setRelationshipName(String relationshipName) {
        driver.findElement(relationshipNametxt).sendKeys(relationshipName);
    }

    public String getGenderErr(){
        return driver.findElement(genderErr).getText();
    }
    public String getGivenNameErr(){
        return driver.findElement(givenErr).getText();
    }

    public String getFamilyNameErr(){
        return driver.findElement(familyErr).getText();
    }

    public String getBirthDayErr(){
        return driver.findElement(birthDayErr).getText();
    }

    public String getAddressErr(){
        return driver.findElement(addressErr).getText();
    }

}
