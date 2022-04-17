package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By statusAlert = By.xpath("/html/body/div/div[3]/div[2]/div/h4");
    private By logoutButton = By.xpath("//a[contains(text(), 'Logout')]");
    private By registerButton = By.id("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension");
    private By findPatientBtn = By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public String getAlertText() {
        return driver.findElement(statusAlert).getText();
    }

    public LoginPage clickLogoutButton() {
        driver.findElement(logoutButton).click();
        return new LoginPage(driver);
    }

    public RegisterPage clickRegisterButton() {
        driver.findElement(registerButton).click();
        return new RegisterPage(driver);
    }

    public FindPatientPage clickFindPatientBtn() {
        driver.findElement(findPatientBtn).click();
        return new FindPatientPage(driver);
    }
}
