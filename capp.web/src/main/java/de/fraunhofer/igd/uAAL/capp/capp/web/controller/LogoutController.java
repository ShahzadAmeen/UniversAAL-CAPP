package de.fraunhofer.igd.uAAL.capp.capp.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.fraunhofer.igd.uAAL.capp.capp.web.model.User;
import de.fraunhofer.igd.uAAL.capp.capp.web.util.UserAuthenticator;

@WebServlet(urlPatterns = { "/Logout" })
public class LogoutController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Fetching the session
		HttpSession session = req.getSession(false);

		// invalidateSession

		// If session is not null
		if (session != null) {
			session.invalidate(); // removes all session attributes bound to the
									// session
			req.setAttribute("Logout Message", "You have logged out successfully");

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.html");
			requestDispatcher.forward(req, resp);

		}
	}
}
