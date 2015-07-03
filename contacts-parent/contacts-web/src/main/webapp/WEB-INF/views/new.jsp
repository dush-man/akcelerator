<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<title>Novi kontakt</title>
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
		<h2>
			Dodajte informacije o kontaktu koji želite da napravite, sva
				polja su obavezna
		</h2>

		<form:form action="/contacts-web/contacts" method="POST"
			commandName="contact">
			<table>
				<tr>
					<td><form:label path="firstName">Ime:</form:label></td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td><form:label path="lastName">Prezime:</form:label></td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td><form:label path="email">eMail:</form:label></td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td><form:label path="phone">Telefonski broj:</form:label></td>
					<td><form:input path="phone" /></td>
				</tr>
				<tr>
					<td><form:label path="street">Ulica:</form:label></td>
					<td><form:input path="street" /></td>
				</tr>
				<tr>
					<td><form:label path="streetNo">Broj:</form:label></td>
					<td><form:input path="streetNo" /></td>
				</tr>
				<tr>
					<td><form:label path="sexName">Pol:</form:label></td>
					<td><form:select path="sexName">
							<form:option path="" value="Izaberite pol"></form:option>
							<form:options items="${listaPolova}" itemLabel="name"
								itemValue="name" />
						</form:select></td>
				</tr>
				<tr>
					<td><form:label path="cityName">Grad:</form:label></td>
					<td><form:select path="cityName">
							<form:option path="" value="Izaberite grad"></form:option>
							<form:options items="${listaGradova}" itemLabel="name"
								itemValue="name" />
						</form:select></td>
				</tr>
				<tr>
					<td><form:label path="countryName">Država:</form:label></td>
					<td><form:select path="countryName">
							<form:option path="" value="Izaberite državu"></form:option>
							<form:options items="${listaDrzava}" itemLabel="name"
								itemValue="name" />
						</form:select></td>
				</tr>

				<tr>
					<td><form:button type="submit">Potvrdi</form:button></td>
				</tr>
			</table>
		</form:form>

	</div>


</body>
</html>