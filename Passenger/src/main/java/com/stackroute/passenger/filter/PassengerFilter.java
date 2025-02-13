package com.stackroute.passenger.filter;

import java.io.IOException;

import org.springframework.http.HttpMethod;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.GenericFilter;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class PassengerFilter extends GenericFilter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpreq=(HttpServletRequest) request;
		HttpServletResponse httpres=(HttpServletResponse) response;
		
		
		httpres.setHeader("Access-Control-Allow-Origin", "*");
		httpres.setHeader("Access-Control-Allow-Credentials", "*");
		httpres.setHeader("Access-Control-Allow-Headers", "*");
		httpres.setHeader("Access-Control-Allow-Methods", "POST,GET,DELETE,PUT");
		
	//to handle preflight request, when client side scrit based applications are accesing api using browser	
		if(httpreq.getMethod().equals(HttpMethod.OPTIONS.name()))
		{
			chain.doFilter(httpreq, httpres);
		}
		else
		{
		
		
		
		try
		{

			String headerinfo=httpreq.getHeader("Authorization");
			System.out.println("headerinfo" + headerinfo);
		
			if (headerinfo==null || headerinfo.isBlank() || headerinfo.isEmpty())
				throw new ServletException("Token is null or empty");
			

			String token=headerinfo.substring(7);
	JwtParser jwtparser=	Jwts.parser().setSigningKey("ctsjuly");
		
	Jwt jwtobj=		jwtparser.parse(token);
	Claims myclaims=	(Claims)		jwtobj.getBody();
	System.out.println("claim " + myclaims.getSubject());
	String username=myclaims.get("username").toString();
	HttpSession session=httpreq.getSession();
	session.setAttribute("uname", username);
	session.setAttribute("emailid",myclaims.getSubject());
	
		}
		catch(SignatureException obn)
		{
			throw new ServletException("Invalid token");
		}
		catch(MalformedJwtException excep)
		{
			throw new ServletException("Someone illegally modifed");
			
		}
		catch(Exception e)
		{
			throw new ServletException("exception occured " + e.getMessage());
		}
	
		chain.doFilter(httpreq, httpres);
		}
	}

}
