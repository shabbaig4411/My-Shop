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
	<form action="SignInController" method="post">

		<table>
			<tr>
				<th colspan="2">Create New Account</th>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" placeholder="Ex: Full Name"
					required /></td>
			</tr>
			<tr>
				<td>Mobile</td>
				<td><input type="text" name="mobile" placeholder="9876543210"
					required /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"
					placeholder="example@gmail.com" required /></td>
			</tr>


			<tr>
				<td>Password</td>
				<td><input type="password" name="password"
					placeholder="password" required /></td>
			</tr>
			<tr>
				<td>Re-Enter Password</td>
				<td><input type="password" name="password1"
					placeholder="Re-Enter Password" required /></td>

			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Create Account" /></td>

			</tr>
		</table>
		<a href="index.jsp"> Login </a>
		<%
		if (request.getAttribute("msg") != null) {
			out.print((String) request.getAttribute("msg"));
		}
		%>
		<%
		if (request.getAttribute("result") != null) {
			out.print((String) request.getAttribute("result"));
		}
		%>

	</form>
</body>
</html>