package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchResult extends Page {
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
}
