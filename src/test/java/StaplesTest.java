import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Point;
import pages.Staples;

public class StaplesTest extends BaseTest {


    @Test
    public void staplesTest() {
        Staples staples = new Staples(driver);
        staples.goToHome();
        Assert.assertTrue(staples.checkIsDisplayed());
        Point location = staples.locationStaplesLogo();
        Assert.assertTrue(0 <= location.getX() && location.getX() <= (staples.getSizeWebSite().width)*0.15);
        Assert.assertTrue(0 <= location.getY() && location.getY() <= (staples.getSizeWebSite().height)*0.15);

        try {
            staples.takeSnapShot(driver, "c://ScreenShot/test.png");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
