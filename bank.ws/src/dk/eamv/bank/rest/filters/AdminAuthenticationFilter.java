package dk.eamv.bank.rest.filters;

public class AdminAuthenticationFilter extends RestAuthenticationFilter{

	@Override
	protected String allowedRole() {
		return "admin";
	}
}