<%--
  Created by IntelliJ IDEA.
  User: joemu
  Date: 22/04/2021
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="registerbox">
    <h1>Register an Account here<br>Please fill in the forms below</h1>
    <form method="POST" action="/MovieSelector_war/RegisterServlet" name="registerform">
        <p>First Name:</p>
        <input type="text" name="firstname" placeholder="Enter your first name"/>
        <p>Surname:</p>
        <input type="text" name="surname" placeholder="Enter your Surname"/>
        <p>Email:</p>
        <input type="text" name="email" placeholder="Enter Email"/>
        <p>Password:</p>
        <input type="password" name="password" placeholder="Enter Password"/>
        <br>
        <br>
        <input type="submit" name="submit" value="Login"/>
    </form>
</div>

</body>
</html>
