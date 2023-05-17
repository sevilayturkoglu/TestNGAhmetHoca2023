package NevzatHocaPracticeDersleri.ieEnstittitue.pages1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProfilCheckPage {
    public ProfilCheckPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[.='Profil']")
    public WebElement profilBtn;

    @FindBy(xpath = "//a[.='Stres Yönetimi Eğitimi']")
    public WebElement stresYonKurs;
}
