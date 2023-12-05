package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PromProductPage extends BasePage {
    public PromProductPage(WebDriver driver){
        super(driver);
    }
    @FindBy (xpath = "//div[@class=\"M3v0L C6zKA\"]/span")
    private WebElement badSearchTitle;

    public String getTextBadSearchTitle(){
        waitVisibleElement(badSearchTitle);
        return badSearchTitle.getText();

    }
}
