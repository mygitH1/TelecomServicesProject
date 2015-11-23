/*
 * EnquiryForPhoneTransferControler.java
 */

package com.telecom;

import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class EnquiryForPhoneTransferControler extends HttpServlet {
    
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

		TransferModel cdm=new TransferModel();
		cdm.setReq_id(Integer.parseInt(request.getParameter("id")));
		cdm.load();
		
		request.setAttribute("tele_no",cdm.getPhone_no()+"");
		request.setAttribute("name",cdm.getName()+"");
		request.setAttribute("present_address",cdm.getPresent_address()+"");
		request.setAttribute("new_address",cdm.getNew_address()+"");
		if (cdm.getStatus()==null)
			request.setAttribute("status","No Status Available");
		else
			request.setAttribute("status",cdm.getStatus()+"");

		RequestDispatcher rd=request.getRequestDispatcher("EnquiryForPhoneTransferConfirm.jsp");
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