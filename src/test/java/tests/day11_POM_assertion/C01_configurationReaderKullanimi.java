package tests.day11_POM_assertion;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_configurationReaderKullanimi {
    @Test
    public void test01(){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime")+ Keys.ENTER);
String expectedIceric=ConfigReader.getProperty("amazonAranacakKelime");
String actualAramaSonuzYazisi=amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualAramaSonuzYazisi.contains(expectedIceric));

    }
}
