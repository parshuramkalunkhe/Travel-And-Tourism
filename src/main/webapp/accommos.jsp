<%@page import="java.util.List"%>
<%@page import="org.travelandtourism.model.Accommodation"%>
<%@page import="org.travelandtourism.dao.AccommodationDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accommodations List</title>
<link rel="stylesheet" href="css/styles.css">
<style>
/* Internal CSS */
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid #ddd;
	padding: 10px;
}

th {
	background-color: #f2f2f2;
}
</style>
</head>
<body>
	<%
	boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
	if (isAdmin) {
	%>
	<%@ include file="components/menu.html"%>
	<div style="margin-top: 20px;">
		<h1>Accommodations List</h1>
		<table border="1">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Location</th>
					<th>Description</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<%
				// Get all accommodations from the database
				AccommodationDAO accommodationDAO = new AccommodationDAO();
				List<Accommodation> accommodationList = accommodationDAO.getAllAccommodations();

				// Loop through the list of accommodations and display them in the table
				for (Accommodation accommodation : accommodationList) {
				%>
				<tr>
					<td><%=accommodation.getId()%></td>
					<td><%=accommodation.getTitle()%></td>
					<td><%=accommodation.getLocation()%></td>
					<td><%=accommodation.getDesc()%></td>
					<td><%=accommodation.getPrice()%> ₹</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
	<%
	} else {
	response.sendRedirect("login.html");
	}
	%>
</body>
</html>
