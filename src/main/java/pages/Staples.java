package pages;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Staples extends Page {
    @FindBy(className = "hdr_logo")
    WebElement staplesLogo;
    @FindBy(id = "Body")
    WebElement bodyWebSite;
    private String baseUrl = "https://www.staples.co.uk/";


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
    public Staples goToHome() {
        driver.get(baseUrl);
        return this;
    }

    public Dimension getSizeWebSite() {
        return bodyWebSite.getSize();
    }

}
