package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    protected static WebDriver driver;
//    @BeforeMethod(alwaysRun=true)
    public static WebDriver initializeDriver(String browser) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//globalData.properties");
        prop.load(fis);
        String browserName=System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");
        System.out.println("Browser name: " + browserName);


        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
        	
        	System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chrome\\chromedriver.exe");
            if (browserName.contains("headless")) {
                options.addArguments("headless");
            }
            try {
				driver = new ChromeDriver(options);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else if(browserName.equalsIgnoreCase("firefox"))
        {
        	System.setProperty("webdriver.gecko.driver","C:\\Driver\\firefoxgeckodriver.exe");
        	driver=new FirefoxDriver();
        

        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browserName);
        }

        driver.manage().window().maximize();
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
