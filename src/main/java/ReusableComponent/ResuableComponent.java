package ReusableComponent;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class ResuableComponent {

    Actions action;
    public void performMouseHower(WebElement element,WebDriver driver){
        action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }
    public void click(WebElement element){
        element.click();
    }
    public void clear(WebElement element){
        element.click();
    }
    public void settext(String text,WebElement element){
        element.sendKeys(text);
    }
    public void selectByVisibleText(WebElement selectSize , String text){
        Select s = new Select(selectSize);
        s.selectByVisibleText(text);

    }
    public void clickUsingJavaScriptExecutor(WebElement element, WebDriver driver){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("argument[0].click();",element);

    }
    public void refresh(WebDriver driver){
        driver.navigate().refresh();

    }
    public boolean validateText(WebDriver driver,WebElement element,String expectedtext){
        String observedText = element.getText();
        if(observedText.equals(expectedtext)){
            return true;
        }
        return false;



    }








    }


