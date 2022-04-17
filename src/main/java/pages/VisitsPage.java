package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VisitsPage {
    private WebDriver driver;
    private By captureVitalsBtn = By.xpath("/html/body/div[1]/div[3]/div[9]/div/div[1]/div[3]/div[1]/div[2]/a[4]");

    public VisitsPage(WebDriver driver) {
        this.driver = driver;
    }

    public CaptureVitalsPage clickCaptureVitalsBtn() {
        WebDriverWait t = new WebDriverWait(driver, 30);

        t.until(ExpectedConditions.visibilityOfElementLocated(captureVitalsBtn));
        System.out.println(driver.findElements(By.tagName("div")).size());
        driver.findElement(captureVitalsBtn).click();
        return new CaptureVitalsPage(driver);
    }
}
