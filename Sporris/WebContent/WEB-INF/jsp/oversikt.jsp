<%@page import="no.hib.dat104.project.controller.UrlMappings"%>
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

	<form action="<%=UrlMappings.LOGINURL%>" method="get">
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

		<c:forEach items="${user.sporrises}" var="s">
			<tr>
				<td>${s.sid}</td>
				<td>${s.sporris_name}</td>

				<td><form action="<%=UrlMappings.OVERSIKTURL%>" method="post">
						<input type="hidden" name="sporrisID" value="${s.sid}"> <input
							type="submit" name="activate" value="${s.active ? 'Deaktiver ' : 'Aktiver' }">
					</form></td>
				<td><form action="<%=UrlMappings.OVERSIKTURL%>" method="post">
						<input type="hidden" name="sporrisID" value="${s.sid}"> <input
							type="submit" name="statictics" value="Statistikk">
					</form></td>
				<td><form action="<%=UrlMappings.OVERSIKTURL%>" method="post">
						<input type="hidden" name="sporrisID" value="${s.sid}"> <input
							type="submit" name="edit" value="Rediger">
					</form></td>
				<td><form action="<%=UrlMappings.OVERSIKTURL%>" method="post">
						<input type="hidden" name="sporrisID" value="${s.sid}"> <input
							type="submit" name="delete" value="Slett">
					</form></td>

			</tr>
		</c:forEach>
	</table>


	<p>
		<a href="<%=UrlMappings.NEWSPORRIS%>">Legg Til Spørris</a>
		<form action="<%=UrlMappings.OVERSIKTURL %>" method="post">
			<input type="hidden" name="sporrisID" value="0">
			<input type="submit" name="newSporris" value="ny sporris">
		</form>
	</p>
</body>
</html>