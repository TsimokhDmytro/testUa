package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class TestInit {
//        private WebDriver driver;
    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
//        System.setProperty("chromedriver", "/Users/mac/.cache/selenium/chromedriver/mac-arm64/119.0.6045.105/chromedriver");

        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-popup-blocking");

        driver.set(new ChromeDriver(options));
//        driver = new ChromeDriver();

//        WebDriverManager.firefoxdriver().setup();
//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        firefoxOptions.addPreference("dom.disable_beforeunload", true);
//        firefoxOptions.addPreference("dom.disable_open_during_load", true);
////        driver = new FirefoxDriver();
//        driver.set(new FirefoxDriver(firefoxOptions));
        getDriver().manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    @AfterMethod
    public void closeBrowser() {
        getDriver().quit();
    }

//    @AfterMethod
//    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
//        if (testResult.getStatus() == ITestResult.FAILURE) {
//            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(scrFile, new File("errorScreenshots" + testResult.getName() + "-"
//                    + Arrays.toString(testResult.getParameters()) + ".jpg"));
//        }
//    }
}
