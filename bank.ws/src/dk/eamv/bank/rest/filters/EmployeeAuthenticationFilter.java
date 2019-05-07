package dk.eamv.bank.rest.filters;

public class EmployeeAuthenticationFilter extends RestAuthenticationFilter{

	@Override
	protected String allowedRole() {
		return "employee";
	}
}