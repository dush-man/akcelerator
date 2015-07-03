<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="javax.servlet.jsp.PageContext"%>

<%@ page session="true"%>

<html>
<head>
<title>Lista Vaših kontakta</title>
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


	<div id="content">
		<div id="header">
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<h2>Lista kontakta:</h2>
				<span class="id">Korisnikov id:
					${pageContext.request.userPrincipal.name}</span>
			</c:if>
		</div>

		<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>

		<div id="lista">
			<c:if test="${!empty contactsList}">
				<table class="tg">
					<tr>
						<th width="120">First Name</th>
						<th width="120">Last Name</th>
						<th width="120">Email</th>
						<th width="120">Phone</th>
						<th width="120">Sex</th>
						<th width="120">Street</th>
						<th width="120">Street No</th>
						<th width="120">City</th>
						<th width="120">Country</th>
					</tr>
					<c:forEach items="${contactsList}" var="contact">
						<tr>
							<td>${contact.firstName}</td>
							<td>${contact.lastName}</td>
							<td>${contact.email}</td>
							<td>${contact.phone}</td>
							<td>${contact.sexName}</td>
							<td>${contact.street}</td>
							<td>${contact.streetNo}</td>
							<td>${contact.cityName}</td>
							<td>${contact.countryName}</td>

							<td><a href="/contacts-web/contacts/${contact.id}">Prikaži</a></td>

							<form:form commandName="contact" method="post">
								<input type="hidden" name="_method" value="DELETE" />
								<td><form:button type="submit"
										formaction="/contacts-web/contacts/${contact.id}">Delete</form:button></td>

							</form:form>
						</tr>
					</c:forEach>
					<!-- <tr>
					<td><a href="/contacts-web/contacts/new">Napravi novi
							kontakt</a></td>
				</tr> -->
					<!-- <tr><td><a href="/login?logout">Izloguj se</a></td></tr> -->
				</table>
			</c:if>
		</div>
	</div>
	<!-- <div id="logout">
		<a href="javascript:formSubmit()"> Logout</a>
	</div> -->
</body>
</html>