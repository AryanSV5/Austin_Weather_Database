// --== CS400 Project One File Header ==--
// Name: Aryan Reddy Permalla
// CSL Username: permalla
// Email: permalla@wisc.edu
// Lecture #: 001 (9:30-10:45)
// Notes to Grader: This is a placeholder class for the Data Wrangler to load a file of 
//                  of weather objects


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder class for the Data Wrangler where we can get our weather objects from the 
 * preferred dataset. 
 * 
 * @author Aryan Permalla
 *
 */
public class WeatherReaderBD implements WeatherReaderInterface {
  /**
   * This is a placeholder implementation of loading weather objects into a list so the backend
   * then can use this method to effectively place these objects into our red black tree data
   * structure. We load the data in two different ways based on our placeholder filename input
   * 
   * @param filename the file from which we load our weather objects
   */
  public List<WeatherInterface> readWeatherFromFile(String filename) throws FileNotFoundException {
    List<WeatherInterface> placeHolder = new ArrayList<>();
    if (filename.equals("file")) {
      WeatherBD placeHolderData1 = new WeatherBD("27/04/2023", 50, 50);
      WeatherBD placeHolderData2 = new WeatherBD("28/04/2023", 56, 57);
      WeatherBD placeHolderData3 = new WeatherBD("29/04/2023", 58, 59);
      WeatherBD placeHolderData4 = new WeatherBD("30/04/2023", 60, 61);
      WeatherBD placeHolderData5 = new WeatherBD("31/05/2023", 70, 77);
      placeHolder.add(placeHolderData1);
      placeHolder.add(placeHolderData2);
      placeHolder.add(placeHolderData3);
      placeHolder.add(placeHolderData4);
      placeHolder.add(placeHolderData5);
    } else  {
      WeatherBD placeHolderData6 = new WeatherBD("07/06/2023", 55, 78);
      WeatherBD placeHolderData7 = new WeatherBD("08/09/2023", 43, 99);
      WeatherBD placeHolderData8 = new WeatherBD("09/01/2023", 43, 49);
      placeHolder.add(placeHolderData6);
      placeHolder.add(placeHolderData7);
      placeHolder.add(placeHolderData8);
    }
    return placeHolder;
  }
}
