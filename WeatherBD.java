// --== CS400 Project One File Header ==--
// Name: Aryan Reddy Permalla
// CSL Username: permalla
// Email: permalla@wisc.edu
// Lecture #: 001 (9:30-10:45)
// Notes to Grader: This is a placeholder class for the data wrangler to defining a single
//                  weather object.

/**
 * 
 * A placeholder implementation of the Data Wrangler's code to define a single weather object
 * 
 * @author Aryan Permalla
 *
 */
public class WeatherBD implements WeatherInterface{
  private String date;  // Date associated with a weather object
  private int avgTemp;  // Average temperature associated with a weather object
  private int humidityAvgPercent; // Average humidity percentage associated with a weather object
  
  public WeatherBD (String date, int avgTemp,int humidityAvgPercent) {
    this.date = date;
    this.avgTemp = avgTemp;
    this.humidityAvgPercent = humidityAvgPercent;
    
  }
  
  public int compareTo(final WeatherInterface other) {
    return 1;
  }
  
  /**
   *  We use this method fetch the date of a weather object
   *  
   * @return the date of our weather object in the form of a string
   */
    public String getDate() {
      return date;
    }
    /**
     *  We use this method fetch the average temperature of a weather object
     *  
     * @return the average temperature of our weather object 
     */
    public int getAvgTemp() {
      return avgTemp;
    }
    /**
     *  We use this method fetch the average humidity of a weather object
     *  
     * @return the average humidity of our weather object
     */
    public int getHumidityAvg() {
      return humidityAvgPercent;
    }
    /*
     * This method enables us to alter the date of a weather object
     * 
     */
    public void setDate(String newDate) {
      date = newDate;
    };
    /*
     * This method enables us to alter the average temperature of a weather object
     * 
     */
    public void setAvgTemp(int newAvgTemp) {
      avgTemp = newAvgTemp;
    };
    /*
     * This method enables us to alter the average humidity of a weather object
     * 
     */
    public void setHumidityAvg(int newHumidityAvg) {
      humidityAvgPercent = newHumidityAvg;
    };
    
    @Override
    public String toString() {
      return "PlaceHolder String: " + date + " " + avgTemp + " " + humidityAvgPercent;
      }
}
