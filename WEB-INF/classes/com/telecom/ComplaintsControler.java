/*
 * ComplaintsControler.java
 */

package com.telecom;

import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class ComplaintsControler extends HttpServlet {
    
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

        ComplaintsModel cdm=new ComplaintsModel();
        
        cdm.setClientName(request.getParameter("client_name"));
		cdm.setSubject(request.getParameter("subject"));
		cdm.setMessage(request.getParameter("message"));
		cdm.setPhoneNo(Integer.parseInt(request.getParameter("phoneno")));
		
		if (cdm.insert())
		{
			request.setAttribute("complaint_id",cdm.getComp_Id()+"");
			RequestDispatcher rd=request.getRequestDispatcher("ComplaintsConfirm.jsp");
			rd.forward(request,response);
		}
		else
		{
			request.setAttribute("error","Error while processing the request");
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