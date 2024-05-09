<%@page import="org.travelandtourism.model.Accommodation"%>
<%@page import="org.travelandtourism.dao.AccommodationDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
AccommodationDAO dao = new AccommodationDAO();
List<Accommodation> accommodations = dao.getAllAccommodations();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accommodation</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<style>
main {
	padding: 20px;
	width: 900px;
	margin: auto;
}

.accommodation {
	display: flex;
	margin-bottom: 20px;
}

.image {
	flex: 1;
	margin-right: 20px;
}

.image img {
	width: 100%;
	height: auto;
}

.details {
	flex: 2;
}

.details h2 {
	margin-top: 0;
}

.location, .description, .price {
	margin-top: 5px;
}

button {
	background-color: #007bff;
	color: #fff;
	border: none;
	padding: 10px 20px;
	cursor: pointer;
}
</style>
<body>
	<%@ include file="components/banner.jsp"%>
	<%@ include file="components/header.html"%>
	<main>
		<%
		for (Accommodation accommodation : accommodations) {
		%>
		<section class="accommodation">
			<div class="image">
				<img src="<%=accommodation.getImgUrl()%>" alt="Accommodation Image">
			</div>
			<div class="details">
				<h2><%=accommodation.getTitle()%></h2>
				<p class="location"> Location: <%=accommodation.getLocation()%></p>
				<p class="description"><%=accommodation.getDesc()%></p>
				<p class="price">
					Price: <%=accommodation.getPrice()%> ₹.
				</p>
				<!-- Add form with hidden input field -->
				<form action="billing.jsp" method="post">
					<input type="hidden" name="accommodationId"	value="<%=accommodation.getId()%>">
					<button type="submit">Book Now</button>
				</form>
			</div>
		</section>
		<%
		}
		%>
	</main>
	<%@ include file="components/footer.html"%>
</body>
</html>