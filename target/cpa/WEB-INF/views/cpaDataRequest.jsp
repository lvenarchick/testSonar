<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>${applicationScope['cpa-website-name']} - Consumer Privacy Act Data Request</title>
<meta name="description" content="Consumer privacy act request.">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1.0, shrink-to-fit=no">

<link rel="shortcut icon" type="image/x-icon" href="resources/images/${applicationScope['cpa-website-favicon-name']}"/>
<link rel="stylesheet" type="text/css" href="resources/css/animate.min.css">
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/css/theme.css">
<link rel="stylesheet" type="text/css" href="resources/css/theme-elements.css">
<link rel="stylesheet" type="text/css" href="resources/css/skin.css">
<link rel="stylesheet" type="text/css" href="resources/css/custom.css">
<link rel="stylesheet" type="text/css" href="resources/fontawesome-free/css/all.css">

<style>
/* open-sans-300 - latin */
@font-face {
  font-family: 'Open Sans';
  font-style: normal;
  font-weight: 300;
  src: url('resources/fonts/open-sans-v17-latin-300.eot'); /* IE9 Compat Modes */
  src: local('Open Sans Light'), local('OpenSans-Light'),
       url('resources/fonts/open-sans-v17-latin-300.eot?#iefix') format('embedded-opentype'), /* IE6-IE8 */
       url('resources/fonts/open-sans-v17-latin-300.woff2') format('woff2'), /* Super Modern Browsers */
       url('resources/fonts/open-sans-v17-latin-300.woff') format('woff'), /* Modern Browsers */
       url('resources/fonts/open-sans-v17-latin-300.ttf') format('truetype'), /* Safari, Android, iOS */
       url('resources/fonts/open-sans-v17-latin-300.svg#OpenSans') format('svg'); /* Legacy iOS */
}
/* open-sans-300italic - latin */
@font-face {
  font-family: 'Open Sans';
  font-style: italic;
  font-weight: 300;
  src: url('resources/fonts/open-sans-v17-latin-300italic.eot'); /* IE9 Compat Modes */
  src: local('Open Sans Light Italic'), local('OpenSans-LightItalic'),
       url('resources/fonts/open-sans-v17-latin-300italic.eot?#iefix') format('embedded-opentype'), /* IE6-IE8 */
       url('resources/fonts/open-sans-v17-latin-300italic.woff2') format('woff2'), /* Super Modern Browsers */
       url('resources/fonts/open-sans-v17-latin-300italic.woff') format('woff'), /* Modern Browsers */
       url('resources/fonts/open-sans-v17-latin-300italic.ttf') format('truetype'), /* Safari, Android, iOS */
       url('resources/fonts/open-sans-v17-latin-300italic.svg#OpenSans') format('svg'); /* Legacy iOS */
}
/* open-sans-regular - latin */
@font-face {
  font-family: 'Open Sans';
  font-style: normal;
  font-weight: 400;
  src: url('resources/fonts/open-sans-v17-latin-regular.eot'); /* IE9 Compat Modes */
  src: local('Open Sans Regular'), local('OpenSans-Regular'),
       url('resources/fonts/open-sans-v17-latin-regular.eot?#iefix') format('embedded-opentype'), /* IE6-IE8 */
       url('resources/fonts/open-sans-v17-latin-regular.woff2') format('woff2'), /* Super Modern Browsers */
       url('resources/fonts/open-sans-v17-latin-regular.woff') format('woff'), /* Modern Browsers */
       url('resources/fonts/open-sans-v17-latin-regular.ttf') format('truetype'), /* Safari, Android, iOS */
       url('resources/fonts/open-sans-v17-latin-regular.svg#OpenSans') format('svg'); /* Legacy iOS */
}
/* open-sans-italic - latin */
@font-face {
  font-family: 'Open Sans';
  font-style: italic;
  font-weight: 400;
  src: url('resources/fonts/open-sans-v17-latin-italic.eot'); /* IE9 Compat Modes */
  src: local('Open Sans Italic'), local('OpenSans-Italic'),
       url('resources/fonts/open-sans-v17-latin-italic.eot?#iefix') format('embedded-opentype'), /* IE6-IE8 */
       url('resources/fonts/open-sans-v17-latin-italic.woff2') format('woff2'), /* Super Modern Browsers */
       url('resources/fonts/open-sans-v17-latin-italic.woff') format('woff'), /* Modern Browsers */
       url('resources/fonts/open-sans-v17-latin-italic.ttf') format('truetype'), /* Safari, Android, iOS */
       url('resources/fonts/open-sans-v17-latin-italic.svg#OpenSans') format('svg'); /* Legacy iOS */
}
/* open-sans-600 - latin */
@font-face {
  font-family: 'Open Sans';
  font-style: normal;
  font-weight: 600;
  src: url('resources/fonts/open-sans-v17-latin-600.eot'); /* IE9 Compat Modes */
  src: local('Open Sans SemiBold'), local('OpenSans-SemiBold'),
       url('resources/fonts/open-sans-v17-latin-600.eot?#iefix') format('embedded-opentype'), /* IE6-IE8 */
       url('resources/fonts/open-sans-v17-latin-600.woff2') format('woff2'), /* Super Modern Browsers */
       url('resources/fonts/open-sans-v17-latin-600.woff') format('woff'), /* Modern Browsers */
       url('resources/fonts/open-sans-v17-latin-600.ttf') format('truetype'), /* Safari, Android, iOS */
       url('resources/fonts/open-sans-v17-latin-600.svg#OpenSans') format('svg'); /* Legacy iOS */
}
/* open-sans-600italic - latin */
@font-face {
  font-family: 'Open Sans';
  font-style: italic;
  font-weight: 600;
  src: url('resources/fonts/open-sans-v17-latin-600italic.eot'); /* IE9 Compat Modes */
  src: local('Open Sans SemiBold Italic'), local('OpenSans-SemiBoldItalic'),
       url('resources/fonts/open-sans-v17-latin-600italic.eot?#iefix') format('embedded-opentype'), /* IE6-IE8 */
       url('resources/fonts/open-sans-v17-latin-600italic.woff2') format('woff2'), /* Super Modern Browsers */
       url('resources/fonts/open-sans-v17-latin-600italic.woff') format('woff'), /* Modern Browsers */
       url('resources/fonts/open-sans-v17-latin-600italic.ttf') format('truetype'), /* Safari, Android, iOS */
       url('resources/fonts/open-sans-v17-latin-600italic.svg#OpenSans') format('svg'); /* Legacy iOS */
}
/* open-sans-700 - latin */
@font-face {
  font-family: 'Open Sans';
  font-style: normal;
  font-weight: 700;
  src: url('resources/fonts/open-sans-v17-latin-700.eot'); /* IE9 Compat Modes */
  src: local('Open Sans Bold'), local('OpenSans-Bold'),
       url('resources/fonts/open-sans-v17-latin-700.eot?#iefix') format('embedded-opentype'), /* IE6-IE8 */
       url('resources/fonts/open-sans-v17-latin-700.woff2') format('woff2'), /* Super Modern Browsers */
       url('resources/fonts/open-sans-v17-latin-700.woff') format('woff'), /* Modern Browsers */
       url('resources/fonts/open-sans-v17-latin-700.ttf') format('truetype'), /* Safari, Android, iOS */
       url('resources/fonts/open-sans-v17-latin-700.svg#OpenSans') format('svg'); /* Legacy iOS */
}
/* open-sans-700italic - latin */
@font-face {
  font-family: 'Open Sans';
  font-style: italic;
  font-weight: 700;
  src: url('resources/fonts/open-sans-v17-latin-700italic.eot'); /* IE9 Compat Modes */
  src: local('Open Sans Bold Italic'), local('OpenSans-BoldItalic'),
       url('resources/fonts/open-sans-v17-latin-700italic.eot?#iefix') format('embedded-opentype'), /* IE6-IE8 */
       url('resources/fonts/open-sans-v17-latin-700italic.woff2') format('woff2'), /* Super Modern Browsers */
       url('resources/fonts/open-sans-v17-latin-700italic.woff') format('woff'), /* Modern Browsers */
       url('resources/fonts/open-sans-v17-latin-700italic.ttf') format('truetype'), /* Safari, Android, iOS */
       url('resources/fonts/open-sans-v17-latin-700italic.svg#OpenSans') format('svg'); /* Legacy iOS */
}
/* open-sans-800 - latin */
@font-face {
  font-family: 'Open Sans';
  font-style: normal;
  font-weight: 800;
  src: url('resources/fonts/open-sans-v17-latin-800.eot'); /* IE9 Compat Modes */
  src: local('Open Sans ExtraBold'), local('OpenSans-ExtraBold'),
       url('resources/fonts/open-sans-v17-latin-800.eot?#iefix') format('embedded-opentype'), /* IE6-IE8 */
       url('resources/fonts/open-sans-v17-latin-800.woff2') format('woff2'), /* Super Modern Browsers */
       url('resources/fonts/open-sans-v17-latin-800.woff') format('woff'), /* Modern Browsers */
       url('resources/fonts/open-sans-v17-latin-800.ttf') format('truetype'), /* Safari, Android, iOS */
       url('resources/fonts/open-sans-v17-latin-800.svg#OpenSans') format('svg'); /* Legacy iOS */
}
/* open-sans-800italic - latin */
@font-face {
  font-family: 'Open Sans';
  font-style: italic;
  font-weight: 800;
  src: url('resources/fonts/open-sans-v17-latin-800italic.eot'); /* IE9 Compat Modes */
  src: local('Open Sans ExtraBold Italic'), local('OpenSans-ExtraBoldItalic'),
       url('resources/fonts/open-sans-v17-latin-800italic.eot?#iefix') format('embedded-opentype'), /* IE6-IE8 */
       url('resources/fonts/open-sans-v17-latin-800italic.woff2') format('woff2'), /* Super Modern Browsers */
       url('resources/fonts/open-sans-v17-latin-800italic.woff') format('woff'), /* Modern Browsers */
       url('resources/fonts/open-sans-v17-latin-800italic.ttf') format('truetype'), /* Safari, Android, iOS */
       url('resources/fonts/open-sans-v17-latin-800italic.svg#OpenSans') format('svg'); /* Legacy iOS */
}


