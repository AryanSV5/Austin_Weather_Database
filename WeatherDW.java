public class WeatherDW implements WeatherInterface{
    private String date;
    private int avgTemp;
    private int humidityAvgPercent;

    /**
     * Constuctor for Weather Object
     * @param date in format YYYY-MM-DD
     * @param avgTemp average temperature per day
     * @param humidityAvgPercent average humidity
     */
    public WeatherDW(String date, int avgTemp,int humidityAvgPercent){
        this.date = date;
        this.avgTemp = avgTemp;
        this.humidityAvgPercent = humidityAvgPercent;
    }

    /**
     * Getter for date
     * @return date
     */
    @Override
    public String getDate() {
        return this.date;
    }

    /**
     * Getter for Avg Temp
     * @return
     */
    @Override
    public int getAvgTemp() {
        return this.avgTemp;
    }

    /**
     * Getter for Humidity Avg
     * @return
     */
    @Override
    public int getHumidityAvg() {
        return this.humidityAvgPercent;
    }

    /**
     * Setter for Date
     * @param newDate new date
     */
    @Override
    public void setDate(String newDate) {
        this.date = newDate;
    }

    /**
     * Setter for AvgTemp
     * @param newAvgTemp new avg temp
     */
    @Override
    public void setAvgTemp(int newAvgTemp) {
        this.avgTemp = newAvgTemp;
    }

    /**
     * Setter for Humidity avg
     * @param newHumidityAvg new humidity avg
     */
    @Override
    public void setHumidityAvg(int newHumidityAvg) {
        this.humidityAvgPercent = newHumidityAvg;
    }

    /**
     * String format "Date: YYYY-MM-DD
     *                Avg Temp: //Temp
     *                Avg Humidity: //Humidity"
     * @return
     */
    @Override
    public String toString(){
        String str = "[Date: " + this.date + " Avg Temp: " + this.avgTemp + " Avg Humidity: " + this.humidityAvgPercent + "]";
       return str;
    }

    /**
     * Compares avgtemp -> avgHumidity -> date
     * @param o the object to be compared.
     * @return Positive int if o is greater, Negative int if o is less, 0 if the same
     */
    @Override
    public int compareTo(WeatherInterface o) {
        // Compare avgTemp
        if (this.avgTemp > o.getAvgTemp()) {
            return 1;
        } else if (this.avgTemp < o.getAvgTemp()){
            return -1;
        }
        // Compare avgHumidity
        if (this.humidityAvgPercent > o.getHumidityAvg()) {
            return 1;
        } else if (this.humidityAvgPercent < o.getHumidityAvg()){
            return -1;
        }
        // Compare dates
        String[] str = this.date.split("/");
        String[] str2 = o.getDate().split("/");
        String fDate = str[2]+str[1] + str[0];
        String sDate = str2[2]+str2[1] + str2[0];
        int date1 = Integer.parseInt(fDate);
        int date2 = Integer.parseInt(sDate);
        if(date1 > date2){
            return 1;
        } else if (date1 < date2){
            return -1;
        }
        return 0;
    }
}



