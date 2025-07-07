<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>www.myshop.com</title>
</head>
<body>
	<h3>My Shop</h3>
	<h4>Veiw Customer</h4>
	<form action="veiwController" method="post">
		<table>
			<th>Search Customer</th>
			<tr>
				<td><input type="text" name="name" required /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Search" /></td>
			</tr>

		</table>
	</form>
	<p>
		<a href="HomeController" method="get">Home</a>
	</p>

</body>
</html>