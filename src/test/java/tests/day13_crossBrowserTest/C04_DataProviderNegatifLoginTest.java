package tests.day13_crossBrowserTest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_DataProviderNegatifLoginTest {

    @DataProvider
    public static Object[][] kullanici() {
       String[][] kullanici={{"Mehmet","1234"},{"Sevgi","567"},{"Emine","674"}};
       return kullanici;
    }

    @Test(dataProvider = "kullanici")
    public void negatifLogin1(String username,String password){
        QdPage qdPage= new QdPage();
        ReusableMethods.bekle(3);
        qdPage= new QdPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qdPage.ilkLoginLinki.click();
        qdPage.emailKutusu.sendKeys(username);
        qdPage.passwordKutusu.sendKeys(password);

        qdPage.cookies.click();
        ReusableMethods.bekle(2);
        qdPage.loginButonu.click();

        Assert.assertTrue(qdPage.emailKutusu.isEnabled());
        Driver.closeDriver();

    }
}
