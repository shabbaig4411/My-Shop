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
		<table>

			<tr>
				<td><a href="distributorsController" method="get">Distributors</a>
				</td>
				<td><a href="accountsController" method="get">Accounts</a>
				</td>
				<td><a href="HomeController" method="get">Home</a>
				</td>
				<td><a href="veiwController" method="get">Veiw</a>
				</td>
				<td><a href="customersController" method="get">Customers</a></td>
			</tr>

		</table>

	</form>
</body>
</html>