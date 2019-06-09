import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class GoogleTest {
    private WebDriver driver;
    private WebDriverWait wait;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Konrad\\Downloads\\Selenium_StaplesSolutions\\src\\test\\java\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=pl");
        driver =  new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");


    }

    @Test
    public void googleSearchTest() {
        wait.until(visibilityOfElementLocated(By.className("gLFyf")));
        driver.findElement(By.className("gLFyf")).sendKeys("staples solutions uk");
        wait.until(ExpectedConditions.elementToBeClickable(By.className("gNO89b")));
        driver.findElement(By.className("gNO89b")).click();




    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
