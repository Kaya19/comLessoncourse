package Common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
        if(driver==null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    }

    public static void setupFirefox(){
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();

    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    public static void quitDriver(){
        if (driver != null)
            driver.quit();
    }

    public static String getProp(String url) throws IOException {
        prop = new Properties();
        FileInputStream fis=new FileInputStream("src/test/java/Common/global.properties");
        prop.load(fis);
        return prop.getProperty(url);
    }
}

