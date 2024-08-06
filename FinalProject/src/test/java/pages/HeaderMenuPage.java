import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderMenuPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public HeaderMenuPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to("https://pizzeria.skillbox.cc/");
    }
    @FindBy(css = "#menu-item-390 a")
    public WebElement menuPizzaLink;
    @FindBy(css = "#menu-item-389 a")
    public WebElement menuMenu;
    @FindBy(css = ".entry-title.ak-container")
    public WebElement namePagePizzaDessertAndDrink;
    @FindBy(css = "#menu-item-391 a")
    public WebElement menuDessertLink;
    @FindBy(css = "#menu-item-393 a")
    public WebElement menuDrinkLink;
    @FindBy(css = "#menu-item-381 a")
    public WebElement deliveryAndPayment;
    @FindBy(css = ".post-title")
    public WebElement namePageDeliveryAndPaymentStocksAboutAs;
    @FindBy(css = "#menu-item-396 a")
    public WebElement stocksLink;
    @FindBy(css = "#menu-item-380 a")
    public WebElement aboutAsLink;
    @FindBy(css = "#menu-item-29 a")
    public WebElement basketLink;
    @FindBy(css = ".current")
    public WebElement namePageBasket;
    @FindBy(css = "#menu-item-30 a")
    public WebElement myAccountLink;
    @FindBy(css = "#menu-item-31 a")
    public WebElement placingAnOrderLink;
    @FindBy(css = "#menu-item-363 a")
    public WebElement bonusProgramLink;

    public void goToMenuElement(WebElement menuItem){
        new Actions(driver)
                .moveToElement(menuMenu)
                .perform();
        wait.until(ExpectedConditions.visibilityOf(menuMenu));
        new Actions(driver)
                .moveToElement(menuItem)
                .click()
                .perform();
    }
}
