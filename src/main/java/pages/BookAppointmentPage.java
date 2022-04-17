package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BookAppointmentPage {
    WebDriver driver;

    //info
    private By appointmentTypetxt = By.id("appointment-type");
    private By apointmentDropdown = By.xpath("/html/body/div/div[3]/div[4]/form/p[1]/ul");
    private By providertxt = By.id("provider");
    private By minTimetxt = By.id("min-time-frame-value");
    private By minTimeOptions = By.id("min-time-frame-units");
    private By maxTimetxt = By.id("max-time-frame-value");
    private By maxTimeOptions = By.xpath("//select[@id = 'max-time-frame-units']");
    private By notesAreatxt = By.id("notes");

    public BookAppointmentPage(WebDriver driver) {
        this.driver = driver;
    }

    //button
    private By saveBtn = By.id("save-button");

    public void setAppointmentType(String appointmentType){
        WebDriverWait t = new WebDriverWait(driver, 30);
        WebElement element = driver.findElement(appointmentTypetxt);
        element.sendKeys(appointmentType);
        t.until(ExpectedConditions.visibilityOfElementLocated(apointmentDropdown));
        WebElement drop = driver.findElement(apointmentDropdown);
        WebElement op = drop.findElements(By.tagName("li")).get(0);
        drop.click();


    }
    public void setProvider(String provider){
        WebElement element = driver.findElement(providertxt); // you can use any locator
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].value='"+provider+"';", element);
    }
    public void setMinTime(String minTime){
        driver.findElement(minTimetxt).sendKeys(minTime);
    }

    public void setMaxTime(String maxTime){
        driver.findElement(maxTimetxt).sendKeys(maxTime);
    }

    public void setMinTimeOptions(String minTime){
        Select minTimes = new Select(driver.findElement(minTimeOptions));
        minTimes.getAllSelectedOptions();

        List<WebElement> listOptions = minTimes.getOptions();
        for (WebElement webElement : listOptions){
            if (webElement.getText().equals(minTime)) minTimes.selectByVisibleText(minTime);
        }
    }

    public void setMaxTimeOptions(String maxTime){
        Select maxTimes = new Select(driver.findElement(maxTimeOptions));
        maxTimes.getAllSelectedOptions();
        List<WebElement> listOptions = maxTimes.getOptions();
        for (WebElement webElement : listOptions){
            if (webElement.getText().equals(maxTime)) maxTimes.selectByVisibleText(maxTime);
        }

    }

    public void setNotesArea(String notes) {
        driver.findElement(notesAreatxt).sendKeys(notes);
    }

    public PatientInfoPage clickSaveBtn(){
        driver.findElement(saveBtn).click();
        return new PatientInfoPage(driver);
    }

    public boolean getSaveBtnState() {
        return Boolean.parseBoolean(driver.findElement(saveBtn).getAttribute("disabled"));
    }
}
