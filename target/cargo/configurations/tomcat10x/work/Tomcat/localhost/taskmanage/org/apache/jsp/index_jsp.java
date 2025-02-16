/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.0.16
 * Generated at: 2025-01-23 12:42:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
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

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
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

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
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

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>SIGNUP PAGE</title>\n");
      out.write("    <style>\n");
      out.write("        /* Body styling */\n");
      out.write("        body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            background-color: #333; /* Dark gray background */\n");
      out.write("            color: #f4f4f4; /* Light text color */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Center alignment for header and form */\n");
      out.write("        center {\n");
      out.write("            text-align: center;\n");
      out.write("            margin-top: 50px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Header styling */\n");
      out.write("        u {\n");
      out.write("            font-size: 1.8em;\n");
      out.write("            color: #f4f4f4; /* Light gray for the underline */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Table styling */\n");
      out.write("        table {\n");
      out.write("            margin: auto;\n");
      out.write("            border-spacing: 10px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        td {\n");
      out.write("            padding: 10px;\n");
      out.write("            color: #f4f4f4; /* Light text for table cells */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        label {\n");
      out.write("            font-size: 1em;\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Input fields */\n");
      out.write("        input[type=\"number\"],\n");
      out.write("        input[type=\"password\"] {\n");
      out.write("            width: 200px;\n");
      out.write("            padding: 10px;\n");
      out.write("            border: 1px solid #444; /* Border in a slightly lighter gray */\n");
      out.write("            border-radius: 5px;\n");
      out.write("            background-color: #555; /* Input background */\n");
      out.write("            color: #f4f4f4; /* Text color */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input[type=\"number\"]:focus,\n");
      out.write("        input[type=\"password\"]:focus {\n");
      out.write("            outline: none;\n");
      out.write("            border-color: #777; /* Slightly lighter border on focus */\n");
      out.write("            background-color: #666; /* Lighter gray on focus */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Button styling */\n");
      out.write("        button {\n");
      out.write("            width: 100px;\n");
      out.write("            padding: 10px;\n");
      out.write("            font-size: 1em;\n");
      out.write("            font-weight: bold;\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            color: #f4f4f4; /* White text color */\n");
      out.write("            cursor: pointer;\n");
      out.write("            background-color: #555; /* Button gray background */\n");
      out.write("            transition: background-color 0.3s ease; /* Smooth hover effect */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        button:hover {\n");
      out.write("            background-color: #777; /* Lighter gray on hover */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Special button for signup */\n");
      out.write("        button[type=\"submit\"] {\n");
      out.write("            background-color: #d9534f; /* Red background */\n");
      out.write("            color: #f4f4f4; /* Light text */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        button[type=\"submit\"]:hover {\n");
      out.write("            background-color: #c9302c; /* Darker red on hover */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Responsive design for smaller screens */\n");
      out.write("        @media (max-width: 600px) {\n");
      out.write("            input[type=\"number\"],\n");
      out.write("            input[type=\"password\"] {\n");
      out.write("                width: 100%; /* Full width on small screens */\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            button {\n");
      out.write("                width: 100%; /* Full width buttons */\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            table {\n");
      out.write("                border-spacing: 5px; /* Smaller spacing */\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <center>\n");
      out.write("        <form action=\"signin.do\" method=\"POST\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td><label>ID:</label></td>\n");
      out.write("                    <td><input type=\"number\" name=\"user_id\" placeholder=\"Enter your ID\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><label>Password:</label></td>\n");
      out.write("                    <td><input type=\"password\" name=\"user_password\" placeholder=\"Enter your password\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td></td>\n");
      out.write("                    <td>\n");
      out.write("                        <br>\n");
      out.write("                        <button type=\"submit\">SIGNUP</button>\n");
      out.write("                        <br><br>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("    </center>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
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
