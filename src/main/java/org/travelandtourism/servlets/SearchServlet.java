package org.travelandtourism.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.travelandtourism.dao.AccommodationDAO;
import org.travelandtourism.model.Accommodation;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/SearchServlet")
public class SearchServlet extends HttpServlet {
	@Override
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Get the search query from the request parameter
	        String location = request.getParameter("query");
	        System.out.println(location);
	        // Initialize the DAO
	        AccommodationDAO accommodationDAO = new AccommodationDAO();
	        
	        try {
	            // Search accommodations based on location
	            List<Accommodation> accommodations = accommodationDAO.searchAccommodationsByLocation(location);
	            
	            // Set the search results as an attribute in the request
	            request.setAttribute("accommodations", accommodations);
	            
	            // Forward the request to the search results JSP page
	            request.getRequestDispatcher("searchacc.jsp").forward(request, response);
	        } catch (Exception e) {
	            e.printStackTrace();
	            // Handle exceptions
	        }
	    }
}
