package app.validators;

import java.util.Map;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.primefaces.validate.ClientValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Custom JSF Validator for Year input, allows only number in YEAR_PATTERN pattern.
 */
@FacesValidator("yearValidator")
public class YearValidator implements Validator, ClientValidator {
 
	private static final Logger logger = LoggerFactory.getLogger(YearValidator.class);
	 
	private Pattern pattern;
  
    private static final String YEAR_PATTERN = "([1-9][0-9][0-9][0-9])";
  
    public YearValidator() {
        pattern = Pattern.compile(YEAR_PATTERN);
        logger.info("Initialized");
    }
 
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if(value == null) {
        	logger.info("No value provided to validation");
            return;
        }
         
        if(!pattern.matcher(value.toString()).matches()) {
        	logger.info("Value is not valid year");
        	context = FacesContext.getCurrentInstance();
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validation Error", 
                        value + " is not a valid year"));
        }
    }
 
    public Map<String, Object> getMetadata() {
        return null;
    }
 
    public String getValidatorId() {
        return "custom.yearValidator";
    }
     
}