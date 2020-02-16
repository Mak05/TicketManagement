<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form"%>
<html>

<head>
<title>Create a Ticket</title>

</head>
<body onload='document.loginForm.j_username.focus();'>
	<h3>Create a Ticket</h3>
	<c:form action="addTicket" method='POST' modelAttribute="ticket">

		<table>
			<tr>
				<td>Ticket Number : </td>
				<td><input type='text' name='ticketId' value=''></td>
			</tr>
			<tr>
				<td>Ticket Description : </td>
				<td><input type='text' name='ticketDesc' /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="Add Ticket" /></td>
			</tr>
		</table>
		<br/>
		<a href = "/SpringProject/logout">Logout</a>
	</c:form>
</body>
</html>