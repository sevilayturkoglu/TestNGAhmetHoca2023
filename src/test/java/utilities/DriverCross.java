package utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverCross {
    private DriverCross(){}
    public static WebDriver driver;
    public static WebDriver getDriver(String browser) {

        browser = browser ==null ? ConfigReader.getProperty("browser"):browser;

        if (driver == null) {
            switch (browser) {
                case "chrome":
                  //  WebDriverManager.chromedriver().setup();
                    System.setProperty("webdriver.http.factory", "jdk-http-client");
                    driver = new ChromeDriver();

                    break;
                case "firefox":
                  //  WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();

                    break;
                case "safari":
                   // WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();

                    break;
                case "edge":
                   // WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();


            }
        }
      //  driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
