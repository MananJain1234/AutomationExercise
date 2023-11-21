package ReusableComponent;


import org.openqa.selenium.JavascriptExecutor;

import static BrowserSetup.sds.driver;
public class ResuableComponent {

    public static void scroll(int xOffset, int yOffset) {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollBy(" + xOffset + ", " + yOffset + ");");
    }
}


