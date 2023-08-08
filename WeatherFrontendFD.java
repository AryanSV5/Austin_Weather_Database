import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * Weather Search App Frontend Class
 * @author zspeetz
 *
 */
public class WeatherFrontendFD implements WeatherFrontendInterfaceFD {

    private Scanner userInput;
    private char command;
    private WeatherBackendInterface backend;

    public WeatherFrontendFD (Scanner userInput, WeatherBackendInterface backend) {
        this.userInput = userInput;
        this.backend = backend;
    }
    
    /**
     * Helper method that is used to separate start  and end of weather search 
     */
    private void header() {
            System.out.println("*******************************************************************************");    
    }
    
    /**
     * Loop that runs for the user to interact with
     */
    @Override
    public void commandLoop() {
        header();
        System.out.println("Welcome! This is the Austin, Texas Weather Search Base.");
        header();
        String input;
        try {
        backend.loadData("austinweather.csv");
        } catch (FileNotFoundException e) {
          
        }
        while (command != 'Q') {
            menuPrompts();  
            command = userInput.next().charAt(0);
            command = Character.toUpperCase(command);
            switch (command) {
                    case 'D': //User wants to search for dates for a certain temperature
                            System.out.println("What dates would you like see the average temperature for?");
                            System.out.print("Please enter the dates in this format: MM/DD/YYYY and make sure "
                                    + "it is within the range of 12/21/2013 and 07/31/2017: ");
                            input = userInput.next();
                            if (checkValid(input) == true) {
                            System.out.println(avgTempByDate(input)); 
                            System.out.println();
                            break;
                            }
                            else {
                                command = 'D';
                                break;
                            }
                            
                    case 'H': // User wants to search for dates with a certain humidity percentage
                            System.out.println("What dates would you like see the average humidity for?");
                            System.out.print("Please enter the dates in this format: MM/DD/YYYY and make sure "
                                    + "it is within the range of 12/21/2013 and 07/31/2017: ");
                            input = userInput.next();
                            if (checkValid(input) == true) {
                                System.out.println(avgHumidityByDate(input));
                                System.out.println();
                                break;
                            }
                            else
                                command = 'H';
                                break;
                    case 'T': // User wants to search for days with a given temperature
                System.out.println("What temperature would you like to enter?");
                            System.out.print("Please enter the temperature as a whole number: ");
                            if (userInput.hasNextInt() == true) {
                                input = userInput.next();
                                System.out.println(daysByTemp(input)); 
                                    System.out.println();
                                 break;
                            }
                            else
                                System.out.println("Not valid input, try again with an integer.");
                                command = 'T';
                                break;                            
                    case 'P': //User wants to search for days with a given humidity percentage
                System.out.println("What humidity would you like to enter?");
                            System.out.print("Please enter the humidity percentage as a whole number: ");
                            if (userInput.hasNextInt() == true) {
                                input = userInput.next();
                                    System.out.println(daysByHumidity(input)); 
                                    System.out.println();
                                    break;
                            }
                            else
                                System.out.println("Not valid input, try again with an integer.");
                                command = 'P';
                                break;
                    case 'Q'://User is done
                            break;
                    default: //Command is unrecognized
                            System.out.println("Didn't recognize that instruction.  "
                                    + "Try typing one of the letters presented within brackets to choose the command.");
                            break;
            }
    }
        
        header(); // thank user before ending this application
        System.out.println("Thank you for checking out the Austin, Texas Weather Search Base!");
        header();
    }

    @Override
    /**
     * A menu that the user interacts with to get data they are looking for
     */
    public void menuPrompts() {
        // show options for the user
        System.out.println("Choose an option from the list below to view the weather for Austin, Texas:");
        System.out.println("    Search Temperature by entering a [D]ate");
        System.out.println("    Search [H]umidity Percentage by entering a Date");
        System.out.println("    Search for Dates by entering an Average [T]emperature");
        System.out.println("    Search for Dates by entering a Humidity [P]ercentage");
        System.out.println("    [Q]uit");
        System.out.print("Choose a command: ");
    }
    
    @Override
    /**
     * This method prints out the temperature for a given day. Utilizes backend method getAvgTempByDate
     * @param input - the input given by the user, specifies what date they want to see the temp for
     */
    public String avgTempByDate(String input) {
        int temp = backend.getAvgTempByDate(input);
        return ("Here is the temperature on " + input + ": " + temp + " degrees F");
        
    }

