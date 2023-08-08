public interface WeatherInterface extends Comparable<WeatherInterface> {
 // public WeatherInterface (String date, int avgTemp,int //humidityAvgPercent);

public String getDate();
public int getAvgTemp();
public int getHumidityAvg();
public void setDate(String newDate);
public void setAvgTemp(int newAvgTemp);
public void setHumidityAvg(int newHumidityAvg);
public String toString();
}

