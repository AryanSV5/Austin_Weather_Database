import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Scanner;


public class FrontendDeveloperTests {
	private WeatherBackendInterface backend;
	private Scanner scnr;
	private WeatherFrontendFD frontend;
	private RangeSearchTreeInterface AE;
	private WeatherReaderInterface DW;
	@BeforeEach
	/**
	 * Creates a frontend object to use
	 */
	public void setup() {
		backend = new WeatherBackend(AE, DW);
		scnr = new Scanner(System.in);
		frontend = new WeatherFrontendFD(scnr, backend);
	}
	
	@Test
	/**
	 * This tests that the command loop works as intended, interacts with user as intended
	 */
	public void testCommandLoop() {
		TextUITester tester = new TextUITester("p\n14\nq");
		TextUITester.run();
		String output = tester.checkOutput();

		assertTrue(output.contains("*******************************************************************************\r\n"
        		+ "Welcome! This is the Austin, Texas Weather Search Base.\r\n"
        		+ "*******************************************************************************\r\n"
        		+ "Choose an option from the list below to view the weather for Austin, Texas:\r\n"
        		+ "    Search Temperature by entering a [D]ate\r\n"
        		+ "    Search [H]umidity Percentage by entering a Date\r\n"
        		+ "    Search for Dates by entering an Average [T]emperature\r\n"
        		+ "    Search for Dates by entering a Humidity [P]ercentage\r\n"
        		+ "    [Q]uit\r\n"
        		+ "Choose a command: \n"
        		+ "p15.0"));
	}
	
	@Test
	/**
	 * This tests that the method avgTempByDate works as intended,
	 *  uses the backend's method correctly and then prints temperature
	 */
	public void testAvgTempByDate() {
		String result = frontend.avgTempByDate("2014-05-03");
		assertEquals(result, "Here is the temperature on 2014-05-03: 68 degrees F");
	}
	
	@Test
	/**
	 * This tests that the method avgHumidityByDate works as intended, 
	 * uses the backend's method correctly and prints the humidity percentage
	 */
	public void testAvgHumidityByDate() {
		String result = frontend.avgHumidityByDate("2015-02-23");
		assertEquals(result, "Here is the humidity percentage on 2015-02-23: 14%");
	}
	
	@Test
	/**
	 * This tests that the method daysByTemp() works as intended, 
	 * utilizes the backend's method and correctly prints out a list of days 
	 */
	public void testDaysByTemp() {
		String result = frontend.daysByTemp("68");
		assertEquals(result, "2014-05-12, 2013-07-10");
	}
	
	@Test
	/**
	 * This tests that the method daysByHumidity() works as intended, prints out a list of days
	 */
	public void testDaysByHumidity() {
		String result = frontend.daysByHumidity("13");
		assertEquals(result, "2016-11-17, 2016-02-14, 2014-09-28");
	}
}
