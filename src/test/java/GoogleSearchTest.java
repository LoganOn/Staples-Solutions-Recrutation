import org.junit.Assert;
import org.junit.Test;
import pages.GoogleSearch;

public class GoogleSearchTest extends BaseTest {
    @Test
    public void googleSearch() {
        GoogleSearch googleSearch = new GoogleSearch(driver);
        googleSearch.goToHome();
        Assert.assertTrue(googleSearch.checkIsDisplayed());
        googleSearch.enterQuery("staples solutions uk");
        googleSearch.search();
        System.out.println(driver.getCurrentUrl());
    }
}