package PageObjects;

import ReusableComponent.ResuableComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart  {

    ResuableComponent resuable;

    @FindBy(xpath="//*[@id =\"homefeatured\"]/li[2]/div/div[1]/div/a[1]/img")
    WebElement itemImage;

    @FindBy(xpath="//*[@id=\"homeFeatured\"]li[2]/div/div[2]/div[2]/a[2]")
     WebElement btnMore;

    @FindBy(xpath = "//*[@id=\"quantity_wanted\"]")
       WebElement txtQuantity;

    @FindBy(xpath="//*[@id=\"group_1\"]")

    WebElement selectSize;

    @FindBy(xpath="//*[@id=\"add_to_cart\"]/button")
    WebElement btnAddToCart;

    @FindBy(css="div#layer_cart a>span")
    WebElement btncheckout;

    @FindBy(xpath="//*[id = \"header\"]/div[3]/div/div/div[3]/div/a/span[1]")
    WebElement cartText;

    public AddToCart(WebDriver driver) {
        PageFactory.initElements(driver, this);
        ResuableComponent resuable = new ResuableComponent();
    }
    public boolean validateAddToCart(WebDriver driver){
        resuable.performMouseHower(itemImage,driver);
        resuable.click(btnMore);
        resuable.settext("3",txtQuantity);
        resuable.selectByVisibleText(selectSize,"M");
        resuable.click(btnAddToCart);
        resuable.clickUsingJavaScriptExecutor(btncheckout,driver);
        resuable.refresh(driver);
        return resuable.validateText(driver,cartText,"3");



    }
}







