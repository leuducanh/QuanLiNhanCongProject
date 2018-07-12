package service.validation;


import java.util.regex.Pattern;

public class CommonValidation {

	private static final String NOT_NUMBER_REGEX = "\\d{10}";

	private static boolean match(String input,String regex){
		Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(input).matches();
	}

	public boolean validateIsNotEmpty(String s) {
		if(("").equals(s)) return false;
		return true;
	}
	
	public boolean validateIsNumber(String input) {
		return match(input,NOT_NUMBER_REGEX);
	}
}
