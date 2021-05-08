<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Sign up or login you cunts" %>
</h1>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<form method="POST" action="LoginServlet" name="myform" >
    <p>Email</p>
    <input type="text" name="email" placeholder="Enter Email"/>
    <p>Password</p>
    <input type="password" name="password" placeholder="Enter Password"/>
    <input type="submit" name="" value="Login"/>
    <a href="passwordRecovery.html">Forgot your Password?</a><br>
    <a href="register.jsp">Need to Register an Account?</a>
</form>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>