/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.13
 * Generated at: 2019-07-16 11:54:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signUp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/tags/captcha.tag", Long.valueOf(1563278039148L));
    _jspx_dependants.put("file:/C:/Users/Vladyslav_Poliak/.gradle/caches/modules-2/files-2.1/javax.servlet/jstl/1.2/74aca283cd4f4b4f3e425f5820cda58f44409547/jstl-1.2.jar", Long.valueOf(1562237154049L));
    _jspx_dependants.put("jar:file:/C:/Users/Vladyslav_Poliak/.gradle/caches/modules-2/files-2.1/javax.servlet/jstl/1.2/74aca283cd4f4b4f3e425f5820cda58f44409547/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153374282000L));
  }

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

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <!-- Required meta tags -->\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" name=\"viewport\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap CSS -->\r\n");
      out.write("    <link crossorigin=\"anonymous\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n");
      out.write("          integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <title>Sign Up</title>\r\n");
      out.write("</head>\r\n");
      out.write("<html>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    <h1 class=\"text-center display-4\">SIGN UP</h1>\r\n");
      out.write("    <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/registration\" enctype=\"multipart/form-data\" id=\"registration-form\"\r\n");
      out.write("          method=\"post\">\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <label for=\"user-name\">First Name</label>\r\n");
      out.write("            <input class=\"form-control\" id=\"user-name\" name=\"userName\" placeholder=\"First Name\" type=\"text\"\r\n");
      out.write("                   value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("            <div class=\"valid-feedback\">\r\n");
      out.write("                Looks good!\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"invalid-feedback\">\r\n");
      out.write("                The name must consist of letters only.\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <label for=\"user-surname\">Second Name</label>\r\n");
      out.write("            <input class=\"form-control\" id=\"user-surname\" name=\"userSurname\" placeholder=\"Second Name\" type=\"text\"\r\n");
      out.write("                   value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${surName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("            <div class=\"valid-feedback\">\r\n");
      out.write("                Looks good!\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"invalid-feedback\">\r\n");
      out.write("                The surname must consist of letters only.\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <label for=\"user-email\">Email address</label>\r\n");
      out.write("            <input class=\"form-control\" id=\"user-email\" name=\"userEmail\" placeholder=\"Please, enter your email\"\r\n");
      out.write("                   type=\"email\"\r\n");
      out.write("                   value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${login}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("            <div class=\"valid-feedback\">\r\n");
      out.write("                Looks good!\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"invalid-feedback\">\r\n");
      out.write("                Invalid email\r\n");
      out.write("            </div>\r\n");
      out.write("            <small class=\"form-text text-muted\" id=\"emailHelp\">We'll never share your email with anyone\r\n");
      out.write("                else.\r\n");
      out.write("            </small>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <label for=\"user-pass\">Password</label>\r\n");
      out.write("            <input class=\"form-control\" id=\"user-pass\" name=\"userPassword\" placeholder=\"Please, enter your password\"\r\n");
      out.write("                   type=\"password\">\r\n");
      out.write("            <div class=\"valid-feedback\">\r\n");
      out.write("                Good password\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"invalid-feedback\">\r\n");
      out.write("                The password is too short\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <label for=\"confirmation-pass\">Confirm your password</label>\r\n");
      out.write("            <input class=\"form-control\" id=\"confirmation-pass\" name=\"confirmationPassword\"\r\n");
      out.write("                   placeholder=\"Please, confirm your password\"\r\n");
      out.write("                   type=\"password\">\r\n");
      out.write("            <div class=\"valid-feedback\">\r\n");
      out.write("                Passwords match\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"invalid-feedback\">\r\n");
      out.write("                Passwords do not match(need more than 5 characters)\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <label for=\"file\">Set your avatar (optional)</label>\r\n");
      out.write("            <input accept=\"image/x-png,image/gif,image/jpeg\" class=\"form-control\" id=\"file\"\r\n");
      out.write("                   name=\"file\" type=\"file\">\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        ");
      if (_jspx_meth_info_005fcaptcha_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("        <label for=\"captcha\"> </label><input id=\"captcha\" name=\"captcha\" placeholder=\"Numbers from picture\" type=\"text\">\r\n");
      out.write("\r\n");
      out.write("        <button class=\"btn btn-primary \" type=\"submit\">Submit</button>\r\n");
      out.write("    </form>\r\n");
      out.write("</div>\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<!--    <script src=\"js/script.js\"> </script>-->\r\n");
      out.write("<script src=\"js/jqueryScript.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_info_005fcaptcha_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  info:captcha
    org.apache.jsp.tag.web.captcha_tag _jspx_th_info_005fcaptcha_005f0 = new org.apache.jsp.tag.web.captcha_tag();
    _jsp_getInstanceManager().newInstance(_jspx_th_info_005fcaptcha_005f0);
    try {
      _jspx_th_info_005fcaptcha_005f0.setJspContext(_jspx_page_context);
      // /signUp.jsp(95,8) name = captchaId type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
      _jspx_th_info_005fcaptcha_005f0.setCaptchaId((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${captchaId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      _jspx_th_info_005fcaptcha_005f0.doTag();
    } finally {
      _jsp_getInstanceManager().destroyInstance(_jspx_th_info_005fcaptcha_005f0);
    }
    return false;
  }
}
