package org.example;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class FirstTest {

    public static FirstPage firstPage;
    public static ProfilePage profilePage;

//    @BeforeClass
//    public static void setup() {
//        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
//        WebDriver driver = new ChromeDriver();
//        firstPage = new FirstPage(driver);
//        profilePage = new ProfilePage(driver);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get(ConfProperties.getProperty("loginpage"));
//
//    }

    @Test
    public void firstTest() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        WebDriver driver = new ChromeDriver();
        firstPage = new FirstPage(driver);
        profilePage = new ProfilePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));

        firstPage.inputLogin(ConfProperties.getProperty("login"));
        firstPage.clickLoginBtn();
        firstPage.inputPassword(ConfProperties.getProperty("password"));
        firstPage.clickPasswordBtn();
        String user = profilePage.getUserName();
        Assert.assertEquals(ConfProperties.getProperty("login"), user);

        profilePage.entryMenu();
        profilePage.userLogout();
        driver.quit();
    }

//    @AfterClass
//    public static void getDown() {
//        profilePage.entryMenu();
//        profilePage.userLogout();
//        driver.quit();
//    }

}