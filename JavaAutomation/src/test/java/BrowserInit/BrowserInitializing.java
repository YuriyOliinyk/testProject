package BrowserInit;

import Helpers.GeneralHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.util.HashMap;
import java.util.Map;


public class BrowserInitializing {
    private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriver GetBrowser(int browserName) {

        switch (browserName) {
            case 1:
                driver = drivers.get("Chrome");
                if (driver == null) {
                    driver = new ChromeDriver();
                    drivers.put("Chrome", driver);
                }
                break;
/*            case 2:
                driver = drivers.get("Firefox");
                if (driver == null) {
                    driver = new FirefoxDriver();
                    drivers.put("Firefox", driver);
                }
                break;*/
        }
        return driver;
    }

    public static void LoadApplication() {
        String url = "http://ia.ca/individuals";
        driver.get(url);
        driver.manage().window().maximize();
    }

    public static void CloseAllDriver() {
        for (String key : drivers.keySet()) {
            drivers.get(key).close();
            drivers.get(key).quit();
        }
        drivers.clear();
    }
}
