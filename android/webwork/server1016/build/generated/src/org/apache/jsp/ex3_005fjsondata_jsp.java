package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ex3_005fjsondata_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/json;charset=EUC-KR");
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
      out.write("[{\"CustomerID\":\"C001\",\"Name\":\"Win Weerachai\",\"Email\":\"win.weerachai@thaicreate.com\" ,\"CountryCode\":\"TH\",\"Budget\":\"1000000\",\"Used\":\"600000\"},\n");
      out.write("\n");
      out.write("{\"CustomerID\":\"C002\",\"Name\":\"John Smith\",\"Email\":\"john.smith@thaicreate.com\" ,\"CountryCode\":\"EN\",\"Budget\":\"2000000\",\"Used\":\"800000\"},\n");
      out.write("\n");
      out.write("{\"CustomerID\":\"C003\",\"Name\":\"Jame Born\",\"Email\":\"jame.born@thaicreate.com\" ,\"CountryCode\":\"US\",\"Budget\":\"3000000\",\"Used\":\"600000\"},\n");
      out.write("\n");
      out.write("{\"CustomerID\":\"C004\",\"Name\":\"Chalee Angel\",\"Email\":\"chalee.angel@thaicreate.com\" ,\"CountryCode\":\"US\",\"Budget\":\"4000000\",\"Used\":\"100000\"}]\n");
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
