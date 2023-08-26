package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
// import org.openqa.selenium.Keys;
// import org.openqa.selenium.remote.BrowserType;
// import org.openqa.selenium.remote.DesiredCapabilities;
// import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.ui.Select;

public class IMDB_Rating {
    ChromeDriver driver;
    public IMDB_Rating()
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

    public void imdb_rating()
    {   
        //Navigate to the IMDB _Rating
        driver.get("https://www.imdb.com/chart/top/");

        //Higest movie rate 
       WebElement hr = driver.findElement(By.xpath("(//h3[@class='ipc-title__text'])[2]"));
       String txt = hr.getText();
       System.out.println("The highest rated movie on IMDb:"+txt);

        //How many movies are included
       List<WebElement> num = driver.findElements(By.xpath("//li[@class='ipc-metadata-list-summary-item sc-bca49391-0 eypSaE cli-parent']"));
        System.out.println(num.size() + "movies are included in the table");
		Select select = new Select(driver.findElement(By.id("sort-by-selector")));
		select.selectByVisibleText("Release date");
		

		WebElement wb1 = driver.findElement(By.xpath("(//div[@class='sc-b85248f1-0 bCmTgE cli-children'])[250]/div/a/h3"));
		WebElement wb3 = driver.findElement(By.xpath("(//div[@class='sc-b85248f1-0 bCmTgE cli-children'])[1]/div/a/h3"));
		if(wb1.isDisplayed())
		{
			String txt1 = wb1.getText();
			System.out.println("The oldest movie on the list : " + txt1);
		}
		if(wb3.isDisplayed())
		{
			String txt2 = wb3.getText();
			System.out.println("The recent movie on the list : " + txt2);
		}
		select.selectByIndex(3);
		System.out.println(txt + " movie has the most user ratings");
    }

 }
 