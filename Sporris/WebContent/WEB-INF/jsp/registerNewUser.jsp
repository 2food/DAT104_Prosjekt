<%@ page
	import="static no.hib.dat104.project.controller.UrlMappings.NEWUSERURL"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>lag-ny-bruker</title>
</head>
<body>
	<h2>Opprett ny bruker</h2>
	<form action="<%=NEWUSERURL%>" method="post">
		<fieldset>
			<legend>Registreringsskjema</legend>
			<p>
				Brukernavn: <input type="text" name="username" value="${registrerInfo.username}" />
			</p>
			${registrerInfo.validUsername ? "" :"<p><font color='red'>Ugyldig brukernavn. Må være 3-20 karakterer.</font></p>"}
			${registrerInfo.usernameExists ? "<p><font color='red'>Brukernavn allerede i bruk.</font></p>" :""}
			<p>
				Passord: <input type="password" name="userpassword" />
			</p>
			${registrerInfo.passwordsMatches ? "" : "<p><font color='red'>Passord må være like.</font></p>"  }
			<p>
				Gjenta passord: <input type="password" name="userpassword2" />
			</p>
			<p>
				<input type="submit" value="Registrer" />
			</p>
		</fieldset>
	</form>
</body>
</html>