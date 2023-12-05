package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PromHomePage extends BasePage {
    public PromHomePage(WebDriver driver) {
        super(driver);
    }

    private String promUa = "https://prom.ua/test";

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitBtn;

   public PromHomePage openPromUa() {
        openUrl(promUa);
        return this;
    }

    public void inputProductInSearchField(String str) {
//        waitVisibleElement(searchField);
        searchField.sendKeys(str);
        waitClicableElement(submitBtn);
        submitBtn.click();
//        pressEnter();
    }
}