input[type=text] {
	text-transform: uppercase;
}

.terms {
	overflow-x: scroll;
	padding: 0;
	margin: 0;
	height: 250px;
}

</style>

<script src="resources/lib/jquery.min.js"></script>
<script src="resources/lib/jquery.mask.js"></script>
<script src="resources/lib/jquery.validation.min.js"></script>
<script src="resources/lib/moment.js"></script>
<script src="resources/lib/modernizr.min.js"></script>
<script src="resources/lib/jquery.appear.min.js"></script>
<script src="resources/lib/jquery.easing.min.js"></script>
<script src="resources/lib/jquery-cookie.min.js"></script>
<script src="resources/lib/bootstrap.min.js"></script>
<script src="resources/lib/common.min.js"></script>
<script src="resources/scripts/cpaRequest.js"></script>

<script src="https://www.google.com/recaptcha/api.js" async defer></script>

<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-39284302-1"></script>
<script>
	window.dataLayer = window.dataLayer || [];
	function gtag() {
		dataLayer.push(arguments);
	}
	gtag('js', new Date());
	gtag('config', 'UA-39284302-1');
</script>

<noscript><meta http-equiv="refresh" content="0;URL=jsdisabled"></noscript>

</head>
<body data-spy="scroll" data-target="#sidebar" data-offset="120">
	<div class="body">
		<header id="header" class="header-narrow" data-plugin-options="{'stickyEnabled': false, 'stickyEnableOnBoxed': false, 'stickyEnableOnMobile': false, 'stickyStartAt': 55, 'stickySetTop': '-33px', 'stickyChangeLogo': true}">
			<div class="header-body">
				<div class="header-container container">
					<div class="header-row">
						<div class="header-column">
							<div class="header-logo">
								<img class="logo-default" alt="${applicationScope['cpa-website-name']}" width="${applicationScope['cpa-website-logo-width']}" height="${applicationScope['cpa-website-logo-height']}" src="resources/images/${applicationScope['cpa-website-logo-name']}"> 
							</div>
						</div>
					</div>
					<div class="header-column justify-content-end">
						<div class="header-row">
							<div class="header-nav header-nav-stripe">
								<div class="header-nav-main header-nav-main-square header-nav-main-effect-2 header-nav-main-sub-effect-1">
									<nav class="collapse">
										<ul class="nav nav-pills" id="mainNav">
											<li><a class="nav-link" href="#contactDetails">Contact Us</a></li>
										</ul>
									</nav>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</header>
		<form:form id="cpaRequestForm" method="POST" autocomplete="nope" action='submitRequest' enctype="multipart/form-data" modelAttribute="cpaRequest" novalidate="novalidate">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<div role="main" class="main">
				<section class="page-header page-header-custom-background parallax d-none d-md-block" data-plugin-parallax data-plugin-options="{'speed': 1.5}" >
					<div class="container">
						<div class="row align-items-center">
							<div class="col-lg-9">
								<h1>Consumer Privacy Act Data Request</h1>
							</div>
						</div>
					</div>
				</section>
				<div class="container">
					<div class="row">
						<div class="col">
							<!-- <h2> </h2>-->
							<p>The following form may be submitted to initiate a request for disclosure of personal information collected (categories of information or specific pieces of information) or to request deletion of personal information collected as defined under the California Consumer Privacy Act.</p>
							<div class="container mb-5">
								<div class="accordion" id="accordion">
									<div class="card card-default">
										<div class="card-header">
											<h4 class="card-title m-0">
												<a class="accordion-toggle" data-toggle="" data-parent="#accordion" href="#collapse1One">Requester</a>
											</h4>
										</div>
										<div id="collapse1One" class="collapse show">
											<div class="card-body">
												<c:if test = "${associate != 'true'}">
													<div class="form-row">
														<div class="form-group col-md-12 col-sm-12">
															<div class="custom-control custom-radio custom-control-inline">
																<form:radiobutton path="requester" id="requesterConsumer" name="requester" value="CN" class="custom-control-input" required="required" /> 
																<label class="custom-control-label" for="requesterConsumer">Consumer</label>
															</div>	
														</div>
													</div>
													<div class="form-row">
														<div class="form-group col-md-12 col-sm-12">
															<div class="custom-control custom-radio custom-control-inline">
																<form:radiobutton path="requester" id="requesterParentMinor" name="requester" value="PM" class="custom-control-input" /> 
																<label class="custom-control-label" for="requesterParentMinor">Parent or Guardian of a Minor</label>
															</div>	
														</div>
													</div>
													<div class="form-row">
														<div class="form-group col-md-12 col-sm-12">
															<div class="custom-control custom-radio custom-control-inline">
																<form:radiobutton path="requester" id="requesterAuthAgent" name="requester" value="AA" class="custom-control-input"/> 
																<label class="custom-control-label" for="requesterAuthAgent">Authorized Agent</label>
															</div>	
														</div>
													</div>
												</c:if>	
												<c:if test = "${associate == 'true'}">
													<div class="form-row">
														<div class="form-group col-md-12 col-sm-12">
															<div class="custom-control custom-radio custom-control-inline">
																<form:radiobutton path="requester" id="requesterAssociate" name="requester" value="AS" class="custom-control-input" required="required"/> 
																<label class="custom-control-label" for="requesterAssociate">Associate</label>
															</div>	
														</div>
													</div>
												</c:if>
											</div>
										</div>
									</div>
									
									<div class="card card-default mt-3" id="requesterInformationSection">
										<div class="card-header">
											<h4 class="card-title m-0">
												<a class="accordion-toggle" data-toggle="" data-parent="#accordion" href="#collapse1One">Requester Information</a>
											</h4>
										</div>
										<div id="collapse1One" class="collapse show">
											<div class="card-body">
												<div class="form-row" id="ri1">
													<div class="form-group col-md-12 col-sm-12 ">
														<form:input path="agencyName" id="agencyName" placeholder="Agency Name" autocomplete="new-password" value="" maxlength="50" class="form-control" />
													</div>
												</div>
												<div class="form-row" id="ri2">
													<div class="form-group col-md-5 col-sm-12">
														<form:input path="agencyAddress" id="agencyAddress" placeholder="Agency Address" autocomplete="new-password" maxlength="26" class="form-control" />
													</div>
													<div class="form-group col-md-3 col-sm-12">
														<form:input path="agencyCity" id="agencyCity" placeholder="Agency City" autocomplete="new-password" maxlength="20" class="form-control" />
													</div>
													<div class="form-group col-md-2 col-sm-12">
														<form:select path="agencyState" id="agencyState" size="1" class="form-control custom-select" >
															<form:option value="" label="STATE" />
															<c:forEach items="${states}" var="state">
																<option value="${state.key}" ${ state.key == cpaRequest.agencyState ? 'selected' : '' }>${state.value}</option>
															</c:forEach>
														</form:select>
													</div>
													<div class="form-group col-md-2 col-sm-12">
														<form:input path="agencyZip" id="agencyZip" placeholder="Agency Zip" autocomplete="new-password" maxlength="5" class="form-control" />
													</div>
												</div>
												<div class="form-row" id="ri6">
													<div class="form-group col-md-6 col-sm-12 ">
														<form:input path="associateId" id="associateId" placeholder="Associate Id" autocomplete="new-password" value="${associateId}" maxlength="8" class="form-control" />
													</div>
													<div class="form-group col-md-6 col-sm-12 ">
														<form:input path="submittedToFdrDate" id="submittedToFdrDate" placeholder="Date Submitted To FDR" autocomplete="new-password" value="" maxlength="10" class="form-control" />
													</div>
												</div>
												<div class="form-row" id="ri3">
													<div class="form-group col-md-4 col-sm-12 ">
														<form:input path="agentFirstName" id="agentFirstName" placeholder="Agent First Name" autocomplete="new-password" value="" maxlength="20" class="form-control" />
													</div>
													<div class="form-group col-md-4 col-sm-12 ">
														<form:input path="agentMiddleName" id="agentMiddleName" placeholder="Agent Middle Name" autocomplete="new-password" value="" maxlength="20" class="form-control" />
													</div>
													<div class="form-group col-md-4 col-sm-12 ">
														<form:input path="agentLastName" id="agentLastName" placeholder="Agent Last Name" autocomplete="new-password" value="" maxlength="20" class="form-control" />
													</div>
												</div>
												<div class="form-row" id="ri4">
													<div class="form-group col-md-5 col-sm-12">
														<form:input path="agentAddress" id="agentAddress" placeholder="Agent Address" autocomplete="new-password" maxlength="26" class="form-control" />
													</div>
													<div class="form-group col-md-3 col-sm-12">
														<form:input path="agentCity" id="agentCity" placeholder="Agent City" autocomplete="new-password" maxlength="20" class="form-control" />
													</div>
													<div class="form-group col-md-2 col-sm-12">
														<form:select path="agentState" id="agentState" size="1" class="form-control custom-select" >
															<form:option value="" label="STATE" />
															<c:forEach items="${states}" var="state">
																<option value="${state.key}" ${ state.key == cpaRequest.agentState ? 'selected' : '' }>${state.value}</option>
															</c:forEach>
														</form:select>
													</div>
													<div class="form-group col-md-2 col-sm-12">
														<form:input path="agentZip" id="agentZip" placeholder="Agent Zip" autocomplete="new-password" maxlength="5" class="form-control" />
													</div>
												</div>
												<div class="form-row" id="ri5">
													<div class="form-group col-md-6 col-sm-12 ">
														<form:input path="agentDob" id="agentDob" placeholder="Agent Date of Birth" autocomplete="new-password" value="" maxlength="8" class="form-control" />
													</div>
													<div class="form-group col-md-6 col-sm-12 ">
														<form:input path="agentSsnLastFour" id="agentSsnLastFour" placeholder="Agent SSN Last 4" autocomplete="new-password" value="" maxlength="4" class="form-control" />
													</div>
												</div>
												
											</div>
										</div>
									</div>

									<div class="card card-default mt-3" id="requestTypeSection">
										<div class="card-header">
											<h4 class="card-title m-0">
												<a class="accordion-toggle" data-toggle="" data-parent="#accordion" href="#collapse1Four">Request Type</a>
											</h4>
										</div>
										<div id="collapse1Four" class="collapse show">
											<div class="card-body">
												<div class="form-row">
													<div class="custom-control custom-checkbox custom-control-inline">
														<c:if test = "${cpaRequest.requestTypeCategories == ''}">
															<form:checkbox path="requestTypeCategories" id="requestTypeCategories" name="requestTypeCategories" class="custom-control-input" value="Y" />
														</c:if>
														<c:if test = "${cpaRequest.requestTypeCategories != ''}">
															<form:checkbox path="requestTypeCategories" id="requestTypeCategories" name="requestTypeCategories" class="custom-control-input" checked="checked" value="Y" />
														</c:if>	
														<form:label class="custom-control-label" path="requestTypeCategories">Categories of Personal Information</form:label>
													</div>
												</div>
												<div class="form-row">
													<div class="custom-control custom-checkbox custom-control-inline">
														<c:if test = "${cpaRequest.requestTypeSpecific == ''}">
															<form:checkbox path="requestTypeSpecific" id="requestTypeSpecific" name="requestTypeSpecific" class="custom-control-input" value="Y" />
														</c:if>
														<c:if test = "${cpaRequest.requestTypeSpecific != ''}">
															<form:checkbox path="requestTypeSpecific" id="requestTypeSpecific" name="requestTypeSpecific" class="custom-control-input" checked="checked" value="Y" />
														</c:if>	
														<form:label class="custom-control-label" path="requestTypeSpecific">Specific Personal Information</form:label>
													</div>
												</div>
												<div class="form-row">
													<div class="custom-control custom-checkbox custom-control-inline">
														<c:if test = "${cpaRequest.requestTypeDelete == ''}">
															<form:checkbox path="requestTypeDelete" id="requestTypeDelete" name="requestTypeDelete" class="custom-control-input" value="Y" />
														</c:if>
														<c:if test = "${cpaRequest.requestTypeDelete != ''}">
															<form:checkbox path="requestTypeDelete" id="requestTypeDelete" name="requestTypeDelete" class="custom-control-input" checked="checked" value="Y" />
														</c:if>	
														<form:label class="custom-control-label" path="requestTypeDelete">Delete Personal Information</form:label>
													</div>
												</div>
												<div class="form-row">
													<div class="custom-control custom-checkbox custom-control-inline">
														<c:if test = "${cpaRequest.requestTypeOptOut == ''}">
															<form:checkbox path="requestTypeOptOut" id="requestTypeOptOut" name="requestTypeOptOut" class="custom-control-input" value="Y" />
														</c:if>
														<c:if test = "${cpaRequest.requestTypeOptOut != ''}">
															<form:checkbox path="requestTypeOptOut" id="requestTypeOptOut" name="requestTypeOptOut" class="custom-control-input" checked="checked" value="Y" />
														</c:if>	
														<form:label class="custom-control-label" path="requestTypeOptOut">Opt Out</form:label>
													</div>
												</div>
											</div>
										</div>
									</div>
									
									<div class="card card-default mt-3" id="consumerInformationSection">
										<div class="card-header">
											<h4 class="card-title m-0">
												<a class="accordion-toggle" data-toggle="" data-parent="#accordion" href="#collapse1One" id="ci">Consumer Information</a>
												<a class="accordion-toggle" data-toggle="" data-parent="#accordion" href="#collapse1One" id="cri">Consumer You Are Representing</a>
												<a class="accordion-toggle" data-toggle="" data-parent="#accordion" href="#collapse1One" id="crm">Minor You Are Representing</a>
											</h4>
										</div>
										<div id="collapse1One" class="collapse show">
											<div class="card-body">
												<div class="form-row">
													<div class="form-group col-md-4 col-sm-12 ">
														<form:input path="consumerFirstName" id="consumerFirstName" placeholder="First Name" autocomplete="new-password" value="" maxlength="20" class="form-control" required="required" />
													</div>
													<div class="form-group col-md-4 col-sm-12">
														<form:input path="consumerMiddleName" id="consumerMiddleName" placeholder="Middle Name" autocomplete="new-password" value="" maxlength="20" class="form-control" />
													</div>
													<div class="form-group col-md-4 col-sm-12">
														<form:input path="consumerLastName" id="consumerLastName" placeholder="Last Name" autocomplete="new-password" value="" maxlength="20" class="form-control" required="required" />
													</div>
												</div>
												<div class="form-row">
													<div class="form-group col-md-4 col-sm-12">
														<form:input path="consumerAddress" id="consumerAddress" placeholder="Address" autocomplete="new-password" maxlength="26" class="form-control" required="required"/>
													</div>
													<div class="form-group col-md-2 col-sm-12">
														<form:input path="consumerApartment" id="consumerApartment" placeholder="Apt/Unit #" autocomplete="new-password" maxlength="20" class="form-control" />
													</div>
													<div class="form-group col-md-3 col-sm-12">
														<form:input path="consumerCity" id="consumerCity" placeholder="City" autocomplete="new-password" maxlength="20" class="form-control" required="required"/>
													</div>
													<div class="form-group col-md-2 col-sm-12">
														<form:select path="consumerState" id="consumerState" size="1" class="form-control custom-select" required="required">
															<form:option value="" label="STATE" />
															<c:forEach items="${states}" var="state">
																<option value="${state.key}" ${ state.key == cpaRequest.consumerState ? 'selected' : '' }>${state.value}</option>
															</c:forEach>
														</form:select>
													</div>
													<div class="form-group col-md-1 col-sm-12">
														<form:input path="consumerZip" id="consumerZip" placeholder="Zip" autocomplete="new-password" maxlength="5" class="form-control" required="required"/>
													</div>
												</div>
												<c:if test = "${company != 'appliedbank'}">
													<div class="form-row">
														<div class="form-group col-md-12 col-sm-12 ">
															<form:input path="consumerPhone" id="consumerPhone" placeholder="Phone" autocomplete="new-password" value="" maxlength="10" class="form-control"/>
														</div>
													</div>
												</c:if>
												<c:if test = "${company == 'appliedbank'}">
													<div class="form-row">
														<div class="form-group col-md-4 col-sm-12 ">
															<form:input path="consumerPhone" id="consumerPhone" placeholder="Phone" autocomplete="new-password" value="" maxlength="10" class="form-control"/>
														</div>
														<div class="form-group col-md-4 col-sm-12 ">
															<form:input path="consumerDob" id="consumerDob" placeholder="Date of Birth" autocomplete="new-password" value="" maxlength="8" class="form-control"/>
														</div>
														<div class="form-group col-md-4 col-sm-12 ">
															<form:input path="consumerSsnLastFour" id="consumerSsnLastFour" placeholder="SSN Last 4" autocomplete="new-password" value="" maxlength="4" class="form-control"/>
														</div>
													</div>
												</c:if>
											</div>
										</div>
									</div>
									
									<div class="card card-default mt-3" id="emailAuthorizationSection">
										<div class="card-header">
											<h4 class="card-title m-0">
												<a class="accordion-toggle" data-toggle="" data-parent="#accordion" href="#collapse1Five"> Email Authorization </a>
											</h4>
										</div>
										<div id="collapse1Five" class="collapse show">
											<div class="card-body">
												<div id="reqAddDetailsRow">
													<div class="form-row">
														<div class="form-group col-md-8 col-sm-12">
															<div class="custom-control custom-checkbox custom-control-inline">
																<c:if test = "${cpaRequest.consumerEmailAuthorization == ''}">
																	<form:checkbox path="consumerEmailAuthorization" name="consumerEmailAuthorization" class="custom-control-input" id="consumerEmailAuthorization" value="Y" />
																</c:if>
																<c:if test = "${cpaRequest.consumerEmailAuthorization != ''}">
																	<form:checkbox path="consumerEmailAuthorization" name="consumerEmailAuthorization" class="custom-control-input" id="consumerEmailAuthorization" checked="checked" value="Y" />
																</c:if>	
																<form:label class="custom-control-label" path="consumerEmailAuthorization">By checking this box, I consent to receive electronic communications regarding this request. If I do not consent, I understand communications will be sent to the provided mailing address.</form:label>
															</div>
														</div>	
														<div class="form-group col-md-4 col-sm-12">
															<form:input path="consumerEmail" placeholder="Email Address" value="" maxlength="50" class="form-control" id="consumerEmail" />
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									
									<div class="card card-default mt-3" id="uploadDocumentsSection">
										<div class="card-header">
											<h4 class="card-title m-0">
												<a class="pDefault"> Upload Documents </a>
											</h4>
										</div>
										<div id="collapse1Six" class="collapse show">
											<div class="card-body">
												<p>Please upload the notarized document signed by the consumer authorizing you to act as an agent on behalf of the aforementioned consumer.  The file must not be greater than 5 Megabytes and must be in a PDF/JPG/JPEG/PNG format.</p>
												<div class="form-row">
													<div class="form-group">
														<label for="docId" style="margin-bottom: -20px;"><strong>Notarized Document or Power of Attorney</strong></label>
														<form:input path="docId" id="docId" type="file" capture="camera" class="form-control-file pt-2" />
														<form:errors path="docId" cssClass="text-danger" />
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="card card-default mt-3" id="confirmationSection">
										<div class="card-header">
											<h4 class="card-title m-0">
												<a class="accordion-toggle" data-toggle="" data-parent="#accordion" href="#collapse1Five"> Confirmation </a>
											</h4>
										</div>
										<div id="collapse1Five" class="collapse show">
											<div class="card-body">
												<div id="reqAddDetailsRow">
													<div class="form-row">
														<div class="form-group col-md-12 col-sm-12">
															<div class="custom-control custom-checkbox custom-control-inline">
																<c:if test = "${cpaRequest.perjuryConfirmation == ''}">
																	<form:checkbox path="perjuryConfirmation" name="perjuryConfirmation" class="custom-control-input" id="perjuryConfirmation" required="required" value="Y" />
																</c:if>
																<c:if test = "${cpaRequest.perjuryConfirmation != ''}">
																	<form:checkbox path="perjuryConfirmation" name="perjuryConfirmation" class="custom-control-input" id="perjuryConfirmation" checked="checked" required="required" value="Y" />
																</c:if>	
																<form:label class="custom-control-label" path="perjuryConfirmation" id="perjuryText"></form:label>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<c:if test = "${associate != 'true'}">
										<div class="g-recaptcha mt-3" data-sitekey="6LdTgL8UAAAAAGgHas7kiViletZiJYuZI2khrNIw" id="recaptchaSection"></div>
									</c:if>
									<div class="col-md-12 pt-5" id="submitButtonSection">
										<input type="submit" id="submitBtn" value="Submit Your Request" class="btn btn-primary btn-lg d-block mx-auto">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
	</form:form>
	<footer id="footer">
		<div class="container">
			<div class="row">
				<div class="col-md-5">&nbsp;</div>
				<div class="col-md-3">&nbsp;</div>
				<div class="col-md-4">
					<div class="contact-details">
						<h4 id="contactDetails">Contact Us</h4>
						<ul class="contact">
							<li><p><i class="fas fa-map-marker-alt"></i> <strong>Address:</strong> ${applicationScope['cpa-website-name']}<br> ${applicationScope['cpa-website-address']}</p></li>
							<li><p><i class="fas fa-phone"></i> <strong>Phone:</strong> ${applicationScope['cpa-website-phone']}</p></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="footer-copyright">
				<div class="row">
					<div class="col-lg-12 text-center">
						<p>&copy; <script>document.write(new Date().getFullYear())</script> ${applicationScope['cpa-website-name']}&reg;. All Rights Reserved.</p>
					</div>
				</div>
			</div>
		</div>
	</footer>
	</div>
	<div class="modal fade" id="modalMsg" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content" style="border-radius: 9px">
				<div class="modal-header">
					<h3 class="modal-title" id="exampleModalLabel">Processing, please wait....</h3>
				</div>
				<div class="modal-body">
					<div class="progress">
						<div class="progress-bar progress-bar-striped progress-bar-animated active" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 75%"></div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="resources/lib/theme.js"></script>
	<script src="resources/lib/custom.js"></script>
	<script src="resources/lib/theme.init.js"></script>
	<input type="hidden" id="newRecord" value="${newRecord}"/>
	<input type="hidden" id="associate" value="${associate}"/>
	<input type="hidden" id="company" value="${company}"/>
</body>
</html>