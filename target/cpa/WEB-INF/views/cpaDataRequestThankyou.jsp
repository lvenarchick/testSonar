<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="com.rochcap.cpa.utils.MsgConstants" %>
<%session.invalidate();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>${applicationScope['cpa-website-name']} - Consumer Privacy Act Request</title>
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
</style>

<script type="application/javascript" src="resources/lib/jquery.min.js"></script>
<script type="application/javascript" src="resources/lib/jquery.mask.js"></script>
<script type="application/javascript" src="resources/lib/jquery.validation.min.js"></script>
<script type="application/javascript" src="resources/lib/moment.js"></script>
<script type="application/javascript" src="resources/lib/modernizr.min.js"></script>
<script type="application/javascript" src="resources/lib/jquery.appear.min.js"></script>
<script type="application/javascript" src="resources/lib/jquery.easing.min.js"></script>
<script type="application/javascript" src="resources/lib/jquery-cookie.min.js"></script>
<script type="application/javascript" src="resources/lib/bootstrap.min.js"></script>
<script type="application/javascript" src="resources/lib/common.min.js"></script>

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

</head>
<body data-spy="scroll" data-target="#sidebar" data-offset="120">
	<div class="body">
		<header id="header" class="header-narrow" data-plugin-options="{'stickyEnabled': false, 'stickyEnableOnBoxed': false, 'stickyEnableOnMobile': false, 'stickyStartAt': 55, 'stickySetTop': '-33px', 'stickyChangeLogo': true}">
			<div class="header-body">
				<div class="header-container container">
					<div class="header-row">
						<div class="header-column">
							<div class="header-logo">
								<a href=""><img class="logo-default" alt="${applicationScope['cpa-website-name']}" width="${applicationScope['cpa-website-logo-width']}" height="${applicationScope['cpa-website-logo-height']}" src="resources/images/${applicationScope['cpa-website-logo-name']}"></a> 
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
		<div role="main" class="main">
			<section class="page-header page-header-custom-background parallax d-none d-md-block " data-plugin-parallax data-plugin-options="{'speed': 1.5}">
				<div class="container">
					<div class="row align-items-center">
						<div class="col-lg-12">
							<h1>Consumer Privacy Act Request</h1>
						</div>
					</div>
				</div>
			</section>
			<div class="container">
				<div class="row">
					<div class="col">
						<h2>Your request was successfully submitted!</h2>
						<p>If you need assistance or have any questions about your request, please call us at ${applicationScope['cpa-website-phone']}.</p>
					</div>
				</div>
			</div>

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
	</div>
	<script src="resources/lib/theme.js"></script>
	<script src="resources/lib/custom.js"></script>
	<script src="resources/lib/theme.init.js"></script>
</body>
</html>