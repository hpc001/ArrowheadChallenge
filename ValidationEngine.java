public class ValidationEngine implements IValidationEngine{
	public IValidationResult validate(String value, String[] validationTags){
		IValidationResult valRes = new Ivalres(value, validationTags);
		return valRes;

	}
	
	public static void main(String[] args)
	{
		IValidationEngine validator;
		validator = new ValidationEngine();

		final String [] validationTags = new String[]{"notEmpty", "allAlpha", "firstLetterUpperOnly"};
		final String value = "jAson";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final String expected = "Value's first letter is not uppercase";
		final String actual = validationResult.getMessage();
		System.out.println("ACTUAL: " + actual);
		assert (expected == actual);
		//assert stampDispenser.calcMinNumStampsToFillRequest(120) == 2;
	}
}