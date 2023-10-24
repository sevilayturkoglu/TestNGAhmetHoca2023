package utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
     /* Daha fazla kontrol imkani ve extends kullanmadan driver'a ulasmak icin
       webDriver objesini Driver class'indaki static bir method ile olusturacagiz
      Ancak getDriver() her kullanildiginda yeni bir driver olusturuyor
      bunu engellemek ve kodumuzun duzgun calismasini saglamak icin
      ilk kullanimda  driver= new ChromeDriver(); kodu calissin
      sonraki kullanimlarda calismasin diye bir yontem gelistirmeliyiz
     */

    private Driver(){}
    public static WebDriver driver;

    public static WebDriver getDriver() {

        String istenenBrowser = ConfigReader.getProperty("browser");

        if (driver == null) {

            switch (istenenBrowser) {

                case "firefox":

                    driver = new FirefoxDriver();
                    break;
                case "edge":

                    driver = new EdgeDriver();
                    break;
                case "safari":

                    driver = new SafariDriver();
                    break;
                default:
                    driver=new ChromeDriver();
                  /*  ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options);*/
                    break;

                    /*
                    //Driver chrome da hata verirse bu option denenebilir
                     driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);

                    chromeOptions.setPageLoadTimeout(Duration.ofSeconds(14));
                    break;
                     */

            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        }


        return driver;

    }

    public static void closeDriver() {

        if (driver != null) {
            driver.close();
            driver = null;
        }


    }

    public static void quiteDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}