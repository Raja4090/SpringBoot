<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:cyan">
<h2 style="color:red">${logonerror}</h2>
<form action="login" method="post">

  <p>Username: <input type="text" name="username"> </p>
  <p>Password: <input type="password" name="password"> </p>
  <p> <input type="submit" value="sign in">
</form>

</body>
</html>