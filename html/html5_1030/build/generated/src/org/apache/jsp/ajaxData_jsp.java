package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ex1.Ex1_Girl;

public final class ajaxData_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    String code = request.getParameter("groupName");
    // 객체생성 
    Ex1_Girl girl = new Ex1_Girl();
    // 메서드 호출후 해당 code에 따른 데이터를 문자열로 반환 받음
    String[] gg = girl.getGirlGroup(code);
    System.out.println(gg.length);

      out.write("<option>선택</option>\n");
 for (String e : gg) {
      out.write("\n");
      out.write("<option>");
      out.print(e);
      out.write("</option>\n");
} 
      out.write("\n");
      out.write("\n");
      out.write("\n");

    request.setCharacterEncoding("euc-kr");
    String gname = request.getParameter("gname");
    gname = gname.trim();
    System.out.println("GName : " + gname);
    //"유라","헤리","소진","미라"
    String imgName = "";
    if (gname.equals("유라")) {
        imgName = "girlImg/ura.jpg";
    } else if (gname.equals("헤리")) {
        imgName = "girlImg/heri.jpg";
    } else if (gname.equals("소진")) {
        imgName = "girlImg/sojin.jpg";
    } else if (gname.equals("미라")) {
        imgName = "girlImg/mina.jpg";
        //"보람","지연","효민","은정"","큐리,"소연"
    } else if (gname.equals("보람")) {
        imgName = "taraImg/boram.jpg";
    } else if (gname.equals("지연")) {
        imgName = "taraImg/jiyun.jpg";
    } else if (gname.equals("효민")) {
        imgName = "taraImg/hymin.jpg";
    } else if (gname.equals("큐리")) {
        imgName = "taraImg/jiyun.jpg";
    } else if (gname.equals("소연")) {
        imgName = "taraImg/soyun.jpg";
    }

      out.print(imgName);
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
