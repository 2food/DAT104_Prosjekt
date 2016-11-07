<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="no.hib.dat104.project.controller.UrlMappings"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="javascript/jquery-3.1.1.js"> </script>
<script src="javascript/sporris.js"> </script>


<c:set var="checked" scope="page" value="checked"/>
<c:set var="unchecked" scope="page" value=""/>

</head>

<body>

<div id="site_container">

<form id="sporris_edit_form" name="sporrisEditForm" action="${UrlMappings.EDITURL}" method="post">
	<input id="newQCounter" type="hidden" name="newQCounter" value="0">
	<input id="newACounter" type="hidden" name="newACounter" value="0">

	Sp&oslashrris navn: <br />
	<input type="text" name="sporrisName" value="${sporrisName}"><br />
    
    <ul id="questions">
		<c:forEach var="q" items="${qlist}">
			<li class="question">
				<div class="extend-control">
					<button class="toggle-button" type="button">Lukk</button>
					<button class="toggle-button" type="button" style="display:none">Utvid</button>
				</div>
				<div class="question-container">
					${q.question_text} <br />
					<ul id="alternatives">
						<li class="alternative"><input type="checkbox" ${q.allow_text ? checked : unchecked}> Fritekst</li>
						<c:forEach var="a" items="${q.alternatives}">
							<li class="alternative">${a.alternative_text}</li>					
						</c:forEach> 
					</ul>
				</div>
			</li>
		</c:forEach> 

    
    </ul>
	
	<input type="submit" value="lagre">




</form>

</div>
</body>



</html>
