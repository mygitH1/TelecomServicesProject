/*
 * UpdateConnControler.java
 */

package com.telecom;

import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class UpdateConnControler extends HttpServlet {
    
    /** Initializes the servlet.
     */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
    
    /** Destroys the servlet.
     */
    public void destroy() {
    }
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        response.setContentType("text/html");

        ConnectionDetailsModel cdm=new ConnectionDetailsModel();
        
        cdm.setReq_id(Integer.parseInt(request.getParameter("id")));
		cdm.load();
		
		if (cdm.getName().equals(request.getParameter("name"))&&cdm.getPassword().equals(request.getParameter("pass")))
		{
			request.setAttribute("id",cdm.getReq_id()+"");
			request.setAttribute("name",cdm.getName()+"");
			request.setAttribute("phoneno",request.getParameter("phoneno")+"");
			RequestDispatcher rd=request.getRequestDispatcher("Modifications.jsp");
			rd.forward(request,response);
		}
		else
		{
			request.setAttribute("error","Name or Password is in correct");
			RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");
			rd.forward(request,response);
		}        
    }
    
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
}
