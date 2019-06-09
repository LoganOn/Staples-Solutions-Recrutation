import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.io.File;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class GoogleTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Konrad\\Downloads\\Selenium_StaplesSolutions\\src\\test\\java\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=pl");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");


    }

    @Test
    public void googleSearchTest() throws Exception {
        wait.until(visibilityOfElementLocated(By.className("gLFyf")));
        driver.findElement(By.className("gLFyf")).sendKeys("staples solutions uk");

        wait.until(ExpectedConditions.elementToBeClickable(By.className("gNO89b")));
        driver.findElement(By.className("gNO89b")).click();

        wait.until(visibilityOfElementLocated(By.id("resultStats")));
        String result = driver.findElement(By.id("resultStats")).getText();
        System.out.println("Number of found : " + cuteResult(result));

        driver.findElement(By.xpath("//a[@href='https://www.staples.co.uk/']")).click();
        wait.until(visibilityOfElementLocated(By.className("hdr_logo")));
        boolean isLogoDisplayed = driver.findElement(By.className("hdr_logo")).isDisplayed();
        Assert.assertTrue(isLogoDisplayed);
        Point loc = driver.findElement(By.className("hdr_logo")).getLocation();
        //int locX = loc.getX();
        //int locY = loc.getY();
        //System.out.println(loc);
        takeSnapShot(driver, "c://ScreenShot/test.png") ;
    }

    @After
    public void tearDown() {
        driver.quit();
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
    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);

    }


}
