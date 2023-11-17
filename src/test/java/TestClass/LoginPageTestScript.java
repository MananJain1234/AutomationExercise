package TestClass;

import BrowserSetup.BrowserSetup1;
import Constants.SetupConstants;
import DataProvider.LoginData;
import Operations.LoginOperations;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTestScript {
    @BeforeTest(groups = {"sanity", "regression"})
    public static void login() {
        BrowserSetup1.setupDriver();
        BrowserSetup1.navigateToURL(SetupConstants.URL);
    }

    @Test(dataProvider = "LoginCredentials", dataProviderClass = LoginData.class, groups = "sanity")
    public static void loginSuccess(String username, String password) {
        LoginOperations loginOperations=new LoginOperations();
        LoginOperations.login(username, password);
    }

    @Test(
            dataProvider = "LoginCredentials",
            dataProviderClass = LoginData.class,
            groups = "sanity",
            priority = 2)
    public static void failedLogin(String username, String password) {
        LoginOperations loginOperations=new LoginOperations();
        LoginOperations.login(username, password);
    }

    @AfterTest
    public static void testCompletion() {
        BrowserSetup1.navigateToURL(SetupConstants.URL);
    }
}
