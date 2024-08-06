import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BonusProgramPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BonusProgramPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void open(){
        driver.navigate().to("https://pizzeria.skillbox.cc/bonus/");
    }

    @FindBy(css = "#bonus_username")
    public WebElement inputName;
    @FindBy(css = "#bonus_phone")
    public WebElement inputPhone;
    @FindBy(css = "#bonus_main button")
    public WebElement buttonApplyForCard;
    @FindBy(css = "#bonus_main h3")
    public WebElement getTextSuccessCard;
    @FindBy(css = "#bonus_content")
    public WebElement errorMessageByEmptyPhone;

    public void waitForMessage(){
        wait.until(ExpectedConditions.visibilityOf(getTextSuccessCard));
    }
    public void waitForMessageSuccess(){
        var loaderPointWait = driver.findElements(By.cssSelector(".loaderPoint")).size();
        if (loaderPointWait != 0){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        }
    }
}
