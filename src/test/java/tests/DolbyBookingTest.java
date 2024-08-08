package tests;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.VideoPlatformDolbyBookingPage;

public class DolbyBookingTest extends BaseTest{
	
	public static WebDriver driver; 
    VideoPlatformDolbyBookingPage page;
    ExtentReports extent;
    ExtentTest test;
    public static String updatedEncoder;
    public static String encoderName; // Ensure this is an instance variable
    
    String userName = "admin@1st.com";
    String password = "admin";
    String orgName = "Test_Org";
    String unitName = "Unit-01";
    String randomDisplayName = UUID.randomUUID().toString();
    
//    String decoderDisplayName = "DecoderTest-" + randomDisplayName.substring(0, 4);
//    String decoderID = decoderDisplayName;
//    String updatedEncoder = "Update" + encoderName;
//    String updatedName = "Update" + decoderDisplayName;
//    String updatedID = "Update" + decoderDisplayName;
//    String dolbyDecoderName = decoderDisplayName;
//    String noneDecoderName = decoderDisplayName;
//    String decoderSearchKeyword = decoderDisplayName;
//    String sourceName = "SourceTest" + randomDisplayName.substring(0, 4);
//    String sourceSearchKeyword = sourceName;
//    String updatedSource = "UpdatedSourceTest-" + randomDisplayName.substring(0, 4);
//    String channelName = "ChannelTest" + randomDisplayName.substring(0, 4);
//    String ChannelSearchKeyword = channelName;
//    String VendorName = "Dolby";
//    String Description = "Test23";
//    String ClusterName = "Ashburn";
//    String ConnectorID = "99";
//    String Angle = "Backside";
//    String sourceAngle = "Backside";
    
    @BeforeClass
    public void setUp() throws InterruptedException, IOException {
    	// Initialize WebDriver
//    	 driver = initializeDriver(System.getProperty("browser"));
    	driver = BaseTest.initializeDriver(System.getProperty("browser"));
        // Set up WebDriver
//        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chrome\\chromedriver.exe");
//        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://prism-web-feature-stm-829-replace-new-mui-license-key.dev.1stbet.com/");
        driver.manage().window().maximize();
        page = new VideoPlatformDolbyBookingPage(driver);
        page.login(userName, password);
        page.navigateToVideoPlatform(orgName, unitName);
        
    }

    @Test(priority = 1)
    public void testEncoder(String encoderName, String encoderID) throws InterruptedException {
        page.Select_Encoder();
        page.createEncoder(encoderName, encoderID);
        Assert.assertEquals(page.getMessage(), "Video Encoder Successfully Added");

        page.verifyToolTip("Add Video Encoder", VideoPlatformDolbyBookingPage.TOOLTIP_ADD_ENCODER);
        page.verifyToolTip("Export", VideoPlatformDolbyBookingPage.TOOLTIP_EXPORT);
        page.verifyToolTip("Column Settings", VideoPlatformDolbyBookingPage.TOOLTIP_COLUMN_SETTINGS);

        page.displayInactive();
        String EncoderSearchKeyword = encoderName;
        page.search(EncoderSearchKeyword);
        updatedEncoder = "Update" + encoderName;
        this.encoderName = encoderName; // Set the instance variable
        String updatedID = "UpdatedID" + encoderName;

        page.updateEncoder(updatedEncoder, updatedID);
        Assert.assertEquals(page.getMessage(), "Video Encoder Successfully Updated");
    }

    @Test(priority = 2)
    public void testDecoder(String DolbyDisplayName,String DecoderID) throws InterruptedException {
//        test = extent.createTest("Test Decoder Creation and Update");
        page.Select_Decoder();
        page.verifyToolTip("Add Video Decoder", VideoPlatformDolbyBookingPage.TOOLTIP_ADD_DECODER);
        page.verifyToolTip("Export", VideoPlatformDolbyBookingPage.TOOLTIP_EXPORT);
        page.verifyToolTip("Column Settings", VideoPlatformDolbyBookingPage.TOOLTIP_COLUMN_SETTINGS);

        page.addDolbyDecoder(DolbyDisplayName, DecoderID);
        Assert.assertEquals(page.getMessage(), "Video Decoder Successfully Added");

        page.displayInactive();
        String decoderSearchKeyword = DolbyDisplayName;
        page.search(decoderSearchKeyword);

        page.disableEntity();
        Assert.assertEquals(page.getMessage(), "Video Decoder Successfully Disabled");
        String updatedName = "Update" + DolbyDisplayName;
        String updatedID = "Update" + DolbyDisplayName;
        page.updateDecoder(updatedName, updatedID);
        Assert.assertEquals(page.getMessage(), "Video Decoder Successfully Updated");

        page.deleteEntity();
        Assert.assertEquals(page.getMessage(), "Video Decoder Successfully Deleted");
        
    }
//
    
