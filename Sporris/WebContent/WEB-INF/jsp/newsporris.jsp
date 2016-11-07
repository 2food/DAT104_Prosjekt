<%@page import="no.hib.dat104.project.controller.UrlMappings"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Lag ny Sp&oslashrris</title>
</head>
<body>

	<h1>Lag ny Sp&oslashrris</h1>
	<form action="<%=UrlMappings.NEWSPORRIS%>" method="post">
		Sp&oslashrris navn: <input type="text" name="name"><br />
		Sp&oslashrris tag: <input type="text" name="tag"><br /> <input
			type="submit" value="Lag">
	</form>

</body>
</html>
