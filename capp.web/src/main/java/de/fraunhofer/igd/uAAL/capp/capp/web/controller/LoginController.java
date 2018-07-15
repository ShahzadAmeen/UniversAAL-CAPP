package de.fraunhofer.igd.uAAL.capp.capp.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.fraunhofer.igd.uAAL.capp.capp.web.identifiers.StringIdentifiers;
import de.fraunhofer.igd.uAAL.capp.capp.web.model.User;
import de.fraunhofer.igd.uAAL.capp.capp.web.util.UserAuthenticator;

@WebServlet(urlPatterns = { "/Login" })
public class LoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User userBean = new User();
		// Initialize the user beans username and password
		userBean.setUserName(req.getParameter("username"));
		userBean.setPassword(req.getParameter("password"));

		UserAuthenticator usr = new UserAuthenticator();

		// Authenticate and return a User Bean with list of apartments it can
		// access
		// Returns null if user is not authenticated to access any apartment
		// UserBean would consist of roles

		User authenticatedUser = usr.authenticate(userBean);

		// called if unsuccessful
		//if(authenticatedUser.getRole().equals(null)
		// resp.sendRedirect("index.html");

		HttpSession session = req.getSession();
		session.setAttribute("Username", req.getParameter("username"));
		session.setMaxInactiveInterval(30);
		session.setAttribute("Apartment(s)", authenticatedUser.getApartments());

		// Called if user is Tenant User role
		//if(authenticatedUser.getRole().equals(StringIdentifiers.TENANT_USER))
		resp.sendRedirect("overviewApartment.html");

		// Called if user is administrator
		//if(authenticatedUser.getRole().equals(StringIdentifiers.ADMINISTRATOR))
		//resp.sendRedirect("overviewApartments.html");

	}
}