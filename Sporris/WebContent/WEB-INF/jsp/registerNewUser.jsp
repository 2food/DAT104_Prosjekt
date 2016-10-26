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
				Brukernavn: <input type="text" name="username" />
			</p>
			<p>
				Passord: <input type="password" name="userpassword" />
			</p>
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