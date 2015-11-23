/*
 * PhoneTransferControler.java
 */

package com.telecom;

import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class PhoneTransferControler extends HttpServlet {
    
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
        
        cdm.setName(request.getParameter("name"));
        cdm.setPhone_no(Integer.parseInt(request.getParameter("phoneno")));

        cdm.setPresent_address(request.getParameter("p_address"));
        cdm.setNew_address(request.getParameter("n_address"));

        DemandDraftModel ddm=new DemandDraftModel();
        
        ddm.setName(request.getParameter("bank_name"));
        ddm.setBranch(request.getParameter("branch"));
        ddm.setDate(request.getParameter("day")+"-"+request.getParameter("month")+"-"+request.getParameter("year"));
        ddm.setAmount(Double.parseDouble(request.getParameter("amount")));
        ddm.setDraft_no(request.getParameter("ddno"));
        
        if(ddm.insert())
        {
System.out.println("DD insert");
            cdm.setBankDeatilsID(ddm.getDD_id());
            if (cdm.insert())
            {
                request.setAttribute("request_id",cdm.getReq_id()+"");
                RequestDispatcher rd=request.getRequestDispatcher("PhoneTransferConfirm.jsp");
                rd.forward(request,response);
            }
            else
            {
                ddm.remove();
                request.setAttribute("error","Unable to create the record");
                RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");
                rd.forward(request,response);
            }
        }
		else
		{
			request.setAttribute("error","Unable to create the DD record");
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
