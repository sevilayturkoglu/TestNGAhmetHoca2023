package tests.day11_POM_assertion;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroPage;

import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


import java.util.ArrayList;
import java.util.List;

public class DeneZero {
    @Test(groups = "smoke")
    public void webappTesti() {
        ZeroPage zeroPage = new ZeroPage();
        //1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));
        // 2. Sign in butonuna basin
        zeroPage.signInButonu.click();
        // 3. Login kutusuna “username” yazin
        zeroPage.usernameKutusu.sendKeys("username");
        // 4. Password kutusuna “password” yazin
        zeroPage.passwordKutusu.sendKeys("password");
        // 5. Sign in tusuna basin
        zeroPage.signInSubmitButonu.click();
        //Navigate back yapin;
        Driver.getDriver().navigate().back();
        // 6. Online banking menusu icinde Pay Bills sayfasina gidin
        zeroPage.onlineBanking.click();
        zeroPage.payBillLinki.click();
        // 7. “Purchase Foreign Currency” tusuna basin
        zeroPage.purchaseFCButonu.click();
        // 8. “Currency” drop down menusunden Eurozone’u secin
        Select select = new Select(zeroPage.currencyDropdown);
        select.selectByVisibleText("Eurozone (euro)");
        // 9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();
        String expectedSelect = "Eurozone (euro)";
        String actualSelect = select.getFirstSelectedOption().getText();
        softAssert.assertEquals(actualSelect, expectedSelect, "Eurozone is not selected");
        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        List<WebElement> selectWebElement = select.getOptions();
        List<String> selectActualList = ReusableMethods.stringListeCevir(selectWebElement);
        List<String>expectedListe=new ArrayList<>();
     // List<String> expectedList = Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)", "Switzerland (franc)", "China (yuan)", "Denmark (krone)", "Eurozone (euro)", "Great Britain (pound)", "Hong Kong (dollar)", "Japan (yen)", "Mexico (peso)", "Norway (krone)", "New Zealand (dollar)", "Sweden (krona)", "Singapore (dollar)", "Thailand (baht)");
      String[]arrList={"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"};
        for (String each:arrList
             ) {
            expectedListe.add(each);
        }

   softAssert.assertEquals(selectActualList,expectedListe);
        //"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
        // "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)",
        // "Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)",
        // "Singapore (dollar)","Thailand (baht)"
        softAssert.assertAll();
    }
}