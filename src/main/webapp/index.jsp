<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Travel And Tourism</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>

	<%@ include file="components/banner.jsp" %>
	<%@ include file="components/header.html"%>
	
	<main>
		<div id="main_index" style="
    height: 100vh;
    background: url('assets/bg.jpg');
    background-attachment: fixed;
    background-repeat: no-repeat;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
">
			<h2 style="font-size: 2rem; margin: 1rem;">Welcome to Travel And Tourism.</h2>
			<form action="SearchServlet" method="post" style="margin-top: 2rem;">
			    <input type="search" name="query" placeholder="Search by location" style="padding: 0.5rem; font-size: 1rem;">
			    <button type="submit" style="padding: 0.5rem 1rem; font-size: 1rem; background-color: #007bff; color: #fff; border: none; cursor: pointer;">Search</button>
			</form>
		</div>		
		
		<div>
		
		</div>
	</main>
	
	<%@ include file="components/footer.html"%>
</body>
</html>