package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearch extends Page {
    @FindBy(id = "hplogo")
    WebElement logoGoogleMain;

    @FindBy(className = "gLFyf")
    WebElement inputText;

    @FindBy(className = "gNO89b")
    WebElement searchButton;
    private String baseUrl = "https://www.google.com";

    public GoogleSearch(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterQuery(String query) {
        waitVisibility(inputText);
        inputText.sendKeys(query);
    }

    public void search() {
        waitClickability(searchButton);
        searchButton.click();
    }

    public boolean checkIsDisplayed() {
        waitVisibility(logoGoogleMain);
        return logoGoogleMain.isDisplayed();
    }

    public GoogleSearch goToHome() {
        driver.get(baseUrl);
        return this;
    }
}
