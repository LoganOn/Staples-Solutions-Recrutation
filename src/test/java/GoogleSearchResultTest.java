import org.junit.Assert;
import org.junit.Test;
import pages.GoogleSearch;
import pages.GoogleSearchResult;

public class GoogleSearchResultTest extends BaseTest {
    @Test
    public void googleSearchResult() {
        GoogleSearchResult googleSearchResult = new GoogleSearchResult(driver);
        googleSearchResult.goToHome();
       // Assert.assertTrue(googleSearchResult.checkIsDisplayed());
       // Assert.assertEquals("staples solutions uk", googleSearchResult.getInputText());
        System.out.println("Number of found : " + googleSearchResult.cuteResult(googleSearchResult.getResultStats()));
        googleSearchResult.goStaplesWebSite();


    }
}
