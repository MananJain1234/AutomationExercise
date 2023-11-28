package TestClass;

import BrowserSetup.sds;
import Constants.SetupConstants;
import DataProvider.CartData;
import DataProvider.CartTestData;
import Operations.LoginOperations;
import Operations.ProductOperations;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddToCartTest extends LoginOperations {
    @BeforeClass(groups = {"sanity", "regression"})
    public static void BrowserLaunch() {
        sds.navigateToURL(SetupConstants.URL);
    }

    @Test(
            dataProvider = "CartData",
            dataProviderClass = CartData.class,
            priority = 2,
            groups = {"sanity"})
    public static void addItemToCart(CartTestData testData) {
        ProductOperations ProductOperations = new ProductOperations();
        LoginOperations.login(testData.getUsername(), testData.getPassword());
        ProductOperations.addToCart(new String[] {testData.getItemToAdd()});
    }
    @AfterClass
    public static void testCompletion() {
        sds.navigateToURL(SetupConstants.URL);
    }
}

