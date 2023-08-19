/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.*;
import java.io.*;
/**
 *
 * @author Ranjeetkumar
 */
@WebServlet(urlPatterns = {"/UserCreation"})
public class UserCreation extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserCreation</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserCreation at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        
        //processRequest(request, response);
        
        String uname,ucname, upwd,upwdcf;
	//uname = "vinayaka@piet.com";
	//upwd = "vprasad";
	uname = request.getParameter("ct1");
        ucname = request.getParameter("cname");
	upwd = request.getParameter("ct2");
        upwdcf = request.getParameter("ct3");
        
        if(upwd.matches(upwdcf))
        {
	System.out.println(uname);
      try{  
      Connection conn = null;
		
	Database db = new Database();	
	conn = db.getConnection();
	Statement stmt=conn.createStatement();
	
	String qry="insert into login(emailid,name,password) values('"+uname+"','"+ucname+"','"+upwd+"')";
        int count=0;
		 count=stmt.executeUpdate(qry);
		System.out.println("Number of rows Inserted in database =  " + count);
                
		System.out.println("******************************************************");
		
              if(count > 0)
		{
                  response.setContentType("text/html");
        PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            String name =request.getParameter("t1");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet loginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>User Successfully Created with Email ID : " + uname + "</h1>");
            //response.sendRedirect("inventory.html");
            out.println("</body>");
            out.println("</html>");
                }
              else
              {
                  response.setContentType("text/html");
        PrintWriter out = response.getWriter();
                  out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login failed </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Entered Text is : " + "Sorry! Unable to Create login in AVS portal" + "</h1>");
            out.println("</body>");
            out.println("</html>");
              }
                    
                    

     conn.close(); 
	stmt.close();
	conn.close();
	}
     catch(SQLException ex)
	{
		          System.out.println("there's a problem "+ex);
	}
        
        }
        else
        {
           response.setContentType("text/html");
        PrintWriter out = response.getWriter();
                  out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login failed </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Password and Confirmation Password does not matches while user creation in AVS portal" + "</h1>");
            out.println("</body>");
            out.println("</html>"); 
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


