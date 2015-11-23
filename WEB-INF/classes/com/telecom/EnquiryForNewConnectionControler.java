/*
 * EnquiryForNewConnectionControler.java
 */

package com.telecom;

import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class EnquiryForNewConnectionControler extends HttpServlet {
    
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

		request.setAttribute("name",cdm.getName()+"");
		request.setAttribute("address",cdm.getAddress()+"");
		if ("y".equalsIgnoreCase(cdm.getConfirmed()))
			request.setAttribute("status","<b>Your application has been varified and a phone number has been allocated.</b>");
		else
			request.setAttribute("status","<b>Your application has not been varified.</b>");

		RequestDispatcher rd=request.getRequestDispatcher("EnquiryForNewConnectionConfirm.jsp");
		rd.forward(request,response);
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