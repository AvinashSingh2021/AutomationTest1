package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Runtime.getRuntime().addShutdownHook(new Thread("Driver shutdown thread") {
            public void run() {
                driver.quit();
            }
        });

        return driver;
    }
}
