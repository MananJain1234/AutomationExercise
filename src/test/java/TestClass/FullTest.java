package TestClass;

import BrowserSetup.sds;
import Constants.SetupConstants;
import DataProvider.CartData;
import DataProvider.CartTestData;
import Operations.CartOperations;
import Operations.LoginOperations;
import Operations.ProductOperations;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static BrowserSetup.sds.driver;
public class FullTest extends CartOperations {
    @BeforeClass(groups = {"sanity", "regression"})
    public static void browserSetup() {
        sds.setupDriver();
        sds.navigateToURL(SetupConstants.URL);
    }
    @Test(
            dataProvider = "CartData",
            dataProviderClass = CartData.class,
            groups = "regression")
    public static void endToEndCheckout(CartTestData testData) {
        LoginOperations LoginOperations = new LoginOperations();
        LoginOperations.login(testData.getUsername(), testData.getPassword());
        ProductOperations.addToCart(new String[]{testData.getItemToAdd()});
        CartOperations.clickCart();
        CartOperations.clickCheckout();
        CartOperations.enterUserInformation(testData.getFirstName(), testData.getLastName(), testData.getZipCode());
    }
    @AfterSuite
    public static void suiteCompletion() {
        driver.quit();
    }
}


