import java.util.List;
import java.util.NoSuchElementException;

public interface WeatherBackendInterfaceFD {
	//WeatherBackendInterface(RangeSearchTreeInterface<WeatherInterface> tree, WeatherReaderInterface weatherReader);
	public void loadData(String filename) throws NoSuchElementException;
	public int getAvgTempByDate(String date);
	public int getAvgHumidityByDate(String date);
	public List<String> DaysByTemp(int temp);
	public List<String> DaysByHumidity(int humidity);

	}
