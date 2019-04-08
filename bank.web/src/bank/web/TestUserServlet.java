package bank.web;

import java.io.IOException;
import java.util.Arrays;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dk.eamv.bank.domain.Role;
import dk.eamv.bank.domain.User;
import dk.eamv.bank.ejb.Admin;

/**
 * Servlet implementation class TestUserServlet
 */
@WebServlet("/TestUser")
public class TestUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private Admin admin;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		if (request.getParameter("test").equalsIgnoreCase("1")) {
			Role role1 = new Role(0, "Role1");
			Role role2 = new Role(0, "Role2");
			role1 = admin.createRole(role1);
			role2 = admin.createRole(role2);
			User user1 = new User("userid1", "User1", "1", Arrays.asList(role1));
			user1 = admin.createUser(user1);
			User user2 = new User("userid2", "User2", "2", Arrays.asList(role1, role2));
			user2 = admin.createUser(user2);
		}
		if (request.getParameter("test").equalsIgnoreCase("2")) {
			User user1 = admin.getUser("userid1").get();
			admin.deleteUser(user1.getUserId());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
