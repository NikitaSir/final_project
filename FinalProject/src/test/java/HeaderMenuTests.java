import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HeaderMenuTests extends TestBase{
    @Test
    public void checkingAllMenuItemsPizza(){
        var page = new HeaderMenuPage(driver, wait);
        page.open();
        page.goToMenuElement(page.menuPizzaLink);
        Assertions.assertEquals("ПИЦЦА", page.namePagePizzaDessertAndDrink.getText(), "Откралсь другая страница");
    }
    @Test
    public void checkingAllMenuItemsDessert(){
        var page = new HeaderMenuPage(driver, wait);
        page.open();
        page.goToMenuElement(page.menuDessertLink);
        Assertions.assertEquals("ДЕСЕРТЫ", page.namePagePizzaDessertAndDrink.getText(), "Откралсь другая страница");
    }
    @Test
    public void checkingAllMenuItemsDrink(){
        var page = new HeaderMenuPage(driver, wait);
        page.open();
        page.goToMenuElement(page.menuDrinkLink);
        Assertions.assertEquals("НАПИТКИ", page.namePagePizzaDessertAndDrink.getText(), "Откралсь другая страница");
    }
    @Test
    public void checkingAllMenuItemsShippingAndPayment(){
        var page = new HeaderMenuPage(driver, wait);
        page.open();
        page.goToMenuElement(page.deliveryAndPayment);
        Assertions.assertEquals("ДОСТАВКА И ОПЛАТА", page.namePageDeliveryAndPaymentStocksAboutAs.getText(), "Откралсь другая страница");
    }
    @Test
    public void checkingAllMenuItemsStocks(){
        var page = new HeaderMenuPage(driver, wait);
        page.open();
        page.goToMenuElement(page.stocksLink);
        Assertions.assertEquals("АКЦИИ", page.namePageDeliveryAndPaymentStocksAboutAs.getText(), "Откралсь другая страница");
    }
    @Test
    public void checkingAllMenuItemsAboutAs(){
        var page = new HeaderMenuPage(driver, wait);
        page.open();
        page.goToMenuElement(page.aboutAsLink);
        Assertions.assertEquals("О НАС", page.namePageDeliveryAndPaymentStocksAboutAs.getText(), "Откралсь другая страница");
    }
    @Test
    public void checkingAllMenuItemsBasket(){
        var page = new HeaderMenuPage(driver, wait);
        page.open();
        page.goToMenuElement(page.basketLink);
        Assertions.assertEquals("Корзина", page.namePageBasket.getText(), "Откралсь другая страница");
    }
    @Test
    public void checkingAllMenuItemsMyAccount(){
        var page = new HeaderMenuPage(driver, wait);
        page.open();
        page.goToMenuElement(page.myAccountLink);
        Assertions.assertEquals("МОЙ АККАУНТ", page.namePageDeliveryAndPaymentStocksAboutAs.getText(), "Откралсь другая страница");
    }
    @Test
    public void checkingAllMenuItemsBonusProgram(){
        var page = new HeaderMenuPage(driver, wait);
        page.open();
        page.goToMenuElement(page.bonusProgramLink);
        Assertions.assertEquals("БОНУСНАЯ ПРОГРАММА", page.namePageDeliveryAndPaymentStocksAboutAs.getText(), "Откралсь другая страница");
    }
}
