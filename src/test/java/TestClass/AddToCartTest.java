package TestClass;

import BrowserSetup.BrowserSetup1;
import Constants.SetupConstants;
import DataProvider.CartData;
import DataProvider.CartTestData;
import Operations.LoginOperations;
import Operations.ProductOperations;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddToCartTest {
    @BeforeClass(groups = {"sanity", "regression"})
    public static void BrowserLaunch() {
        BrowserSetup1.navigateToURL(SetupConstants.URL);
    }


    @Test(
            dataProvider = "CartData",
            dataProviderClass = CartData.class,
            priority = 2,
            groups = {"sanity"})
    public static void addItemToCart(CartTestData testData) {
        LoginOperations loginOperations = new LoginOperations();
        ProductOperations productsOperations = new ProductOperations();
        loginOperations.login(testData.getusername, testData.getpassword());
        ProductOperations.addToCart(new String[] {testData.getitemToAdd()});
    }

    @AfterClass
    public static void testCompletion() {
        BrowserSetup1.navigateToURL(SetupConstants.URL);
    }
}

