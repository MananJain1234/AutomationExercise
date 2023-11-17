package DataProvider;

import org.testng.annotations.DataProvider;

public class CartData {

    @DataProvider(name = "CartData")
    public static Object[][] cartData() {
        return new Object[][]{
                {new CartTestData("standard_user", "secret_sauce", "Sauce Labs Backpack", "Manan", "Jain", "10001")},
        };
    }
}

