/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.13
 * Generated at: 2019-07-19 22:10:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class aside_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("/WEB-INF/tags/tagForCarProduсers.tag", Long.valueOf(1563574189454L));
    _jspx_dependants.put("jar:file:/C:/Users/Влад/.gradle/caches/modules-2/files-2.1/javax.servlet/jstl/1.2/74aca283cd4f4b4f3e425f5820cda58f44409547/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153374282000L));
    _jspx_dependants.put("/WEB-INF/tags/tagForCarClass.tag", Long.valueOf(1563574189453L));
    _jspx_dependants.put("jar:file:/C:/Users/Влад/.gradle/caches/modules-2/files-2.1/javax.servlet/jstl/1.2/74aca283cd4f4b4f3e425f5820cda58f44409547/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153374282000L));
    _jspx_dependants.put("file:/C:/Users/Влад/.gradle/caches/modules-2/files-2.1/javax.servlet/jstl/1.2/74aca283cd4f4b4f3e425f5820cda58f44409547/jstl-1.2.jar", Long.valueOf(1562953034249L));
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

      out.write("<div class=\"container\">\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("        <div class=\"col-sm-12 col-md-3 \">\r\n");
      out.write("            <form class=\"sticky-top p-2\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/search\" >\r\n");
      out.write("                <h3>Producers</h3>\r\n");
      out.write("                ");
      if (_jspx_meth_tag_005ftagForCarProduсers_005f0(_jspx_page_context))
        return;
      out.write("<h3>Class</h3>\r\n");
      out.write("                ");
      if (_jspx_meth_tag_005ftagForCarClass_005f0(_jspx_page_context))
        return;
      out.write("<div class=\"form-group\">\r\n");
      out.write("                    <label for=\"exampleInputEmail1\">Min price</label>\r\n");
      out.write("                    <input type=\"number\" class=\"input-number\" name=\"minPrice\" id=\"exampleInputEmail1\">\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label for=\"exampleInputPassword1\">Max price</label>\r\n");
      out.write("                    <input type=\"number\" class=\"input-number\" name=\"maxPrice\" id=\"exampleInputPassword1\">\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label for=\"exampleInputPassword1\">Search for name</label>\r\n");
      out.write("                    <input type=\"text\" class=\"input-number2\" name=\"searchByName\" id=\"exampleInputPassword12\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${searchForm.query}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <button type=\"submit\" class=\"btn btn-primary\">Search</button>\r\n");
      out.write("            </form>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
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

  private boolean _jspx_meth_tag_005ftagForCarProduсers_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  tag:tagForCarProduсers
    org.apache.jsp.tag.web.tagForCarProduсers_tag _jspx_th_tag_005ftagForCarProduсers_005f0 = new org.apache.jsp.tag.web.tagForCarProduсers_tag();
    _jsp_getInstanceManager().newInstance(_jspx_th_tag_005ftagForCarProduсers_005f0);
    try {
      _jspx_th_tag_005ftagForCarProduсers_005f0.setJspContext(_jspx_page_context);
      // /aside.jsp(12,16) name = producers type = java.util.Collection reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
      _jspx_th_tag_005ftagForCarProduсers_005f0.setProducers((java.util.Collection) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${MARKS_LIST}", java.util.Collection.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      _jspx_th_tag_005ftagForCarProduсers_005f0.doTag();
    } finally {
      _jsp_getInstanceManager().destroyInstance(_jspx_th_tag_005ftagForCarProduсers_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_tag_005ftagForCarClass_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  tag:tagForCarClass
    org.apache.jsp.tag.web.tagForCarClass_tag _jspx_th_tag_005ftagForCarClass_005f0 = new org.apache.jsp.tag.web.tagForCarClass_tag();
    _jsp_getInstanceManager().newInstance(_jspx_th_tag_005ftagForCarClass_005f0);
    try {
      _jspx_th_tag_005ftagForCarClass_005f0.setJspContext(_jspx_page_context);
      // /aside.jsp(15,16) name = cl type = java.util.Collection reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
      _jspx_th_tag_005ftagForCarClass_005f0.setCl((java.util.Collection) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${CLASSES_LIST}", java.util.Collection.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      _jspx_th_tag_005ftagForCarClass_005f0.doTag();
    } finally {
      _jsp_getInstanceManager().destroyInstance(_jspx_th_tag_005ftagForCarClass_005f0);
    }
    return false;
  }
}
