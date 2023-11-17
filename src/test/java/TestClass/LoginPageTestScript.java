package TestClass;

import PageObjects.LoginPageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTestScript {
    WebDriver driver;
    @BeforeTest
    @Parameters("browser")
    public void setup(String browser){
        if(browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\Application");
            driver = new ChromeDriver();
        }
        else if(browser.equals("firefox")){
           // System.setProperty("webdriver.geko.driver");
            driver=new FirefoxDriver();
            }
        driver.get("http://automationpractice.com/index.php\"");
        }
     @Test
     public void validateLogin(){
            LoginPageObjects page = new LoginPageObjects(driver);
            page.validateLogin();
        }
     @AfterTest
     public void teardown(){
            driver.close();

        }
    }

