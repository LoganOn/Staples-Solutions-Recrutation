package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;

public abstract class Page {
    public WebDriver driver;
    public WebDriverWait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);

    }

    public void waitVisibility(WebElement elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elementBy));
    }

    public void waitClickability(WebElement elementBy) {
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    public abstract boolean checkIsDisplayed();
}