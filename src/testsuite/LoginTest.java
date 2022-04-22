package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        driver.findElement(By.linkText("Sign In")).click();// sign in locator and click
        String actualMsg=driver.findElement(By.xpath("//h1[@class='page__heading']")).getText();// get text
        String expectedMsg="Welcome Back!";// expected message
        Assert.assertEquals("Welcome message not displayed",expectedMsg,actualMsg);// validation
    }
    @Test
    public void verifyTheErrorMessage() {
        driver.findElement(By.linkText("Sign In")).click();// sign link locator
        driver.findElement(By.id("user[email]")).sendKeys("123@gmail.com");// send keys to email field
        driver.findElement(By.id("user[password]")).sendKeys("12345");// send keys to password field
        driver.findElement(By.xpath("//input[@type='submit']")).click();// click on submit button
        String actualMsg=driver.findElement(By.className("form-error__list-item")).getText();// get text
        String expectedMsg="Invalid email or password.";// expected message
        Assert.assertEquals("Invalid error msg not displayed",expectedMsg,actualMsg);// validation
    }
    @After
    public void tearDown() {
        closeBrowser();
    }

}
