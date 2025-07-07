<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>www.myshop.com</title>
</head>
<body>

	<form action="addDistributorController" method="post">
		<table>
			<tr>
				<td>Name <input type="text" name="name" required /> <br>Distributor's
					Name cannot be same as other Distributor's Name.
				</td>
			</tr>
			<tr>
				<td>Mobile <input type="text" name="mobile" required /> <br>
					
				</td>
			</tr>
			<tr>
				<td>Email <input type="text" name="email" required /> <br>
					
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add"></td>
			</tr>
		</table>
	</form>
	
	<a href="distributorsController" method="get">Back</a>
	
	
<%
if(request.getAttribute("error")!=null){
	out.print((String)request.getAttribute("error"));
}
%>
</body>
</html>