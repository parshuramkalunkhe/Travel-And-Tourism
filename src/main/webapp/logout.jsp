<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    // Get the session
    session = request.getSession(false);
    
    // Invalidate the session if it exists
    if (session != null) {
        session.invalidate();
    }
    
    // Redirect to the login page or any other appropriate page
    response.sendRedirect("login.html");
%>