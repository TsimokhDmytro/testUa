package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RozetkaProductPage extends BasePage {
    public RozetkaProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class='button button_color_green button_size_medium search-form__submit']")
    private WebElement badSearchTitle;

    public String getTextBadSearchTitle() {
        waitVisibleElement(badSearchTitle);
        return badSearchTitle.getText();
    }
}
