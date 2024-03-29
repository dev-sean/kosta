package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.SQLException;
import conn.ConnUtil;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

public final class store_005fwoo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=EUC-KR");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    String gidv = request.getParameter("store_no");
    Connection con = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstm = null;
    ResultSet rr = null;
    ResultSet rs = null;
    int cnt = 0;
    int i = 0;
    // StringBuffer str = null;
    try {
        con = ConnUtil.getConn();
        StringBuffer sb = new StringBuffer();
        sb.append("select count(*) cnt from store where store_no=?");
        pstm = con.prepareStatement(sb.toString());
        pstm.setString(1, gidv);
        rr = pstm.executeQuery();
        if (rr.next()) {
            cnt = rr.getInt("cnt");
        }
 
        StringBuffer sql = new StringBuffer();
        sql.append("select * from store where store_no=?");
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, gidv);
        rs = pstmt.executeQuery();
        
        
      
        
        String output = "";
        out.print("[");
        StringBuffer str = new StringBuffer();
        while (rs.next()) {
            ++i;
            int store_no = rs.getInt("store_no");
            String store_name = rs.getString("store_name");
            String store_image = rs.getString("store_image");
            int store_avgpoint = rs.getInt("store_avgpoint");
            String store_address = rs.getString("store_address");
            String store_time = rs.getString("store_time");
            String store_delivery_location = rs.getString("store_delivery_location");
            String store_tel = rs.getString("store_tel");
            String store_category = rs.getString("store_category");
            int store_avg_delivery_time = rs.getInt("store_avg_delivery_time");
            
            output = "{" + "\"" + "store_no" + "\"" + ":" + "\"" + store_no + "\"" + ","
                    + "\"" + "store_name" + "\"" + ":" + "\"" + store_name + "\"" + ","
                    + "\"" + "store_image" + "\"" + ":" + "\"" + store_image + "\"" + ","
                    + "\"" + "store_avgpoint" + "\"" + ":" + "\"" + store_avgpoint + "\"" + ","
                    + "\"" + "store_address" + "\"" + ":" + "\"" + store_address + "\"" + ","
                    + "\"" + "store_time" + "\"" + ":" + "\"" + store_time + "\"" + ","
                    + "\"" + "store_delivery_location" + "\"" + ":" + "\"" + store_delivery_location + "\"" + ","
                    + "\"" + "store_tel" + "\"" + ":" + "\"" + store_tel + "\"" + ","
                    + "\"" + "store_category" + "\"" + ":" + "\"" + store_category + "\"" + ","
                    + "\"" + "store_avg_delivery_time" + "\"" + ":" + "\"" + store_avg_delivery_time + "\"" + "}";

            if (i < cnt) {
                str.append(output + ",");
            } else {
                str.append(output);
            }
        }
        out.println(str+"]");
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (rr != null) {
                rr.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
