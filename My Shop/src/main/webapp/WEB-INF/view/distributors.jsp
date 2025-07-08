<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>www.myshop.com</title>
</head>
<body>
	<h3>My Shop</h3>
	<h4>Distributors</h4>
	<a href="addDistributorController" method="get">+ Add Distributor</a>
	<table>

		<tr>
			<th> Id</th>
			<th> Name</th>
			<th> Mobile</th>
			<th> Email</th>
			<th>Edit</th>
			
		</tr>

		<%
		if ((ResultSet)request.getAttribute("distributor") != null) {

			ResultSet result = (ResultSet) request.getAttribute("distributor");
			while (result.next()) {
		%>

		<tr>
			<td><%=result.getInt("distributorId")%></td>
			<td><%=result.getString("name")%></td>
			<td><%=result.getString("mobile")%></td>
			<td><%=result.getString("email")%></td>
			<td><a href="editDistributorController?distributorId=<%=result.getString("distributorId")%>">Edit</a></td>
		</tr>


		<%
		}
		}
		%>

	</table>


	<a href="HomeController" method="get">Home</a>
</body>
</html>