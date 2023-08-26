package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.devtools.Connection;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Linkedin_ImagePost{
    WebDriver driver;
    public Linkedin_ImagePost()
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
    public void linkedin1() throws InterruptedException
    {
    // Navigate to the Linkedin   https://www.linkedin.com/ 
        driver.get("https://www.linkedin.com/");

        //Enter the user name or email in the webElemennt userNaamme Using Locator "Xapth"
       driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys("linkedin@gmail.com");

        //enter the password in webelement 
        driver.findElement(By.xpath("//input[@id='session_password']")).sendKeys("Linkedin");
       // driver.get("https://www.linkedin.com/feed/?trk=guest_homepage-basic_google-one-tap-submit");
       
        Thread.sleep(3000);
        // click on to the Sign in button
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
        
        //click on Start a post button
        driver.findElement(By.xpath("//span[text()='Start a post']")).click();
        Thread.sleep(3000);

        //click onusername dropdown 
        //driver.findElement(By.xpath("//span[@class='text-body-large-bold truncate']")).click();
        driver.findElement(By.xpath("//div[@class='display-flex align-items-center artdeco-entity-lockup__title ember-view']")).click();
        Thread.sleep(3000);

        //click on Connection Only
        //driver.findElement(By.xpath("//span[@class='sharing-shared-generic-list_text-wrapper'][2]")).click();
        driver.findElement(By.id("CONNECTIONS_ONLY")).click();
        Thread.sleep(3000);

        //click on Done button
        driver.findElement(By.xpath("//span[text()='Done']")).click();
        Thread.sleep(3000);

        //Enter the text box 
        driver.findElement(By.xpath("(//p)[1]")).sendKeys("Hello");
        Thread.sleep(3000);
        //CLick on photo icon using locator xpth
        driver.findElement(By.xpath("//span[text()='Post']")).click();

        // click on photoicon
        //driver.findElement(By.xpath("//button[@aria-label='Add a photo']/span[@class='share-promoted-detour-button__icon-container")).click();
        Thread.sleep(3000);

        WebElement image = driver.findElement(By.xpath("//span[text()='Post successful.']"));
        //String  imagepath = "C:\\Users\\Anand\\Pictures\\Screenshots.png";
        System.out.println("Post is successful?:" +image.isDisplayed());
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[text()='View post']")).click();
        Thread.sleep(3000);

        WebElement afterpost = driver.findElement(By.xpath("//section[@class='fixed-full']"));
        try{
            if(afterpost.isDisplayed())
            System.out.println("the post is posted and visible");
        }
        catch(Exception e){
            System.out.println("Fileformat Exception => " +e.getMessage());
    
        }
    }
}