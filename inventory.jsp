<%-- 
    Document   : inventory
    Created on : 23 May, 2023, 11:54:23 AM
    Author     : Ranjeetkumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.math.*" %>

<%@ page contentType="text/html" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.* "%>
<%@ page import="java.lang.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.text.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
        String itype = "";
	String iname = "";
	String idesc = "";      
        
        %>
        <table border="1" width="88%">
 <!--  <p align="center"><b><font size="4">OPD Detail On</font>
   <font size="5"> </font></b>  
 -->
 <tr>
     <td colspan="3" align="center"> Inventory Master</td>
     </tr>
 <tr>
    <td width="33%" align="center">Item Type</td>
    <td width="33%">Item Name</td>
    <td width="33%">Item Description</td>
    </tr>
    
    <%				
  Connection conn = null;    
     try 
         {
             Class.forName("oracle.jdbc.driver.OracleDriver");
             DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());	
	         conn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","avs","avs");
	         Statement stmt=conn.createStatement();
	         Statement  stmt1=conn.createStatement();
	         ResultSet rs = stmt.executeQuery("select * FROM inventory order by itemtype");
              while(rs.next())
	              {
	                    itype = rs.getString("ITEMTYPE");
	                    iname = rs.getString("ITEMNAME");
	                    idesc = rs.getString("ITEMDESCRIPTION");
	                    	                    
                            %>
                            
                            <tr>
    <td width="33%" align="center"><font face="Tahoma" size="2"><span style="text-transform: uppercase"><%=itype%></span></font>&nbsp;</td>
    <td width="33%"><font face="Tahoma" size="2"><span style="text-transform: uppercase"><%=iname%></span></font>&nbsp;</td>
    <td width="33%"><font face="Tahoma" size="2"><span style="text-transform: uppercase"><%=idesc%></span></font>&nbsp;</td>
 
  </tr>
                            
                           <%

                            
                            
                      }
%>

</table>
        <%
         }
    catch(SQLException e) 
   {
       while((e = e.getNextException()) != null)
       out.println(e.getMessage() + "<BR>");
   }
 catch(ClassNotFoundException e) 
      {
          out.println("ClassNotFoundexception :" + e.getMessage() + "<BR>");
      }
 finally
      {
          if(conn != null) 
            {
               try
                  {
                      conn.close();
                  }
               catch (Exception ignored) {}
            }
      }
%>	
    
    </body>
</html>
