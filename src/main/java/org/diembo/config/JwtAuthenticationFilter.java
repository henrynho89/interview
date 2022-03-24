package org.diembo.config;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.diembo.entities.Person;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private AuthenticationManager authenticationManager;
	public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager= authenticationManager;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		Person person = null;
		
		try {
			person = new ObjectMapper().readValue(request.getInputStream(), Person.class);
		} catch (StreamReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(person.getLogin(),person.getPassword()));
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		User springUser = (User)authResult.getPrincipal();
		
		String jwtToken = Jwts.builder()
				.setSubject(springUser.getUsername())
		        .setIssuer("mycompany")
		        .setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
		        .claim("roles", springUser.getAuthorities())
		        .signWith(SignatureAlgorithm.HS512,SecurityConstants.SECRET)
		        .compact();
		
		response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX+jwtToken);
	}
	
//	@Override
//	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
//	        AuthenticationException failed) throws IOException, ServletException {
//	    logger.debug("failed authentication while attempting to access "
//	            + urlPathHelper.getPathWithinApplication((HttpServletRequest) request));
//
//	    //Add more descriptive message
//	    response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
//	            "Authentication Failed");
//	}

}
