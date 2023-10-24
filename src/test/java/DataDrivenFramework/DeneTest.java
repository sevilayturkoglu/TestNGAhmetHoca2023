package DataDrivenFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Driver;

import java.io.IOException;
import java.util.Arrays;

public class DeneTest {
    @DataProvider
    public Object[][] datas() throws IOException {
        String path = "src/test/java/DataDrivenFramework/ulkeler (12).xlsx"; // excel dosya path'i
        XLUtility xlutil = new XLUtility(path);
        int totalrows = xlutil.getRowCount("Sayfa1");
        int totalcols = xlutil.getCellCount("Sayfa1", 1) - 3;
        String[][] ulkeBaskent = new String[totalrows][totalcols];
        for (int i = 1; i <= totalrows; i++) { // Buradaki i değişkeni okumaya başlamak istediğimiz satırdır.
            for (int j = 0; j < totalcols; j++) {
                ulkeBaskent[i - 1][j] = xlutil.gellCellData("Sayfa1", i, j); // i-1 kısmı ise başlangıçta 0'a eşit olmalıdır. Yani i=5 için i-5 olmalı.
            }
        }
        System.out.println(Arrays.deepToString(ulkeBaskent));

        return ulkeBaskent;
    }

    @Test(dataProvider = "datas")
    public void ulkeBaskentCheckCheck(String ulke, String baskent) throws InterruptedException {
        Driver.getDriver().get("https://www.google.com");
        //Driver.getDriver().findElement(By.xpath("//div[.='Reject all']")).click();
        WebElement cookies = Driver.getDriver().findElement(By.xpath("//div[.='Reject all']"));
        if (cookies.isDisplayed()) {
            cookies.click();
        }

          //Driver.getDriver().findElement(By.xpath("//input[@class='gLFyf']")).sendKeys(ulke+" capital"+ Keys.ENTER);
            WebElement baskent1 = Driver.getDriver().findElement(By.id("APjFqb"));
            baskent1.sendKeys(ulke + " capital " + Keys.ENTER);
            if (ulke.equals("Bolivia")) {
                String actualBaskent = Driver.getDriver().findElement(By.xpath("//div[.='La Paz']")).getText();
                String expectedBaskent = baskent;
                System.out.println(actualBaskent);
                System.out.println(baskent);
                Assert.assertEquals(actualBaskent, expectedBaskent);

                Driver.closeDriver();

            }else {
                Thread.sleep(1000);
                String actualBaskent = Driver.getDriver().findElement(By.xpath("//a[@class='FLP8od']")).getText();
                String expectedBaskent = baskent;
                System.out.println(actualBaskent);
                System.out.println(baskent);
                Assert.assertEquals(actualBaskent, expectedBaskent);


                Driver.closeDriver();

            }
        }
    }
