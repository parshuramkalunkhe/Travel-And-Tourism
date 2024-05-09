<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Accommodation</title>
<link rel="stylesheet" href="css/styles.css">
<style type="text/css">
	main div {
		width: 500px;
		box-shadow: 1px 4px solid black;
		border: 1px solid black;
		border-radius: 10px;
		padding: 10px;
		margin: auto;
	}
</style>
</head>
<body>

	<%
	boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
	if (isAdmin) {
	%>
	<%@ include file="components/menu.html"%>
	<main>
		<div style="margin-top: 20px;">
			<h1>Add New Accommodation</h1>
			<form action="AddAccommodation" method="post">
				<label for="title">Title:</label><br> 
				<input type="text" id="title" name="title" required><br> 
				<label for="location">Location:</label><br> 
				<input type="text" id="location" name="location" required><br> 
				<label for="description">Description:</label><br>
				<textarea id="description" name="description" rows="4" required></textarea> <br> 
				<label for="price">Price:</label><br> 
				<input type="number" id="price" name="price" required><br> 
				<label for="imgUrl">Image URL:</label><br> 
				<input type="text" id="imgUrl" name="imgUrl" required><br>

				<button type="submit">Add Accommodation</button>
			</form>
		</div>
	</main>


	<%
	} else {
	response.sendRedirect("login.html");
	}
	%>

</body>
</html>
