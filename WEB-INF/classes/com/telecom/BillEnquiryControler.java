/*
 * BillEnquiryControler.java
 */

package com.telecom;

import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class BillEnquiryControler extends HttpServlet {
    
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

		try
		{
			request.setAttribute("phone_no",request.getParameter("phone_no")+"");

			Connection con=MyDriver.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from billdetails where phone_no="+request.getParameter("phone_no"));
			if (rs.next())
			{	
				request.setAttribute("billno",rs.getInt(2)+"");
				request.setAttribute("billamount",rs.getDouble(3)+"");
			}
			else
			{
				request.setAttribute("error","Wrong Number");
				RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");
				rd.forward(request,response);
			}
			RequestDispatcher rd=request.getRequestDispatcher("BillEnquiryConfirm.jsp");
			rd.forward(request,response);
		}
		catch (Exception w)
		{
			w.printStackTrace();
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