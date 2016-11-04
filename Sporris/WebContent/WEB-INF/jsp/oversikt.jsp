<%@ page
	import="static no.hib.dat104.project.controller.UrlMappings.OVERSIKTURL"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kontrollpanel</title>
</head>
<body>
	<h1>Kontrollpanel for ${login.username} sine spørriser</h1>

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

		<tr>
			<td>1</td>
			<td>Spørris1</td>
			<td>
				<form action="<%=OVERSIKTURL%>" method="post">
					<input type="hidden" name="sporrisID" value="123"> <input
						type="submit" name="activate" value="Aktiver">
				</form>
			</td>
			<td><input type="submit" name="statictics" value="Statistikk"></td>
			<td><input type="submit" name="edit" value="Rediger"></td>
			<td><input type="submit" name="delete" value="Slett"></td>
		</tr>
		<tr>
			<td>2</td>
			<td>Spørris2</td>
			<td><input type="submit" value="aktiver"></td>
			<td><input type="submit" value="statistikk"></td>
			<td><input type="submit" value="rediger"></td>
			<td><input type="submit" value="slett"></td>
		</tr>
	</table>

	<p>
		<a href="/Sporris/leggtil.html">Legg Til Spørris</a>
	</p>
</body>
</html>