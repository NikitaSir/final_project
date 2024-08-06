import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShippingAndPaymentTests extends TestBase{
    @Test
    public void getTextConditionMinSum(){
        var pageShippingAndPayment = new ShippingAndPaymentPage(driver,wait);
        pageShippingAndPayment.open();
        pageShippingAndPayment.switchToFrame();
        Assertions.assertEquals("Минимальная сумма заказа 800 рублей.", pageShippingAndPayment.messageText.getText(), "Не верный текст");
    }
    @Test
    public void getTextConditionFreeDelivery(){
        var pageShippingAndPayment = new ShippingAndPaymentPage(driver,wait);
        pageShippingAndPayment.open();
        pageShippingAndPayment.switchToFrame();
        Assertions.assertEquals("Доставка заказа осуществляется бесплатно.", pageShippingAndPayment.messageTextFreeDelivery.getText(), "Не верный текст");
    }
    @Test
    public void getTextConditionOperatingMode(){
        var pageShippingAndPayment = new ShippingAndPaymentPage(driver,wait);
        pageShippingAndPayment.open();
        pageShippingAndPayment.switchToFrame();
        Assertions.assertEquals("Заказ можно сделать с 9:00 до 23:59", pageShippingAndPayment.messageTextOperatingMode.getText(), "Не верный текст");
    }
}
