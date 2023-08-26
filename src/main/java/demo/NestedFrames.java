package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//Selenium Imports
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.remote.BrowserType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.ui.Select;
//import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class NestedFrames {
    ChromeDriver driver;
    public  NestedFrames(){
    System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    // 
    
    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

	public void nestedFrames() 
    {  
       String text;
       String name;
       driver.get("https://the-internet.herokuapp.com/nested_frames");
       List<WebElement> frameElements = driver.findElements(By.xpath("//frameset//frame"));
       for(WebElement frameElement :frameElements){
        name = frameElement.getAttribute("name");

        if(!name.contains("top"))
        {
            driver.switchTo().frame(frameElement);
            text = driver.findElement(By.xpath("//body")).getText();
            System.out.println("Frame text is :"+text);
            driver.switchTo().defaultContent();

        }
        else{
            driver.switchTo().frame(frameElement);
            List<WebElement> innerFrameElements = driver.findElements(By.xpath("//frameset//frame"));
            for(WebElement innerFrameElement : innerFrameElements){
                driver.switchTo().frame(innerFrameElement);
                text = driver.findElement(By.xpath("//body")).getText();
                System.out.println("Frame is :"+text);
                driver.switchTo().parentFrame();
            }
            driver.switchTo().defaultContent();
        }
     }
   }
    
}
