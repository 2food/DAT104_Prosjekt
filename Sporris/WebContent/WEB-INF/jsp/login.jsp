<%@ page
	import="static no.hib.dat104.project.controller.UrlMappings.LOGINURL"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>login</h2>
	<form action="<%=LOGINURL%>" method="post">
		<fieldset>
			<legend>Login</legend>
			<p>
				Brukernavn <input type="text" name="username"
					value="${login.username}">
					<span id="wrongUsername">${login.validUsername ? " " : "<font color='red'>Brukernavn er ikke registrert.</font>" }</span>
			</p>
			
			<p>
				Passord: <input type="password" name="password"
					value="${login.password}" />
					<span id="wrongPassword">${login.validUsername && !login.validPassword ? "<font color='red'>Passord passer ikke til brukernavn.</font>" : " " }</span>
			</p>
			
			<p>
				<input type="submit" value="Login" />
			</p>
		</fieldset>
	</form>
	<a href="index.html">Tilbake til forsiden</a>
</body>
</html>