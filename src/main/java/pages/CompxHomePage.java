package pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompxHomePage extends BasePage {

    public CompxHomePage(WebDriver driver) {
        super(driver);
    }

    private String compX = "https://compx.ua/";


    @FindBy(name = "search")
    private WebElement searchField;
    @FindBy(xpath = "//div[@class='no_results ']")
    private WebElement noResultMessage;
    @FindBy(xpath = "//button[@class='header__search-btn']")
    private WebElement submitBtn;

    public CompxHomePage openCompX() {
        openUrl(compX);
        return this;
    }


    public CompxProductPage inputProductInSearchField(String str) {
//        waitVisibleElement(searchField);
        searchField.sendKeys(str);
//        Assert.isTrue(isDisplayedElement(noResultMessage),"Елемент " + "\"" + noResultMessage + "\"" + " не відображений");
        waitClicableElement(submitBtn);
        submitBtn.click();
//        pressEnter();
        return new CompxProductPage(driver);
    }

}
