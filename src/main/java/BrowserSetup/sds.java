package BrowserSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class sds {
    public static WebDriver driver;
    public static WebDriver getDriverInstance() {
        if (driver == null) {
            setupDriver();
        }
        return driver;
    }

    public static void setupDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    public static void navigateToURL(String url) {
        getDriverInstance().manage().deleteAllCookies();
        getDriverInstance().get(url);
        getDriverInstance().manage().window().maximize();
    }
}


