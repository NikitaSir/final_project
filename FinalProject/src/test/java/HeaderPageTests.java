import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

public class HeaderPageTests extends TestBase{
    @Test
    public void swapPizzaInHeadPage(){
        var page = new HeaderPage(driver, wait);
        page.open();
        page.goToButtonSwap();
        Assertions.assertTrue(page.pizzaPepperoni.isDisplayed(), "Пицца не отображена");
    }

    @Test
    public void goToDessertPage(){
        var page = new HeaderPage(driver, wait);
        page.open();
        page.scrollToFirstRecords(33);
        page.buttonInBuBasket();
        Assertions.assertTrue(page.inBasket.isDisplayed(), "Кнопка В корзину не отобразилась");
    }

    @Test
    public void openPageDessert(){
        var page = new HeaderPage(driver, wait);
        page.open();
        page.scrollToFirstRecords(20);
        page.cardDessert.click();
        Assertions.assertEquals("Десерт «Булочка с корицей»", page.getDessertName.getText(), "Название десерта не соответствует");
    }
    @Test
    public void buttonUpIsDisplayed(){
        var page = new HeaderPage(driver, wait);
        page.open();
        page.scrollToFirstRecords(30);
        Assertions.assertTrue(page.buttonUp.isDisplayed(), "Кнопка вверх не появилась");
    }
    @Test
    public void goToDessertPageAndGetText(){
        var page = new HeaderPage(driver, wait);
        page.open();
        page.scrollToFirstRecords(20);
        var getNameDessertInHeaderPage = page.nameDessert.getText();
        page.cardDessert.click();
        Assertions.assertEquals(getNameDessertInHeaderPage, page.getDessertName.getText().toUpperCase(), "Не верное название позиции");
    }
    @Test
    public void goToDrinkPageAndGetText(){
        var page = new HeaderPage(driver, wait);
        page.open();
        page.scrollToFirstRecords(25);
        var getTextDrink = page.getTextDrink.getText();
        page.drinkButton.click();
        Assertions.assertEquals(getTextDrink, page.getDessertName.getText().toUpperCase(),"Не верное название позиции");
    }

    @Test
    public void openLinkVK(){
        var page = new HeaderPage(driver, wait);
        page.open();
        var initialWindow = driver.getWindowHandle();
        page.linkVK.click();
        var exceptionURL = "https://vk.com/skillbox";
        var allWindows = driver.getWindowHandles();
        var otherWindows = allWindows.stream().filter(w -> !w.equals(initialWindow)).collect(Collectors.toSet());
        driver.switchTo().window(otherWindows.stream().findFirst().get());
        Assertions.assertAll(
                () -> Assertions.assertEquals(2, allWindows.size(), "Разное количество вкладок"),
                () -> Assertions.assertEquals(exceptionURL, driver.getCurrentUrl(), "Разнае ссылки")
        );
    }
}
