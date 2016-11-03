<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<link rel="stylesheet" type="text/css" href="style.css">
<script src="jquery-3.1.1.js"> </script>
<script src="test.js"> </script>


<c:set var="checked" scope="page" value="checked"/>
<c:set var="unchecked" scope="page" value=""/>

</head>

<body>

<div id="site_container">

<form id="sporris_edit_form" name="sporrisEditForm" action="edit" method="post">
	<input id="newQCounter" type="hidden" name="newQCounter" value="0">
	<input id="newACounter" type="hidden" name="newACounter" value="0">

	Sp&oslashrris navn: <br />
	<input type="text" name="sporrisNavn"><br />
    
    <ul id="questions">
		<c:forEach var="q" items="${qlist}">
			<li class="question">
				<div class="extend-control">
					<input type="button" value="Lukk" class="button toggle-button">
					<input type="button" value="Utvid" class="button toggle-button" style="display:none">
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
