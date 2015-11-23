/*
 * EnquiryByTelephoneNoControler.java
 */

package com.telecom;

import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class EnquiryByTelephoneNoControler extends HttpServlet {
    
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

        TelephoneModel tm=new TelephoneModel();
        
        tm.setPhoneNo(Integer.parseInt(request.getParameter("tele_no")));
		tm.load();
		
		if (tm.getReq_Id()==0)
		{
			request.setAttribute("error","Invalid Phone Number");
			RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");
			rd.forward(request,response);
		}

		ConnectionDetailsModel cdm=new ConnectionDetailsModel();
		cdm.setReq_id(tm.getReq_Id());
		cdm.load();

		request.setAttribute("name",cdm.getName()+"");
		request.setAttribute("address",cdm.getAddress()+"");		

		RequestDispatcher rd=request.getRequestDispatcher("EnquiryByTelephoneNoResult.jsp");
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