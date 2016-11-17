<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="no.hib.dat104.project.controller.UrlMappings"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Resultat</title>
</head>
<body>
	<h1>Resultat for ${sporris.sporris_name}</h1>
	<a href="/Sporris/oversikt" >Tilbake til oversikt</a>

	<c:forEach items="${sporris.questions}" var="q">
		<p>${q.question_text}</p>
		<c:forEach items="${q.alternatives}" var="a">
			<table border="1">
				<tr>
					<td>${a.alternative_text}</td>
					<td>Antall</td>
				</tr>
			</table>
		</c:forEach>
	</c:forEach>
</body>
</html>