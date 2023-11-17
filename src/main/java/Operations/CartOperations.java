package Operations;

import Constants.CheckoutConstants;
import PageObjects.AddToCart;
import ReusableComponent.ResuableComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static BrowserSetup.BrowserSetup1.driver;
import static PageObjects.AddToCart.*;

public class CartOperations {
    public CartOperations(){
        PageFactory.initElements(driver, AddToCart.class);

}
    public static void clickCart() {
        ResuableComponent.scroll(0, -100);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", cart_Button_Element);
        cart_Button_Element.click();
        String cart_url=driver.getCurrentUrl();
        Assert.assertEquals(cart_url, CheckoutConstants.EXPECTED_CART_URL);
    }

    public static void clickCheckout() {
        checkOut_Button_Element.click();
    }

    public static void enterUserInformation(String firstName, String lastName, String zipCode) {
        firstName_Input_Element.sendKeys(firstName);
        lastName_Input_Element.sendKeys(lastName);
        zipCode_Input_Element.sendKeys(zipCode);
        continue_Button_Element.click();

    }

    public static void verifyAddedItems(String[] itemsToAdd) {
        for (String verifyItem : itemsToAdd) {
            WebElement ele =
                    driver.findElement(By.xpath("//div[contains(text(), '" + verifyItem + "')]"));
            ResuableComponent.WaitUtility.waitForElementVisibility(ele);
            String itemText = ele.getText();
            Assert.assertEquals(itemText, verifyItem);
        }
    }
}
