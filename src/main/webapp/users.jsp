<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="org.travelandtourism.model.User"%>
<%@ page import="org.travelandtourism.dao.UserDAO"%>

<%
boolean admin = (Boolean) session.getAttribute("isAdmin");
if (admin) {
%>

<div>
	<h1>User List</h1>
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Contact</th>
				<th>Email</th>
			</tr>
		</thead>
		<tbody>
			<%
			// Get all users from the database
			UserDAO userDao = new UserDAO();
			List<User> userList = userDao.getAllUsers();

			// Loop through the list of users and display them in the table
			for (User user : userList) {
			%>
			<tr>
				<td><%=user.getId()%></td>
				<td><%=user.getUsername()%></td>
				<td><%=user.getContact() %></td>
				<td><%=user.getEmail()%></td>
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