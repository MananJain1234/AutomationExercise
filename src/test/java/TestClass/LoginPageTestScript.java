package TestClass;

import BrowserSetup.sds;
import Constants.SetupConstants;
import DataProvider.LoginData;
import Operations.LoginOperations;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTestScript {
    @BeforeTest(groups = {"sanity", "regression"})
    public static void login() {
        sds.setupDriver();
        sds.navigateToURL(SetupConstants.URL);
    }
    @Test(dataProvider = "LoginCredentials", dataProviderClass = LoginData.class, groups = "sanity")
    public static void loginSuccess(String username, String password) {
        LoginOperations LoginOperations=new LoginOperations();
        LoginOperations.login(username, password);
    }
    @AfterTest
    public static void testCompletion() {
        sds.navigateToURL(SetupConstants.URL);
    }
}
