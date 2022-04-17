package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CaptureVitalsPage {
    private WebDriver driver;

    private By nextBtn = By.id("next-button");
    private By saveBtn = By.xpath("//button[contains(text(), 'Save')]");
    private By noBtn = By.cssSelector("input[value='no'][type='button']");
    private By heightTxt = By.id("w8");
    private By weightTxt = By.id("w10");
    private By temperatureTxt = By.id("w12");
    private By pulseTxt = By.id("w14");
    private By respiratoryRateTxt = By.id("w16");
    private By bloodPressureMinTxt = By.id("w18");
    private By bloodPressureMaxTxt = By.id("w20");
    private By oxygenSaturationTxt = By.id("w22");

    private By confirmTab = By.xpath("//*[@id=\"formBreadcrumb\"]/li[2]");

    private By error = By.xpath("//*[@id=\"confirmationQuestion\"]/p[3]/span");

    public CaptureVitalsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNextBtn(){
        driver.findElement(nextBtn).click();
    }
    public void clickNoBtn(){
        driver.findElement(noBtn).click();
    }
    public VisitsPage clickSaveBtn(){
        driver.findElement(saveBtn).click();
        return new VisitsPage(driver);
    }

    public void clickConfirmTab() {
        driver.findElement(confirmTab).click();
    }

    public void setHeight(String height) {
        driver.findElement(heightTxt).sendKeys(height);
    }

    public void setWeight(String weight) {
        driver.findElement(weightTxt).sendKeys(weight);
    }

    public void setTemperature(String temperature) {
        driver.findElement(temperatureTxt).sendKeys(temperature);
    }

    public void setPulse(String pulse) {
        driver.findElement(pulseTxt).sendKeys(pulse);
    }

    public void setRespiratoryRate(String respiratoryRate) {
        driver.findElement(respiratoryRateTxt).sendKeys(respiratoryRate);
    }

    public void setBloodPressureMin(String bloodPressureMin) {
        driver.findElement(bloodPressureMinTxt).sendKeys(bloodPressureMin);
    }

    public void setBloodPressureMax(String bloodPressureMax) {
        driver.findElement(bloodPressureMaxTxt).sendKeys(bloodPressureMax);
    }

    public void setOxygenSaturation(String oxygenSaturation) {
        driver.findElement(oxygenSaturationTxt).sendKeys(oxygenSaturation);
    }

    public String getErr() {
        return driver.findElement(error).getText();
    }

}
