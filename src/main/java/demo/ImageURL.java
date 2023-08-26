package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//Selenium Imports
// import org.openqa.selenium.Keys;
// import org.openqa.selenium.remote.BrowserType;
// import org.openqa.selenium.remote.DesiredCapabilities;
// import org.openqa.selenium.remote.RemoteWebDriver;
// import org.openqa.selenium.support.ui.Select;



public class ImageURL {
    ChromeDriver driver;
    public ImageURL()
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
    public void imageurl()
    {
        //  Navigate to BookMyShow homepage  https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");

        List<WebElement> list = driver.findElements(By.tagName("a"));
        System.out.println("No.of links in the BOook My Show Landing Page:"+list.size());

        String URL;
        List<WebElement> image_URLs = driver.findElements(By.xpath("//h2[text()='Recommende Movies']/../../../following-sibling::div//div[contains(@class,'YeNog')]/div"));
        System.out.println("No . Of images URLSs:"+ image_URLs.size());
        for(WebElement image_URL : image_URLs){
            URL = image_URL.findElement(By.xpath("//a/img")).getAttribute("src");
            System.out.println(URL);

            driver.findElement(By.xpath("//h2[text()='Premieres']/../../../following-sibling::div/div/div/div[2]/a/div/div[3]"));
            String PremiereName = driver.findElement(By.xpath(".//div[@class='sc-7o7neZ-0 iHsoLV")).getText();
            String PremiereLanguage = driver.findElement(By.xpath(".//div[@class='sc-7o7nez-0 kHxEsl']")).getText();

            System.out.println(PremiereName);
            System.out.println(PremiereLanguage);

        }
    }
}