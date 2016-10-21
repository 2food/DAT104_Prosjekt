<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Kontrollpanel for spørriser</h1>
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
			<td><input type="submit" value="aktiver"></td>
			<td><input type="submit" value="statistikk"></td>
			<td><input type="submit" value="rediger"></td>
			<td><input type="submit" value="slett"></td>
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
	
	<p> <a href="/Sporris/leggtil.html">Legg Til Spørris</a></p>
</body>
</html>