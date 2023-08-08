import java.util.Scanner;

public class AustinWeatherSearchBaseApplication {
  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);
    WeatherReaderDW weatherReader = new WeatherReaderDW();
    RangeSearchTreeAE<WeatherInterface> tree = new RangeSearchTreeAE<>();
    WeatherBackendInterface backend = new WeatherBackend( tree, weatherReader);
    WeatherFrontendFD frontendDW = new WeatherFrontendFD(userInput,backend);
    frontendDW.commandLoop();
  }
}
