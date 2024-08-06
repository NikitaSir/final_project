import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestBase {
    public static WebDriver driver;
    public WebDriverWait wait;
    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        var options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }

}
