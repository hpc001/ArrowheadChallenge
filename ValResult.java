/*
 * @author Hector Chen
 * @contact hectorchen6@gmail.com
 */

public class Ivalres implements IValidationResult{
	
	String val;
	String[] valTags;
	
    /**
     * Constructs a new Ivalres that will validate each check
     *
     * @param val 		The value that will be checked by the given rules 
     * @param valTags 	A string array that contains the specific rules
     *					the given value will be checked on
     */	
    public Ivalres(String val, String[] valTags){
    	//Sets instance variables to be used later
		this.val = val;
		this.valTags = valTags;
	} 

    /**
     * Checks the validity of the given value based on the given rules. 
     * Returns false if any of the rules don't pass and true if they all
     * pass. 
     */
	public boolean passes(){
		
		//Loops through each given tag and checks if the given
		//value passes each specific rule
		for(String s : valTags){
			//System.out.println("VALTAG: " + s);
			switch(s){
				case "money": 
					if(!moneyCheck(val)) return false;
					continue; 
				case "factor": 
					if(!factorCheck(val)) return false;
					continue;
				case "notEmpty": 
					if(!notEmptyCheck(val)) return false;
					continue;					 
				case "notNegative":
					if(!notNegativeCheck(val)) return false;
					continue; 
				case "withinModLimits": 
					if(!withinModLimitsCheck(val)) return false;
					continue;
				case "allAlpha": 
					if(!allAlphaCheck(val)) return false;
					continue;
				case "firstLetterUpperOnly": 
					if(!firstLetterUpperOnlyCheck(val)) return false;
					continue; 					 					 	
			}
		}
		return true;
	}

	/**
     * Checks the validity of the given value based on the given rules. 
     * Returns the proper message based on the failed rule.
     */
	public String getMessage(){

		for(String s : valTags){
			//System.out.println("VALTAG: " + s);
			switch(s){
				case "money": 
					if(!moneyCheck(val)) 
						return "Value is not a valid monetary value";
					continue; 
				case "factor": 
					if(!factorCheck(val)) 
						return "Value is not a valid decimal number";
					continue;
				case "notEmpty": 
					if(!notEmptyCheck(val)) 
						return "Value cannot be empty";
					continue;					 
				case "notNegative":
					if(!notNegativeCheck(val)) 
						return "Value cannot be negative";
					continue; 
				case "withinModLimits": 
					if(!withinModLimitsCheck(val)) 
						return "Value is not within limits for a mod factor";
					continue;
				case "allAlpha": 
					if(!allAlphaCheck(val)) 
						return "Value has non alphabetic characters";
					continue;
				case "firstLetterUpperOnly": 
					if(!firstLetterUpperOnlyCheck(val)) 
						return "Value's first letter is not uppercase";
					continue; 					 					 	

			}
		}
		return "Value has passed all rules";
	}

	/**
     * Checks if the given value is a valid monetary value. 
     * Returns true if valid and false if not.
     *
     * @param val The value that needs to be checked
     */
	public boolean moneyCheck(String val){
		int decimalLength = 0;
		String[] valSplit = val.split("\\.");
		/*
		for(int i = 0; i<valSplit.length; i++){
			System.out.println("valSplit: " + valSplit[i]);
		}*/

		if(valSplit.length>1)
			decimalLength = valSplit[1].length();  //decimal count
		
		if (decimalLength <= 2) 
			return true;
		else 
			return false;
	}

	/**
     * Checks if the given value is not null or not empty. 
     * Returns true if valid and false if not.
     *
     * @param val The value that needs to be checked
     */
	public boolean notEmptyCheck(String val){
		//System.out.println("~~~ notEmptyCheck ~~~");
		if(val.isEmpty() || val == null) 
			return false;
		else 
			return true;
	}

	/**
     * Checks if the given value is not negative. 
     * Returns true if valid and false if not.
     *
     * @param val The value that needs to be checked
     */
	public boolean notNegativeCheck(String val){
		//System.out.println("--- notNegative ---");
		if(val.charAt(0) == '-') 
			return false;
		else 
			return true;
	}

	/**
     * Checks if the given value is a valid decimal number. 
     * Returns true if valid and false if not.
     *
     * @param val The value that needs to be checked
     */
	public boolean factorCheck(String val){
		//System.out.println("=== factorCheck ===");
		return val.matches("[+-]?\\d*\\.?\\d+");  
	}
	
	/**
     * Checks if the given value is a greater than or equal to 1.0
     * and less than or equal to 3.5. 
     * Returns true if valid and false if not.
     *
     * @param val The value that needs to be checked
     */
	public boolean withinModLimitsCheck(String val){
		//System.out.println("<<< withinModLimitsCheck >>>");
		float result = Float.parseFloat(val);
		if(1.0<=result && result<=3.5) 
			return true;
		else
			return false;
	}		

	/**
     * Checks if the given value contains all alphabetic letters. 
     * Returns true if valid and false if not.
     *
     * @param val The value that needs to be checked
     */
	public boolean allAlphaCheck(String val){
		//System.out.println("@@@ allAlphaCheck @@@");
		return val.matches("[a-zA-Z]+");
	}

	/**
     * Checks if the given value's first letter is upper case only. 
     * Returns true if valid and false if not.
     *
     * @param val The value that needs to be checked
     */
	public boolean firstLetterUpperOnlyCheck(String val){
		//System.out.println("@@@ firstLetterUpperOnlyCheck @@@");
		return val.matches("^[A-Z][a-zA-Z]*");
	}



}
