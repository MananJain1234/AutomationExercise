package Operations;

import PageObjects.LoginPageObjects;
import org.openqa.selenium.support.PageFactory;

import static BrowserSetup.sds.driver;
import static PageObjects.LoginPageObjects.*;

public class LoginOperations {
    public LoginOperations(){
        PageFactory.initElements(driver, LoginPageObjects.class);
    }

    public static void login(String username, String Password) {
        userName_Element.sendKeys(username);
        password_Element.sendKeys(Password);
        loginButton_Element.click();
    }
}

