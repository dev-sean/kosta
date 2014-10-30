package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ex3_005fajax_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=EUC-KR\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script src=\"//code.jquery.com/jquery-1.11.0.min.js\"></script>\n");
      out.write("        <script src=\"//code.jquery.com/jquery-migrate-1.2.1.min.js\"></script>\n");
      out.write("        <script> \n");
      out.write("            $(document).ready(function(){\n");
      out.write("                $(\"#btn1\").click(function(){\n");
      out.write("                    var n = $('#name').val();\n");
      out.write("                    var on = $('#orderNum').val();\n");
      out.write("                    //$ajax() : 메서드를 사용한 Ajax통신\n");
      out.write("                    //url : 비동기식으로 보낼 서버측 주소\n");
      out.write("                    //data : 보낼 파라미터\n");
      out.write("                    //success : 성공했을 때 callback\n");
      out.write("                    //error : 실패!\n");
      out.write("                    $.ajax({\n");
      out.write("                        url:\"ex3_basicData.jsp\",\n");
      out.write("                        data:{name:n, orderNum:on},\n");
      out.write("                        success: function(data, status){\n");
      out.write("                            console.log(\"Status:\"+status);\n");
      out.write("                            $('#res').html(data);\n");
      out.write("                        \n");
      out.write("                        },\n");
      out.write("                        error:function(e){\n");
      out.write("                            console.log(e);\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("                });       \n");
      out.write("             });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("       \n");
      out.write("      \n");
      out.write("    <body>\n");
      out.write("        <h1>주문확인</h1>\n");
      out.write("        <input type=\"text\" name=\"name\" id=\"name\"><br/>\n");
      out.write("        <input type=\"text\" name=\"orderNum\" id=\"orderNum\"><br/>\n");
      out.write("        <input type=\"button\" value=\"click\" id=\"btn1\"><br/>\n");
      out.write("        <div id=\"res\">Status:</div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