    @Test(priority = 3)
    public void testSource(String sourceName,String sourceAngle,String ForeignIDType,String ForeignIDValue,String AutomatedStartMargin,String AutomatedEndMargin,boolean AutomatedBooking) throws InterruptedException {
//        test = extent.createTest("Test Source Creation and Update");
        page.Select_Source();
        page.createSource(sourceName, sourceAngle, updatedEncoder);
        Assert.assertEquals(page.getMessage(), "Video Source Successfully Added");

        page.verifyToolTip("Add Video Source", VideoPlatformDolbyBookingPage.TOOLTIP_ADD_SOURCE);
        page.verifyToolTip("Export", VideoPlatformDolbyBookingPage.TOOLTIP_EXPORT);
        page.verifyToolTip("Column Settings", VideoPlatformDolbyBookingPage.TOOLTIP_COLUMN_SETTINGS);
        page.disableEntity();
        Assert.assertEquals(page.getMessage(), "Video Source Successfully Disabled");
        page.displayInactive();
        String sourceSearchKeyword = sourceName;
        page.search(sourceSearchKeyword);
        String updatedSource = "UpdatedSourceTest-" + randomDisplayName.substring(0, 4);
        page.updateSource(updatedSource);
         Assert.assertEquals(page.getMessage(), "Video Source Successfully Updated");

        
    }
//
//    @Test(priority = 4)
//    public void testChannel() throws InterruptedException {
////        test = extent.createTest("Test Channel Creation and Update");
//        page.Select_Channel();
//        page.CreateDolby_Channel(channelName, VendorName, Angle, ConnectorID, ClusterName, Description);
//        Assert.assertEquals(page.getMessage(), "Video Channel Successfully Added");
//
//        page.verifyToolTip("Add Video Channel", VideoPlatformDolbyBookingPage.TOOLTIP_ADD_CHANNEL);
//        page.verifyToolTip("Export", VideoPlatformDolbyBookingPage.TOOLTIP_EXPORT);
//        page.verifyToolTip("Column Settings", VideoPlatformDolbyBookingPage.TOOLTIP_COLUMN_SETTINGS);
//
//        page.displayInactive();
//        page.search(ChannelSearchKeyword);
//
//        // page.disableEntity();
//        // Assert.assertEquals(page.getMessage(), "Video Channel Successfully Disabled");
//
//        page.updateDolbyChannel();
//        Assert.assertEquals(page.getMessage(), "Video Channel Successfully Updated");
//
//        // page.deleteEntity();
//        // Assert.assertEquals(page.getMessage(), "Video Channel Successfully Deleted");
//    }
//
//    @Test(priority = 5)
//    public void testBooking() throws InterruptedException {
////        test = extent.createTest("Test Booking Creation and Update");
//        page.Select_Booking();
//        System.out.println("Source name is" + sourceName);
//        String sourceName1 = updatedSource + "_" + sourceAngle;
//        System.out.println("Channel name is" + channelName);
//        String channelName1 = channelName + " (Dolby)";
//        // String channelName1=channelName+" (VendorName)";
//        System.out.println("Channel name is" + channelName);
//        page.createBooking(sourceName1, channelName1);
//        Assert.assertEquals(page.getMessage(), "Video Booking Successfully Added");
//
//        page.disableEntity();
//        Assert.assertEquals(page.getMessage(), "Video Booking Successfully Disabled");
//
//        page.deleteEntity();
//        Assert.assertEquals(page.getMessage(), "Video Booking Successfully Deleted");
//    }



    @AfterClass
    public void tearDown() throws InterruptedException {
        // Close the browser and end the session
        driver.quit();

        // Write all test information to the report
//        extent.flush();
    }

}
