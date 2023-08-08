// --== CS400 Spring 2023 File Header Information ==--
// Name: Aryan Reddy Permalla
// Email: permalla@wisc.edu
// Team: AS
// TA: Jack Zhang
// Lecturer: Gary Dahl
// Notes to Grader: This is where I develop my backend tests


import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
// import TextUITester;

/**
 * 
 * This class is designed to check if our backend implementation of WeatherBackend works as intended
 * and is able to properly organize the information provided by the Data Wrangler. Our backend class
 * should make appropriate use of this information in a Red Black Tree using our Algorithm
 * Engineer's extended version of this data structure.
 * 
 * @author Aryan Permalla
 *
 */
public class BackendDeveloperTests {
  WeatherBackendInterface backend; //Based on placeholders
  WeatherBackendInterface backendIntegration; // the backend used during integration
  int sizeOfTree;
  WeatherReaderDW weatherReader = new WeatherReaderDW();
  RangeSearchTreeAE<WeatherInterface> tree = new RangeSearchTreeAE<>();


  @BeforeEach
  /**
   * This method ensures we initialise our backend with appropriate code from the Data Wrangler and
   * Algorithm Engineer.
   */
  public void setupTests() {
    backend = new WeatherBackend(new RangeSearchTreeBD(), new WeatherReaderBD()); // Initialising
                                                                                  // backend based
                                                                                  // on placeholders
    try {
      sizeOfTree = backend.loadData("file");
    } catch (FileNotFoundException error) {
      sizeOfTree = 0;
    }
    weatherReader = new WeatherReaderDW();
    tree = new RangeSearchTreeAE<>();
    backendIntegration = new WeatherBackend(tree, weatherReader);
  }

  @Test
  /*
   * This method checks if our loadData method can store the correct number of weather objects. We
   * load an additional set of weather objects into our red black tree and need to make sure we
   * didn't overwrite the weather objects but rather added onto them. This increases the total size
   * of our tree.
   *
   */
  public void checkLoadData() {
    int expected = 5; // We know that our placeholder classes load only five weather objects
    assertEquals(expected, sizeOfTree, "Number of Files do not correspend to the expected value");
    String newFile = "new File";
    int newResult = 0;
    expected = 8;
    try {
      newResult = backend.loadData(newFile); // Loading three more weather objects
      assertEquals(expected, newResult, "Number of Files do not correspend to the expected value");
    } catch (FileNotFoundException error) {
      assertEquals(expected, newResult, "Number of Files do not correspend to the expected value");
    }
  }

  @Test
  /**
   * This check tests to see if we are able to accurately return the precise average temperature
   * value for a given date.
   * 
   */
  public void checkTempByDate() {
    int expectedTemp = 50; // We know the temperature of the specific date based on placeholders
    int temp = backend.getAvgTempByDate("27/04/2023");
    assertEquals(expectedTemp, temp, "Incorrect temperature return");
    expectedTemp = 58;
    temp = backend.getAvgTempByDate("29/04/2023");
    assertEquals(expectedTemp, temp, "Incorrect temperature return");
    expectedTemp = 56;
    temp = backend.getAvgTempByDate("28/04/2023");
    assertEquals(expectedTemp, temp, "Incorrect temperature return");
  }

  @Test
  /**
   * This check tests to see if we are able to accurately return the precise average humidity value
   * for a given date.
   * 
   */
  public void checkHumidityByDate() {
    int expectedHumidity = 61; // We know the temperature of the specific date based on placeholders
    int humidity = backend.getAvgHumidityByDate("30/04/2023");
    assertEquals(humidity, expectedHumidity, "Incorrect humidity value returned");
    expectedHumidity = 50;
    humidity = backend.getAvgHumidityByDate("27/04/2023");
    assertEquals(humidity, expectedHumidity, "Incorrect humidity value returned");
    expectedHumidity = 77;
    humidity = backend.getAvgHumidityByDate("31/05/2023");
    assertEquals(humidity, expectedHumidity, "Incorrect humidity value returned");
  }

  @Test
  /**
   * This check tests to see if we are able to accurately return the correct number of dates with an
   * average temperature value above a certain temperature point. I test cases where the temperature
   * level is below, above and in between all the average temperature values for all our weather
   * objects in our red black tree.
   * 
   */
  public void checkDatesByTemp() {
    int temp = 58; // only two our dates have an average temperature higher than this point
    List<String> days = backend.DaysByTemp(temp);
    int expected = 2;
    int numDates = days.size();
    assertEquals(expected, numDates, "Incorrect number of dates returned");
    temp = 33; // All our dates have an average temperature higher than this point
    days = backend.DaysByTemp(temp);
    expected = 5;
    numDates = days.size();
    assertEquals(expected, numDates, "Incorrect number of dates returned");
    temp = 80;
    days = backend.DaysByTemp(temp);
    expected = 0; // All our dates have an average temperature below than this point
    numDates = days.size();
    assertEquals(expected, numDates, "Incorrect number of dates returned");
  }

  @Test
  /**
   * This check tests to see if we are able to accurately return the correct number of dates with an
   * average humidity value above a certain humidity level. I test cases where the humidity level is
   * below, above and in between all the average humidity values for all our weather objects in our
   * red black tree.
   * 
   */
  public void checkDatesByHumidity() {
    int humidity = 59; // only two dates have an average humidity higher than this point
    List<String> days = backend.DaysByHumidity(humidity);
    int expected = 2;
    int numDates = days.size();
    assertEquals(expected, numDates, "Incorrect number of dates returned");
    humidity = 40; // All our dates have an average humidity higher than this point
    days = backend.DaysByHumidity(humidity);
    expected = 5;
    numDates = days.size();
    assertEquals(expected, numDates, "Incorrect number of dates returned");
    humidity = 99; // None our dates have an average humidity higher than this point
    days = backend.DaysByHumidity(humidity);
    expected = 0;
    numDates = days.size();
    assertEquals(expected, numDates, "Incorrect number of dates returned");
  }

