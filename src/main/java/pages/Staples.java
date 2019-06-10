package pages;


import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Staples extends Page {
    @FindBy(className = "hdr_logo")
    WebElement staplesLogo;

    public Staples(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public boolean checkIsDisplayed() {
        return staplesLogo.isDisplayed();
    }

    public Point locationStaplesLogo() {
        return staplesLogo.getLocation();
    }

}
