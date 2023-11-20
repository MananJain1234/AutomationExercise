package Operations;

import PageObjects.AddToCart;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static BrowserSetup.sds.driver;
import static PageObjects.AddToCart.getAddToCartButton;
import static PageObjects.AddToCart.getProductByName;

public class ProductOperations {
    public void ProductsOperations()
    {
        PageFactory.initElements(driver, AddToCart.class);
    }

    public static void addToCart(String[] itemsToAdd) {
        for (String itemToAdd : itemsToAdd) {
            WebElement item = getProductByName(itemToAdd);
            WebElement addToCartButton = getAddToCartButton(item);
            addToCartButton.click();
        }
    }
}

