import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingAndPaymentPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public ShippingAndPaymentPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void open(){
        driver.navigate().to("https://pizzeria.skillbox.cc/delivery/");
    }
    @FindBy(xpath = "(//li)[2]")
    public WebElement messageText;
    @FindBy(css = ".content-page iframe")
    public WebElement switchToFrame;
    @FindBy(xpath = "(//li)[3]")
    public WebElement messageTextFreeDelivery;
    @FindBy(xpath = "(//li)[4]")
    public WebElement messageTextOperatingMode;

    public void switchToFrame(){
        driver.switchTo().frame(switchToFrame);
    }
}
