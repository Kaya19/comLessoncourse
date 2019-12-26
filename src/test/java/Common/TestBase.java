package Common;

import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestBase extends Base{
    @BeforeSuite
    public void beforeSuite() {
      Driver.setUpDriver();
       //Driver.getDriver().manage().window().maximize();
       //Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void beforeMethod() {
        Driver.getDriver();
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Driver.getDriver();
    }

    @AfterMethod
    public void afterMethod() {
        Driver.closeDriver();
    }

    @AfterSuite
    public void afterSuite() {
        Driver.quitDriver();

    }
}
