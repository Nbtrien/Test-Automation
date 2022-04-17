package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindPatientPage {
    private WebDriver driver;

    private By patientSearchtxt = By.id("patient-search");
    private By formSearch = By.id("patient-search-form");
    private By tablePatients = By.id("patient-search-results-table");


    public FindPatientPage(WebDriver driver) {
        this.driver = driver;
    }


    public void setPatientSearch(String keySearch) {
        WebElement searchInputElement = driver.findElement(patientSearchtxt);
        searchInputElement.sendKeys(keySearch);
        searchInputElement.sendKeys(Keys.RETURN);
    }

    public void submitFormSearch() {
        driver.findElement(formSearch).sendKeys(Keys.RETURN);

    }

    public String getFirstRecord() {
        try {
            Thread.sleep(2000);
        } catch (Exception e){

        }
        WebElement baseTable = driver.findElement(tablePatients);

        WebElement tableBody = baseTable.findElement(By.tagName("tbody"));

        List<WebElement> tableRows = tableBody.findElements(By.tagName("tr"));
        return tableRows.get(0).findElements(By.tagName("td")).get(0).getText();
    }

    public PatientInfoPage clickPatientRecord(String name) {
        WebElement baseTable = driver.findElement(tablePatients);
        List<WebElement> tableRows = baseTable.findElements(By.tagName("td"));
        int index = -1;

        for (int i = 0; i<tableRows.size(); i++) {
            if (tableRows.get(i).getText().contains(name))  {
                index = i;

                break;
            }
        }

        if (index != -1) {
            tableRows.get(index).click();
        }
        return new PatientInfoPage(driver);
    }
}
