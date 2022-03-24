package org.diembo.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers", "X-Requested-With,Origin,Content-Type, Accept, authorization,"
				+ "Access-Control-Request-Method");
		response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials,"
				+ "authorization");
		
		if ( "OPTIONS".equals(request.getMethod())) {
		    // CORS "pre-flight" request
		    response.setStatus(HttpServletResponse.SC_OK);
		}
//		if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
//			    // CORS "pre-flight" request
//			    response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
//			    response.addHeader("Access-Control-Allow-Headers", "X-Requested-With,Origin,Content-Type, Accept, Authorization");
//			  }
		  filterChain.doFilter(request, response);
	}

	

}
