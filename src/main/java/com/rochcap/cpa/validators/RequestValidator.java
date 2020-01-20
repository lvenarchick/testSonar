
package com.rochcap.cpa.validators;

import java.util.Arrays;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.rochcap.cpa.models.CpaRequest;
import com.rochcap.cpa.utils.Constants;

@Component
public class RequestValidator implements Validator
{
	private static final Logger log = Logger.getLogger("*** " + RequestValidator.class);
	private static final String fileExtensions = "PNG/JPG/JPEG/PDF";
	public static final List<String> ALLOWED_FILE_TYPES = Arrays.asList("image/png", "image/jpg", "image/jpeg", "application/pdf");
	private static final String SIZE_IN_BYTES = "5242880";
	public static final long MAX_MB_IN_BYTES = 5242880;
	
	@Override
	public boolean supports(Class<?> clazz)
	{
		return CpaRequest.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors)
	{
		CpaRequest cpaRequest = (CpaRequest) obj;
		
		MultipartFile docIdfile = cpaRequest.getValidateDocId();
		if (!docIdfile.isEmpty())
			this.validateFile(docIdfile, "docId", errors);

	}

	public boolean isValidRequestState(String stateToCheckValue) 
    { 
		log.debug("isValidRequestState - stateToCheckValue: " + stateToCheckValue);
		boolean validState = false;
		if(stateToCheckValue != null && !stateToCheckValue.equals(""))
		{	
	        for (String element : Constants.VALID_REQUEST_STATE_LIST) 
	        {
	        	log.debug("isValidRequestState - element: " + element + ", state: " + stateToCheckValue);
	            if (element.equals(stateToCheckValue)) 
	            {
	            	validState = true;
	            	break;
	            }
	        }
		}  
		log.debug("isValidRequestState - validState: " + validState);
        return validState;
    }
	
	private void validateFile(MultipartFile file, String property, Errors errors)
	{
		if (!ALLOWED_FILE_TYPES.contains(file.getContentType()))
			errors.rejectValue(property, "cpa." + property + ".file.invalid.type", new Object[] { fileExtensions }, null);
		else if (file.getSize() > MAX_MB_IN_BYTES)
			errors.rejectValue(property, "cpa." + property + ".upload.exceeded.file.size", new Object[] { 5, SIZE_IN_BYTES }, null);
	}
}
