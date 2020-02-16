<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success</title>
</head>
<body>
	<div align="center">
		<h1>Resolution has been updated successfully</h1>
		<a href="/SpringProject/getAssignedTickets?id=${tickets.assigneeId}">Change the Ticket Status</a>
		<a href = "/SpringProject/logout">Logout</a>
	</div>
</body>
</html>