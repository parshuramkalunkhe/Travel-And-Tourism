<%@page import="org.travelandtourism.model.User"%>
<%@page import="org.travelandtourism.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="org.travelandtourism.model.Accommodation"%>
<%@ page import="org.travelandtourism.dao.AccommodationDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Billing</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<style>
/* Billing Details */
.billing-details {
    margin-top: 20px;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    background-color: #f9f9f9;
}

.billing-details h2 {
    font-size: 1.5rem;
    margin-bottom: 10px;
}

.billing-details p {
    margin: 5px 0;
}

/* Billing Form */
.billing-form {
    margin-top: 20px;
}

.billing-form input[type="text"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

.billing-form button {
    background-color: #007bff;
    color: #fff;
    border: none;
    padding: 10px 20px;
    cursor: pointer;
    border-radius: 5px;
}

.billing-form button:hover {
    background-color: #0056b3;
}

</style>
<body>

	<%
	Boolean isLogin = (Boolean) session.getAttribute("isLogin");
	if (isLogin != null && isLogin) {
	%>
    

    <main>
        <h1>Billing Details</h1>
        <% 
            // Retrieve accommodation ID from request parameter
            int accommodationId = Integer.parseInt(request.getParameter("accommodationId"));
            String email = (String)session.getAttribute("email");
            // Get accommodation details based on ID
            AccommodationDAO dao = new AccommodationDAO();
            Accommodation accommodation = dao.getAccommodationById(accommodationId);
      
        %>
        <section class="billing-details">
            <h2>Selected Accommodation:</h2>
            <p>Title: <%= accommodation.getTitle() %></p>
            <p>Location: <%= accommodation.getLocation() %></p>
            <p>Description: <%= accommodation.getDesc() %></p>
            <p>Price: <%= accommodation.getPrice() %> ₹</p>

            <form action="BillingServlet" method="post">
				<input type="hidden" name="email" value="<%= email %>">
                <input type="hidden" name="accommodationId" value="<%= accommodationId %>">
                <input type="hidden" name="price" value="<%= accommodation.getPrice() %>">
                <input type="text" name="upi" placeholder="enter upi id" required>
                <button type="submit">Proceed to Payment</button>
            </form>
        </section>
    </main>
    <%
	} else {
	response.sendRedirect("login.html");
	}
	%>
</body>
</html>
