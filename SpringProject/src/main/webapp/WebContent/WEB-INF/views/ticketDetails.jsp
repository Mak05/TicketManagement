<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ticket Management Screen</title>
<style type="text/css">
              body {
                     font-family: verdana;
                     font-size: 12px;
                     margin: 40px;
              }
              td {
                     border-collapse: collapse;
                     margin: 2px;
                     padding: 2px 2px 2px 10px;
                     font-size: 12px;
              }
              th {
                     font-weight: bold;
                     font-size: 12px;
                     background-color: #5C82FF;
                     color: white;
              }
              a, a:AFTER {
                     color: blue;
              }
</style>
</head>
<body>
	<div align="center">
		<h1>Hi GateKeeper</h1>
		<br/>
		<h2>Ticket List</h2>
		<table border="1">

			<th>Ticket Id</th>
			<th>Ticket Details</th>
			<th>Ticket Status</th>
			<th>Assignee Id</th>

			<c:forEach var="ticket" items="${listTickets}">
				<tr>					
					<td><a href ="/TicketManagement/getTicketToAssign?ticketId=${ticket.ticketId}">${ticket.ticketId}</a></td>
					<td>${ticket.ticketDesc}</td>
					<td>${ticket.ticketStatus}</td>
					<td>${ticket.assigneeId}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>