package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KinoHomePage extends BasePage {

    public KinoHomePage(WebDriver driver) {
        super(driver);
    }

    private String kino = "https://planetakino.ua";
//    private String rozetka = "https://ciprobet-int.doruk.tech";


    @FindBy(xpath = "//input[@class='search-input']")

    private WebElement searchField;

    @FindBy(xpath = "//i[@class='material-icons move-to-active']")
    private WebElement submitBtn1;
    @FindBy(xpath = "//i[@class='material-icons move-to-active show-result']")
    private WebElement submitBtn2;

    @FindBy(xpath = "//p[text()='Фільм не знайдено']")
    private WebElement badSearchTitle;

    public KinoHomePage openKino() {
        openUrl(kino);
        return this;
    }

    public void inputProductInSearchField(String str) {
//        waitClicableElement(submitBtn1);
        submitBtn1.click();
//        waitClicableElement(searchField);
        searchField.sendKeys(str);
//        pressEnter();
    }
    public String getbadSearchTitleText (){
//        waitVisibleElement(badSearchTitle);
        System.out.println(badSearchTitle.getText());
        return badSearchTitle.getText();
    }

    //    public String getTextBadSearchTitle() throws InterruptedException {
//        Thread.sleep(5);
//        waitVisibleElement(badSearchTitle);
//        return badSearchTitle.getText();
//    }
    public void clickSubmitBtn() {
//        waitClicableElement(submitBtn2);
        submitBtn2.click();
    }
}
