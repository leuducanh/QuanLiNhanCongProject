package main.java.service.validation;


public class CommonValidation {

	public boolean validateIsNotEmpty(String s) {
		if(("").equals(s)) return false;
		
		return true;
	}
	
	public boolean validateIsNumber(String s) {
		try {
			Long.parseLong(s);
		} catch (NumberFormatException e) {
			return false;
		}
		
		return true;
	}
}
