package NevzatHocaPracticeDersleri.ieEnstittitue.pages1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KimlikDogrulamaPage {
    public KimlikDogrulamaPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "email")
    public WebElement kimlikDogrulama;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement odemeyeGec;

    //p[@class='_1x52f9s1 _1fragema3 _1x52f9sm _1fragem1i _1fragema6']
    @FindBy(xpath = "//p[@class='_1x52f9s1 _1fragema3 _1x52f9sm _1fragem1i _1fragema6']")
    public WebElement ucretsizEgitimCheck;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement siparisTamamla;
}
