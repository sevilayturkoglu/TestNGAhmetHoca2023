package NevzatHocaPracticeDersleri.QualityPage.pages2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class QualityPage {
    public QualityPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Accept']")
    private WebElement cookies;
    @FindBy(xpath = "//*[text()='Log in']")
    private WebElement loginLink;

    @FindBy(id = "login-email")
    private WebElement mail;

    @FindBy(id = "login-password")
    private WebElement password;

    @FindBy(xpath = "(//*[text()='Login'])[2]")
    private WebElement loginBtn;
    @FindBy(xpath = "(//img[@class='img-fluid'])[1]")
    public WebElement kullaniciLogo;

    @FindBy(xpath = "(//li[@class='user-dropdown-menu-item'])[5]")
    public WebElement userProfil;

    @FindBy(xpath = "//input[@id='FristName']")
    public WebElement profileFirstNameBox;

    @FindBy(name = "last_name")
    public WebElement profileLastNameBox;

    @FindBy(id = "Biography_ifr")
    public WebElement iframe;

    @FindBy(id = "tinymce")
    public WebElement webElementBioBox;

    @FindBy(xpath = "//*[.='Save']")
    public WebElement saveBtn;



    public  void providerMethod(String mail1, String password1) {

        if (cookies.isDisplayed()) {//cookies ilk giriste cikiyor ,geri kalan islemlerde cikmadigi icin boyle yaptik
            cookies.click();

        } else {
            ReusableMethods.bekle(1);
            loginLink.click();
            mail.sendKeys(mail1);
            password.sendKeys(password1);
            ReusableMethods.bekle(2);
            loginBtn.click();
        }
    }public void loginOl(){
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        cookies.click();
        loginLink.click();
        mail.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        password.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        ReusableMethods.bekle(2);
        loginBtn.click();
    }

}
