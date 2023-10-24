package NevzatHocaPracticeDersleri.QualityPage.tests2;

import NevzatHocaPracticeDersleri.QualityPage.pages2.QualityPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class dataProvider {
    QualityPage page=new QualityPage();


    @DataProvider
    public static Object[][] gonderilecekMail() {
         Object[][]gonderilecekMailvePassword={{"nevzat","1234"},
                                               {"nevzat@hotmail.com","12345"},
                                                {"ahmet@hotmail.com","nevzat12345"},
                                                 {"celik@hotmail.com","nevzat"},
                                                 {"anevzatcelik@gmail.com","Nevzat152032"}};
         return gonderilecekMailvePassword;
    }
    @Test(dataProvider = "gonderilecekMail")
    public void qualityTest(String mail,String password){
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        page.providerMethod(mail,password);

         /*  if(page.cookies.isDisplayed()) {//cookies ilk giriste cikiyor ,geri kalan islemlerde cikmadigi icin boyle yaptik
            page.cookies.click();

        }else {
            page.loginLink.click();
            page.mail.sendKeys(mail);
            page.password.sendKeys(password);
            ReusableMethods.bekle(2);
            page.loginBtn.click();
        }*/

    }@Test
    public void loginOlmaTesti(){
        page.loginOl();
        Driver.closeDriver();
    }
}
