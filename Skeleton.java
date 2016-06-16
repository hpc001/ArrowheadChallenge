public class ValidationEngine implements IValidationEngine{
	public IValidationResult validate(String value, String[] validationTags){
		IValidationResult valRes = new Ivalres(value, validationTags);
		return valRes;

	}
	






	public static void main(String[] args)
	{
		IValidationEngine validator;
		validator = new ValidationEngine();


		final String [] validationTags = new String[]{"notEmpty", "factor", "notNegative"};
		final String value = "1.0";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = true;
		final boolean actual = validationResult.passes();
		System.out.println("ACTUAL: " + actual);
		assert (expected == actual);
		//assert stampDispenser.calcMinNumStampsToFillRequest(120) == 2;

	}
}