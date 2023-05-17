package NevzatHocaPracticeDersleri.ieEnstittitue.pages1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "//input[@type='text']")
    public WebElement loginEmailBox;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement loginPasswordBox;
    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement submitButton;
    @FindBy(xpath = "//button[.='Log In']")
    public WebElement loginBtn;

    public  void loginOl(){
        Driver.getDriver().get("https://www.iienstitu.com/en");
        loginBtn.click();
        loginEmailBox.sendKeys(ConfigReader.getProperty("email"));
        loginPasswordBox.sendKeys(ConfigReader.getProperty("password"));
        submitButton.click();

    }

}
