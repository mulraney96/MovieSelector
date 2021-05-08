<%--
  Created by IntelliJ IDEA.
  User: joemu
  Date: 19/04/2021
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><%= "Sign up or login you cunts" %>
</h1>
<form method="POST" action="/MovieSelector/LoginServlet" name="myform" >
    <p>Email</p>
    <input type="text" name="email" placeholder="Enter Email"/>
    <p>Password</p>
    <input type="password" name="password" placeholder="Enter Password"/>
    <input type="submit" name="" value="Login"/>
    <a href="passwordRecovery.html">Forgot your Password?</a><br>
    <a href="register.jsp">Need to Register an Account?</a>
</form>
</body>
</html>
