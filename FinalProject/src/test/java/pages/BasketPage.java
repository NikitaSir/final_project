import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasketPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to("https://pizzeria.skillbox.cc/product-category/menu/pizza/");
    }
    @FindBy(xpath = "(//div[@class = 'price-cart']/a)[1]")
    public WebElement inBasketButton;
    @FindBy(xpath = "(//div[@class = 'price-cart']/a)[2]")
    public WebElement inBasketButtonTwoItem;
    @FindBy(xpath = "//div[@class = 'price-cart']/a[@title = 'Подробнее']")
    public WebElement moreDetailsButton;
    @FindBy(css = ".input-text.qty.text")
    public WebElement inputCountPizza;
    @FindBy(xpath = "(//button[@class = 'button'])[2]")
    public WebElement buttonUpdateBasket;
    @FindBy(xpath = "(//span[@class = 'woocommerce-Price-amount amount']/bdi)[2]")
    public WebElement totalPriceOnePizza;
    @FindBy(css = ".woocommerce-message")
    public WebElement messageCardUpdate;
    @FindBy(css = "input#coupon_code.input-text:last-of-type")
    public WebElement inputPromoCodeElement;
    @FindBy(css = ".coupon .button")
    public WebElement buttonApplyCoupon;
    @FindBy(css = ".remove")
    public WebElement deletePizzaFromBasket;
    @FindBy(css = ".woocommerce-cart-form__cart-item.cart_item")
    public WebElement availabilityOfGoodsInTheCart;
    @FindBy(css = ".cart-empty.woocommerce-info")
    public WebElement messageBasketIsEmpty;
    @FindBy(css = ".woocommerce-message")
    public WebElement messageAboutDeletePizza;
    @FindBy(css = ".order-total td span bdi")
    public WebElement totalPriceBasket;
    @FindBy(css = ".checkout-button.button.alt.wc-forward")
    public WebElement goToPayButton;
    @FindBy(css = ".showlogin")
    public WebElement linkAuthorization;
    @FindBy(css = "#username")
    public WebElement inputUserNameElement;
    @FindBy(css = "#password")
    public WebElement inputPasswordElement;
    @FindBy(css = ".woocommerce-button.button.woocommerce-form-login__submit")
    public WebElement loginButton;
    @FindBy(css = ".post-title")
    public WebElement headerCheckout;
    @FindBy(css = "tr.cart-discount.coupon-givemehalyava th")
    public WebElement saleCoupon;
    @FindBy(css = "ul.woocommerce-error li strong")
    public WebElement errorMessage;


    public int getConvertIntegerPrice(String price){
        return Integer.parseInt(price.replaceAll("[^0-9]", ""));
    }
    public void waitForTotalPriceBasket(){
        wait.until(ExpectedConditions.visibilityOf(totalPriceBasket)).isDisplayed();
    }
    public void waitForSaleCoupon(){
        wait.until(ExpectedConditions.visibilityOf(saleCoupon));
    }
    public int getCountItemsInBasket(){
        return driver.findElements(By.cssSelector(".woocommerce-cart-form__cart-item.cart_item")).size();
    }

}


