package NevzatHocaPracticeDersleri.ieEnstittitue.pages1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MyPage {
    public MyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[@class='usertext mr-1']")
    public WebElement loggedCheckControl;


   @FindBy(xpath = "(//a[.='Eğitimler'])[1]")
    public WebElement egitimlerOnHeaders;
}
