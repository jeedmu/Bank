package dk.eamv.bank.rest;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RestAuthenticationFilter implements javax.servlet.Filter {
	public static final String AUTHENTICATION_HEADER = "Authorization";

	//protected abstract String getRole();
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filter) throws IOException, ServletException {
		if (request instanceof HttpServletRequest) {
			
		
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
			String userid = httpServletRequest.getHeader("userid");
			String password = httpServletRequest.getHeader("password");
		/*	
			boolean authenticationStatus = false;
			
			if(userid!= null && password!=null)
				authenticationStatus=true;
			*/	
			//if (authenticationStatus) {
			try {
			httpServletRequest.login(userid, password);
			}catch(Exception e) {}
			
			if (httpServletRequest.isUserInRole("employee")) {
				filter.doFilter(request, response);
			} else {
				if (response instanceof HttpServletResponse) {
					HttpServletResponse httpServletResponse = (HttpServletResponse) response;
					httpServletResponse
							.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				}
			}
		}
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}