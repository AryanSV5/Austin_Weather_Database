import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;

public class WeatherBackendFD implements WeatherBackendInterfaceFD{

	@Override
	public void loadData(String filename) throws NoSuchElementException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getAvgTempByDate(String date) {
		// TODO Auto-generated method stub
		return 68;
	}

	@Override
	public int getAvgHumidityByDate(String date) {
		// TODO Auto-generated method stub
		return 14;
	}

	@Override
	public List<String> DaysByTemp(int temp) {
		ArrayList<String> result = new ArrayList<String>();
		result.add("2014-05-12");
		result.add("2013-07-10");
		return result;
	}

	@Override
	public List<String> DaysByHumidity(int humidity) {
		ArrayList<String> result = new ArrayList<String>();
		result.add("2016-11-17");
		result.add("2016-02-14");
		result.add("2014-09-28");
		return result;
	}

}
