<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>www.myshop.com</title>
</head>
<body>
	<h2>Welcome to My Shop</h2>
	<form action="LoginController" method="post" >

		<table>
			<tr>
				<th colspan="2">Login</th>
			</tr>

			<tr>
				<td>Mobile/Email</td>
				<td><input type="text" name="mobile_email"
					placeholder="exmp@gmail.com/9876" required /></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><input type="password" name="password"
					placeholder="password" required /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="login" /></td>

			</tr>
		</table>
		
		<%
		if (request.getAttribute("error") != null) {
			out.print((String)request.getAttribute("error"));
		}
		%>
		<p>
			<a href="SignIn.jsp"> New User? </a>
		</p>
	</form>
</body>
</html>