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
	<input type="text" name="sporrisName" value="${sporris.sporris_name}"><br />
    
    <ul id="questions">
		<c:forEach var="q" items="${sporris.questions}">
			<li class="question">
				<div class="extend-control">
					<button class="toggle-button" type="button">Lukk</button>
					<button class="toggle-button" type="button" style="display:none">Utvid</button>
				</div>
				<div class="question-container">
					Sp&oslashrsm&aringl:<br />
					<input type="text" name="oldQ_${q.qid }" value="${q.question_text}">
					<button type="button" class="remove-grandparent">X</button>
					<ul id="alternatives">
						<li class="alternative"><input type="checkbox" ${q.allow_text ? checked : unchecked}> Inkluder tekstsvar</li>
						<li class="alternative"><input type="checkbox" ${q.allow_multiple ? checked : unchecked}> Flervalg</li>
						<c:forEach var="a" items="${q.alternatives}">
							<li class="alternative">
								Alternativ: 
								<input type="text" name="oldQ_${q.qid }_oldA_${a.aid}" value="${a.alternative_text}">
	    						<button type="button" class="remove-parent">X</button>
							</li>				
						</c:forEach> 
						<li class="alternative"><button type="button" class="button add-alternative-button">Legg til alternativ</button></li>	
					</ul>
				</div>
			</li>
		</c:forEach> 
		<li class="question"><button type="button" class="button add-question-button">Legg til Sp&oslashrsm&aringl</button></li>
    
    </ul>
	
	<button type="submit" class="button">Lagre</button>




</form>

</div>
</body>



</html>
