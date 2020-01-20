<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<jsp:useBean id="today" class="java.util.Date" />
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>${applicationScope['cpa-website-name']} - Consumer Privacy Act Data Request</title>

<link rel="shortcut icon" type="image/x-icon" href="resources/images/${applicationScope['cpa-website-favicon-name']}"/>
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
<script type="application/javascript" src="resources/lib/jquery.min.js"></script>
<script type="application/javascript" src="resources/lib/bootstrap.min.js"></script>
<script type="application/javascript" src="resources/lib/moment.js"></script>
<style>
body#LoginForm {
	background-repeat: no-repeat;
	background-position: center;
	background-size: cover;
	padding: 10px;
}

.panel p {
	color: #777777;
	font-size: 14px;
	margin-bottom: 30px;
	line-height: 24px;
}

.login-form .form-control {
	background: #f7f7f7 none repeat scroll 0 0;
	border: 1px solid #d4d4d4;
	border-radius: 4px;
	font-size: 14px;
	height: 50px;
	line-height: 50px;
}

.main-div {
	background: #f7f7f7 none repeat scroll 0 0;
	border: #DCDCDC 1px solid;
	border-radius: 3px;
	margin: 100px auto 30px;
	max-width: 38%;
	padding: 50px 70px 70px 71px;
}

.login-form .form-group {
	margin-bottom: 10px;
}

.login-form {
	text-align: center;
}

.login-form .btn.btn-default {
	border-color: #666666;
	color: #000000;*/
	font-size: 14px;
	width: 100%;
	height: 50px;
	line-height: 50px;
	padding: 0;
}

button.submitBtn:hover {
	font-weight: bold
}

.panel-title {
	text-align: center;
	font-size: 23px;
	font-weight: normal;
	margin-bottom: 20px;
}

</style>
</head>
<body id="LoginForm">
<div class="container">
	<div class="login-form">
		<div class="main-div">
			<div class="panel">
				<div class="panel-heading">
					<div class="panel-title">${applicationScope['cpa-portal-website-name']} Login</div>
				</div>
				<c:if test = "${errorMessage == ''}">
					<p>Please enter your user name and password</p>
				</c:if>
				<c:if test = "${errorMessage != ''}">
					<p style="color: red">${errorMessage}</p>
				</c:if>
			</div>
			<form id="Login" action="login" method="post">
				<div class="form-group">
					<input type="text" class="form-control" id="username" name="username" placeholder="User Name">
				</div>
				<div class="form-group">
					<input type="password" class="form-control" id="password" name="password" autocomplete="off" placeholder="Password">
				</div>
				<div class="form-group">
					<select class="form-control" id="domain" name="domain">
					  <c:if test = "${applicationScope['cpa-portal-website-name'] != 'carbon'}">
					  	<option value="acsbnt">ACSBNT</option>
					  	<option value="acsnt">ACSNT</option>
					  	<option value="ccbbank">CCB</option>
					  </c:if>	
					  <c:if test = "${applicationScope['cpa-portal-website-name'] == 'carbon'}">
					  	<option value="NCC">NCC.LOCAL</option>
					  </c:if>	
					</select>
				</div>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<br>
				<button type="submit" class="btn btn-default submitBtn">Login</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>