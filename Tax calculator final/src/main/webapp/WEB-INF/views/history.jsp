<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 27/12/2022
  Time: 6:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Tax History</title>
</head>




<body>

<div>

  <br><br><br><br><br><br><br><br>
  <table>
    <tr>
      <td> Total Ammount : </td>
      <td>Taka, ${total}</td>
    </tr>
    <tr>
      <td> Tax payable Ammount : </td>
      <td>Taka, ${taxpayble}</td>
    </tr>
    <tr>
      <td> Tax Ammount : </td>
      <td>Taka, ${tax}</td>
    </tr>
    <tr>
      <td> Maximum Investment Ammount : </td>
      <td>Taka, ${maxinvest}</td>
    </tr>
    <tr>
      <td> Rebate Ammount : </td>
      <td>Taka, ${rebate}</td>
    </tr>
    <tr>
      <td> Yearly Payable Tax Ammount : </td>
      <td>Taka, ${nettax}</td>
    </tr>
    <tr>
      <td> Monthly Payable Tax Ammount : </td>
      <td>Taka, ${mnettax}</td>
    </tr>

  </table>
</div>


</body>
</html>
