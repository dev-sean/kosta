package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.SQLException;
import conn.ConnUtil;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

public final class pay_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    String editCardNumber = request.getParameter("editCardNumber");
    String editValidMonth = request.getParameter("editValidMonth");
    String editValidYear = request.getParameter("editValidYear");
    String editPassword = request.getParameter("editPassword");
    String editJumin = request.getParameter("editJumin");

    Connection con = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    int num = 0;
    String cardnumber = null;
    String validmonth = null;
    String validyear = null;
    int cardpassword = 0;
    String jumin = "";
    try {
        con = ConnUtil.getConn();
        StringBuffer sb = new StringBuffer();
        sb.append("select * from card");
        pstm = con.prepareStatement(sb.toString());

        rs = pstm.executeQuery();

        StringBuffer str = new StringBuffer();
        while (rs.next()) {
            num = rs.getInt("card_no");
            cardnumber = rs.getString("card_number");
            validmonth = rs.getString("valid_month");
            validyear = rs.getString("valid_year");
            cardpassword = rs.getInt("password");
            jumin = rs.getString("jumin");
        }

        if (cardnumber.equals(editCardNumber)) {
            out.println("cardnumbertrue");
        } else {
            out.println("cardnumberfalse");
        }
        if (validmonth.equals(editValidMonth)) {
            out.println("monthtrue");
        } else {
            out.println("monthfalse");
        }
        if (validyear.equals(editValidYear)) {
            out.println("yeartrue");
        } else {
            out.println("yearfalse");
        }
        //editPassword.startsWith(String.valueOf(editPassword));
        if ((cardpassword / 100) == Integer.parseInt(editPassword)) {
            out.println("passtrue");
        } else {
            out.println("passfalse");
        }
        if (jumin.equals(editJumin)) {
            out.println("jumintrue");
        } else {
            out.println("juminfalse");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (pstm != null) {
                pstm.close();
            }
            if (rs != null) {
                rs.close();
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
