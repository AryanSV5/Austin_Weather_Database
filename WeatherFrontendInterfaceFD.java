

public interface WeatherFrontendInterfaceFD {
	//public WeatherFrontendInterface (Scanner userInput, WeatherBackendInterface backend)
	public void commandLoop();
	public void menuPrompts();
//	public void loadDataCommand();
	public String avgTempByDate(String input);
	public String avgHumidityByDate(String input);
	public String daysByTemp(String input);
	public String daysByHumidity(String input);
}
