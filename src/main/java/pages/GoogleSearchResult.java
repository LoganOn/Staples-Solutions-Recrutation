package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResult extends Page {
    @FindBy(className = "logoGoogleMain")
    WebElement logoGoogleSmall;

    @FindBy(className = "gLFyf")
    WebElement inpuText;

    @FindBy(xpath = "//a[@href='https://www.staples.co.uk/']")
    WebElement staplesWebSite;

    @FindBy(id = "resultStats")
    WebElement resultStats;
    private String baseUrl = "https://www.google.com/search?source=hp&ei=ahf-XKyWBunnrgSFmbkQ&q=staples+solutions+uk&oq=staples+solutions+uk&gs_l=psy-ab.12..0i19j0i22i30i19l2.2610.2752..3483...0.0..1.187.684.0j4......0....1..gws-wiz.....0..0j0i22i30.ANUEkaoUDJQ";

    public GoogleSearchResult(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

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
        waitClickability(staplesWebSite);
        staplesWebSite.click();
    }

    public String getResultStats() {
        waitVisibility(resultStats);
        return resultStats.getText();
    }


    public boolean checkIsDisplayed() {
        waitVisibility(logoGoogleSmall);
        return logoGoogleSmall.isDisplayed();
    }
    public GoogleSearchResult goToHome() {
        driver.get(baseUrl);
        return this;
    }
}
