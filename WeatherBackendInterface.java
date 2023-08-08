import java.io.FileNotFoundException;
import java.util.List;

public interface WeatherBackendInterface {
    //WeatherBackendInterface(RangeSearchTreeInterface<WeatherInterface> tree, WeatherReaderInterface weatherReader);

    public int loadData(String filename) throws FileNotFoundException;
    public int getAvgTempByDate(String date);
    public int getAvgHumidityByDate(String date);
    public List<String> DaysByTemp(int temp);
    public List<String> DaysByHumidity(int humidity);

    }

