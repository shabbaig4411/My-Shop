<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to My Shop</title>
</head>
<body>
	<form action="editDistributorController" method="post">
		<table>
			<%
			if ((ResultSet) request.getAttribute("result") != null) {

				ResultSet result = (ResultSet) request.getAttribute("result");
				while (result.next()) {
					
					
			%>
			<tr>
				<td><input type="text" value ="<%=result.getString("distributorId")%>" readonly /></td>
				<td><input type="text" name="name"
					placeholder="<%=result.getString("name")%>" required /></td>
				<td><input type="text" name="mobile"
					placeholder="<%=result.getString("mobile")%>" required /></td>
				<td><input type="text" name="email"
					placeholder="<%=result.getString("email")%>" required /></td>
			</tr>
			<%
			}
			}
			%>
			<tr>
				<td colspan="2"><input type="submit" value="Update"></td>
			</tr>
		</table>
	</form>
	<a href="distributorsController">Back</a>
</body>
</html>