    @Override
    /**
     * This method prints out the humidity for a given day, or range of days. Uses backend's getAvgHumidityByDate
     * @param input - the input given by the user, specifies what date they want to see the humidity for
     */
    public String avgHumidityByDate(String input) {
        int humidity = backend.getAvgHumidityByDate(input);
        return ("Here is the humidity percentage on " + input + ": " + humidity + "%");
        
    }

    @Override
    /**
     * This method prints a list of days that have the temperature specified
     * @param input - the temperature the user specifies
     */
    public String daysByTemp(String input) {
        String answer = "";
        int temp = Integer.parseInt(input);
        List<String> results = backend.DaysByTemp(temp);
        if (results.size() > 0) {
            System.out.println("Here are the dates when the temperature is " + temp + " degrees F: ");
        }
        else {
            System.out.println("No dates found for when the temperature is " + temp + " degrees F.");
            return answer;
        }
        for (int i = 0; i < results.size(); i ++) {
            if (results.size() > 1 && i < results.size() - 1) {
            answer += (results.get(i) + ", ");
            }
            else {
                answer += (results.get(i));
            }
        }
        return answer;
    }

    @Override
    /**
     * This method prints a list of days that have the humidity percentage that was specified
     * @param input - the humidity the user specifies
     */
    public String daysByHumidity(String input) {
        String answer = "";
        int humidity = Integer.parseInt(input);
        List<String> results =  backend.DaysByHumidity(humidity);
        if (results.size() > 0) {
            System.out.println("Here are the dates when the humidity percentage is " + humidity + "%: ");
        }
        else {
            System.out.println("No dates found for when the humidity is " + humidity + "%.");
            return answer;
        }
        for (int i = 0; i < results.size(); i ++) {
            if (results.size() > 1 && i < results.size() - 1) {
                answer += (results.get(i) + ", ");
                }
                else {
                    answer += (results.get(i));
                }
        }
        return answer;
    }

        private boolean checkValid(String input) {
            if ((input.trim().length() == 10) || (input.trim().length() == 9) || (input.trim().length() == 8)) {
            // Range of dates
              /*
            String [] splitDates = input.split("-");
            if (splitDates.length > 1) {
              
                String[] date1 = splitDates[0].split("/");
                String[] date2 = splitDates[1].split("/");
                int year1 = Integer.parseInt(date1[0]);
                int month1 = Integer.parseInt(date1[1]);
                int day1 = Integer.parseInt(date1[2]);
                int year2 = Integer.parseInt(date2[0]);
                int month2 = Integer.parseInt(date2[1]);
                int day2 = Integer.parseInt(date2[2]);
                if (year1 > year2 || (year1==year2 && month1 > month2) || (year1==year2 && month1==month2 && day1 > day2)) {
                    System.out.println("Not a valid range, make sure the dates are valid.");
                    return false;
                }
                return correctDate(date1) && correctDate(date2);
            } */
            // Just one date
            
            String[] result = input.split("/");
            return correctDate(result);
        
            }
            else {
                System.out.println("Not a valid input.");
                return false; 
            }
        }
    /**
     * Makes sure the date is within the range
     * @param result split date
     * @return true if it is valid, false otherwise
     */
        private boolean correctDate(String [] result) {
            int year = Integer.parseInt(result[2]);
            int month = Integer.parseInt(result[0]);
            int day = Integer.parseInt(result[1]);
            if (year > 2017 || year < 2013) {
                System.out.println("Invalid year, please try again with a date within the given range.");
                return false;
            }
            else if (month < 1 || month > 12) {
                System.out.println("Invalid month, please try again with a date within given range.");
                return false;
            }
            else if (day < 1) {
                System.out.println("Invalid day, please try again with a date within the given range.");
                return false;
            }
            else if (((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) && (day > 31)) {
                System.out.println("Invalid day, please try again with a date within the given range.");
                return false;
            }
            else if (((month == 4) || (month == 6) || (month == 9) || (month == 11)) && (day > 30)) {
                System.out.println("Invalid day, please try again with a date within the given range.");
                return false;
            }
            else if ((month == 2) && (day > 28) && (year != 2016)) {
                System.out.println("Invalid day, please try again with a date within the given range.");
                return false;
            }
            else if ((month == 2) && (year == 2016) && (day > 29)) {
                System.out.println("Invalid day, please try again with a date within the given range.");
                return false;
            }
            else 
                return true;
            
            }
        }
    