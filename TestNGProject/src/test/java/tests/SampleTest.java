package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {    
    public static void main(String[] args) {
        // Set the path to the chromedriver executable if necessary
    	 System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chrome\\chromedriver.exe");

        // Create an instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Set the implicit wait time
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Open the desired URL
        driver.get("https://prism-web.preprod.1stbet.com/");

        // Maximize the browser window
        driver.manage().window().maximize();
        System.out.println("Hi");

        // Add any additional test steps here

        // Close the browser
        driver.quit();
    }
}
