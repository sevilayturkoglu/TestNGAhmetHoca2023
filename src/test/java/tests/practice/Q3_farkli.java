package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q3_farkli {
    /*
     * Navigate to https://www.saucedemo.com/
     * Enter the username as standard_user
     * Enter the password as secret_sauce
     * Click on login button
     *    Test1 : Choose price low to high
     *    Test2 : Verify item prices are sorted from low to high with soft Assert
     */
    @BeforeTest
    public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("sauceDemo"));
        Driver.getDriver().findElement(By.id("user-name")).sendKeys("standard_user");
        Driver.getDriver().findElement(By.id("password")).sendKeys("secret_sauce");
        Driver.getDriver().findElement(By.id("login-button")).click();
    }
    SoftAssert softAssert=new SoftAssert();
    @Test
    public void saucedemoTest1(){

        WebElement selectWebElement=Driver.getDriver().findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select=new Select(selectWebElement);
        select.selectByVisibleText("Price (low to high)");
        selectWebElement=Driver.getDriver().findElement(By.xpath("//select[@class='product_sort_container']"));
        select=new Select(selectWebElement);
        softAssert.assertTrue(select.getFirstSelectedOption().getText().equals("Price (low to high)"));

        softAssert.assertAll();
    } @Test
    public void saucedemoTest2() {
      /*  WebElement selectWebElement=Driver.getDriver().findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select=new Select(selectWebElement);
        select.selectByVisibleText("Price (low to high)");*/
        List<WebElement> fiyatlar= Driver.getDriver().findElements(By.xpath("//div[@class='inventory_item_price']"));
        ArrayList<Double> fiyatDouble=new ArrayList<>();
        for (WebElement fiyat:fiyatlar
        ) {
            String fiyatStr=fiyat.getText().replaceAll("^\\D","");
            fiyatDouble.add(Double.valueOf(fiyatStr));
        }
        System.out.println(fiyatDouble);

        ArrayList<Double>controlList=new ArrayList<>(fiyatDouble);
        Collections.sort(controlList);

        softAssert.assertEquals(fiyatDouble,controlList);
        softAssert.assertAll();

    }
}
