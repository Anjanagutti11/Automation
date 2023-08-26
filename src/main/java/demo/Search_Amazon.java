package demo;

//import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Search_Amazon {
    WebDriver driver;
    public Search_Amazon()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public  void SearchAmazon()
    {
        // Navigate to Google home page  (url:https://www.google.com) Using Locator "ID" driver.get(URL);
        driver.get("https://www.google.com");

        // Enter for 'Amazon' in google search text box Using Locator  "ID" q| sendKeys("amazon")
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("Amazon");

        // Hit <Enter> key  q|send_keys(Keys.RETURN)
       // Object keys;
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

        // Validate the Amazon.in present in the Search result Using Locator "XPath" q|send_keys(Keys.ENTER)
        boolean result = driver.findElement(By.xpath("//span[text()='amazon.in' or text()='Amazon.com']")).isDisplayed();
        System.out.println("Is Amazon on present in results?:" +result);
        // close the browser Using Locator "ID" driver.close();
       // driver.close();
        
    }
}
