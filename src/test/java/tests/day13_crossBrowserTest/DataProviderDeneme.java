package tests.day13_crossBrowserTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class DataProviderDeneme {


    @DataProvider
    public static Object[][] arnacakUrun() {
        String[][] ara={{"Nutella"},{"Java"},{"iphone"}};
        return ara;
    }
    @Test (dataProvider = "arnacakUrun")
    public void nutellaTesti(String urun){
        AmazonPage amazonPage=new AmazonPage();
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(urun + Keys.ENTER);
        String expectedIcerik = urun;
        String actualSonucYazisi = amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
        Driver.closeDriver();

    }

}
