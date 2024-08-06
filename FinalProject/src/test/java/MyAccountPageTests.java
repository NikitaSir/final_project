import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyAccountPageTests extends TestBase{
    @Test
    public void downloadFileForMyAccount(){
        var pageMyAccount = new MyAccountPage(driver, wait);
        pageMyAccount.open();
        pageMyAccount.inputUserNameElement.sendKeys("nikita");
        pageMyAccount.inputPasswordElement.sendKeys("123456qwerty");
        pageMyAccount.loginButton.click();
        pageMyAccount.accountDetailsTab.click();
        var filePath = System.getProperty("user.dir") + "\\src\\test\\fileForUpload\\bfoto_ru_4761.jpg";
        pageMyAccount.uploadFileElement.sendKeys(filePath);
        pageMyAccount.waitForFile();
        Assertions.assertTrue(pageMyAccount.uploadFile.isDisplayed(), "Файл не загрузился");
    }
    @Test
    public void changingAccountDetailsEmptyName(){
        var pageMyAccount = new MyAccountPage(driver, wait);
        pageMyAccount.open();
        pageMyAccount.inputUserNameElement.sendKeys("nikita");
        pageMyAccount.inputPasswordElement.sendKeys("123456qwerty");
        pageMyAccount.loginButton.click();
        pageMyAccount.accountDetailsTab.click();
        pageMyAccount.inputName.clear();
        pageMyAccount.buttonUpdateDate.click();
        Assertions.assertEquals("Имя обязательное поле.", pageMyAccount.errorMessage.getText(), "Нет текста ошибки");
    }
    @Test
    public void changingAccountDetailsEmptyEmail(){
        var pageMyAccount = new MyAccountPage(driver, wait);
        pageMyAccount.open();
        pageMyAccount.inputUserNameElement.sendKeys("nikita");
        pageMyAccount.inputPasswordElement.sendKeys("123456qwerty");
        pageMyAccount.loginButton.click();
        pageMyAccount.accountDetailsTab.click();
        pageMyAccount.inputEmail.clear();
        pageMyAccount.buttonUpdateDate.click();
        Assertions.assertEquals("Адрес почты обязательное поле.", pageMyAccount.errorMessage.getText(), "Нет текста ошибки");
    }
}
