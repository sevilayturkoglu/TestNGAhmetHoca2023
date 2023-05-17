package tests.day12_xmlFiles;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C03_RaporluPozitifLoginTest extends TestBaseRapor {

    @Test
    public void pozitifLoginTesti() {

        extentTest=extentReports.createTest("Pozitif login testi","gecerli bilgilerle giris yapilabilmeli");
        // qd anasayfaya gidin

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        extentTest.info("qualitydemy ana sayfaya gidildi");

        QdPage qdPage = new QdPage();
        qdPage.ilkLoginLinki.click();
       extentTest.info("ilk login linkine gidildi");

        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        extentTest.info("gecerli email yazildi");
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
       extentTest.info("gecerli password yazildi");
        qdPage.cookies.click();
        ReusableMethods.bekle(1);
        qdPage.loginButonu.click();
       extentTest.info("login butonu click yapildi");

        Assert.assertTrue(qdPage.basariliGirisElementi.isDisplayed());
     extentTest.pass("Basarili sekilde giris yapildigi test edildi");
    }
}