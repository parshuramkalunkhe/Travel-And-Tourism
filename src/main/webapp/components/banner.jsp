<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="registration">
	<marquee behavior="scroll" direction="left" scrollamount="5">
		Explore breathtaking landscapes and vibrant cultures around the globe.
		Plan your dream vacation with us and create unforgettable memories.
		Embark on thrilling adventures and immerse yourself in new
		experiences. Relax on pristine beaches or trek through majestic
		mountains. Indulge in delicious cuisine and savor the flavors of the
		world. Unwind in luxurious resorts and discover hidden gems off the
		beaten path. 
	</marquee>

	<%
	Boolean isLogin = (Boolean) session.getAttribute("isLogin");
	if (isLogin != null && isLogin) {
	%>
	<!-- User is logged in -->
	<a href="logout.jsp">Logout</a>
	<%
	} else {
	%>
	<!-- User is not logged in -->
	<a href="login.html" target="_parent">Login</a> 
	<a href="signup.html" target="_parent">Signup</a>
	<%
	}
	%>

</div>