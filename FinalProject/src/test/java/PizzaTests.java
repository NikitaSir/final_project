import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PizzaTests extends TestBase{

    @Test
    public void sortingPizza(){
        var page = new PizzaPage(driver, wait);
        page.open();
        var expectedPizza = "price-desc";
        page.setSelectPlaylist(expectedPizza);
        Assertions.assertEquals("Пицца «Рай»", page.firstPizzaInSorting.getText(), "Название пицц не совпадает");
    }
    @Test
    public void sortingPizzaAsc(){
        var page = new PizzaPage(driver, wait);
        page.open();
        var expectedPizza = "price";
        page.setSelectPlaylist(expectedPizza);
        Assertions.assertEquals("Пицца «4 в 1»", page.firstPizzaInSorting.getText(), "Название пицц не совпадает");
    }

    @Test
    public void clickButtonInBasketPizza(){
        var page = new PizzaPage(driver, wait);
        page.open();
        page.inBasketButton.click();
        page.waitForButtonMoreDetails();
        Assertions.assertEquals("ПОДРОБНЕЕ", page.moreDetailsButton.getText(), "Кнопка В корзину не нажата");
    }
    @Test
    public void filterForPizzaPrice(){
        var page = new PizzaPage(driver, wait);
        page.open();
        page.filterForPizzaPrice(-130, 0);
        page.buttonFilterApply.click();
        Assertions.assertEquals(3, page.countPizza(), "Разное количество пицц");
    }
    @Test
    public void filterForPizzaPriceOnePizza(){
        var page = new PizzaPage(driver, wait);
        page.open();
        page.filterForPizzaPrice(-230, 0);
        page.buttonFilterApply.click();
        Assertions.assertEquals(2, page.countPizza(), "Разное количество пицц");
    }
}
