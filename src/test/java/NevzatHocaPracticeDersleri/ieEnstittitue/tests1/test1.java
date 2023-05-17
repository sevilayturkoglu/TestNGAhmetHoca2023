package NevzatHocaPracticeDersleri.ieEnstittitue.tests1;

import NevzatHocaPracticeDersleri.ieEnstittitue.pages1.*;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class test1 {
    UdemyPage homePage=new UdemyPage();
    LoginPage loginPage=new LoginPage();
    MyPage myPage=new MyPage();
    EgitimlerPage egitimlerPage=new EgitimlerPage();
    KimlikDogrulamaPage kimlik=new KimlikDogrulamaPage();
    OrtakAdimlar ortakAdimlar=new OrtakAdimlar();
    ProfilCheckPage profil=new ProfilCheckPage();
    @Test
    public void tesA(){
        // Kullanici https://www.iienstitu.com/en sayfasina gider
       // Driver.getDriver().get("https://www.iienstitu.com/en");
        // Login butonuna tiklar
        // Giris bilgilerini girer ve basarili sekilde giris yaptigini test eder
        loginPage.loginOl();
        Assert.assertTrue(myPage.loggedCheckControl.isDisplayed());
        // headers da bulunan egitimler kismina tiklar
        myPage.egitimlerOnHeaders.click();
        // acilan egitimler sayfasindan fiyat araligi olarak artan fiyat olarak secer
        Select select=new Select(egitimlerPage.onlineSiralaDdm);
        select.selectByVisibleText("Artan fiyat");
        // ucretsiz egitimlerden herhangi birini alir
        egitimlerPage.lessonStresYonetimiEgitimi.click();
        egitimlerPage.hemenBasla.click();
        // kimlik dogrulama islemlerini girer
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(kimlik.kimlikDogrulama,ConfigReader.getProperty("email")).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("Sevilay").sendKeys(Keys.TAB).
                sendKeys("Celik").sendKeys(Keys.TAB).sendKeys("London").sendKeys(Keys.TAB).sendKeys("E14").
                sendKeys(Keys.TAB).sendKeys("E14 3DR").sendKeys(Keys.TAB).sendKeys("123456").perform();
        kimlik.odemeyeGec.click();

        // egitimin ucretsiz oldugunu test eder ve siparisi tamamlar
        Assert.assertTrue(kimlik.ucretsizEgitimCheck.isDisplayed());
        kimlik.siparisTamamla.click();
        Driver.closeDriver();

    }@Test
    public void test2(){
        loginPage=new LoginPage();
        profil=new ProfilCheckPage();
        //kullanici login olur
        loginPage.loginOl();
        // Kullanici profil kismina gider
        profil.profilBtn.click();
      // Kullanici profil kismindan dersin basarili bir sekilde kaydedildigini test eder
        Assert.assertTrue(profil.stresYonKurs.isDisplayed());
        Driver.closeDriver();
    }
}
