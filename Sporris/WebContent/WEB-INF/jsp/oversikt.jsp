<%@ page
	import="static no.hib.dat104.project.controller.UrlMappings.OVERSIKTURL"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kontrollpanel</title>
</head>
<body>
	<h1>Kontrollpanel for ${user.user_name} sine spørriser</h1>

	<form action="login" method="get">
		<input type="submit" value="Logg ut">
	</form>

	<p>
	<table border="1">
		<tr>
			<th align="left">Id</th>
			<th>Spørris</th>
			<th>status</th>
			<th>statistikk</th>
			<th>rediger</th>
			<th>slett</th>
		</tr>

		<c:forEach items="${user.sporrises}" var="i">
			<tr>
				<td>${i.sid}</td>
				<td>${i.sporris_name}</td>

				<td><input type="hidden" name="sporrisID" value="${i.sid}">
					<input type="submit" name="activate" value="Aktiver"></td>
				<td><input type="hidden" name="sporrisID" value="${i.sid}">
					<input type="submit" name="statictics" value="Statistikk"></td>
				<td><input type="hidden" name="sporrisID" value="${i.sid}">
					<input type="submit" name="activate" value="Rediger"></td>
				<td><input type="hidden" name="sporrisID" value="${i.sid}">
					<input type="submit" name="activate" value="Slett"></td>

			</tr>
		</c:forEach>
	</table>


	<p>
		<a href="/Sporris/leggtil.html">Legg Til Spørris</a>
	</p>
</body>
</html>