<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Us</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<%@ include file="components/banner.jsp" %>
	<%@ include file="components/header.html" %> 
	
    <h1 class="contactus">Contact Us</h1>

    <div class="cocontainer">
        <form action="contactus" method="post">
            <label for="name">Name</label><br>
            <input type="text" id="name" name="name" required><br>
            <label for="email">Email</label><br>
            <input type="text" id="email" name="email" required><br>
            <label for="message">Message</label><br>
            <textarea id="message" name="message" rows="6" required></textarea><br>
            <input type="submit" value="submit">
        </form>
        <br>
        <hr>
         <div class="social-media">
            <a href="" target="_parent">@facebook</a>
            <a href="" target="_parent">@twitter</a>
            <a href="" target="_parent">@instagram</a>
            <a href="" target="_parent">@linkedin</a>
        </div>
    </div>
    <%@ include file="components/footer.html" %> 
</body>
</html>