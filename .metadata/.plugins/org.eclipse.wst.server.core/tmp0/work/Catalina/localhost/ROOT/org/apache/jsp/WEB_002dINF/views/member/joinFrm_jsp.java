/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.82
 * Generated at: 2022-09-30 10:47:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class joinFrm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>회원가입</title>\r\n");
      out.write("<style>\r\n");
      out.write("	ul{\r\n");
      out.write("		margin: 20px;\r\n");
      out.write("		padding: 0;\r\n");
      out.write("	}\r\n");
      out.write("	li{\r\n");
      out.write("		list-style-type: none;\r\n");
      out.write("	}\r\n");
      out.write("	input[type=text], input[type=password]{\r\n");
      out.write("		width: 250px;\r\n");
      out.write("		height: 30px;\r\n");
      out.write("		margin: 10px 0px 10px 0px;\r\n");
      out.write("		border: 0;\r\n");
      out.write("		border-bottom: 1px solid #396EB0;\r\n");
      out.write("		font-size: 16px;\r\n");
      out.write("	}\r\n");
      out.write("	input:focus{\r\n");
      out.write("		outline: 0;\r\n");
      out.write("		color: #396EB0;\r\n");
      out.write("		font-weight: bold;\r\n");
      out.write("	}\r\n");
      out.write("	input[type=submit]{\r\n");
      out.write("		margin-top: 15px;\r\n");
      out.write("		width:200px;\r\n");
      out.write("		height:50px;\r\n");
      out.write("		border: 1px solid #000;\r\n");
      out.write("		background-color: #fff;\r\n");
      out.write("		font-size: 18px;\r\n");
      out.write("	}\r\n");
      out.write("	input[type=submit]:hover{\r\n");
      out.write("		cursor: pointer;\r\n");
      out.write("		border-color: #396EB0;\r\n");
      out.write("		background-color: #396EB0;\r\n");
      out.write("		color: #fff;\r\n");
      out.write("		font-weight: bold;\r\n");
      out.write("		transition: 0.5s;\r\n");
      out.write("	}\r\n");
      out.write("	label{\r\n");
      out.write("		display: inline-block;\r\n");
      out.write("		width: 80px;\r\n");
      out.write("		height: 30px;\r\n");
      out.write("		color: #396EB0;\r\n");
      out.write("		font-weight: 900;\r\n");
      out.write("	}\r\n");
      out.write("	fieldset{\r\n");
      out.write("		width: 400px;\r\n");
      out.write("		position: relative;\r\n");
      out.write("	}\r\n");
      out.write("	fieldset>legend{\r\n");
      out.write("		color: #396EB0;\r\n");
      out.write("		font-weight: 900;\r\n");
      out.write("		font-size: 20px;\r\n");
      out.write("		text-align: center;\r\n");
      out.write("	}\r\n");
      out.write("	fieldset>span{\r\n");
      out.write("		position: absolute;\r\n");
      out.write("		right: 10px;\r\n");
      out.write("		font-size: 12px;\r\n");
      out.write("	}\r\n");
      out.write("	.require{\r\n");
      out.write("		color: red;\r\n");
      out.write("		font-size: 16px;\r\n");
      out.write("	}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<h1>회원가입</h1>\r\n");
      out.write("	<hr>\r\n");
      out.write("	<form action=\"/join.do\" method=\"post\">\r\n");
      out.write("		<fieldset>\r\n");
      out.write("			<legend>회원정보 입력</legend>\r\n");
      out.write("			<span><span class=\"require\">*</span>표시는 필수입력정보 입니다</span>\r\n");
      out.write("			<ul>\r\n");
      out.write("				<li>\r\n");
      out.write("					<label for=\"id\">아이디<span class=\"require\">*</span></label>\r\n");
      out.write("					<input type=\"text\" name=\"memberId\" id=\"id\" placeholder=\"coronaki11\" autocomplete=\"off\" required>\r\n");
      out.write("				</li>\r\n");
      out.write("				<li>\r\n");
      out.write("					<label for=\"pw\">비밀번호<span class=\"require\">*</span></label>\r\n");
      out.write("					<input type=\"password\" name=\"memberPw\" id=\"pw\" placeholder=\"c0r0sskill\" autocomplete=\"off\" required>\r\n");
      out.write("				</li>\r\n");
      out.write("				<li>\r\n");
      out.write("					<label for=\"name\">이름<span class=\"require\">*</span></label>\r\n");
      out.write("					<input type=\"text\" name=\"memberName\" id=\"name\" placeholder=\"코로쓰\" autocomplete=\"off\" required>\r\n");
      out.write("				</li>\r\n");
      out.write("				<li>\r\n");
      out.write("					<label for=\"phone\">전화번호</label>\r\n");
      out.write("					<input type=\"text\" name=\"phone\" id=\"phone\" placeholder=\"010-XXXX-XXXX\" autocomplete=\"off\">\r\n");
      out.write("				</li>\r\n");
      out.write("				<li>\r\n");
      out.write("					<label for=\"email\">이메일</label>\r\n");
      out.write("					<input type=\"text\" name=\"email\" id=\"email\" placeholder=\"corona@coross.com\" autocomplete=\"off\">\r\n");
      out.write("				</li>\r\n");
      out.write("				<li style=\"text-align: center;\"><input type=\"submit\" value=\"가입하기\"></li>\r\n");
      out.write("			</ul>\r\n");
      out.write("		</fieldset>\r\n");
      out.write("	</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
