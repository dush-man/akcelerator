<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<title>Prikaz kontakta</title>
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


	<div id="content">
		<form:form method="GET" commandName="contact">
			<table>
				<tr>
					<td>Ime:</td>
					<td><label>${contact.firstName}</label></td>
				</tr>
				<tr>
					<td>Prezime:</td>
					<td><label>${contact.lastName}</label></td>
				</tr>
				<tr>
					<td>Grad:</td>
					<td><label>${contact.cityName}</label></td>
				</tr>
				<tr>
					<td>Drzava:</td>
					<td><label>${contact.countryName}</label></td>
				</tr>
				<tr>
					<td>Alpha2:</td>
					<td><label>${contact.alpha2}</label></td>
				</tr>
				<tr>
					<td>Alpha3:</td>
					<td><label>${contact.alpha3}</label></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><label>${contact.email}</label></td>
				</tr>
				<tr>
					<td>Telefon:</td>
					<td><label>${contact.phone}</label></td>
				</tr>
				<tr>
					<td>Ulica:</td>
					<td><label>${contact.street}</label></td>
				</tr>
				<tr>
					<td>Broj:</td>
					<td><label>${contact.streetNo}</label></td>
				</tr>
				<tr>
					<td>Zip:</td>
					<td><label>${contact.zipCode}</label></td>
				</tr>
				<tr>
					<td>Pol:</td>
					<td><label>${contact.sexName}</label></td>
				</tr>
				<tr>
					<td><form:button
							formaction="/contacts-web/contacts/${contact.id}/edit">Izmeni</form:button></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>