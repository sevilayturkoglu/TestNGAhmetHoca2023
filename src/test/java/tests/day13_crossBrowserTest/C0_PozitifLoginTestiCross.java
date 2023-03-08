package tests.day13_crossBrowserTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import pages.QdPageCross;
import utilities.*;


public class C0_PozitifLoginTestiCross extends TestBaseCross {
    @Test(groups = "smoke")
    public void pozitifLoginTesti() {
        // qd anasayfaya gidin

        driver.get(ConfigReader.getProperty("qdUrl"));

        // login linkine tiklayin
        WebElement ilkLoginLinki = driver.findElement(By.linkText("Log in"));
        ilkLoginLinki.click();

        // gecerli kullanici adi ve password ile giris yapin
        WebElement emailKutusu = driver.findElement(By.id("login-email"));
        emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));

        WebElement passwordKutusu = driver.findElement(By.id("login-password"));
        passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        driver.findElement(By.xpath("//a[.='Accept']")).click();
        ReusableMethods.bekle(1);

        driver.findElement(By.xpath("//button[text()='Login']")).click();

        // basarili bir sekilde giris yapildigini test edin
        WebElement basariliGirisElementi = driver.findElement(By.xpath("//a[text()='Instructor']"));

        Assert.assertTrue(basariliGirisElementi.isDisplayed());

       // DriverCross.closeDriver();
    }
}
