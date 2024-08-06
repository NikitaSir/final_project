import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlacingAnOrderPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public PlacingAnOrderPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to("https://pizzeria.skillbox.cc/checkout/");
    }

    @FindBy(css = "#billing_first_name")
    public WebElement inputName;
    @FindBy(css = "#billing_last_name")
    public WebElement inputLastname;
    @FindBy(css = "#billing_address_1")
    public WebElement inputAddress;
    @FindBy(css = "#billing_city")
    public WebElement inputCity;
    @FindBy(css = "#billing_state")
    public WebElement inputRegion;
    @FindBy(css = "#billing_postcode")
    public WebElement inputPostIndex;
    @FindBy(css = "#billing_phone")
    public WebElement inputPhone;
    @FindBy(css = ".wc_payment_method.payment_method_cod .input-radio")
    public WebElement cashPaymentCheckBox;
    @FindBy(css = ".button.alt")
    public WebElement checkoutButton;
    @FindBy(css = "p label input")
    public WebElement checkboxConditions;
    @FindBy(css = "#order_date")
    public WebElement datePicker;
    @FindBy(css = ".post-title")
    public WebElement namePageHeader;
    @FindBy(css = ".woocommerce-order p")
    public WebElement waitElement;
    @FindBy(css = "#billing_email")
    public WebElement inputEmail;

    public void waitForPageOrder() {
        wait.until(ExpectedConditions.visibilityOf(waitElement));
    }
}
