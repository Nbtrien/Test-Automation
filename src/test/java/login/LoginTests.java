package login;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginTests {
    private WebDriver driver;
    public LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        System.out.println("before logintetst");
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        driver.manage().window().maximize();
        this.loginPage = new LoginPage(driver);
    }

    @Test
    @DisplayName("TC01-Login successfully")
    public void testLoginSuccessful() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.clickInpatientWard();
        HomePage homePage = loginPage.clickLoginButton();
        String alertText = homePage.getAlertText();
        Assertions.assertTrue(alertText.contains("Logged in as Super User (admin) at Inpatient Ward."), "Alert text is incorrect!");
    }

    @Test
    @DisplayName("TC02-Login fail with Incorrect username and password")
    public void testLoginFailIncorrectUsernameAndPassword() {
        loginPage.setUserName("Adminn");
        loginPage.setPassword("Adminn");
        loginPage.clickInpatientWard();
        loginPage.clickLoginButton();
        String message = loginPage.getErrorMessage();
        Assertions.assertTrue(message.contains("Invalid username/password. Please try again."));
    }

    @Test
    @DisplayName("TC03-Login fail with Password and username are empty")
    public void testLoginFailPasswordAndUserNameEmpty() {
        loginPage.setUserName("");
        loginPage.setPassword("");
        loginPage.clickInpatientWard();
        loginPage.clickLoginButton();
        String message = loginPage.getErrorMessage();
        Assertions.assertTrue(message.contains("Invalid username/password. Please try again."));
    }


    @Test
    @DisplayName("TC04-Login fail with No Location is selected")
    public void testLoginFailNoLocationIsSelected() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.clickLoginButton();
        String alert = loginPage.getLocationErr();
        Assertions.assertTrue(alert.contains("You must choose a location!"));
    }

    @Test
    @DisplayName("TC05-Login fail with Incorrect password and username, location is not selected")
    public void testLoginFailPassAndUserEmptyLocationNoSelected() {
        loginPage.setUserName("Adminn");
        loginPage.setPassword("Adminn");
        loginPage.clickLoginButton();
        String alert = loginPage.getLocationErr();
        Assertions.assertTrue(alert.contains("You must choose a location!"));
    }

    @Test
    @DisplayName("TC06-Login fail with password and username are empty, location is not selected")
    public void testLoginFailIncorrectAndNoLocationIsSelected() {
        loginPage.setUserName("");
        loginPage.setPassword("");
        loginPage.clickLoginButton();
        String alert = loginPage.getLocationErr();
        Assertions.assertTrue(alert.contains("You must choose a location!"));
    }

//
//    @AfterEach
//    public void tearDown() {
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.quit();
//    }
}
