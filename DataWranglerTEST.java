import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataWranglerTEST {

    /**
     * Test if WeatherReaderDW can read from file
     * Returns true if no exceptions are thrown
     */
    @Test
    void test1() throws FileNotFoundException {
        WeatherReaderDW test = new WeatherReaderDW();
        test.readWeatherFromFile("austinweather.csv");
    }

    /**
     * Test Case 1 in the compareTo method
     */
    @Test
    void test2(){
        WeatherDW a = new WeatherDW("2023-29-03",40,50);
        WeatherDW b = new WeatherDW("2023-29-03",50,50);
        assertEquals(-1,a.compareTo(b));
    }
    /**
     * Test Case 2 in the compareTo method
     */
    @Test
    void test3(){
        WeatherDW a = new WeatherDW("2023-29-03",40,50);
        WeatherDW b = new WeatherDW("2023-29-03",40,60);
        assertEquals(1,b.compareTo(a));
    }

    /**
     * Test Case 3 in the compareTo Method
     */
    @Test
    void test4(){
        WeatherDW a = new WeatherDW("2023-29-03",40,50);
        WeatherDW b = new WeatherDW("2022-29-04",40,50);
        assertEquals(-1,b.compareTo(a));
    }
    /**
     * Test if same in the compareTo Method
     */
    @Test
    void test5(){
        WeatherDW a = new WeatherDW("2023-29-03",40,50);
        WeatherDW b = new WeatherDW("2023-29-03",40,50);
        assertEquals(0,a.compareTo(b));
    }

}

