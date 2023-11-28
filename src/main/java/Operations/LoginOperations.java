package Operations;

import PageObjects.LoginPageObjects;
import ReportGeneration.ExtentManager;
import org.openqa.selenium.support.PageFactory;

import static BrowserSetup.sds.driver;
import static PageObjects.LoginPageObjects.*;

public class LoginOperations {
    public LoginOperations(){
        PageFactory.initElements(driver, LoginPageObjects.class);
    }
    public static void login(String username, String Password) {
        userName_Element.sendKeys(username);
        ExtentManager.log("Entered username");
        password_Element.sendKeys(Password);
        ExtentManager.log("Entered password");
        loginButton_Element.click();
    }
}

