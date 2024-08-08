@tag
Feature: WebAutomation-CucumberBDD-PrismWeb
  I want to use this template for my feature file

  Background:
  Given Landed in 1ST Application

  @tag2
  Scenario Outline: Dolby Booking workflow - VideoEncoderTest
    Given Create Encoder with DisplayName "<DisplayName>" and ID "<EncoderID>"
    Then close the application
    

    Examples: 
      | DisplayName | EncoderID |
      | Test-06      | Test-06  |
#
#	@tag3
  #Scenario Outline: Dolby Booking workflow - VideoDecoderTest
    #Given Create Decoder with DisplayName "<DolbyDisplayName>" and ID "<DecoderID>"
    #Then close the application
#
    #Examples:    
    #|  DolbyDisplayName 	 |  DecoderID | 
    #|  DolbyDecoder-03  			|	  DolbyID-03   | 
    #
    
  @tag4
  Scenario Outline: Dolby Booking workflow - VideoSourceTest
    Given Create Source with "<sourceName>" "<sourceAngle>" "<ForeignIDType>" "<ForeignIDValue>" "<AutomatedStartMargin>" "<AutomatedEndMargin>" "<AutomateBooking>"
    Then close the application
																											
    Examples:
    | sourceName| sourceAngle 	| ForeignIDType | ForeignIDValue | AutomatedStartMargin | AutomatedEndMargin | AutomateBooking |
    | Source-06     |Backside | CHRIMSEventCode| test 					| 10s      							| 10s 							| true					 |
    
    #
#
#	tag5
  #Scenario Outline: Dolby Booking workflow - VideoChannelTest
    #Given Create Source with "<sourceName>" "<sourceAngle>" "<ForeignIDType>" "<ForeignIDValue>" "<AutomatedStartMargin>" "<AutomatedEndMargin>" "<AutomateBooking>"
    #Then close the application
#																											
   #| DisplayName |  AutoAngle                          | connectorID | clusterName                                                      | height | frameRate | description      | ForeignIDType  | ForeignIDValue | createReplay |
   #| DolbyChannel  |  platforms/video/cameraAngles/backside | 74          | platforms/video/videoChannelClusters/018e5dcb-7d64-7578-b9b7-2f1a324894de | _1080p | _50f      | test description | CHRIMSEventCode | 123            | true         |
    
  #tag6
  #Scenario Outline: Dolby Booking workflow - VideoSourceTest
    #Given Create Source with "<sourceName>" "<sourceAngle>" "<ForeignIDType>" "<ForeignIDValue>" "<AutomatedStartMargin>" "<AutomatedEndMargin>" "<AutomateBooking>"
    #Then close the application
#																											
    #Examples:
    #| sourceName| sourceAngle 																| ForeignIDType | ForeignIDValue | AutomatedStartMargin | AutomatedEndMargin | AutomateBooking |
    #| Source-004     |platforms/video/cameraAngles/jockey_cam_10 | CHRIMSEventCode| test 					| 10s      							| 10s 							| true					 |
    #
    

  

  
      