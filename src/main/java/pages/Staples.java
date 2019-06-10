package pages;


import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Staples extends Page {
    @FindBy(className = "hdr_logo")
    WebElement staplesLogo;
    public Staples(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean checkIsDisplayed() {
        return staplesLogo.isDisplayed();
    }

    public Point locationStaplesLogo() {
        return staplesLogo.getLocation();
    }

}
