package org.jboss.resteasy.clientkeepalive;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.resteasy.client.ClientRequest;


@WebServlet(urlPatterns="/servlet/*", loadOnStartup=1)
public class SiteContentServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ClientRequest clientRequest = ClientRequestFactory.getClientRequest();
		try {
			resp.getOutputStream().write(clientRequest.get(String.class).getEntity().getBytes());
			resp.getOutputStream().close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.doGet(req, resp);
	}
	
}
