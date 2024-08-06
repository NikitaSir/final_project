import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PizzaPage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private JavascriptExecutor jsExecutor;

    public PizzaPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
        jsExecutor = (JavascriptExecutor)driver;
    }

    public void open() {
        driver.navigate().to("https://pizzeria.skillbox.cc/product-category/menu/pizza/");
    }
    @FindBy(css = ".orderby")
    public WebElement selectPizza;
    @FindBy(xpath = "(//div[@class = 'collection_desc clearfix']/a/h3)[1]")
    public WebElement firstPizzaInSorting;
    @FindBy(xpath = "(//div[@class = 'price-cart']/a)[1]")
    public WebElement inBasketButton;
    @FindBy(xpath = "//div[@class = 'price-cart']/a[@title = 'Подробнее']")
    public WebElement moreDetailsButton;
    @FindBy(css = ".ui-slider-handle.ui-state-default.ui-corner-all:nth-of-type(2)")
    public WebElement rightScrollFilterPizza;
    @FindBy(css = "button.button")
    public WebElement buttonFilterApply;

    public void setSelectPlaylist(String value){
        var playlist = new Select(selectPizza);
        playlist.selectByValue(value);
    }
    public String getSelectPlaylist(){
        var playlist = new Select(selectPizza);
        return playlist.getFirstSelectedOption().getText();
    }

    public void waitForButtonMoreDetails(){
        wait.until(driver -> driver.findElements(By.xpath("//div[@class = 'price-cart']/a[@title = 'Подробнее']")).size() == 1);
    }

    public void filterForPizzaPrice(int xOffset, int yOffset){
        new Actions(driver)
                .dragAndDropBy(rightScrollFilterPizza, xOffset, yOffset)
                .perform();
    }

    public int countPizza(){
        return driver.findElements(By.cssSelector(".products.columns-4 li")).size();
    }

}