  @Test
  /**
   * This is our integration test checking to see we can present the user with the correct average
   * temperature and Humidity percentage on 12th December 2013.
   * 
   */
  public void firstIntegration() {
    TextUITester tester = new TextUITester("D\n12/23/2013\nH\n12/23/2013\nQ\n");
    Scanner userInput = new Scanner(System.in);
    WeatherFrontendFD frontendDW = new WeatherFrontendFD(userInput, backendIntegration);
    frontendDW.commandLoop();
    String output = tester.checkOutput();
    String expectedTemp = "Here is the temperature on 12/23/2013: 45 degrees F";
    String expectedHumidity = "Here is the humidity percentage on 12/23/2013: 52%";
    assertTrue(output.contains(expectedHumidity), "Incorrect Humidity value returned");
    assertTrue(output.contains(expectedTemp), "Incorrect Temp value returned");
  }

  @Test
  /**
   * This integration tests ensures we return information on all the dates where the average
   * temperature exceeded 50 degrees F. Similarly, We also return the dates where the average
   * humidity percentage exceeded 65%.
   * 
   */
  public void secondIntegration() {
    TextUITester tester = new TextUITester("T\n50\nP\n65\nQ\n");
    Scanner userInput = new Scanner(System.in);
    WeatherFrontendFD frontendDW = new WeatherFrontendFD(userInput, backendIntegration);
    frontendDW.commandLoop();
    String output = tester.checkOutput();
    String expectedTempDates = "[Date: 12/28/2013 Avg Temp: 51 Avg Humidity: 64], "
        + "[Date: 12/27/2013 Avg Temp: 53 Avg Humidity: 65], "
        + "[Date: 1/1/2014 Avg Temp: 54 Avg Humidity: 68], "
        + "[Date: 1/4/2014 Avg Temp: 57 Avg Humidity: 68],"
        + " [Date: 12/21/2013 Avg Temp: 60 Avg Humidity: 75], "
        + "[Date: 1/9/2014 Avg Temp: 62 Avg Humidity: 80]";
    String expectedHumidityDates =
        "[Date: 1/8/2014 Avg Temp: 47 Avg Humidity: 75], "
        + "[Date: 12/22/2013 Avg Temp: 48 Avg Humidity: 68], "
        + "[Date: 12/25/2013 Avg Temp: 50 Avg Humidity: 71], "
        + "[Date: 12/29/2013 Avg Temp: 50 Avg Humidity: 76], "
        + "[Date: 1/1/2014 Avg Temp: 54 Avg Humidity: 68], "
        + "[Date: 1/4/2014 Avg Temp: 57 Avg Humidity: 68], "
        + "[Date: 12/21/2013 Avg Temp: 60 Avg Humidity: 75], "
        + "[Date: 1/9/2014 Avg Temp: 62 Avg Humidity: 80]";
    assertTrue(output.contains(expectedTempDates), "Incorrect temperature dates returned");
    assertTrue(output.contains(expectedHumidityDates), "Incorrect Humidity dates returned");
  }
  
  @Test
  /**
   * We test the case if a user feeds in incorrect input and the WeatherFrontedFD 
   * returns an appropriate response. We feed in an incorrect date which does not exist
   * in our CSV file. We also feed in a value which does not match any of the menu prompt
   * options.
   * 
   */
  public void CodeReviewOfFrontendDeveloperFirstTest() {
    TextUITester tester = new TextUITester("D\n346\n789\nQ\n");
    Scanner userInput = new Scanner(System.in);
    WeatherReaderDW weatherReader = new WeatherReaderDW();
    RangeSearchTreeAE<WeatherInterface> tree = new RangeSearchTreeAE<>();
    backendIntegration = new WeatherBackend(tree, weatherReader);
    WeatherFrontendFD frontendDW = new WeatherFrontendFD(userInput, backend);
    frontendDW.commandLoop();
    String output = tester.checkOutput();
    String expected = "Not a valid input.";
    String expectedResponse = "Didn't recognize that instruction.  "
        + "Try typing one of the letters presented "
        + "within brackets to choose the command.";
    assertTrue(output.contains(expected), "Incorrect user prompt");
    assertTrue(output.contains(expectedResponse), "Incorrect user prompt");
  }
  @Test
  /**
   * We test the case if a user feeds an impossibly high temperature and humidity value
   * and check to see if the user receives an appropriate message telling them that no dates
   * have a higher avg humidity or temp value. 
   * 
   */
  public void CodeReviewOfFrontendDeveloperSecondTest() {
    TextUITester tester = new TextUITester("T\n1000000000\nP\n100000000\nQ\n");
    Scanner userInput = new Scanner(System.in);
    WeatherReaderDW weatherReader = new WeatherReaderDW();
    RangeSearchTreeAE<WeatherInterface> tree = new RangeSearchTreeAE<>();
    backendIntegration = new WeatherBackend(tree, weatherReader);
    WeatherFrontendFD frontendDW = new WeatherFrontendFD(userInput, backend);
    frontendDW.commandLoop();
    String output = tester.checkOutput();
    String expected = "No dates found for when the temperature is 1000000000 degrees F.";
    String expectedHumidity = "No dates found for when the humidity is 100000000%.";
    assertTrue(output.contains(expected), "Incorrect user prompt");
    assertTrue(output.contains(expectedHumidity), "Incorrect user prompt");
  }


}
