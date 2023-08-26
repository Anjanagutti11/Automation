package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.devtools.Connection;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Linkedin {
    WebDriver driver;
    public Linkedin()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.edgedriver().timeout(30).setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }
    public void linkedin() throws InterruptedException
    {
    // Navigate to the Linkedin   https://www.linkedin.com/ 
        driver.get("https://www.linkedin.com/");

        //Enter the user name or email in the webElemennt userNaamme Using Locator "Xapth"
       driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys("anjanagutti11@gmail.com");

        //enter the password in webelement 
        driver.findElement(By.xpath("//input[@id='session_password']")).sendKeys("Anjana@5445");
       // driver.get("https://www.linkedin.com/feed/?trk=guest_homepage-basic_google-one-tap-submit");
       
        Thread.sleep(3000);
        // click on to the Sign in button
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();

         //Print the count of `Who's viewed your profile Using Locator "Class" Name //p[@class='t-12 t-black--light t-normal']
        //  WebElement result = driver.findElement(By.xpath("//p[@class='t-12 t-black--light t-normal']"));
        //  System.out.println(result.getText());

       // Print the count  of  who's Impressions of your post Using Locator "Class" Name //p[@class='t-12 t-black--light t-normal']
        WebElement result1 = driver.findElement(By.xpath("//p[@class='t-12 t-black--light t-normal']"));
        //Thread.sleep(3000);
        System.out.println(result1.getText());
        

        //click on Start a post text box in home page
        driver.findElement(By.xpath("//span[text()='Start a post']")).click();
        Thread.sleep(3000);

        // click on user dropdown 
        driver.findElement(By.xpath("//span[@class='text-body-large-bold truncate']")).click();
        Thread.sleep(3000);

        // click on the select COnnection only
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@class='sharing-shared-generic-list__text-wrapper']"));
        

      // click on the Done Button
     driver.findElement(By.xpath("//span[text()='Done']")).click();
     Thread.sleep(3000);
     
     // Enter text box in editor box 
     driver.findElement(By.xpath("//div[@data-placeholder='What do you want to talk about?']")).sendKeys("Hi");
  
     //click on the post button and validate the post successful Message
     driver.findElement(By.xpath("//span[text()='post']")).click();
    Thread.sleep(3000);
     driver.findElement(By.xpath("//span[text()='Post successful.']"));

    }
}


