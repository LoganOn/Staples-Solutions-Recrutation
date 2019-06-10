package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchResult extends Page {
    @FindBy(className = "logoGoogleMain")
    WebElement logoGoogleSmall;

    @FindBy(className = "gLFyf")
    WebElement inpuText;

    @FindBy(xpath = "//a[@href='https://www.staples.co.uk/']")
    WebElement staplesWebSite;

    @FindBy(id = "resultStats")
    WebElement resultStats;
    public GoogleSearchResult(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public int cuteResult(String s) {
        s.trim();
        String str = s.substring(0, s.indexOf('w') - 1);
        String[] strArray = str.split("Około");
        String[] result = strArray[1].split(" ");
        int i = Integer.valueOf(concatenateResult(result));

        return i;
    }

    public String concatenateResult(String[] s) {
        String concatenate = "";
        for (String str : s)
            concatenate = concatenate.concat(str);

        return concatenate;
    }

    public void goStaplesWebSite() {
        staplesWebSite.click();
    }

    public String getResultStats() {
        return resultStats.getText();
    }

    public String getInputText() {
        return inpuText.getText();
    }
    public boolean checkLogoDisplayed() {
        return logoGoogleSmall.isDisplayed();
    }
}
