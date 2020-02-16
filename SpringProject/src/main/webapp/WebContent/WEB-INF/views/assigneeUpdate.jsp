<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ticket Details</title>
</head>
<body>
	<div align="center">
		<h1>Ticket Details</h1>
		<c:set var="ticket" value="${tickets}"></c:set>
		<div>					
			<div>Ticket Description: ${ticket.ticketDesc}</div>
			<div>Ticket Status: ${ticket.ticketStatus}</div>
		</div>
		<br/><br/>
		<form action="updateAssignee">
		    Assign the ticket:
		    <input type="text" value="${ticket.ticketId}" name="ticketId">
		    <select name="assigneeId">
	            <option value=101>mak</option>
	            <option value=102>siv</option>
		    </select>
		    <br/><br/>
		    <input type="submit" value="Submit" />
		</form>
	</div>
</body>
</html>
