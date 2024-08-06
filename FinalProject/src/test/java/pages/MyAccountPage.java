import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public MyAccountPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void open(){
        driver.navigate().to("https://pizzeria.skillbox.cc/my-account/");
    }
    @FindBy(xpath = "//nav/ul/li/a[text() = 'Данные аккаунта']")
    public WebElement accountDetailsTab;
    @FindBy(css = "#uploadFile")
    public WebElement uploadFileElement;
    @FindBy(css = "#uploadPreview")
    public WebElement uploadFile;
    @FindBy(css = "#username")
    public WebElement inputUserNameElement;
    @FindBy(css = "#password")
    public WebElement inputPasswordElement;
    @FindBy(css = ".woocommerce-button.button.woocommerce-form-login__submit")
    public WebElement loginButton;
    @FindBy(css = "#account_first_name")
    public WebElement inputName;
    @FindBy(css = ".woocommerce-Button.button")
    public WebElement buttonUpdateDate;
    @FindBy(css = ".woocommerce-error li")
    public WebElement errorMessage;
    @FindBy(css = "#account_email")
    public WebElement inputEmail;

    public void waitForFile(){
        wait.until(ExpectedConditions.visibilityOf(uploadFile));
    }
}
