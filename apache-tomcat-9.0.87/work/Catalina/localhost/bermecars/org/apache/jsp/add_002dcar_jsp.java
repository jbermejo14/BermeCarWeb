/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.87
 * Generated at: 2024-06-10 12:15:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.bermecar.domain.Car;
import com.bermecar.dao.CarDao;
import com.bermecar.dao.Database;

public final class add_002dcar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/includes/header.jsp", Long.valueOf(1717496454000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(3);
    _jspx_imports_classes.add("com.bermecar.dao.Database");
    _jspx_imports_classes.add("com.bermecar.dao.CarDao");
    _jspx_imports_classes.add("com.bermecar.domain.Car");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
      out.write("    header{\n");
      out.write("        background-color: #000 !important;\n");
      out.write("        color: #fff;\n");
      out.write("    }\n");
      out.write("</style>\n");

    HttpSession currentSession = request.getSession();
    String role = "anonymous";
    int userId = 0;
    if (currentSession.getAttribute("role") != null) {
        role = currentSession.getAttribute("role").toString();
    }
    if (currentSession.getAttribute("id") != null) {
        userId = Integer.parseInt(currentSession.getAttribute("id").toString());
    }

      out.write("\n");
      out.write("<header>\n");

    if (role.equals("user")) {

      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"navbar bg-black shadow-sm\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <ul class=\"nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0\">\n");
      out.write("              <li><a href=\"/bermecars\" class=\"nav-link px-2 text-secondary\">Home</a></li>\n");
      out.write("              <li><a href=\"reservation.jsp\" class=\"nav-link px-2 text-white\">Reservas</a></li>\n");
      out.write("              <li><a href=\"view-profile.jsp\" class=\"nav-link px-2 text-white\">Perfil</a></li>\n");
      out.write("        </div>\n");
      out.write("        <button type=\"button\" class=\"btn btn-outline-light me-5 text-white\"><a href=\"logout\" title=\"logout\" class=\"text-white text-decoration-none\">Logout</a></button>\n");
      out.write("    </div>\n");
      out.write("\n");

    } if (role.equals("admin")){

      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"navbar shadow-sm\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <ul class=\"nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0\">\n");
      out.write("              <li><a href=\"/bermecars\" class=\"nav-link px-2 text-secondary\">Home</a></li>\n");
      out.write("              <li><a href=\"list-reservations.jsp\" class=\"nav-link px-2 text-white\">Reservas</a></li>\n");
      out.write("              <li><a href=\"view-profile.jsp\" class=\"nav-link px-2 text-white\">Perfil</a></li>\n");
      out.write("              <li><a href=\"list-users.jsp\" class=\"nav-link px-2 text-white\">Usuarios</a></li>\n");
      out.write("              <li><a href=\"add-car.jsp\" class=\"nav-link px-2 text-white\">Coches</a></li>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <button type=\"button\" class=\"btn btn-outline-light text-white me-2 mr-2\"><a href=\"logout\" title=\"logout\" class=\"text-decoration-none\">Logout</a></button>\n");
      out.write("    </div>\n");
      out.write("\n");

    }

      out.write("\n");
      out.write("</header>");
      out.write("\n");
      out.write("<style>\n");
      out.write("    .btn-black{\n");
      out.write("        background-color: #000 !important;\n");
      out.write("        color: #fff;\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("<script>\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        $(\"#edit-button\").click(function (event) {\n");
      out.write("            event.preventDefault();\n");
      out.write("            const form = $(\"#edit-form\")[0];\n");
      out.write("            const data = new FormData(form);\n");
      out.write("\n");
      out.write("            $(\"#edit-button\").prop(\"disabled\", true);\n");
      out.write("\n");
      out.write("            $.ajax({\n");
      out.write("                type: \"POST\",\n");
      out.write("                enctype: \"multipart/form-data\",\n");
      out.write("                url: \"add-car\",\n");
      out.write("                data: data,\n");
      out.write("                processData: false,\n");
      out.write("                contentType: false,\n");
      out.write("                cache: false,\n");
      out.write("                timeout: 600000,\n");
      out.write("                success: function (data) {\n");
      out.write("                    $(\"#result\").html(data);\n");
      out.write("                    $(\"#name\").value(\"\");\n");
      out.write("                    $(\"#edit-button\").prop(\"disabled\", false);\n");
      out.write("                },\n");
      out.write("                error: function (error) {\n");
      out.write("                    $(\"#result\").html(error.responseText);\n");
      out.write("                    $(\"#edit-button\").prop(\"disabled\", false);\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("\n");

    if (!role.equals("admin")) {
        response.sendRedirect("/bermecars");
    }
    int id;
    Car car = null;
    if (request.getParameter("id") == null) {
        id = 0;
    } else {
        id = Integer.parseInt(request.getParameter("id"));
        Database.connect();
        car = Database.jdbi.withExtension(CarDao.class, dao -> dao.getCar(id));
    }

      out.write("\n");
      out.write("\n");
      out.write("<main>\n");
      out.write("    <section class=\"py-5 container\">\n");
      out.write("        <h1>Registrar nuevo Coche</h1>\n");
      out.write("        <form class=\"row g-3 needs-validation\" method=\"post\" enctype=\"multipart/form-data\" id=\"edit-form\">\n");
      out.write("            <div class=\"mb-3\">\n");
      out.write("                <label for=\"brand\" class=\"form-label\">Marca</label>\n");
      out.write("                <input type=\"text\" name=\"brand\" class=\"form-control\" id=\"brand\" value=\"Marca\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"mb-3\">\n");
      out.write("                <label for=\"model\" class=\"form-label\">Modelo</label>\n");
      out.write("                <input type=\"text\" name=\"model\" class=\"form-control\" id=\"model\" value=\"Modelo\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"mb-3\">\n");
      out.write("                <label for=\"license_plate\" class=\"form-label\">Matricula</label>\n");
      out.write("                <input type=\"text\" name=\"license_plate\" class=\"form-control\" id=\"license_plate\"\n");
      out.write("                    value=\"XXXX-XXX\">\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"mb-3\">\n");
      out.write("                <label for=\"country\" class=\"form-label\">Pais</label>\n");
      out.write("                <input type=\"text\" name=\"country\" class=\"form-control\" id=\"country\" value=\"Pais\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"mb-3\">\n");
      out.write("                <label for=\"year\" class=\"form-label\">Año</label>\n");
      out.write("                <input type=\"number\" name=\"year\" class=\"form-control\" id=\"year\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"mb-3\">\n");
      out.write("                <label for=\"price\" class=\"form-label\">Precio</label>\n");
      out.write("                <input type=\"number\" name=\"price\" class=\"form-control\" id=\"price\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-12\">\n");
      out.write("                <button class=\"btn btn-black w-100\" id=\"edit-button\" type=\"submit\">Enviar</button>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("        <div id=\"result\"></div>\n");
      out.write("    </section>\n");
      out.write("</main>\n");
      out.write("\n");
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
