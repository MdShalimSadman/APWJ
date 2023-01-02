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
    <title>Update</title>





</head>


<body>


<div style="background-color:#32323b;">
    <center><h1 style="color:white;">Update an user</h1></center>
</div>
<center>
    <div>
        <form method="POST" action="updateuserByAdmin"  modelAttribute="user" >
            <table>
                <tr>
                    <td><label for="Prev-name">Previous Name </label></td>
                    <td> <input type="text" name="Prev-name" id="Prev-name"> </td>
                </tr>
                <tr>
                    <td><label for="Prev-email">Previous Email </label></td>
                    <td> <input type="text" name="Prev-email" id="Prev-email"> </td>
                </tr>
                <tr>
                    <td><label for="New-name">New name </label></td>
                    <td> <input type="text" name="New-name" id="New-name"> </td>
                </tr>
                <tr>
                    <td><label for="New-email">New email</label></td>
                    <td> <input type="text" name="New-email" id="New-email"> </td>
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