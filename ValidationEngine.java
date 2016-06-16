public class ValidationEngine implements IValidationEngine{
	public IValidationResult validate(String value, String[] validationTags){
		IValidationResult valRes = new Ivalres(value, validationTags);
		return valRes;

	}
}