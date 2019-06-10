import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    public WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Konrad\\Downloads\\Selenium_StaplesSolutions\\src\\test\\java\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=pl");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }
    @After
    public void tearDown() {
        driver.quit();
    }

}
