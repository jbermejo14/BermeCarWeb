/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.87
 * Generated at: 2024-05-20 19:23:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.bermecar.dao.Database;
import com.bermecar.dao.UserDao;
import com.bermecar.domain.User;
import java.util.List;

public final class list_002dusers_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/includes/header.jsp", Long.valueOf(1716230742000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(4);
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.bermecar.dao.Database");
    _jspx_imports_classes.add("com.bermecar.dao.UserDao");
    _jspx_imports_classes.add("com.bermecar.domain.User");
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\"/>\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <title>Bermecars</title>\r\n");
      out.write("\r\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n");
      out.write("          integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"\r\n");
      out.write("            integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write("    header{\r\n");
      out.write("        background-color: #000 !important;\r\n");
      out.write("        color: #fff;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");

    HttpSession currentSession = request.getSession();
    String role = "anonymous";
    int userId = 0;
    if (currentSession.getAttribute("role") != null) {
        role = currentSession.getAttribute("role").toString();
    }
    if (currentSession.getAttribute("id") != null) {
        userId = Integer.parseInt(currentSession.getAttribute("id").toString());
    }

      out.write("\r\n");
      out.write("<header>\r\n");

    if (role.equals("user")) {

      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class=\"navbar bg-black shadow-sm\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <ul class=\"nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0\">\r\n");
      out.write("              <li><a href=\"/bermecars\" class=\"nav-link px-2 text-secondary\">Home</a></li>\r\n");
      out.write("              <li><a href=\"reservation.jsp\" class=\"nav-link px-2 text-white\">Reservas</a></li>\r\n");
      out.write("              <li><a href=\"user-profile.jsp\" class=\"nav-link px-2 text-white\">Perfil</a></li>\r\n");
      out.write("        </div>\r\n");
      out.write("        <button type=\"button\" class=\"btn btn-outline-light me-5\"><a href=\"logout\" title=\"logout\" class=\"text-white text-decoration-none\">Logout</a></button>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");

    } if (role.equals("admin")){

      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class=\"navbar shadow-sm\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <ul class=\"nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0\">\r\n");
      out.write("              <li><a href=\"/bermecars\" class=\"nav-link px-2 text-secondary\">Home</a></li>\r\n");
      out.write("              <li><a href=\"reservation.jsp\" class=\"nav-link px-2 text-white\">Reservas</a></li>\r\n");
      out.write("              <li><a href=\"user-profile.jsp\" class=\"nav-link px-2 text-white\">Perfil</a></li>\r\n");
      out.write("              <li><a href=\"list-users.jsp\" class=\"nav-link px-2 text-white\">Usuarios</a></li>\r\n");
      out.write("              <li><a href=\"edit-car.jsp\" class=\"nav-link px-2 text-white\">Editar</a></li>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <button type=\"button\" class=\"btn btn-outline-light text-white me-2 mr-2\"><a href=\"logout\" title=\"logout\" class=\"text-decoration-none\">Logout</a></button>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");

    }

      out.write("\r\n");
      out.write("</header>");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("    .btn-black{\r\n");
      out.write("        background-color: #000 !important;\r\n");
      out.write("        color: #fff;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("    $(document).ready(function () {\r\n");
      out.write("      $(\"#search-input\").focus();\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
      out.write("<main>\r\n");
      out.write("    <section class=\"py-5 text-center container\">\r\n");
      out.write("        <h1>Usuarios</h1>\r\n");
      out.write("    </section>\r\n");
      out.write("    <section class=\"py-5 text-center container\">\r\n");
      out.write("        <form class=\"row g-2\" id=\"search-form\" method=\"GET\">\r\n");
      out.write("            <div class=\"mb-1 col\">\r\n");
      out.write("                <input type=\"text\" class=\"form-control\" placeholder=\"Búsqueda\" name=\"search\" id=\"search-input\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-auto\">\r\n");
      out.write("                <button type=\"submit\" class=\"btn btn-black mb-3\" id=\"search-button\">Buscar</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("    </section>\r\n");
      out.write("        ");

            String search = "";
            if (request.getParameter("search") != null)
                search = request.getParameter("search");

            Database.connect();
            List<User> users = null;
            if (search.isEmpty()) {
                users = Database.jdbi.withExtension(UserDao.class, dao -> dao.getAllUsers());
            } else {
                final String searchTerm = search;
                users = Database.jdbi.withExtension(UserDao.class, dao -> dao.getUsers(searchTerm));
            }
                for (User user : users) {
        
      out.write("\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"list-group\">\r\n");
      out.write("            <a href=\"add-users.jsp?id=");
      out.print( user.getId() );
      out.write("\" type=\"button\" class=\"btn btn-sm btn-black m-2\">\r\n");
      out.write("                <div class=\"d-flex w-100 justify-content-between\">\r\n");
      out.write("                    <h6 class=\"mb-1\">User Nº: ");
      out.print(user.getId());
      out.write("</h6>\r\n");
      out.write("                    <p class=\"mb-1\">");
      out.print(user.getUsername());
      out.write("</p>\r\n");
      out.write("                    <p class=\"mb-1\">");
      out.print(user.getRole());
      out.write("</p>\r\n");
      out.write("                </div>\r\n");
      out.write("            </a>\r\n");
      out.write("            ");

                }
            
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</main>\r\n");
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
