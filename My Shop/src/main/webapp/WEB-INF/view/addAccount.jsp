<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>www.myshop.com</title>
</head>
<body>

	<form action="addAccountController" method="post">
		<table>
			<tr>
				<td>Name <input type="text" name="name" required /> <br>Account's
					Name must be different.
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add"></td>
			</tr>
		</table>
	</form>

</body>
</html>