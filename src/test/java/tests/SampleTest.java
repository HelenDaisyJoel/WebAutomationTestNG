package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.VideoPlatformDolbyBookingPage;
import pageObjects.samplePage;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class SampleTest {
	 public static WebDriver driver; 
    private samplePage page;

    @BeforeClass
    public void setUp() {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chrome\\chromedriver.exe");

        // Create an instance of ChromeDriver
        driver = new ChromeDriver();

        // Set the implicit wait time
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Open the desired URL
        driver.get("https://prism-web.preprod.1stbet.com/");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Initialize page object
        page = new samplePage(driver);
    }

    @Test(priority = 1)
    public void testEncoder() throws InterruptedException {
        // Test inputs
        String userName = "admin@1st.com";
        String password = "admin";
        String orgName = "Test_Org";
        String unitName = "Unit-01";
        String randomDisplayName = UUID.randomUUID().toString();
        String encoderName = "EncoderTest-" + randomDisplayName.substring(0, 4);
        String encoderID = "TestID" + randomDisplayName.substring(0, 4);
        String EncoderSearchKeyword = encoderName;
        String updatedID = "mper-pit-studio-d1|78985";

        // Perform login and navigation
        page.login(userName, password);
        page.navigateToVideoPlatform(orgName, unitName);

        // Test encoder creation and update
        page.Select_Encoder();
        page.createEncoder(encoderName, encoderID);
        Assert.assertEquals(page.getMessage(), "Video Encoder Successfully Added");

        page.verifyToolTip("Add Video Encoder", VideoPlatformDolbyBookingPage.TOOLTIP_ADD_ENCODER);
        page.verifyToolTip("Export", VideoPlatformDolbyBookingPage.TOOLTIP_EXPORT);
        page.verifyToolTip("Column Settings", VideoPlatformDolbyBookingPage.TOOLTIP_COLUMN_SETTINGS);

        page.displayInactive();
        page.search(EncoderSearchKeyword);

        // You need to define 'updatedEncoder' and 'updatedID' or use actual values
        String updatedEncoder = "UpdatedEncoderName" + randomDisplayName.substring(0, 4);

        page.updateEncoder(updatedEncoder, updatedID);
        Assert.assertEquals(page.getMessage(), "Video Encoder Successfully Updated");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
