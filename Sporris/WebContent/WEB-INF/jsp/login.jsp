<%@ page import="static no.hib.dat104.project.controller.UrlMappings.LOGINURL"%>
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
<form action="<%=LOGINURL%>" method = "post">
  <fieldset>
    <legend>Login</legend>
    <p>Brukernavn <input type = "text" name = "username" value="${logininfo.username}"></p>
    ${logininfo.validUsername ? " " : "<p><font color='red'>Ugyldig brukernavn. Må være 3-20 karakterer.</font></p>" }
    <p>Passord: <input type="password" name="password" value="${logininfo.password}" /></p>
    ${logininfo.validPassword ? " " : "<p><font color='red'>Ugyldig passord. Må være 8 eller flere karakterer.</font></p>" }
    <p><input type="submit" value="Login" /></p>
  </fieldset>
</form>
</body>
</html>