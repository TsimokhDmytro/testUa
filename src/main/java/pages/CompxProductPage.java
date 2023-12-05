package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompxProductPage extends BasePage {
    public CompxProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[@class='catalog__heading']")
    private WebElement badSearchTitle;

    public String getTextBadSearchTitle() {
        waitVisibleElement(badSearchTitle);
        return badSearchTitle.getText();
    }
}
