<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="no.hib.dat104.project.controller.UrlMappings"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sporris</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="javascript/jquery-3.1.1.js"> </script>
<script src="javascript/sporris.js"> </script>

</head>
<body>
	<form action="${url}" method="post">
	<ul id="questions">
		<c:forEach var="q" items="${sporris.questions}">
			<li class="question">
				<p>${q.question_text}</p>
				<ul class="alternatives">
					<c:if test="${q.allow_text }">
						<li class="alternative">
							Fritekst: <input type="text" name="q_${q.qid}_text">
						</li>
					</c:if>
					<c:forEach var="a" items="${q.alternatives}">
						<li class="alternative">
							<input type="checkbox" name="q_${q.qid}" value="a_${a.aid}">${a.alternative_text}<br>
						</li>					
					</c:forEach>
				
				</ul>
			</li>
		</c:forEach> 
    </ul>
    <button type="submit" class="button">Send</button>
	</form>
</body>
</html>