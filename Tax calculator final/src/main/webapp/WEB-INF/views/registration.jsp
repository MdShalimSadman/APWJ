<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 27/12/2022
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>


        <title>Profile</title>



</head>


<body>


<div style="background-color:#32323b;">
    <center><h1 style="color:white;">Create your Account <br>আপনার একাউন্ট তৈরী করুন</h1></center>
</div>
<center>
    <div>
        <form method="POST" action="createuser" modelAttribute="user">
            <table>
                <tr>
                    <td><label for="name">Full Name (পুরো নাম)</label></td>
                    <td> <input type="text" name="name" id="name"> </td>
                </tr>
                <tr>
                    <td><label for="email">Email (ইমেইল)</label></td>
                    <td> <input type="text" name="email" id="email"> </td>
                </tr>
                <tr>
                    <td><label for="username">Username <p style="color:#9f9898;font-size:12px">(ex:sadman31)</p> </label></td>
                    <td> <input type="text" name="username" id="username"> </td>
                </tr>
                <tr>
                    <td><label for="password">Password (পাসওয়ার্ড) </label></td>
                    <td> <input type="text" name="password" id="password"> </td>
                </tr>


                <tr>
                    <td colspan = "2" align="center"> <input type="submit" value="Registration" id="Registration" align="center"> </td>
                </tr>
            </table>
        </form>
    </div>
<br>
</center>


<br><br><br>

</body>
</html>
<%
    request.setAttribute("send", "email");
%>