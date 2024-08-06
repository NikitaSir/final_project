import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class BonusProgramTests extends TestBase{
    private static Stream<Arguments> inputLoginAndPassword(){
        return Stream.of(
                arguments("Никита", "+1234567891"),
                arguments("nikita","+9098572672")
        );
    }

    @ParameterizedTest
    @MethodSource("inputLoginAndPassword")
    public void inputBioSuccessForBonusProgram(String name, String phone){
        var pageBonusProgram = new BonusProgramPage(driver, wait);
        pageBonusProgram.open();
        pageBonusProgram.inputName.sendKeys(name);
        pageBonusProgram.inputPhone.sendKeys(phone);
        pageBonusProgram.buttonApplyForCard.click();
        var alert = driver.switchTo().alert();
        var alertMessage = alert.getText();
        Assertions.assertEquals("Заявка отправлена, дождитесь, пожалуйста, оформления карты!", alertMessage, "Не успешное оформление карты");
    }
    @ParameterizedTest
    @MethodSource("inputLoginAndPassword")
    public void inputBioSuccessForBonusProgramGetTextSuccessCard(String name, String phone){
        var pageBonusProgram = new BonusProgramPage(driver, wait);
        pageBonusProgram.open();
        pageBonusProgram.inputName.sendKeys(name);
        pageBonusProgram.inputPhone.sendKeys(phone);
        pageBonusProgram.buttonApplyForCard.click();
        var alert = driver.switchTo().alert();
        var alertMessage = alert.getText();
        Assertions.assertEquals("Заявка отправлена, дождитесь, пожалуйста, оформления карты!", alertMessage, "Не успешное оформление карты");
        alert.accept();
        pageBonusProgram.waitForMessageSuccess();
        Assertions.assertEquals("Ваша карта оформлена!", pageBonusProgram.getTextSuccessCard.getText(), "Ошибка оформления карты");
    }
    @ParameterizedTest
    @MethodSource("inputLoginAndPassword")
    public void inputBioSuccessForBonusProgramEmptyPhone(String name, String phone){
        var pageBonusProgram = new BonusProgramPage(driver, wait);
        pageBonusProgram.open();
        pageBonusProgram.inputName.sendKeys(name);
        pageBonusProgram.buttonApplyForCard.click();
        Assertions.assertEquals("Поле \"Телефон\" обязательно для заполнения", pageBonusProgram.errorMessageByEmptyPhone.getText(), "Не успешное оформление карты");
    }
    @Test
    public void inputBioSuccessForBonusProgramEmptyAll(){
        var pageBonusProgram = new BonusProgramPage(driver, wait);
        pageBonusProgram.open();
        pageBonusProgram.buttonApplyForCard.click();
        Assertions.assertEquals("Поле \"Имя\" обязательно для заполнения\n" +
                "Поле \"Телефон\" обязательно для заполнения", pageBonusProgram.errorMessageByEmptyPhone.getText(), "Не успешное оформление карты");
    }
}
