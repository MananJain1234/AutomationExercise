package ReusableComponent;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static BrowserSetup.BrowserSetup1.driver;

public class ResuableComponent {

    public static void scroll(int xOffset, int yOffset) {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollBy(" + xOffset + ", " + yOffset + ");");
    }
    public class WaitUtility {
        private final WebDriver driver;
        private static WebDriverWait wait;

        public WaitUtility(WebDriver driver) {
            this.driver = driver;
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        public static void waitForElementVisibility(WebElement element) {
            wait.until(ExpectedConditions.visibilityOf(element));
        }

        public void waitForElementVisibility(WebElement element, Duration customTimeoutInSeconds) {
            WebDriverWait customWait = new WebDriverWait(driver, customTimeoutInSeconds);
            customWait.until(ExpectedConditions.visibilityOf(element));
        }

    }
    }


