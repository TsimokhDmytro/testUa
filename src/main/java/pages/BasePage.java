package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private final int timeOut = 30;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        PageFactory.initElements(driver,this);
    }
    protected void openUrl(String url){
        driver.get(url);
    }
    protected void waitClicableElement(WebElement elenemt){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(elenemt));
        }
        catch (NoSuchElementException e){
            System.out.println("Елемент " + "\"" + elenemt + "\"" + " не знайдено");
        }
            catch (NullPointerException e){
            System.out.println("Елемент " + "\"" + elenemt + "\"" + " Null");
        }
            catch (TimeoutException e){
            System.out.println("Елемент " + "\"" + elenemt + "\"" + " не став клікабельним протягом " + timeOut + "секунд");
        }
    }
    protected void waitVisibleElement(WebElement element){
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch (NoSuchElementException e){
            System.out.println("Елемент " + "\"" + element + "\"" + " не знайдено");
        }
        catch (NullPointerException e){
            System.out.println("Елемент " + "\"" + element + "\"" + " Null");
        }
        catch (TimeoutException e){
            System.out.println("Елемент " + "\"" + element + "\"" + " не став видимим протягом " + timeOut + "секунд");
        }
    }

    protected boolean isDisplayedElement(WebElement element){
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }
        catch (NoSuchElementException e){
            System.out.println("Елемент " + "\"" + element + "\"" + " не знайдено");
            return false;
        }
    }
    protected void pressEnter(){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }
}
