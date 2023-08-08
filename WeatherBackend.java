//--== CS400 Project One File Header ==--
//Name: Aryan Reddy Permalla
//CSL Username: permalla
//Email: permalla@wisc.edu
//Lecture #: 001 (9:30-10:45)
//Notes to Grader: None

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Performs all the application specific logic for the WeatherSearchApp. This primarily involved
 * loading the weather information for particular days, efficiently searching through this
 * information, reporting information on the average temperature or average humidity on a given 
 * date, and fetches the dates whose average temperature and humidity exceeds a certain limit.
 * 
 * @author Aryan Permalla
 * 
 */
public class WeatherBackend implements WeatherBackendInterface {
  private RangeSearchTreeInterface<WeatherInterface> tree;
  private WeatherReaderInterface weatherReader;
  
  /**
   * Initialize backend to make use of the provided RangeSearchTree and
   * WeatherReader, and initialize the number of posts in this dataset to 0.
   * 
   * @param tree    placeholder by me, working implementation
   *                by the AlgorithmEngineer
   * @param weatherReader   placeholder by me, working implementation by DataWrangler
   */
  public WeatherBackend(RangeSearchTreeInterface<WeatherInterface> tree,
      WeatherReaderInterface weatherReader) {
    this.tree = tree;
    this.weatherReader = weatherReader;
  }

  
  /**
   * Use DataWrangler's code to load weather information from the specified file, and then add
   * this information for each date into the Red Black Tree.
   * 
   * @param filename the path and name of the file to load weather information from
   */
  public int loadData(String filename) throws FileNotFoundException{
    List<WeatherInterface> data = weatherReader.readWeatherFromFile(filename);
      for (WeatherInterface weatherObject : data) {
        tree.insertOne(weatherObject);   // We add the weather objects to our tree
      }
    return tree.size();
  }

  
  /**
   * Finds the average temperature of the specified date
   * 
   * @param date specifies a particular date
   * @return the average temperature on the given date
   */
  public int getAvgTempByDate(String date) {
    Iterator<WeatherInterface> iterator = tree.iterator();
    while (iterator.hasNext()) {
      WeatherInterface weatherObject = iterator.next();
      if (weatherObject.getDate().equals(date)) {
        return weatherObject.getAvgTemp();
      }
    }
    return 0;
  }
  
  /**
   * Finds the average humidity of the specified date
   * 
   * @param date specifies a particular date
   * @return the average humidity on the given date
   */
  public int getAvgHumidityByDate(String date) {
    Iterator<WeatherInterface> iterator = tree.iterator();
    while (iterator.hasNext()) {
      WeatherInterface weatherObject = iterator.next();
      if (weatherObject.getDate().equals(date)) {
        int humidity = weatherObject.getHumidityAvg();
        return humidity;
      }
    }
    return 0;
  }
  
  /**
   * Finds all the dates whose average temperature exceeds a specified point
   * 
   * @param temp specifies the temperature 
   * @return list of strings of all the dates whose average temperature exceeded the specified
   *         temperature value
   */
  public List<String> DaysByTemp(int temp) {
    List<String> Dates = new ArrayList<String>();
    Iterator<WeatherInterface> iterator = tree.iterator();
    while (iterator.hasNext()) {
      WeatherInterface weatherObject = iterator.next();
      if (weatherObject.getAvgTemp() > temp) {
        Dates.add(weatherObject.toString());
      }
    }
    return Dates;
  }
  /**
   * Finds all the dates whose average humidity exceeds a specified point
   * 
   * @param humidity specifies the temperature 
   * @return list of strings of all the dates whose average humidity exceeded the specified
   *         humidity value
   */
  public List<String> DaysByHumidity(int humidity) {
    List<String> Dates = new ArrayList<String>();
    Iterator<WeatherInterface> iterator = tree.iterator();
    while (iterator.hasNext()) {
      WeatherInterface weatherObject = iterator.next();
      if (weatherObject.getHumidityAvg() > humidity) {
        Dates.add(weatherObject.toString());
      }
    }
    return Dates;
  } 

}