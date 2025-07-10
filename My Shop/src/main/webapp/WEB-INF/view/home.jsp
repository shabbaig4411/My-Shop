<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>www.myshop.com</title>
</head>
<body>
	<form action="HomeController" method="post">
		<h1>Hello Welcome to your SHOP....</h1>
		<h4>
			<a href="logOutController">Logout</a>
		</h4>
		<table>

			<tr>
				<td><a href="distributorsController">Distributors</a></td>
				<td><a href="accountsController">Accounts</a></td>
				<td><a href="HomeController">Home</a></td>
				<td><a href="veiwController">Veiw</a></td>
				<td><a href="customersController">Customers</a></td>
			</tr>

		</table>

	</form>
</body>
</html>