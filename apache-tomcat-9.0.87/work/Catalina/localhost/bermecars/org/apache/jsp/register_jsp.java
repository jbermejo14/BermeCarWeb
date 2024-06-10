/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.87
 * Generated at: 2024-06-10 12:16:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\"/>\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <title>Bermecars</title>\n");
      out.write("\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n");
      out.write("          integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"\n");
      out.write("            integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<style>\n");
      out.write("body {\n");
      out.write("    font-family: \"Lato\", sans-serif;\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(".main-head{\n");
      out.write("    height: 150px;\n");
      out.write("    background: #FFF;\n");
      out.write("\n");
      out.write("}\n");
      out.write("\n");
      out.write(".sidenav {\n");
      out.write("    height: 100%;\n");
      out.write("    background-color: #000;\n");
      out.write("    overflow-x: hidden;\n");
      out.write("    padding-top: 20px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write(".main {\n");
      out.write("    padding: 0px 10px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("@media screen and (max-height: 450px) {\n");
      out.write("    .sidenav {padding-top: 15px;}\n");
      out.write("}\n");
      out.write("\n");
      out.write("@media screen and (max-width: 450px) {\n");
      out.write("    .login-form{\n");
      out.write("        margin-top: 10%;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .register-form{\n");
      out.write("        margin-top: 10%;\n");
      out.write("    }\n");
      out.write("}\n");
      out.write("\n");
      out.write("@media screen and (min-width: 768px){\n");
      out.write("    .main{\n");
      out.write("        margin-left: 40%;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .sidenav{\n");
      out.write("        width: 40%;\n");
      out.write("        position: fixed;\n");
      out.write("        z-index: 1;\n");
      out.write("        top: 0;\n");
      out.write("        left: 0;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .login-form{\n");
      out.write("        margin-top: 10%;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write(".login-main-text{\n");
      out.write("    margin-top: 20%;\n");
      out.write("    padding: 60px;\n");
      out.write("    color: #fff;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".login-main-text h2{\n");
      out.write("    font-weight: 300;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".btn-black{\n");
      out.write("    background-color: #000 !important;\n");
      out.write("    color: #fff;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("<link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n");
      out.write("<script src=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>\n");
      out.write("<script src=\"//code.jquery.com/jquery-1.11.1.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("$(document).ready(function() {\n");
      out.write("    $(\"form\").on(\"submit\", function(event) {\n");
      out.write("        event.preventDefault();\n");
      out.write("        const formValue = $(this).serialize();\n");
      out.write("        $.ajax(\"register\", {\n");
      out.write("            type: \"POST\",\n");
      out.write("            data: formValue,\n");
      out.write("            statusCode: {\n");
      out.write("                200: function(response) {\n");
      out.write("                    if (response === \"ok\") {\n");
      out.write("                        window.location.href = \"/bermecars\";\n");
      out.write("                    } else {\n");
      out.write("                        $(\"#result\").html(response);\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("});\n");
      out.write("</script>\n");
      out.write("<div class=\"sidenav\">\n");
      out.write("         <div class=\"login-main-text\">\n");
      out.write("            <h2>Bermecars<br></h2>\n");
      out.write("            <p>Necesitas una cuenta para acceder</p>\n");
      out.write("         </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"main\">\n");
      out.write("         <div class=\"col-md-12 col-sm-12\">\n");
      out.write("            <div class=\"login-form\">\n");
      out.write("                <form class=\"p-5\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <input type=\"text\" name=\"telephone\" class=\"form-control\" id=\"floatingTelephone\" placeholder=\"Telephone\">\n");
      out.write("                        <label for=\"floatingInput\">Telefono</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <input type=\"text\" name=\"email\" class=\"form-control\" id=\"floatingEmail\" placeholder=\"Email\">\n");
      out.write("                        <label for=\"floatingInput\">Email</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group py-2\">\n");
      out.write("                        <input type=\"text\" name=\"username\" class=\"form-control\" id=\"floatingInput\" placeholder=\"Usuario\">\n");
      out.write("                        <label for=\"floatingInput\">Usuario</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <input type=\"password\" name=\"password\" class=\"form-control\" id=\"floatingPassword\" placeholder=\"Contraseña\">\n");
      out.write("                        <label for=\"floatingPassword\">Contraseña</label>\n");
      out.write("                    </div>\n");
      out.write("                    <button class=\"btn btn-black w-100\" type=\"submit\">Registrarse</button>\n");
      out.write("                    <p class=\"h5 fw-normal\"><a href=\"login.jsp\" class=\"nav-link\">¿Tienes ya cuenta? Inicia Sesión!</a></p>\n");
      out.write("                </form>\n");
      out.write("                <div id=\"result\"></div>\n");
      out.write("            </div>\n");
      out.write("         </div>\n");
      out.write("      </div>\n");
      out.write("</main>");
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