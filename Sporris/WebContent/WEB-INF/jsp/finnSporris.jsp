<%@ page import="static no.hib.dat104.prosjekt.controller.UrlMappings.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Finn Sp�rris</title>
</head>
<body>
	<h2>Finn Sp�rris</h2>
	<form action="<%=FINNSPORRISURL%>" method=post>
		<fieldset>
			<legend> Finn Sp�rris</legend>
			<p>
				Skriv inn sp�rris tag:<input type="text" name="tag">
			</p>
			<p>
				<input type="submit" value="G� til Sp�rris">
			</p>
		</fieldset>
	</form>
</body>
</html>