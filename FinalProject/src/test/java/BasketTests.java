import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTests extends TestBase{
    @Test
    public void increasingTheQuantityAndGettingTheTotalAmount(){
        var page = new BasketPage(driver, wait);
        page.open();
        page.inBasketButton.click();
        page.moreDetailsButton.click();
        var getFirstTotalPricePizza = page.getConvertIntegerPrice(page.totalPriceOnePizza.getText());
        page.inputCountPizza.clear();
        page.inputCountPizza.sendKeys("2");
        page.buttonUpdateBasket.click();
        page.messageCardUpdate.isDisplayed();
        var getSecondTotalPricePizza = page.getConvertIntegerPrice(page.totalPriceOnePizza.getText());
        Assertions.assertEquals(getFirstTotalPricePizza * 2, getSecondTotalPricePizza, "Разная цена пицц");
    }
    @Test
    public void addingTwoItemsToCart(){
        var page = new BasketPage(driver, wait);
        page.open();
        page.inBasketButton.click();
        page.inBasketButtonTwoItem.click();
        page.moreDetailsButton.click();
        Assertions.assertEquals(2, page.getCountItemsInBasket(), "Количество товаров ращличается");
    }

    @Test
    public void updateCartContents(){
        var page = new BasketPage(driver, wait);
        page.open();
        page.inBasketButton.click();
        page.moreDetailsButton.click();
        page.inputCountPizza.clear();
        page.inputCountPizza.sendKeys("5");
        page.buttonUpdateBasket.click();
        Assertions.assertTrue(page.messageCardUpdate.isDisplayed(), "Корзина не обновилась");
    }
    @Test
    public void deletePizzaFromBasket(){
        var page = new BasketPage(driver, wait);
        page.open();
        page.inBasketButton.click();
        page.moreDetailsButton.click();
        Assertions.assertTrue(page.availabilityOfGoodsInTheCart.isDisplayed(), "Нет товара в корзине");
        page.deletePizzaFromBasket.click();
        Assertions.assertAll(
                () -> Assertions.assertTrue(page.messageAboutDeletePizza.isDisplayed(), "Корзина не обновилась"),
                () -> Assertions.assertEquals("Корзина пуста.", page.messageBasketIsEmpty.getText(), "Корзина не пуста")
        );
    }
    @Test
    public void applyingAPromotionalCode(){
        var page = new BasketPage(driver, wait);
        page.open();
        page.inBasketButton.click();
        page.moreDetailsButton.click();
        var getFirstTotalPricePizza = page.getConvertIntegerPrice(page.totalPriceOnePizza.getText());
        page.inputPromoCodeElement.sendKeys("GIVEMEHALYAVA");
        page.buttonApplyCoupon.click();
        page.messageCardUpdate.isDisplayed();
        page.waitForSaleCoupon();
        page.waitForTotalPriceBasket();
        var getSecondTotalPriceBasket = page.getConvertIntegerPrice(page.totalPriceBasket.getText());
        Assertions.assertEquals(getFirstTotalPricePizza - (getFirstTotalPricePizza * 0.1), getSecondTotalPriceBasket, "Разная цена пицц");
    }
    @Test
    public void switchToPaymentForm(){
        var page = new BasketPage(driver, wait);
        page.open();
        page.inBasketButton.click();
        page.moreDetailsButton.click();
        page.goToPayButton.click();
        page.linkAuthorization.click();
        page.inputUserNameElement.sendKeys("nikita");
        page.inputPasswordElement.sendKeys("123456qwerty");
        page.loginButton.click();
        Assertions.assertEquals("ОФОРМЛЕНИЕ ЗАКАЗА", page.headerCheckout.getText(), "Другая страница");
    }

    @Test
    public void setTheDateAndPlacingAnOrder(){
        var pagePlacingAnOrder = new PlacingAnOrderPage(driver, wait);
        var page = new BasketPage(driver, wait);
        page.open();
        page.inBasketButton.click();
        page.moreDetailsButton.click();
        page.goToPayButton.click();
        page.linkAuthorization.click();
        page.inputUserNameElement.sendKeys("nikita");
        page.inputPasswordElement.sendKeys("123456qwerty");
        page.loginButton.click();
        pagePlacingAnOrder.inputName.sendKeys("Имя");
        pagePlacingAnOrder.inputLastname.sendKeys("Фамилия");
        pagePlacingAnOrder.inputName.sendKeys("Имя");
        pagePlacingAnOrder.inputAddress.sendKeys("Ленина 10");
        pagePlacingAnOrder.inputCity.sendKeys("Пермь");
        pagePlacingAnOrder.inputRegion.sendKeys("Пермский край");
        pagePlacingAnOrder.inputPostIndex.sendKeys("4343");
        pagePlacingAnOrder.inputPhone.sendKeys("123456789");
        pagePlacingAnOrder.cashPaymentCheckBox.click();
        pagePlacingAnOrder.datePicker.sendKeys("23022024");
        pagePlacingAnOrder.checkboxConditions.click();
        pagePlacingAnOrder.checkoutButton.click();
        pagePlacingAnOrder.waitForPageOrder();
        Assertions.assertEquals("ЗАКАЗ ПОЛУЧЕН", pagePlacingAnOrder.namePageHeader.getText(), "Не получилось перейти на страницу заказа");
    }
    @Test
    public void setTheDateAndPlacingAnOrderEmptyName(){
        var pagePlacingAnOrder = new PlacingAnOrderPage(driver, wait);
        var page = new BasketPage(driver, wait);
        page.open();
        page.inBasketButton.click();
        page.moreDetailsButton.click();
        page.goToPayButton.click();
        page.linkAuthorization.click();
        page.inputUserNameElement.sendKeys("nikita");
        page.inputPasswordElement.sendKeys("123456qwerty");
        page.loginButton.click();
        pagePlacingAnOrder.inputName.sendKeys("Имя");
        pagePlacingAnOrder.inputLastname.sendKeys("Фамилия");
        pagePlacingAnOrder.inputName.sendKeys("Имя");
        pagePlacingAnOrder.inputAddress.sendKeys("Ленина 10");
        pagePlacingAnOrder.inputCity.sendKeys("Пермь");
        pagePlacingAnOrder.inputRegion.sendKeys("Пермский край");
        pagePlacingAnOrder.inputPostIndex.sendKeys("4343");
        pagePlacingAnOrder.inputPhone.sendKeys("123456789");
        pagePlacingAnOrder.cashPaymentCheckBox.click();
        pagePlacingAnOrder.datePicker.sendKeys("23022024");
        pagePlacingAnOrder.checkboxConditions.click();
        pagePlacingAnOrder.inputName.clear();
        pagePlacingAnOrder.checkoutButton.click();
        Assertions.assertEquals("Имя для выставления счета", page.errorMessage.getText(), "Ошибки нет");
    }
    @Test
    public void setTheDateAndPlacingAnOrderEmptyEmail(){
        var pagePlacingAnOrder = new PlacingAnOrderPage(driver, wait);
        var page = new BasketPage(driver, wait);
        page.open();
        page.inBasketButton.click();
        page.moreDetailsButton.click();
        page.goToPayButton.click();
        page.linkAuthorization.click();
        page.inputUserNameElement.sendKeys("nikita");
        page.inputPasswordElement.sendKeys("123456qwerty");
        page.loginButton.click();
        pagePlacingAnOrder.inputName.sendKeys("Имя");
        pagePlacingAnOrder.inputLastname.sendKeys("Фамилия");
        pagePlacingAnOrder.inputName.sendKeys("Имя");
        pagePlacingAnOrder.inputAddress.sendKeys("Ленина 10");
        pagePlacingAnOrder.inputCity.sendKeys("Пермь");
        pagePlacingAnOrder.inputRegion.sendKeys("Пермский край");
        pagePlacingAnOrder.inputPostIndex.sendKeys("4343");
        pagePlacingAnOrder.inputPhone.sendKeys("123456789");
        pagePlacingAnOrder.cashPaymentCheckBox.click();
        pagePlacingAnOrder.datePicker.sendKeys("23022024");
        pagePlacingAnOrder.checkboxConditions.click();
        pagePlacingAnOrder.inputEmail.clear();
        pagePlacingAnOrder.checkoutButton.click();
        Assertions.assertEquals("Адрес почты для выставления счета", page.errorMessage.getText(), "Ошибки нет");
    }
}
