/*
 * StAuth10066: I Chao Zhang, 000306946 certify that this material is my original work. 
 * No other person's work has been used without due acknowledgement. 
 * I have not made my work available to anyone else.
 */
package com.mohawkcollege.cz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Danny
 */
public class RestrictFilter implements Filter {

	FilterConfig fc;
	ArrayList<String> urlList;
	String defaultlogin;

	public void init(FilterConfig filterConfig) throws ServletException {
		fc = filterConfig;
		String urls = fc.getInitParameter("avoid-urls");
		StringTokenizer token = new StringTokenizer(urls, ",");
		defaultlogin = fc.getInitParameter("defaultlogin");
		urlList = new ArrayList<String>();

		while (token.hasMoreTokens()) {
			urlList.add(token.nextToken());
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);

		// Skip JSF resources (CSS/JS/Images/etc) - see 
		if (!req.getRequestURI().startsWith(req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER)) {
			resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
			resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
			resp.setDateHeader("Expires", 0); // Proxies.
		}

		String requestedURL = new String(req.getRequestURI());

		boolean allowRequest = false;
		Login log = new Login();

		for (String url : urlList) {
			String pattern = ".*" + url;
			if (requestedURL.matches(pattern)) {
				allowRequest = true;
			}
		}

		String redirectPage = null;
		if (!allowRequest) {
      
			// Page requested that needs to be verfied further
			if (session == null) {
				redirectPage = defaultlogin;
			} 
        else {
            log = (Login) session.getAttribute("loginBean");
            
            //user is not logged in
            if (!log.isLoggedIn()) {
                redirectPage = "/FinalProject/faces/noaccess.xhtml";
            }
            //user logged in that is not admin
            else if (log.isLoggedIn() && !log.getUserName().equals("admin") && requestedURL.equals("/FinalProject/faces/admin.xhtml")) {
                redirectPage = "/FinalProject/faces/noaccess.xhtml";
            }
        }
		}
		if (redirectPage != null) {
			resp.sendRedirect(redirectPage);
		}
		else {
			chain.doFilter(request, response);
		}
	}
	public void destroy() {}
}