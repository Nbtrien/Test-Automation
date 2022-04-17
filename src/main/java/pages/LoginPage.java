package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By userNametxt = By.id("username");
    private By passwordTxt = By.id("password");

    private By inpatientWard = By.xpath("//li[contains(text(), 'Inpatient Ward')]");

    private By loginButton = By.id("loginButton");

    private By locationErr = By.id("sessionLocationError");

    private By errorMesage = By.id("error-message");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String userName){
        driver.findElement(userNametxt).sendKeys(userName);
    }

    public void setPassword(String password) {
        driver.findElement(passwordTxt).sendKeys(password);
    }

    public void clickInpatientWard () {
        driver.findElement(inpatientWard).click();
    }

    public String getLocationErr () {
        return driver.findElement(locationErr).getText();
    }

    public String getErrorMessage () {
        return driver.findElement(errorMesage).getText();
    }

    public HomePage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }

    public boolean existsLogin() {
        try {
            driver.findElement(loginButton);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
