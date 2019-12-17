package Common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Driver {
    public static WebDriver driver;
    public static Properties prop;

    public static WebDriver getDriver() {
        if (driver == null) {
            setUpDriver();
        }
        return driver;
    }

    public static void setUpDriver() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
    public static void quitDriver(){
            driver.quit();
    }
    public static String getProp(String url) throws IOException {
        prop = new Properties();
        FileInputStream fis=new FileInputStream("src/test/java/Common/global.properties");
        prop.load(fis);
        return prop.getProperty(url);
    }
}

