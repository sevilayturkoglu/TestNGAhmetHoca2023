package tests.day13_crossBrowserTest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_DataProvider {
    @DataProvider
    public static Object[][] siteIsimleri() {
        String[][] site={{"amazonUrl"},{"youtubeUrl"},{"wiseUrl"}};
        return site;
    }
    @Test(dataProvider = "siteIsimleri")

    public void urlTest(String gidilecekSite){
       Driver.getDriver().get(ConfigReader.getProperty(gidilecekSite));
            ReusableMethods.bekle(2);
            String actualurl= Driver.getDriver().getCurrentUrl();
           if(gidilecekSite.equals("wiseUrl")) {
               Assert.assertEquals(actualurl, ConfigReader.getProperty(gidilecekSite));
           }
           else{
               Assert.assertEquals(actualurl, ConfigReader.getProperty(gidilecekSite)+"/");
           }
            Driver.closeDriver();
    }
}
