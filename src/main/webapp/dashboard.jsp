<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet" href="css/styles.css">
<style type="text/css">
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
	<div class="registration">
		<marquee behavior="scroll" direction="left" scrollamount="5">
			Admin Dashboard </marquee>
		<a href="logout.jsp">Logout</a>
	</div>
	<%@ include file="components/menu.html"%>
	<main>
		<h1>Welcome to Admin Dashboard</h1>
		<%@ include file="users.jsp"%>
	</main>


	<%
	} else {
	response.sendRedirect("login.html");
	}
	%>
</body>
</html>