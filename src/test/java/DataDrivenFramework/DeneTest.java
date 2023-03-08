package DataDrivenFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.IOException;
import java.util.Arrays;

public class DeneTest{
    @DataProvider
    public Object[][] datas() throws IOException {
        String path = "src/test/java/DataDrivenFramework/ulkeler (12).xlsx"; // excel dosya path'i
        XLUtility xlutil = new XLUtility(path);
        int totalrows = xlutil.getRowCount("Sayfa1");
        int totalcols = xlutil.getCellCount("Sayfa1",1)-3;
        String[][] creditCardNumbers = new String[totalrows][totalcols];
        for (int i=1; i<=totalrows; i++){ // Buradaki i değişkeni okumaya başlamak istediğimiz satırdır.
            for (int j=0; j<totalcols; j++){
                creditCardNumbers[i-1][j]=xlutil.gellCellData("Sayfa1",i,j); // i-1 kısmı ise başlangıçta 0'a eşit olmalıdır. Yani i=5 için i-5 olmalı.
            }
        }
        System.out.println(Arrays.deepToString(creditCardNumbers));

        return creditCardNumbers;
    }
    @Test(dataProvider = "datas")
        public void ulkeBaskentCheckCheck(String ulke, String baskent) throws InterruptedException {
            Driver.getDriver().get("https://www.google.com");

           Driver.getDriver().findElement(By.xpath("//div[.='Reject all']")).click();

            Driver.getDriver().findElement(By.xpath("//input[@class='gLFyf']")).sendKeys(ulke+" capital"+ Keys.ENTER);
        if(ulke.equals("Bolivia")){
            String actualBaskent=Driver.getDriver().findElement(By.xpath("//div[.='La Paz']")).getText();
            String expectedBaskent=baskent;
            System.out.println(actualBaskent);
            System.out.println(baskent);
            Assert.assertEquals(actualBaskent,expectedBaskent);
            Driver.closeDriver();
        }
          Thread.sleep(1000);
            String actualBaskent=Driver.getDriver().findElement(By.xpath("//a[@class='FLP8od']")).getText();
            String expectedBaskent=baskent;
        System.out.println(actualBaskent);
        System.out.println(baskent);
        Assert.assertEquals(actualBaskent,expectedBaskent);
            Driver.closeDriver();



        }
    }
