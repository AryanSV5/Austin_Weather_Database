import java.io.FileNotFoundException;
import java.util.List;

public interface WeatherReaderInterface{
  // public WeatherReaderInterface ();
  public List<WeatherInterface> readWeatherFromFile (String filename) throws FileNotFoundException;

}

