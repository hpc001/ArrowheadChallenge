/*
 * @author Hector Chen
 * @contact hectorchen6@gmail.com
 */

public class ValidationEngine implements IValidationEngine{
	public IValidationResult validate(String value, String[] validationTags){
		IValidationResult valRes = new ValResult(value, validationTags);
		return valRes;

	}
}