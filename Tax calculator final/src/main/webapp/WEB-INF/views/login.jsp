<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 27/12/2022
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body bgcolor="aqua">
    <h1 align="center">Welcome to Vehicle Parts and Service Center</h1>
    <br><br>

    <div align="center">
        <form method="POST" action="userlogin">
            <table align="center">
                <tr>
                    <td> <label for="username"> Username </label> </td>
                    <td> <input type="text" name="username" id="username"> </td>
                </tr>
                <tr></tr><tr></tr><tr></tr>
                <tr>
                    <td> <label for="password"> Password </label> </td>
                    <td> <input type="text" name="password" id="password"> </td>
                </tr>
                <tr></tr><tr></tr><tr></tr>
                <tr>
                    <td colspan = "2" align="center"><input type="submit" value="Login" align="center"></td>
                </tr>
            </table>
        </form>
    </div>

    <a href="http://localhost:8080/spring_webmvc_war_exploded/home/signup">Don't have an account! Signup now</a>

    <br><br><br>
    <a href="http://localhost:8080/spring_webmvc_war_exploded/">Goback</a>

</body>
</html>
