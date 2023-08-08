import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WeatherReaderDW implements WeatherReaderInterface {
    @Override
    public List<WeatherInterface> readWeatherFromFile(String filename) throws FileNotFoundException {
        // use scanner to read from the specified file, and store results in posts
        ArrayList<WeatherInterface> weather = new ArrayList<>();
        
        Scanner in = new Scanner(new File(filename));
        in.nextLine();
        while (in.hasNextLine()) {
            // for each line in the file being read:
            String line = in.nextLine();
            // split that line into parts around the delimiter: +++
            String[] parts = line.split(",");
            // most lines should have all three parts
            if(parts[0].equals("-") || parts[2].equals("-") || parts[8].equals("-")){
                continue;
            }
            weather.add(new WeatherDW(parts[0],Integer.parseInt(parts[2]),Integer.parseInt(parts[8])));
        }

        // then close the scanner before returning the list of weather
        in.close();
        return weather;
    }
}