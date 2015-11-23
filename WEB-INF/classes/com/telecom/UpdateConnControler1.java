/*
 * UpdateConnControler1.java
 */

package com.telecom;

import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class UpdateConnControler1 extends HttpServlet {
    
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
		cdm.setPurpose(Integer.parseInt(request.getParameter("purpose")));
		cdm.setPurpose(Integer.parseInt(request.getParameter("facility")));
		
		if (cdm.update())
		{
			RequestDispatcher rd=request.getRequestDispatcher("ModificationsConfirm.html");
			rd.forward(request,response);
		}
		else
		{
			request.setAttribute("error","Problem while Updating Data try again");
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
