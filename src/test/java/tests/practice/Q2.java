package tests.practice;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class Q2 {
    /*
    - Birbirine bagimli testler olusturun.
    - Config reader ile birbirine bagli testler olusturup.
    - Birbirine bagimli testler olusturarak ;
        =>ilk once facebook'a gidin
        =>sonra facebook'a bagimli olarak google'a gidin
        =>daha sonra google'a bagimli olarak amazon'a gidin
    - driver'i kapatin.
     */
@Test
public void wisequarter(){
    Driver.getDriver().get(ConfigReader.getProperty("wiseUrl"));
}

    @Test(dependsOnMethods = "wisequarter")
    public void youtube(){
        Driver.getDriver().get(ConfigReader.getProperty("youtubeUrl"));
    }
    @Test(dependsOnMethods = "youtube")
    public void amazon(){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
    }
}
