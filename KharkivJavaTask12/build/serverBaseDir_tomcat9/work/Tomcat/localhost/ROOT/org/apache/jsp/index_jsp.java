/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.13
 * Generated at: 2019-07-16 11:54:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/tags/login.tag", Long.valueOf(1563278039149L));
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
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">\r\n");
      out.write("    <meta content=\"ie=edge\" http-equiv=\"X-UA-Compatible\">\r\n");
      out.write("    <link href=\"css/icon.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link crossorigin=\"anonymous\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\"\r\n");
      out.write("          integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" rel=\"stylesheet\">\r\n");
      out.write("    <title>Main</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\r\n");
      out.write("    <button aria-controls=\"navbarTogglerDemo03\" aria-expanded=\"false\" aria-label=\"Toggle navigation\"\r\n");
      out.write("            class=\"navbar-toggler\"\r\n");
      out.write("            data-target=\"#navbarTogglerDemo03\" data-toggle=\"collapse\" type=\"button\">\r\n");
      out.write("        <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("    </button>\r\n");
      out.write("    <a class=\"navbar-brand\" href=\"#\">Home</a>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"navbarToggler\">\r\n");
      out.write("        <ul class=\"navbar-nav mr-auto mt-2 mt-lg-0\">\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"#\">Bicycles</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"#\">Car</a>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("            ");
      if (_jspx_meth_info_005flogin_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("        <div class=\"card col-sm-4\">\r\n");
      out.write("            <img alt=\"Card image cap\"\r\n");
      out.write("                 class=\"card-img-top\"\r\n");
      out.write("                 src=\"https://bls.ua/image_cache/cars/97.Seat_Ibiza_2019/585x440-5c9e3129877ff.jpg\">\r\n");
      out.write("            <div class=\"card-body\">\r\n");
      out.write("                <h5 class=\"card-title text-truncate\" data-placement=\"top\" data-toggle=\"tooltip\"\r\n");
      out.write("                    title=\" Seat Ibiza \">Seat Ibiza</h5>\r\n");
      out.write("                <p class=\"card-text\">МЕСТ 4; ПЕРЕДНИЙ ПРИВОД; С КОНДИЦИОНЕРОМ; БЕНЗИН 1.2</p>\r\n");
      out.write("                <h5>Price: 40$</h5>\r\n");
      out.write("                <a class=\"btn btn-primary\" href=\"#\">Rent</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"card col-sm-4\">\r\n");
      out.write("            <img alt=\"Card image cap\"\r\n");
      out.write("                 class=\"card-img-top\"\r\n");
      out.write("                 src=\"https://bls.ua/image_cache/cars/4.VolkswagenPolo2017/585x440-5a5e12254199c.jpg\">\r\n");
      out.write("            <div class=\"card-body\">\r\n");
      out.write("                <h5 class=\"card-title text-truncate\" data-placement=\"top\" data-toggle=\"tooltip\"\r\n");
      out.write("                    title=\"Volkswagen Polo\">Volkswagen Polo</h5>\r\n");
      out.write("                <p class=\"card-text\">МЕСТ 4; ПЕРЕДНИЙ ПРИВОД; С КОНДИЦИОНЕРОМ; БЕНЗИН 1.4</p>\r\n");
      out.write("                <h5>Price: 60$</h5>\r\n");
      out.write("                <a class=\"btn btn-primary\" href=\"#\">Rent</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"card col-sm-4\">\r\n");
      out.write("            <img alt=\"Card image cap\"\r\n");
      out.write("                 class=\"card-img-top\"\r\n");
      out.write("                 src=\"https://bls.ua/image_cache/cars/46.HyundayAccentTumentsev_2017/585x440-5a72dcb69e541.jpg\">\r\n");
      out.write("            <div class=\"card-body\">\r\n");
      out.write("                <h5 class=\"card-title text-truncate\" data-placement=\"top\" data-toggle=\"tooltip\"\r\n");
      out.write("                    title=\"Hyundai Accent NEW\">Hyundai Accent NEW</h5>\r\n");
      out.write("                <p class=\"card-text\">МЕСТ 5; ПЕРЕДНИЙ ПРИВОД; С КОНДИЦИОНЕРОМ; БЕНЗИН 1.4</p>\r\n");
      out.write("                <h5>Price: 55$</h5>\r\n");
      out.write("                <a class=\"btn btn-primary\" href=\"#\">Rent</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"card col-sm-4\">\r\n");
      out.write("            <img alt=\"Card image cap\"\r\n");
      out.write("                 class=\"card-img-top\"\r\n");
      out.write("                 src=\"https://bls.ua/image_cache/cars/58.SkodaOctaviaA7_2018/585x440-5a93fd43d8178.jpg\">\r\n");
      out.write("            <div class=\"card-body\">\r\n");
      out.write("                <h5 class=\"card-title text-truncate\" data-placement=\"top\" data-toggle=\"tooltip\"\r\n");
      out.write("                    title=\"Skoda Octavia A7 \">Skoda Octavia A7 </h5>\r\n");
      out.write("                <p class=\"card-text\">МЕСТ 5; ПЕРЕДНИЙ ПРИВОД; С КОНДИЦИОНЕРОМ; БЕНЗИН 1.6л</p>\r\n");
      out.write("                <h5>Price: 65$</h5>\r\n");
      out.write("                <a class=\"btn btn-primary\" href=\"#\">Rent</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"card col-sm-4\">\r\n");
      out.write("            <img alt=\"Card image cap\"\r\n");
      out.write("                 class=\"card-img-top\"\r\n");
      out.write("                 src=\"https://bls.ua/image_cache/cars/63.ChevroletSpark2018/585x440-5aaa606da30eb.jpg\">\r\n");
      out.write("            <div class=\"card-body\">\r\n");
      out.write("                <h5 class=\"card-title text-truncate\" data-placement=\"top\" data-toggle=\"tooltip\"\r\n");
      out.write("                    title=\" Chevrolet Spark \"> Chevrolet Spark </h5>\r\n");
      out.write("                <p class=\"card-text\">МЕСТ 5; ПЕРЕДНИЙ ПРИВОД; С КОНДИЦИОНЕРОМ; БЕНЗИН 1.25</p>\r\n");
      out.write("                <h5>Price: 45$</h5>\r\n");
      out.write("                <a class=\"btn btn-primary\" href=\"#\">Rent</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"card col-sm-4\">\r\n");
      out.write("            <img alt=\"Card image cap\"\r\n");
      out.write("                 class=\"card-img-top\"\r\n");
      out.write("                 src=\"https://bls.ua/image_cache/cars/53.Peugeot301_2018/585x440-5a901099d875e.jpg\">\r\n");
      out.write("            <div class=\"card-body\">\r\n");
      out.write("                <h5 class=\"card-title text-truncate\" data-placement=\"top\" data-toggle=\"tooltip\" title=\"Peugeot 301\">\r\n");
      out.write("                    Peugeot 301</h5>\r\n");
      out.write("                <p class=\"card-text\">МЕСТ 5; ПЕРЕДНИЙ ПРИВОД; С КОНДИЦИОНЕРОМ; БЕНЗИН 1.6</p>\r\n");
      out.write("                <h5>Price: 60$</h5>\r\n");
      out.write("                <a class=\"btn btn-primary\" href=\"#\">Rent</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script crossorigin=\"anonymous\"\r\n");
      out.write("        integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\"\r\n");
      out.write("        src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\"></script>\r\n");
      out.write("<script crossorigin=\"anonymous\"\r\n");
      out.write("        integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\"\r\n");
      out.write("        src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\"></script>\r\n");
      out.write("<script crossorigin=\"anonymous\"\r\n");
      out.write("        integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\"\r\n");
      out.write("        src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("    $(function () {\r\n");
      out.write("        $('[data-toggle=\"tooltip\"]').tooltip()\r\n");
      out.write("    })\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
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

  private boolean _jspx_meth_info_005flogin_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  info:login
    org.apache.jsp.tag.web.login_tag _jspx_th_info_005flogin_005f0 = new org.apache.jsp.tag.web.login_tag();
    _jsp_getInstanceManager().newInstance(_jspx_th_info_005flogin_005f0);
    try {
      _jspx_th_info_005flogin_005f0.setJspContext(_jspx_page_context);
      _jspx_th_info_005flogin_005f0.doTag();
    } finally {
      _jsp_getInstanceManager().destroyInstance(_jspx_th_info_005flogin_005f0);
    }
    return false;
  }
}
