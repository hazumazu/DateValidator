import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DateValidator {
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;
        String next = in.nextLine();
        
        res = validateDates(next);
        System.out.println(res);
        
    }

	public static String validateDates(String a) {
		//split dates into 2 seperate strings
		String[] dates = a.split("-");
		
		//remove spaces from dates
		dates[0] = dates[0].replaceAll("\\s", "");
		dates[1] = dates[1].replaceAll("\\s", "");
		
		//set up regex
		Pattern pattern;
		Matcher matcher;
		String validDate = "\\d{2}/\\d{2}/\\d{4}";
		pattern = Pattern.compile(validDate);
		
		//test to make sure the pattern is valid
		for (int i = 0; i < dates.length; i++) {
			if (dates[i].matches(validDate) == false) {
				return "Invalid";}
				}
		
		//break date up into the month day year and make sure those parts are valid
		String firstDate[] = dates[0].split("/");
		String secondDate[] = dates[1].split("/");
		
		//divide dates up into proper parts for testing
		int firstMonth = Integer.parseInt(firstDate[0]);
		int secondMonth = Integer.parseInt(secondDate[0]);
		int date1Day = Integer.parseInt(firstDate[1]);
		int date2Day = Integer.parseInt(secondDate[1]);
		int firstYear = Integer.parseInt(firstDate[2]);
		int secondYear = Integer.parseInt(secondDate[2]);
		
		//if either month is greater than 12 the dates are invalid
		if (firstMonth > 12 || secondMonth > 12) {
			return "Invalid"; }
		
		//create map with valid month and days to refer to
		HashMap<String, Integer> validDays = new HashMap<String, Integer>();
		validDays.put("1", 31);
		validDays.put("2", 28);
		validDays.put("3", 31);
		validDays.put("4", 30);
		validDays.put("5", 31);
		validDays.put("6", 30);
		validDays.put("7", 31);
		validDays.put("8", 31);
		validDays.put("9", 30);
		validDays.put("10", 31);
		validDays.put("11", 30);
		validDays.put("12", 31);
		

		
		//if the value is greater than the value in the corresponding month it is invalid
			if (date1Day > validDays.get(firstDate[0]) || date2Day > validDays.get(secondDate[0])) {
				return "Invalid" ; }
		
		//if date 2 is before date 1 they are invalid
		if (secondYear < firstYear) {
			return "Invalid"; }
		
        //if we get here all the tests have been passed and the dates are valid
		return "Valid";
    }

}