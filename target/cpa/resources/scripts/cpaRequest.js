$(function()
{
	setFieldmasking();
	setFieldData();

	/* Processing Dialog */
	$(document).on('submit', '#cpaRequestForm', function(evt) 
	{  	
		var response = grecaptcha.getResponse();
	    if (response.length === 0) {
	        alert("Please select the \"I\'m not a robot\" checkbox below.");
	        return false;
	    } 
	    			else 
	    {
	        $("#modalMsg").modal({backdrop: "static"});
	        return true;
	    }
	});

	$("input[name=requester]").on("change", function ()
	{
		clearFields();
		
		var validator = $("#cpaRequestForm").validate();
		validator.resetForm();
		
		var requester = $("input[name='requester']:checked").val();
		if(requester == "CN") //consumer
		{
			$("#requesterInformationSection").hide();
			$("#uploadDocumentsSection").hide();
			$("#ci").show();
			$("#cri").hide()
			$("#crm").hide();
			setConsumerRequesterRequiredFields();
		}
		else if(requester == "AA") //auth agent
		{
			
			$("#requesterInformationSection").show();
			$("#ri1,#ri2,#ri3,#ri4,#ri5,#ri6").show();
			$("#ri6").hide();
			$("#uploadDocumentsSection").show();
			$("#ci").hide();
			$("#cri").show()
			$("#crm").hide();
			setAgentRequesterRequiredFields();
			setAgentPlaceholderFieldText();
		}
		else if(requester == "PM") //parent
		{
			
			$("#requesterInformationSection").show();
			$("#ri3,#ri4,#ri5").show();
			$("#ri1,#ri2,#ri6").hide();
			$("#uploadDocumentsSection").hide();
			$("#ci").hide();
			$("#cri").hide()
			$("#crm").show();
			setAgentRequesterRequiredFields();
			setParentPlaceholderFieldText();
		}
		else //associate
		{
			
			$("#uploadDocumentsSection").hide();
			$("#requesterInformationSection").show();
			$("#ri1,#ri2").hide();
			$("#ri3,#ri4,#ri5,#ri6").show();
			$("#ci").hide();
			$("#cri").show()
			$("#crm").hide();
			setAssociateRequesterRequiredFields();
			setParentPlaceholderFieldText();
		}
		setPerjuryLabelText(requester);
	});	
	
	$("#consumerEmailAuthorization").on("change", function ()
	{
		if(this.checked) //consumer
		{
			$("#consumerEmail").prop("required", true);
			$("#consumerEmail").prop("disabled", false);
		}
		else
		{
			$('#consumerEmail').removeClass('error').next('label.error').remove();
			$("#consumerEmail").val("");
			$("#consumerEmail").prop("required", false);
			$("#consumerEmail").prop("disabled", true);
		}
	});	

	$("#requestTypeCategories").on("change", function ()
	{
		if(this.checked) 
		{
			$('#requestTypeCategories-error').removeClass('error').remove();
		}
	});	
	
	$("#requestTypeSpecific").on("change", function ()
	{
		if(this.checked) 
		{
			$('#requestTypeCategories-error').removeClass('error').remove();
		}
	});	

	$("#requestTypeDelete").on("change", function ()
	{
		if(this.checked) 
		{
			$('#requestTypeCategories-error').removeClass('error').remove();
		}
	});	

	$("#requestTypeOptOut").on("change", function ()
	{
		if(this.checked) 
		{
			$('#requestTypeCategories-error').removeClass('error').remove();
		}
	});	
	
	
	///////////////////////////////////////////////////////////////	
	// Initial Page Setup
	///////////////////////////////////////////////////////////////	
	function setFieldData()
	{
		var newRecord = $("#newRecord").val(); // The new record field is used to prevent resubmission of a request by reseting the page and fields
		//console.log("setFieldData - newRecord: " + newRecord);

		if(newRecord == "true")
		{
			setupNewApplication();
		}
		else
		{
			//TODO:  add resetup code after error was found
		}
	}
	
	function setupNewApplication()
	{
		//console.log("setupNewApplication");
		$("#newRecord").val("false");
		
		var isAssociateRequest = $("#associate").val();
		if(isAssociateRequest == "true")
		{
			clearFieldsForAssociateStart();
			$("#requesterAssociate").prop("checked", true);
			$("#requesterInformationSection").show();
			$("#ri1,#ri2").hide();
			$("#ri3,#ri4,#ri5,#ri6").show();
			$("#ci").hide();
			$("#cri").show()
			setAssociateRequesterRequiredFields();
			setParentPlaceholderFieldText();
			setPerjuryLabelText("");
			$("#associateId").prop("disabled", true);
			$("#associateId").css('background-color', 'white');
		}	
		else
		{	
			clearFields();
			$("#requesterConsumer").prop("checked", true);
			$("#requesterInformationSection").hide();
			$("#ci").show();
			$("#cri").hide()
			setConsumerRequesterRequiredFields();
			setPerjuryLabelText("CN");
		}
		$("#crm").hide();
		$("#uploadDocumentsSection").hide();
		$("#consumerEmail").prop("disabled", true);
	}
	
	function clearFields()
	{
		$("#agencyName").val("");
		$("#agencyAddress").val("");
		$("#agencyCity").val("");
		$("#agencyState").val("");
		$("#agencyZip").val("");
		$("#agentFirstName").val("");
		$("#agentMiddleName").val("");
		$("#agentLastName").val("");
		$("#agentAddress").val("");
		$("#agentCity").val("");
		$("#agentState").val("");
		$("#agentZip").val("");
		$("#agentDob").val("");
		$("#agentSsnLastFour").val("");
		$("#associateId").val("");
		$("#submittedToFdrDate").val("");
		$("#requestCategories").prop("checked", false);
		$("#requestSpecificInformation").prop("checked", false);
		$("#requestDelete").prop("checked", false);
		$("#requestOptOut").prop("checked", false);
		$("#consumerFirstName").val("");
		$("#consumerMiddleName").val("");
		$("#consumerLastName").val("");
		$("#consumerAddress").val("");
		$("#consumerApartment").val("");
		$("#consumerCity").val("");
		$("#consumerZip").val("");
		$("#consumerPhone").val("");
		$("#consumerDob").val("");
		$("#consumerSsnLastFour").val("");
		$("#consumerEmailAuthorization").prop("checked", false);
		$("#consumerEmail").val("");
		$("#consumerEmail").prop("disabled", true);
		$("#docId").val("");
		$("#perjuryConfirmation").prop("checked", false);
	}	

	function clearFieldsForAssociateStart()
	{
		$("#agencyName").val("");
		$("#agencyAddress").val("");
		$("#agencyCity").val("");
		$("#agencyState").val("");
		$("#agencyZip").val("");
		$("#agentFirstName").val("");
		$("#agentMiddleName").val("");
		$("#agentLastName").val("");
		$("#agentAddress").val("");
		$("#agentCity").val("");
		$("#agentState").val("");
		$("#agentZip").val("");
		$("#agentDob").val("");
		$("#agentSsnLastFour").val("");
		$("#submittedToFdrDate").val("");
		$("#requestCategories").prop("checked", false);
		$("#requestSpecificInformation").prop("checked", false);
		$("#requestDelete").prop("checked", false);
		$("#requestOptOut").prop("checked", false);
		$("#consumerFirstName").val("");
		$("#consumerMiddleName").val("");
		$("#consumerLastName").val("");
		$("#consumerAddress").val("");
		$("#consumerApartment").val("");
		$("#consumerCity").val("");
		$("#consumerZip").val("");
		$("#consumerPhone").val("");
		$("#consumerDob").val("");
		$("#consumerSsnLastFour").val("");
		$("#consumerEmailAuthorization").prop("checked", false);
		$("#consumerEmail").val("");
		$("#consumerEmail").prop("disabled", true);
		$("#docId").val("");
		$("#perjuryConfirmation").prop("checked", false);
	}	
	
	function setAssociateRequesterRequiredFields()
	{
		$("#agencyName").prop("required", false);
		$("#agencyAddress").prop("required", false);
		$("#agencyCity").prop("required", false);
		$("#agencyState").prop("required", false);
		$("#agencyZip").prop("required", false);
		$("#agentFirstName").prop("required", false);
		$("#agentMiddleName").prop("required", false);
		$("#agentLastName").prop("required", false);
		$("#agentAddress").prop("required", false);
		$("#agentCity").prop("required", false);
		$("#agentState").prop("required", false);
		$("#agentZip").prop("required", false);
		$("#agentDob").prop("required", false);
		$("#agentSsnLastFour").prop("required", false);
		$("#associateId").prop("required", true);
		$("#submittedToFdrDate").prop("required", true);

		
		var company = $("#company").val();
		if(company == "appliedbank")
		{	
			$("#consumerDob").prop("required", true);
			$("#consumerSsnLastFour").prop("required", true);
		}
		else
		{
			$("#consumerDob").prop("required", false);
			$("#consumerSsnLastFour").prop("required", false);
		}
		$("#consumerPhone").prop("required", true);
		
		var emailAuth = $("input[name='consumerEmailAuthorization']:checked").val();
		if(emailAuth)
			$("#consumerEmail").prop("required", true);
		else
			$("#consumerEmail").prop("required", false);
		
		$("#docId").prop("required", false);
	}

	function setConsumerRequesterRequiredFields()
	{
		$("#agencyName").prop("required", false);
		$("#agencyAddress").prop("required", false);
		$("#agencyCity").prop("required", false);
		$("#agencyState").prop("required", false);
		$("#agencyZip").prop("required", false);
		$("#agentFirstName").prop("required", false);
		$("#agentMiddleName").prop("required", false);
		$("#agentLastName").prop("required", false);
		$("#agentAddress").prop("required", false);
		$("#agentCity").prop("required", false);
		$("#agentState").prop("required", false);
		$("#agentZip").prop("required", false);
		$("#agentDob").prop("required", false);
		$("#agentSsnLastFour").prop("required", false);
		$("#associateId").prop("required", false);
		$("#submittedToFdrDate").prop("required", false);

		var company = $("#company").val();
		if(company == "appliedbank")
		{	
			$("#consumerDob").prop("required", true);
			$("#consumerSsnLastFour").prop("required", true);
		}
		else
		{
			$("#consumerDob").prop("required", false);
			$("#consumerSsnLastFour").prop("required", false);
		}
		$("#consumerPhone").prop("required", true);
		
		var emailAuth = $("input[name='consumerEmailAuthorization']:checked").val();
		if(emailAuth)
			$("#consumerEmail").prop("required", true);
		else
			$("#consumerEmail").prop("required", false);
		
		$("#docId").prop("required", false);
	}
	
	function setAgentRequesterRequiredFields()
	{
		$("#agencyName").prop("required", false);
		$("#agencyAddress").prop("required", false);
		$("#agencyCity").prop("required", false);
		$("#agencyState").prop("required", false);
		$("#agencyZip").prop("required", false);
		$("#agentFirstName").prop("required", true);
		$("#agentMiddleName").prop("required", false);
		$("#agentLastName").prop("required", true);
		$("#agentAddress").prop("required", true);
		$("#agentCity").prop("required", true);
		$("#agentState").prop("required", true);
		$("#agentZip").prop("required", true);
		$("#agentDob").prop("required", true);
		$("#agentSsnLastFour").prop("required", true);
		$("#associateId").prop("required", false);
		$("#submittedToFdrDate").prop("required", false);

		var company = $("#company").val();
		if(company == "appliedbank")
		{	
			$("#consumerDob").prop("required", true);
			$("#consumerSsnLastFour").prop("required", true);
		}
		else
		{
			$("#consumerDob").prop("required", false);
			$("#consumerSsnLastFour").prop("required", false);
		}
		$("#consumerPhone").prop("required", true);
		
		var emailAuth = $("input[name='consumerEmailAuthorization']:checked").val();
		if(emailAuth)
			$("#consumerEmail").prop("required", true);
		else
			$("#consumerEmail").prop("required", false);
		
		$("#docId").prop("required", true);
	}
	
	function setAgentPlaceholderFieldText()
	{
		$("#agentFirstName").prop("placeholder", "Agent First Name");
		$("#agentMiddleName").prop("placeholder", "Agent Middle Name");
		$("#agentLastName").prop("placeholder", "Agent Last Name");
		$("#agentAddress").prop("placeholder", "Agent Address");
		$("#agentCity").prop("placeholder", "Agent City");
		$("#agentState").prop("placeholder", "Agent State");
		$("#agentZip").prop("placeholder", "Agent Zip");
		$("#agentDob").prop("placeholder", "Agent Date of Birth");
		$("#agentSsnLastFour").prop("placeholder", "Agent SSN Last 4");
	}
	
	function setParentPlaceholderFieldText()
	{
		$("#agentFirstName").prop("placeholder", "Parent/Guardian First Name");
		$("#agentMiddleName").prop("placeholder", "Parent/Guardian Middle Name");
		$("#agentLastName").prop("placeholder", "Parent/Guardian Last Name");
		$("#agentAddress").prop("placeholder", "Parent/Guardian Address");
		$("#agentCity").prop("placeholder", "Parent/Guardian City");
		$("#agentState").prop("placeholder", "Parent/Guardian State");
		$("#agentZip").prop("placeholder", "Zip");
		$("#agentDob").prop("placeholder", "Parent/Guardian Date of Birth");
		$("#agentSsnLastFour").prop("placeholder", "Parent/Guardian SSN Last 4");
	}
	
	function setPerjuryLabelText(requester)
	{
		var perjuryText = "";
		if(requester == "CN") //consumer
		{
			perjuryText = $("#perjuryText").text("I certify under penalty of perjury that I am the consumer whose personal information is the subject of this request.");		
		}
		else if(requester == "AA") //agent
		{
			perjuryText = $("#perjuryText").text("I certify under penalty of perjury that I am the legally authorized agent for the consumer whose personal information is the subject of this request.");			
		}
		else if(requester == "PM") //parent
		{
			perjuryText = $("#perjuryText").text("I certify under penalty of perjury that I am the parent or legal guardian for the minor whose personal information is the subject of this request.");			
		}
		else	// associate
		{
			perjuryText = $("#perjuryText").text("I certify under penalty of perjury that I am the legally authorized agent for the consumer whose personal information is the subject of this request.");			
		}	
		
		return perjuryText;
	}
	
	///////////////////////////////////////////////////////////////	
	// Client Side Field Validation
	///////////////////////////////////////////////////////////////	
	$("#cpaRequestForm").validate(
	{
		rules: 
		{			
			associateId: {validateAssociateid: true},
			submittedToFdrDate: {validDate: true},
			
			agencyName: {validName: true},
			agencyAddress: {validAgencyAddress: true},
			agencyCity: {validAgencyCity: true},
			agencyZip: {validAgencyZip: true},
			
			agentFirstName: {validName: true},
			agentLastName: {validName: true},
			agentAddress: {validAgentAddress: true},
			agentCity: {validAgentCity: true},
			agentZip: {validAgentZip: true},
			agentDob: {validDob: true},
			agentSsnLastFour: {validateLast4: true},
			
			consumerFirstName: {validName: true},
			consumerMiddleName: {validName: true},
			consumerLastName: {validName: true},
			consumerAddress: {validConsumerAddress: true},
			consumerApartment: {validConsumerApt: true},
			consumerCity: {validConsumerCity: true},
			consumerZip: {validConsumerZip: true},
			consumerPhone: {phoneUS: true},
			consumerDob: {validDob: true},
			consumerSsnLastFour: {validateLast4: true},
			consumerEmail: {validEmail: true},
			docId : { required: true, extension: "jpg|jpeg|png|pdf", filesize: 5242880 },
			requestTypeCategories: {validRequestType: true}
		},
		messages:{
			docId: { extension: 'only JPG/JPEG/PNG/PDF file types allowed!'}
		}

	});

	jQuery.validator.addMethod("validRequestType", function(value, element) 
	{
		var cat = $('#requestTypeCategories').is(":checked")
		var spec = $('#requestTypeSpecific').is(":checked")
		var del = $('#requestTypeDelete').is(":checked")
		var opt = $('#requestTypeOptOut').is(":checked")
		
		if(!cat && !spec && !del && !opt)
		{	
			customErrorMessage = "You must select at least one Request Type.";
			return false;
		}	
		else
		{
			customErrorMessage = "";
		    return true;
		}
    }, 
    function()
    {
    	var returnMessage = customErrorMessage;
    	customErrorMessage = "";
        return returnMessage;
   	});
	
	jQuery.validator.addMethod("validName", function(value, element) 
	{
		var trimmedValue = value.replace(/ /g, "");
		return this.optional(element) || trimmedValue.length > 0;
	}, "Invalid Name.");
	
	var customErrorMessage = "";
	jQuery.validator.addMethod("validAgencyAddress", function(value, element) 
	{
		var trimmedValue = value.replace(/ /g, "");
		var re = /^ *((#\d+)|((box|bin)[-. \/\\]?\d+)|(.*p[ \.]? ?(o|0)[-. \/\\]? *-?((box|bin)|b|(#|num)?\d+))|(p(ost)? *(o(ff(ice)?)?)? *((box|bin)|b)? *\d+)|(p *-?\/?(o)? *-?box)|post office box|((box|bin)|b) *(number|num|#)? *\d+|(num|number|#) *\d+)/i;
		if(re.test(value))
		{	
			customErrorMessage = "PO Boxes are not allowed.";
			return false;
		}	
		else if (trimmedValue.length == 0 && !value == "")
		{	
			customErrorMessage = "Invalid address.";
			return false;
		}
		else
		{
			var ha = $("#agencyAddress").val();
			var hc = $("#agencyCity").val();
			var hs = $("#agencyState").val();
			var hz = $("#agencyZip").val();
			
			if(value != "" && (hc == "" || hs == "" || hz == "") )
			{
				customErrorMessage = "Incomplete address.";
				return false;
			}
			else if(hc != "" && (ha == "" || hs == "" || hz == "") )
			{
				customErrorMessage = "Incomplete address.";
				return false;
			}
			else if(hs != "" && (ha == "" || hc == "" || hz == "") )
			{
				customErrorMessage = "Incomplete address.";
				return false;
			}
			else if(hz != "" && (ha == "" || hc == "" || hs == "") )
			{
				customErrorMessage = "Incomplete address.";
				return false;
			}
			else
			{
				customErrorMessage = "";
		        return true;
			}
		}	
    }, 
    function()
    {
    	var returnMessage = customErrorMessage;
    	customErrorMessage = "";
        return returnMessage;
   	});
	
	jQuery.validator.addMethod("validAgencyCity", function(value, element) 
	{
		var ha = $("#agencyAddress").val();
		var hc = $("#agencyCity").val();
		var hs = $("#agencyState").val();
		var hz = $("#agencyZip").val();
		var trimmedValue = value.replace(/ /g, "");
		if (trimmedValue.length == 0 && !value == "")
		{	
			customErrorMessage = "Invalid city.";
			return false;
		}
		else
		{	
			if(ha != "" && hc != "" && hs != "" && hz != "") 
			{
				$('#homeAddress').removeClass('error').next('label.error').remove();
			}	
			return true;
		}
    }, 
    function()
    {
    	var returnMessage = customErrorMessage;
    	customErrorMessage = "";
        return returnMessage;
   	});
	
	jQuery.validator.addMethod("validAgencyZip", function(value, element) 
	{
		var ha = $("#agencyAddress").val();
		var hc = $("#agencyCity").val();
		var hs = $("#agencyState").val();
		var hz = $("#agencyZip").val();
		var trimmedValue = value.replace(/ /g, "");
		if (trimmedValue.length == 0 && !value == "")
		{	
			customErrorMessage = "Invalid zip.";
			return false;
		}
		else
		{	
			if(ha != "" && hc != "" && hs != "" && hz != "") 
			{
				$('#homeAddress').removeClass('error').next('label.error').remove();
			}	
			return true;
		}
	}, 
    function()
    {
    	var returnMessage = customErrorMessage;
    	customErrorMessage = "";
        return returnMessage;
   	});	
	
	jQuery.validator.addMethod("validAgentAddress", function(value, element) 
	{
		var trimmedValue = value.replace(/ /g, "");
		var re = /^ *((#\d+)|((box|bin)[-. \/\\]?\d+)|(.*p[ \.]? ?(o|0)[-. \/\\]? *-?((box|bin)|b|(#|num)?\d+))|(p(ost)? *(o(ff(ice)?)?)? *((box|bin)|b)? *\d+)|(p *-?\/?(o)? *-?box)|post office box|((box|bin)|b) *(number|num|#)? *\d+|(num|number|#) *\d+)/i;
		if(re.test(value))
		{	
			customErrorMessage = "PO Boxes are not allowed.";
			return false;
		}	
		else if (trimmedValue.length == 0 && !value == "")
		{	
			customErrorMessage = "Invalid address.";
			return false;
		}
		else
		{
			var ha = $("#agentAddress").val();
			var hc = $("#agentCity").val();
			var hs = $("#agentState").val();
			var hz = $("#agentZip").val();
			
			if(value != "" && (hc == "" || hs == "" || hz == "") )
			{
				customErrorMessage = "Incomplete address.";
				return false;
			}
			else if(hc != "" && (ha == "" || hs == "" || hz == "") )
			{
				customErrorMessage = "Incomplete address.";
				return false;
			}
			else if(hs != "" && (ha == "" || hc == "" || hz == "") )
			{
				customErrorMessage = "Incomplete address.";
				return false;
			}
			else if(hz != "" && (ha == "" || hc == "" || hs == "") )
			{
				customErrorMessage = "Incomplete address.";
				return false;
			}
			else
			{
				customErrorMessage = "";
		        return true;
			}
		}	
    }, 
    function()
    {
    	var returnMessage = customErrorMessage;
    	customErrorMessage = "";
        return returnMessage;
   	});
	
	jQuery.validator.addMethod("validAgentCity", function(value, element) 
	{
		var ha = $("#agentAddress").val();
		var hc = $("#agentCity").val();
		var hs = $("#agentState").val();
		var hz = $("#agentZip").val();
		var trimmedValue = value.replace(/ /g, "");
		if (trimmedValue.length == 0 && !value == "")
		{	
			customErrorMessage = "Invalid city.";
			return false;
		}
		else
		{	
			if(ha != "" && hc != "" && hs != "" && hz != "") 
			{
				$('#homeAddress').removeClass('error').next('label.error').remove();
			}	
			return true;
		}
    }, 
    function()
    {
    	var returnMessage = customErrorMessage;
    	customErrorMessage = "";
        return returnMessage;
   	});
	
	jQuery.validator.addMethod("validAgentZip", function(value, element) 
	{
		var ha = $("#agentAddress").val();
		var hc = $("#agentCity").val();
		var hs = $("#agentState").val();
		var hz = $("#agentZip").val();
		var trimmedValue = value.replace(/ /g, "");
		if (trimmedValue.length == 0 && !value == "")
		{	
			customErrorMessage = "Invalid zip.";
			return false;
		}
		else
		{	
			if(ha != "" && hc != "" && hs != "" && hz != "") 
			{
				$('#homeAddress').removeClass('error').next('label.error').remove();
			}	
			return true;
		}
	}, 
    function()
    {
    	var returnMessage = customErrorMessage;
    	customErrorMessage = "";
        return returnMessage;
   	});
	
	jQuery.validator.addMethod("validConsumerAddress", function(value, element) 
	{
		var trimmedValue = value.replace(/ /g, "");
		var re = /^ *((#\d+)|((box|bin)[-. \/\\]?\d+)|(.*p[ \.]? ?(o|0)[-. \/\\]? *-?((box|bin)|b|(#|num)?\d+))|(p(ost)? *(o(ff(ice)?)?)? *((box|bin)|b)? *\d+)|(p *-?\/?(o)? *-?box)|post office box|((box|bin)|b) *(number|num|#)? *\d+|(num|number|#) *\d+)/i;
		if(re.test(value))
		{	
			customErrorMessage = "PO Boxes are not allowed.";
			return false;
		}	
		else if (trimmedValue.length == 0 && !value == "")
		{	
			customErrorMessage = "Invalid address.";
			return false;
		}
		else
		{
			var ha = $("#consumerAddress").val();
			var hapt = $("#consumerApartment").val();
			var hc = $("#consumerCity").val();
			var hs = $("#consumerState").val();
			var hz = $("#consumerZip").val();
			
			if(value != "" && (hc == "" || hs == "" || hz == "") )
			{
				customErrorMessage = "Incomplete address.";
				return false;
			}
			else if(hapt != "" && (ha == "" || hc == "" || hs == "" || hz == "") )
			{
				customErrorMessage = "Incomplete address.";
				return false;
			}
			else if(hc != "" && (ha == "" || hs == "" || hz == "") )
			{
				customErrorMessage = "Incomplete address.";
				return false;
			}
			else if(hs != "" && (ha == "" || hc == "" || hz == "") )
			{
				customErrorMessage = "Incomplete address.";
				return false;
			}
			else if(hz != "" && (ha == "" || hc == "" || hs == "") )
			{
				customErrorMessage = "Incomplete address.";
				return false;
			}
			else
			{
				customErrorMessage = "";
		        return true;
			}
		}	
    }, 
    function()
    {
    	var returnMessage = customErrorMessage;
    	customErrorMessage = "";
        return returnMessage;
   	});
	
	jQuery.validator.addMethod("validConsumerApt", function(value, element) 
	{
		var ha = $("#consumerAddress").val();
		var hapt = $("#consumerApartment").val();
		var hc = $("#consumerCity").val();
		var hs = $("#consumerState").val();
		var hz = $("#consumerZip").val();
		var trimmedValue = value.replace(/ /g, "");
		if (trimmedValue.length == 0 && !value == "")
		{	
			customErrorMessage = "Invalid text.";
			return false;
		}
		else
		{	
			if(ha != "" && hc != "" && hs != "" && hz != "") 
			{
				$('#homeAddress').removeClass('error').next('label.error').remove();
			}	
			return true;
		}
    }, 
    function()
    {
    	var returnMessage = customErrorMessage;
    	customErrorMessage = "";
        return returnMessage;
   	});

	jQuery.validator.addMethod("validConsumerCity", function(value, element) 
	{
		var ha = $("#consumerAddress").val();
		var hapt = $("#consumerApartment").val();
		var hc = $("#consumerCity").val();
		var hs = $("#consumerState").val();
		var hz = $("#consumerZip").val();
		var trimmedValue = value.replace(/ /g, "");
		if (trimmedValue.length == 0 && !value == "")
		{	
			customErrorMessage = "Invalid city.";
			return false;
		}
		else
		{	
			if(ha != "" && hc != "" && hs != "" && hz != "") 
			{
				$('#homeAddress').removeClass('error').next('label.error').remove();
			}	
			return true;
		}
    }, 
    function()
    {
    	var returnMessage = customErrorMessage;
    	customErrorMessage = "";
        return returnMessage;
   	});
	
	jQuery.validator.addMethod("validConsumerZip", function(value, element) 
	{
		var ha = $("#consumerAddress").val();
		var hapt = $("#consumerApartment").val();
		var hc = $("#consumerCity").val();
		var hs = $("#consumerState").val();
		var hz = $("#consumerZip").val();
		var trimmedValue = value.replace(/ /g, "");
		if (trimmedValue.length == 0 && !value == "")
		{	
			customErrorMessage = "Invalid zip.";
			return false;
		}
		else
		{	
			if(ha != "" && hc != "" && hs != "" && hz != "") 
			{
				$('#homeAddress').removeClass('error').next('label.error').remove();
			}	
			return true;
		}
	}, 
    function()
    {
    	var returnMessage = customErrorMessage;
    	customErrorMessage = "";
        return returnMessage;
   	});		
	
	jQuery.validator.addMethod("phoneUS", function(phone_number, element) 
	{
    	phone_number = phone_number.replace(/\s+/g, ""); 
		    return this.optional(element) || phone_number.length > 9 &&
			    phone_number.match(/^(1-?)?(\([2-9]\d{2}\)|[2-9]\d{2})-?[2-9]\d{2}-?\d{4}$/);
	}, "Invalid phone number.");
	
	jQuery.validator.addMethod("validateLast4", function(value, element) 
	{
		var trimmedValue = value.replace(/ /g, "");
		return this.optional(element) || trimmedValue.length == 4;
    }, "Must contain 4 digits");	

	jQuery.validator.addMethod("validateAssociateid", function(value, element) 
	{
		var trimmedValue = value.replace(/ /g, "");
		return this.optional(element) || trimmedValue.length == 8;
    }, "Must contain 8 digits");	
	
	jQuery.validator.addMethod("validDob", function(value, element) 
	{
		var validFormat = /^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[01])\/(19|20)\d{2}$/.test(value);
		var date = new Date(value);
	    var input = value.split( '/' );   
	    var validDate = date.getMonth() + 1 === +input[0] && date.getDate() === +input[1] && date.getFullYear() === +input[2];
        return this.optional(element) || (moment(value,"MM/DD/YYYY").isValid() && validFormat && validDate);
        
    }, "Invalid date of birth.");	
	
	jQuery.validator.addMethod("validDate", function(value, element) 
	{
		var validFormat = /^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[01])\/(19|20)\d{2}$/.test(value);
		var date = new Date(value);
	    var input = value.split( '/' );   
	    var validDate = date.getMonth() + 1 === +input[0] && date.getDate() === +input[1] && date.getFullYear() === +input[2];
        return this.optional(element) || (moment(value,"MM/DD/YYYY").isValid() && validFormat && validDate);
        
    }, "Invalid date.");
	
	jQuery.validator.addMethod("validEmail", function(value, element) 
	{
		var re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
		//var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		return this.optional( element ) || re.test(value);
	},"Invalid email address.");
	
	jQuery.validator.addMethod('filesize', function (value, element, param) {
	    return this.optional(element) || (element.files[0].size < param)
	}, 'File size must be equal to or less than 5 MBs');	
	
	
	
	function setFieldmasking()
	{
		var fields = [
			'agencyName','agencyAddress','agencyCity','agentAddress','agentCity','consumerAddress','consumerApartment','consumerCity'
		];
		
		fields.forEach(function(field){
			
			jQuery('#'+field).mask('Z',{translation: {'Z': {pattern: /[a-zA-Z0-9-#.,\s]/, recursive: true}}});	
		});
		
		$("#agentFirstName, #agentMiddleName, #consumerFirstName, #consumerMiddleName").mask('Z',{translation: {'Z': {pattern: /[a-zA-Z-\s]/, recursive: true}}});
		$("#agentLastName, #consumerLastName").mask('Z',{translation: {'Z': {pattern: /[a-zA-Z0-9-\s]/, recursive: true}}});
		$("#agencyZip, #agentZip, #consumerZip").mask("00000");
		$("#agentDob, #submittedToFdrDate, #consumerDob").mask("00/00/0000");
		$("#agentSsnLastFour, #consumerSsnLastFour").mask("0000");
		$("#associateId").mask('Z',{translation: {'Z': {pattern: /[a-zA-Z0-9\s]/, recursive: true}}});
		$('#consumerEmail').mask('Z',{translation: {'Z': {pattern: /[a-zA-Z0-9!#$%&'*+-/=?^_`{|}~.@]/, recursive: true}}});
		$("#consumerPhone").mask("(000) 000-0000");
	}
})