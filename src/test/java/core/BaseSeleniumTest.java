package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.chrome.ChromeOptions;

abstract public class BaseSeleniumTest {
    protected WebDriver driver;

    @Before
    public void setUp() {
        //WebDriverManager.chromedriver().setup();
        System.setProperty("chromeoptions.args", "--remote-allow-origins=*");
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        BaseSeleniumPage.setDriver(driver);
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
