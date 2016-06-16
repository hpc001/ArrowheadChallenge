public class Ivalres implements IValidationResult{
	
	String val;
	String[] valTags;
	public Ivalres(String val, String[] valTags){
		this.val = val;
		this.valTags = valTags;
	} 

	public boolean passes(){
		
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
		return "";
	}

	public boolean moneyCheck(String val){
		String[] splitter = val.split("\\.");
		int decimalLength = 0;
		/*
		for(int i = 0; i<splitter.length; i++){
			System.out.println("Splitter: " + splitter[i]);
		}*/

		if(splitter.length>1){
			splitter[0].length();   // Before Decimal Count
			decimalLength = splitter[1].length();  // After Decimal Count
		}
		if (decimalLength <= 2)
		   return true;
		else
		   return false;
	}

	public boolean notEmptyCheck(String val){
		//System.out.println("~~~ notEmptyCheck ~~~");
		if(val.equals("")) return false;
		else return true;
	}

	public boolean notNegativeCheck(String val){
		//System.out.println("--- notNegative ---");
		if(val.charAt(0) == '-') return false;
		else return true;
	}

	public boolean factorCheck(String val){
		//System.out.println("=== factorCheck ===");
		return val.matches("[+-]?\\d*\\.?\\d+");  

	}

	public boolean withinModLimitsCheck(String val){
		//System.out.println("<<< withinModLimitsCheck >>>");
		float result = Float.parseFloat(val);
		if(1.0<=result && result<=3.5) return true;
		return false;
	}		

	public boolean allAlphaCheck(String val){
		//System.out.println("@@@ allAlphaCheck @@@");

		return val.matches("[a-zA-Z]+");
	}

	public boolean firstLetterUpperOnlyCheck(String val){
		//System.out.println("@@@ firstLetterUpperOnlyCheck @@@");

		return val.matches("^[A-Z][a-zA-Z]*");
	}



}