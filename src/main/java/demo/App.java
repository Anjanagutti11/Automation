/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo;
import java.net.MalformedURLException;


public class App {
    public void getGreeting() throws InterruptedException, MalformedURLException {
        //TestCases tests = new TestCases(); // Initialize your test class
        IMDB_Rating Search  = new IMDB_Rating();
        

        Search.imdb_rating();
        //tests.testcase01();

        //END Tests
        Search.endTest(); // End your test by clearning connections and closing browser
    }
    
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        new App().getGreeting();
    }
}
