package Utils;
import Common.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.util.List;
public class SeleniumUtil {
    public void goToPage(String url) throws IOException {
        Driver.getDriver().get(Driver.getProp(url));
    }
    public WebElement findElement(By locator){
        return Driver.getDriver().findElement(locator);
    }
    public List<WebElement> findElements(By locator){
        return Driver.getDriver().findElements(locator);
    }
    public void clear(By locator){
        findElement(locator).clear();
    }
    public void sendKeys(By locator, String text){
        clear(locator);
        findElement(locator).sendKeys(text);
    }
    public void enter(By locator){
        findElement(locator).sendKeys(Keys.ENTER);
    }
    public void click(By locator){
        findElement(locator).click();
    }
    public String getText(By locator){
        return findElement(locator).getText();
    }
    public String getUrl(){
        return Driver.getDriver().getCurrentUrl();
    }
    public Actions getAction(){
        return new Actions(Driver.getDriver());
    }
    public Select getSelect(By locator){
        return new Select(findElement(locator));
    }
    public Select getSelect(WebElement element){
        return new Select(element);
    }
    public boolean isDisplayed(By locator){
        return findElement(locator).isDisplayed();
    }
    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }
    public WebDriverWait getWait(long millSecond){
        return new WebDriverWait(Driver.getDriver(),millSecond);
    }
    public void waitForVisibility(By locator, long millSecond){
        getWait(millSecond).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public boolean isClickable(By locator, long milliSecond){
        try {
            getWait(milliSecond).until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean isClickable(WebElement element, long milliSecond){
        try {
            getWait(milliSecond).until(ExpectedConditions.elementToBeClickable(element));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public String getAttribute(By locator, String elementAttribute){
        return findElement(locator).getAttribute(elementAttribute);
    }
    public String getAttribute(WebElement element, String elementAttribute){
        return element.getAttribute(elementAttribute);
    }
    public void getThread(int milliSecond) throws InterruptedException {
        Thread.sleep(milliSecond);
    }
}

