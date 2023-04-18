package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test

    public void userShouldNavigateToLoginPageSuccessfully(){
        //click on the sign in
        driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
        String expectText = "Welcome Back!";
        WebElement actualTextElement = driver.findElement(By.xpath("//h2[contains(text(),'Welcome Back!')]"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Invalid Text",expectText,actualText);


    }
    @Test
    public void verifyTheErrorMessage(){
        //click on the sign in link
        driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
        // enter invalid  username
        driver.findElement(By.id("user[email]")).sendKeys("abc15@gmail.com");
        //enter invalid password
        driver.findElement(By.id("user[password]")).sendKeys("abc12");
        //click on sign in button
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
        String expectedMessage = "Invalid email or password.";
        WebElement actualTextMessage = driver.findElement(By.xpath("//li[@class='form-error__list-item']"));
        String actualMessage = actualTextMessage.getText();
        Assert.assertEquals("Invalid Message",expectedMessage,actualMessage);


    }
}
