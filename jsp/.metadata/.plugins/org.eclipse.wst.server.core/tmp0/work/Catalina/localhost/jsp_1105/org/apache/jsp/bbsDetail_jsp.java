/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.56
 * Generated at: 2014-11-05 10:21:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.BbsDao;
import vo.BbsVO;
import java.util.List;

public final class bbsDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/ex1_top.jsp", Long.valueOf(1415087843864L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=EUC-KR");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"EUC-KR\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"style/style.css\" type=\"text/css\">\r\n");
      out.write("<script src=\"//code.jquery.com/jquery-1.11.0.min.js\"></script>\r\n");
      out.write("<script src=\"//code.jquery.com/jquery-migrate-1.2.1.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<header class=\"hd\">\r\n");
      out.write("\t\t<h1>Include 연습</h1>\r\n");
      out.write("\t\t<h2>include 지시자의 top.jsp영역</h2>\r\n");
      out.write("\t\t");

			if(session.getAttribute("MEMBERID")!=null){
				String username = (String) session.getAttribute("USERNAME");
		
      out.write("\r\n");
      out.write("\t\t\t<h2 style=\"color:yellow; font-size:13pt\">");
      out.print(username );
      out.write("님 반갑습니다. ^^</h2>\r\n");
      out.write("\t\t");
		
			}
		
      out.write("\r\n");
      out.write("\t</header>\r\n");
      out.write("\t<nav>\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li><a href=\"ex1_body.jsp\">홈</a>&nbsp; |</li>\r\n");
      out.write("\t\t\t");

				String menu1= "";
				String menu2 = "";
				//세션의 유무 판단
				if(session.getAttribute("MEMBERID")==null){
			
      out.write("\r\n");
      out.write("\t\t\t\t\t<li><a href=\"join.jsp\">회원가입</a>&nbsp; |</li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"loginForm.jsp\">로그인</a>&nbsp; |</li>\r\n");
      out.write("\t\t\t");

				}else{
			
      out.write("\r\n");
      out.write("\t\t\t\t\t<li><a href=\"mypage.jsp\">마이페이지</a>&nbsp; |</li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"LogOut.jsp\">로그아웃</a>&nbsp; |</li>\r\n");
      out.write("\t\t\t");

				}
			
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<li><a href=\"\">게시판</a>&nbsp; |</li>\r\n");
      out.write("\t\t\t<li><a href=\"\">메뉴1</a>&nbsp; |</li>\r\n");
      out.write("\t\t\t<li><a href=\"\">메뉴2</a>&nbsp; |</li>\r\n");
      out.write("\t\t\t<li><a href=\"\">메뉴3</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</nav>");
      out.write("\r\n");
      out.write("<article>\r\n");
      out.write("\t<p>현재 IT에서 가장 각광받는 java Technology의 기초부터 고급기술까지 학습합니다 전자정부\r\n");
      out.write("\t\t프레임워크(java opensource framework)를 이용한 Enterprise Solution 설계 및 구현과\r\n");
      out.write("\t\t안드로이드 및 하이브리드앱을 이용한 모바일 애플리케이션 구현을 학습하고 실무 프로젝트를 통해 현업에서 필요로 하는 자바\r\n");
      out.write("\t\t엔지니어 양성을 목표로 합니다.</p>\r\n");
      out.write("\t<section>\r\n");
      out.write("\t\t<header style=\"margin: auto; width: 100%\">\r\n");
      out.write("\t\t\t<h2>BbsDetail Page</h2>\r\n");
      out.write("\t\t</header>\r\n");
      out.write("\t\t<p>\r\n");
      out.write("\t\t\t");

				int num = Integer.parseInt(request.getParameter("num"));
				BbsVO vo = BbsDao.getDao().getDetail(num);
			
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<table style=\"margin: auto; width: 80%\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>번호</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(vo.getNum());
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>제목</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(vo.getSub());
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>Writer</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(vo.getWriter());
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>내용</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(vo.getCont());
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>작성날짜</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(vo.getRedate());
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>작성자 아이피</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(vo.getReip());
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"2\" style=\"text-align: right;\"><input type=\"button\"\r\n");
      out.write("\t\t\t\t\tvalue=\"Write\" style=\"width: 100px; height: 30px;\"\r\n");
      out.write("\t\t\t\t\tonclick=\"location='bbsForm.jsp'\"> <input type=\"button\"\r\n");
      out.write("\t\t\t\t\tvalue=\"List\" style=\"width: 100px; height: 30px;\"\r\n");
      out.write("\t\t\t\t\tonclick=\"location='bbslist.jsp'\"> <input type=\"button\"\r\n");
      out.write("\t\t\t\t\tvalue=\"Update\" style=\"width: 100px; height: 30px;\"\r\n");
      out.write("\t\t\t\t\tonclick=\"location='bbsupform.jsp?num=");
      out.print(num);
      out.write("'\"> <input\r\n");
      out.write("\t\t\t\t\ttype=\"button\" value=\"Delete\" style=\"width: 100px; height: 30px;\"\r\n");
      out.write("\t\t\t\t\tonclick=\"location='bbsdelete.jsp?num=");
      out.print(num);
      out.write("'\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t</p>\r\n");
      out.write("\t</section>\r\n");
      out.write("\r\n");
      out.write("</article>\r\n");
      out.write("<aside>\r\n");
      out.write("\t<header>\r\n");
      out.write("\t\t<h1>Siderbar Heading</h1>\r\n");
      out.write("\t</header>\r\n");
      out.write("\t<p>문서의 주 내용이 아닌 관련성이 낮은 내용들은 aside로 표시할 수 있다. 본문과 직접적으로 상관이 없는 관련\r\n");
      out.write("\t\t사이트 링크나 안내글, nav 요소의 그룹 등이 aside 요소로 기술 될 수 있다. 보통 블로그에서 좌우측 사이드바를\r\n");
      out.write("\t\t의미하는 것으로서 사이드바의 특성으로 볼때 필수적이지 않아서 표시를 해도 되고 안 해도 되는 내용들 또는 광고물같은 내용들이\r\n");
      out.write("\t\t자리할 수 있다.</p>\r\n");
      out.write("\r\n");
      out.write("</aside>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
