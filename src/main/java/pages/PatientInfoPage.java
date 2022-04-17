package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PatientInfoPage {
    private WebDriver driver;

    private By requestAppointment = By.xpath("//div[contains(text(), 'Request Appointment')]");
    private By visitBtn = By.id("org.openmrs.module.coreapps.createVisit");
    private By comfirmVisitBtn = By.id("start-visit-with-visittype-confirm");
    private By captureVitalsBtn = By.xpath("/html/body/div[1]/div[3]/div[9]/div[2]/ul/li[4]/a");

    public PatientInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public BookAppointmentPage clickRequestAppointment() {
        driver.findElement(requestAppointment).click();
        return new BookAppointmentPage(driver);
    }

    public boolean clickVisitBtn() {
        try {
            driver.findElement(visitBtn).click();
        } catch (Exception e){
            return false;
        }
       return true;
    }
    public VisitsPage clickConfirmVisitBtn() {
        driver.findElement(comfirmVisitBtn).click();
        return new VisitsPage(driver);
    }

    public CaptureVitalsPage clickCaptureVitalsBtn() {
        WebDriverWait t = new WebDriverWait(driver, 30);
        WebElement button = driver.findElement(captureVitalsBtn);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", button);
        return new CaptureVitalsPage(driver);
    }
}
