package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearch extends Page {
    @FindBy(id = "hplogo")
    WebElement logoGoogleMain;

    @FindBy(className = "gLFyf")
    WebElement inputText;

    @FindBy(className = "gNO89b")
    WebElement searchButton;

    public GoogleSearch(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void enterQuery(String query) {
        inputText.sendKeys(query);
    }

    public void search() {
        searchButton.click();
    }

    public boolean checkLogoDisplayed() {
        return logoGoogleMain.isDisplayed();
    }
}
