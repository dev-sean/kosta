package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.SQLException;
import conn.ConnUtil;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

public final class review_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");

    request.setCharacterEncoding("EUC-KR");
    //String reId = request.getParameter("userid");
    String reContent = request.getParameter("content");
    
    String reStarpoint = request.getParameter("starpoint");
    //String reImage = request.getParameter("image");
    //String reStore = request.getParameter("store_no");
    System.out.println(reContent);
    Connection con = null;
    PreparedStatement pstm = null;
    try {
        con = ConnUtil.getConn();
        StringBuffer sb = new StringBuffer();
  

        //id, content, starpoint, image, time, store
        sb.append("insert into board values(board_seq.nextVal, ?, ?, ?, ?, sysdate, ?)");
        pstm = con.prepareStatement(sb.toString());
        pstm.setString(1, "ko1");
        pstm.setString(2, reContent);
        pstm.setString(3, reStarpoint);
        pstm.setString(4, "http://image.gmarket.co.kr/mobileecoupon_image/2014/02/11/20140211093431485695_0_0.jpg");
        pstm.setString(5, "5");
        
        pstm.executeUpdate();
        
        out.print("success");
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }      

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
