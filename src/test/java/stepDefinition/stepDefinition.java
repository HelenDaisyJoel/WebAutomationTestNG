package stepDefinition;

import java.io.IOException;

//import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
import tests.DolbyBookingTest;

public class stepDefinition extends DolbyBookingTest{
	private DolbyBookingTest test;

    public stepDefinition() {
        test = new DolbyBookingTest();
    }

    @Given("Landed in 1ST Application")
    public void landed_in_1st_application() throws IOException, InterruptedException {
        test.setUp();    
    }
    @Given("Create Encoder with DisplayName {string} and ID {string}")
    public void create_encoder_with_display_name_and_id(String DisplayName, String EncoderID) throws InterruptedException {
        test.testEncoder(DisplayName, EncoderID);
        System.out.println("Encoder Name: " + DolbyBookingTest.encoderName); // Use the static field
        updatedEncoder = "Update" + DolbyBookingTest.encoderName; // Use the static field
        System.out.println("Updated Encoder: " + updatedEncoder);
    }

//    
//    @Given("Create Decoder with DisplayName {string} and ID {string}")
//    public void create_decoder_with_display_name_and_id(String DolbyDisplayName, String DecoderID) throws InterruptedException {
//        test.testDecoder(DolbyDisplayName,DecoderID);
//    }
    
    
    @Given("Create Source with {string} {string} {string} {string} {string} {string} {string}")
    public void create_source_with_display_name_angle_foreign_id_type_foreign_id_value_automate_booking(String sourceName, String sourceAngle, String ForeignIDType, String ForeignIDValue, String AutomatedStartMargin, String AutomatedEndMargin, String automateBookingString) throws InterruptedException {
        boolean automateBooking = Boolean.parseBoolean(automateBookingString);
        test.testSource(sourceName, sourceAngle, ForeignIDType, ForeignIDValue, AutomatedStartMargin, AutomatedEndMargin, automateBooking);
        System.out.println("Encoder Name: " + encoderName);
        updatedEncoder = "Update" + encoderName;
        System.out.println("Updated Encoder: " + updatedEncoder);
    }

    @Then("close the application")
    public void close_the_application() throws InterruptedException {
    	
    	test.tearDown();
    }
}


