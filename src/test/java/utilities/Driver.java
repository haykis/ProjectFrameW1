package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    static WebDriver driver;  //null

    public static WebDriver getDriver(){

       if(driver==null){
           switch (ConfigReader.getProperty("browser")) {

               case "chrome":
               default:
                   WebDriverManager.chromedriver().setup();
                   driver = new ChromeDriver();
                   break;
               case "firefow":
                   WebDriverManager.firefoxdriver().setup();
                   driver = new FirefoxDriver();
                   break;
               case "edge":
                   WebDriverManager.edgedriver().setup();
                   driver = new EdgeDriver();
                   break;

           }

       }
       driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       return driver;

    }
    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver=null; //en basa geri dondu
        }
    }

    public static void bekle(int sec) {
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
