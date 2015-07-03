<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<title>Kontakt je dodat</title>
<link rel="stylesheet" type="text/css"
	href="/contacts-web/css/contacts-style.css">
</head>
<body>

	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

	<div id="navigacija">
		<ul>
			<li><a href="/contacts-web/contacts">Lista kontakta</a></li>
			<li><a href="/contacts-web/contacts/new">Novi kontakt</a></li>
			<li><a href="javascript:formSubmit()">Logout</a></li>
		</ul>
	</div>

	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>

	<h2>Kontakt je uspešno dodat.</h2>
	<a href="/contacts-web/contacts">Natrag na listu kontakta</a>
</body>
</html>