package home;

import login.LoginTests;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

public class HomeTests extends LoginTests {
    protected HomePage homePage;

//    public void setHomePage(HomePage homePage) {
//        this.homePage = testLoginSuccessful();
//        System.out.println("setHoemapge");
//    }
//
    @BeforeEach
    public void config() {
        this.loginPage.setUserName("Admin");
        this.loginPage.setPassword("Admin123");
        this.loginPage.clickInpatientWard();
        homePage =  this.loginPage.clickLoginButton();
    }

    @Test
    @DisplayName("TC07-Logout Successful")
    public void testLogoutSuccessful() {
        LoginPage loginPage = homePage.clickLogoutButton();
        boolean isLogin = loginPage.existsLogin();
        System.out.println(isLogin);
        Assertions.assertTrue(isLogin);
    }

//    public static void main(String[] args) {
//        System.out.println("main");
//        HomeTests test = new HomeTests();
//        test.setUp();
//        test.setHomePage(test.testLoginSuccessful());
//    }
}
