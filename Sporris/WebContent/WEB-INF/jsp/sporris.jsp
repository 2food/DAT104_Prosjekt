<%@ page import="static no.hib.dat104.project.controller.UrlMappings.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sporris</title>
</head>
<body>
	<form action="<%=SPORRISURL%>" method=post>
		<input type="radio" name="svar" value="Svaralt1">Svar alternativ 1<br>
		<input type="radio" name="svar" value="Svaralt2">Svar alternativ 2<br>
		<input type="radio" name="svar" value="Svaralt3">Svar alternativ 3<br>
		<input type="radio" name="svar" value="Svaralt4">Svar alternativ 4<br>
		<p>
			<input type="submit" value="svar">
		</p>
	</form>
</body>
</html>