import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private JavascriptExecutor jsExecutor;

    public HeaderPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
        jsExecutor = (JavascriptExecutor)driver;
    }

    public void open() {
        driver.navigate().to("http://pizzeria.skillbox.cc/");
    }

    @FindBy(css = ".slick-prev")
    public WebElement swapLeft; //кнопка стрелка влево
    @FindBy(css = ".slick-next")
    public WebElement swapRight; //кнопка стрелка вправо
    @FindBy(xpath = "(//div//a[@title = 'Пицца «Пепперони»']/h3)[2]")
    public WebElement pizzaPepperoni; // пицца Пепперони в меню на главной старнице
    @FindBy(xpath = "//li//div//a[@title = 'Десерт «Булочка с корицей»']")
    public WebElement clickOnDessert;
    @FindBy(css = "#accesspress_store_product-6 a h3:first-of-type")
    public WebElement nameDessert;
    @FindBy(css = ".woocommerce-breadcrumb.accesspress-breadcrumb span")
    public WebElement nameDessertInPageDessert;
    @FindBy(css = ".prod1-slider .product-slider ul .slick-list.draggable:nth-of-type(1)")
    public WebElement productSlider;
    @FindBy(tagName = "html")
    public WebElement page;
    @FindBy(xpath = "(//div[@class = 'item-img'])[15]")
    public WebElement cappuccinoDrink;
    @FindBy(xpath = "(//div[@class = 'item-img'])[15]//a[@class = 'button product_type_simple add_to_cart_button ajax_add_to_cart']")
    public WebElement inBasket;
    @FindBy(xpath = "(//*[@class = 'prod2-slider']//*[@class = 'item-img'])[1]")
    public WebElement cardDessert; // Булочка с корицей
    @FindBy(css = ".product_title.entry-title")
    public WebElement getDessertName;
    @FindBy(xpath = "//div[@id = 'ak-top'][@style = 'right: 20px;']")
    public WebElement buttonUp;
    @FindBy(css = "p.text-5-value:nth-of-type(4) a")
    public WebElement linkVK;
    @FindBy(xpath = "(//*[@id = 'accesspress_store_product-7']/ul/div//h3)[1]")
    public WebElement getTextDrink;
    @FindBy(xpath = "(//*[@id = 'accesspress_store_product-7']/ul/div//li//a)[1]")
    public WebElement drinkButton;

    public void waitForReceivingTheFirstCourseInTheDeferredTab(){
        wait.until(driver -> driver.findElement(By.xpath("(//div//a[@title = 'Пицца «Пепперони»']/h3)[2]")).isDisplayed());
    }
    public void buttonSwapRightWaitDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(productSlider));
    }

    public void visibleSelectOne(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("document.getElementsByClassName('slick-next')[0].style = 'display:block;'");
    }

    public void goToButtonSwap(){
        new Actions(driver)
                .moveToElement(swapRight)
                .perform();
        wait.until(ExpectedConditions.visibilityOf(swapRight));
        new Actions(driver)
                .moveToElement(swapRight)
                .click()
                .perform();
        wait.until(ExpectedConditions.visibilityOf(pizzaPepperoni));
    }

    public void scrollToFirstRecords(int countScroll){
        for(var i = 0; i < countScroll; i++) {
            page.sendKeys(Keys.ARROW_DOWN);
        }
    }

    public void buttonInBuBasket(){
        new Actions(driver)
                .moveToElement(cappuccinoDrink)
                .perform();
        wait.until(ExpectedConditions.visibilityOf(cappuccinoDrink));
    }



}
