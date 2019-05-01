package test;

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
@WebServlet("admin/TestUser")
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
			User user1 = new User.Builder("userid1").setName("User1").setPassword("1").setRoles(Arrays.asList(role1)).build();
			user1 = admin.createUser(user1);
			User user2 = new User.Builder("userid2").setName("User2").setPassword("2").setRoles(Arrays.asList(role1,role2)).build();
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
