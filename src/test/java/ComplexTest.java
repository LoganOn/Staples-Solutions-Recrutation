import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Point;
import pages.GoogleSearch;
import pages.GoogleSearchResult;
import pages.Staples;

public class ComplexTest extends BaseTest {
    @Test
    public void ComplexTest() {
        GoogleSearch googleSearch = new GoogleSearch(driver);
        GoogleSearchResult googleSearchResult = new GoogleSearchResult(driver);
        Staples staples = new Staples(driver);

        googleSearch.goToHome();
        Assert.assertTrue(googleSearch.checkIsDisplayed());
        googleSearch.enterQuery("staples solutions uk");
        googleSearch.search();

        System.out.println("Number of found : " + googleSearchResult.cuteResult(googleSearchResult.getResultStats()));
        googleSearchResult.goStaplesWebSite();

        Assert.assertTrue(staples.checkIsDisplayed());
        Point location = staples.locationStaplesLogo();
        Assert.assertTrue(0 <= location.getX() && location.getX() <= (staples.getSizeWebSite().width) * 0.15);
        Assert.assertTrue(0 <= location.getY() && location.getY() <= (staples.getSizeWebSite().height) * 0.15);

        try {
            staples.takeSnapShot(driver, "c://ScreenShot/test.png");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
