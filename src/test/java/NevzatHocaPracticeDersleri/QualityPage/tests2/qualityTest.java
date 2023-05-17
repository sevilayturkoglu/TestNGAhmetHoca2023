package NevzatHocaPracticeDersleri.QualityPage.tests2;

import NevzatHocaPracticeDersleri.QualityPage.pages2.QualityPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;
import utilities.ReusableMethods;

public class qualityTest {
    @Test
    public void qualityProfiltest(){
        QualityPage qualityPage=new QualityPage();
//Kullanici https://qualitydemy.com/ sayfasina gider
        // Siteye basarili bir sekilde giris yapar
// sag taraf bulunan kullanici menusunden User Profile kismina gider
        qualityPage.loginOl();
        Actions actions=new Actions(Driver.getDriver());
        ReusableMethods.bekle(5);
        actions.moveToElement(qualityPage.kullaniciLogo).click(qualityPage.userProfil).build().perform();

//FirstName,Lastname,Biography, ve Linklerin kendine ait oldugunu dogrular
        String firstname=qualityPage.profileFirstNameBox.getAttribute("value");
        String expectedname="nevzat";
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(firstname,expectedname);

        String lastname=qualityPage.profileLastNameBox.getAttribute("value");
        String expectedlastname="celik";
        softAssert.assertEquals(lastname,expectedlastname);

        WebElement frame=qualityPage.iframe;
        Driver.getDriver().switchTo().frame(frame);
        WebElement bio=qualityPage.webElementBioBox;
        String actualbio=bio.getText();
        String expectedbio="WiseQuarter\n" +
                           "QaTester\n" +
                           "Intern";
        softAssert.assertEquals(actualbio,expectedbio);

        // Bu kutucuklarda degisiklik yaparak kaydeder degisiklikleri dogrular
        Driver.getDriver().switchTo().defaultContent();

        qualityPage.profileFirstNameBox.clear();
        qualityPage.profileFirstNameBox.sendKeys("Furkan");
        qualityPage.profileLastNameBox.clear();
        qualityPage.profileLastNameBox.sendKeys("Inal");
        Driver.getDriver().switchTo().frame(qualityPage.iframe);
        qualityPage.webElementBioBox.clear();
        qualityPage.webElementBioBox.sendKeys("VELI");
        Driver.getDriver().switchTo().defaultContent();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);
        qualityPage.saveBtn.click();




        softAssert.assertAll();
    }

}
