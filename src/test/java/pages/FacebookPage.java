package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage extends BasePage{
   /* public FacebookPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }*/

    @FindBy(xpath = "//button[@title='Only allow essential cookies']")
    public WebElement cookiesKabulBtn;
    @FindBy(xpath = "//input[@placeholder='Email address or phone number']")
    public WebElement emailKutusu;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement loginButton;
    @FindBy(xpath = "//div[@class='_9ay7']")
    public WebElement girisYapilamadiYaziElementi;

         public static void getter(){
                System.out.println("Deneme");
 }

}
