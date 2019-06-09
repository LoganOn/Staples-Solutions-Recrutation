import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class GoogleTest {
    private WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Konrad\\Downloads\\Selenium_StaplesSolutions\\src\\test\\java\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=us");
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

    }

    @Test
    public void googleSearchTest() {

    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
