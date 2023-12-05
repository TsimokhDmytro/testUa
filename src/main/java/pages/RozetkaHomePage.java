package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RozetkaHomePage extends BasePage {

    public RozetkaHomePage(WebDriver driver) {
        super(driver);
    }

    private String rozetka = "https://rozetka.com.ua";
//    private String rozetka = "https://ciprobet-int.doruk.tech";


    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchField;
    @FindBy(xpath = "//button[@class='button button_color_green button_size_medium search-form__submit']")
    private WebElement submitBtn;

    public RozetkaHomePage openRozetka() {
        openUrl(rozetka);
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
