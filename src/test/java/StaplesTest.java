import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Point;
import pages.Page;
import pages.Staples;

public class StaplesTest extends BaseTest {


    @Test
    public void staplesTest() {
        Staples staples = new Staples(driver);
        staples.goToHome();
        Assert.assertTrue(staples.checkIsDisplayed());
        Point location = staples.locationStaplesLogo();
        Assert.assertTrue(0 <= location.getX() && location.getX() <= 200);
        Assert.assertTrue(0 <= location.getY() && location.getY() <= 200);

        try {
            staples.takeSnapShot(driver, "c://ScreenShot/test.png");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
