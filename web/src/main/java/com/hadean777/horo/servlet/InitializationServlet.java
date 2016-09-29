package com.hadean777.horo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


/**
 * Initialization servlet
 * 
 * @author Created by hadean777 <br>
 * @author Last modified by $Author: hadean777 $ <br>
 * @author Last modified on $Date: 2016-09-28 11:52:33 +0200 (Thu, 28 Sep 2016) $ at revision $Revision:   $ <br>
 */
public class InitializationServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3979521722144998476L;


	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext( getServletContext() );

	}

}
