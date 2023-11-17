package TestClass;

import PageObjects.AddToCart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddToCartTest {
    WebDriver driver;
    AddToCart page;
    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromeDriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        page = new AddToCart(driver);
    }
    @Test
    public void validateAddToCart(){
        Assert.assertTrue(page.validateAddToCart(driver));
    }
    @AfterTest
    public void close(){
        driver.quit();
    }

}
