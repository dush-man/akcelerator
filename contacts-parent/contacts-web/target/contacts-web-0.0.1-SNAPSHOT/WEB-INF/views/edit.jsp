<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.error {
	color: #ff0000;
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Izmena kontakta</title>
<link rel="stylesheet" type="text/css" href="/contacts-web/css/contacts-style.css">
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
	<h2>Izmena kontakta</h2>

	<form:form method="POST" commandName="contact" action="/contacts-web/contacts/${contact.id}" >
		<input type="hidden" name="_method" value="PUT" />
		<table>
			<tr>
				<td>Ime:</td>
				<td><form:input path="firstName" /></td>
				<td><form:errors path="firstName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Prezime:</td>
				<td><form:input path="lastName" /></td>
				<td><form:errors path="lastName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Grad:</td>
				<td><form:input path="cityName" /></td>
				<td><form:errors path="cityName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Drzava:</td>
				<td><form:input path="countryName" /></td>
				<td><form:errors path="countryName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Alpha2:</td>
				<td><form:input path="alpha2" /></td>
				<td><form:errors path="alpha2" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Alpha3:</td>
				<td><form:input path="alpha3" /></td>
				<td><form:errors path="alpha3" cssClass="error" /></td>
			</tr>
			<tr>
				<td>email:</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Telefon:</td>
				<td><form:input path="phone" /></td>
				<td><form:errors path="phone" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Ulica:</td>
				<td><form:input path="street" /></td>
				<td><form:errors path="street" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Broj:</td>
				<td><form:input path="streetNo" /></td>
				<td><form:errors path="streetNo" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Zip:</td>
				<td><form:input path="zipCode" /></td>
				<td><form:errors path="zipCode" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Pol:</td>
				<td><form:input path="sexName" /></td>
				<td><form:errors path="sexName" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Potvrdi unos"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>