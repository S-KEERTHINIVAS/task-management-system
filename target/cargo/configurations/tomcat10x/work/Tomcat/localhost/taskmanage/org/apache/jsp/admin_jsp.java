/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.0.16
 * Generated at: 2025-01-23 12:43:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Admin Dashboard</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            background-color: #f4f4f4;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        header {\n");
      out.write("            background: #333;\n");
      out.write("            color: white;\n");
      out.write("            padding: 1em;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container {\n");
      out.write("            display: flex;\n");
      out.write("            height: 100vh;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .sidebar {\n");
      out.write("            width: 20%;\n");
      out.write("            background: #333;\n");
      out.write("            color: white;\n");
      out.write("            padding: 10px;\n");
      out.write("            display: flex;\n");
      out.write("            flex-direction: column;\n");
      out.write("            gap: 10px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .sidebar a {\n");
      out.write("            text-decoration: none;\n");
      out.write("            color: white;\n");
      out.write("            padding: 10px;\n");
      out.write("            background: #444;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            text-align: center;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .sidebar a:hover {\n");
      out.write("            background: #555;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .content {\n");
      out.write("            flex: 1;\n");
      out.write("            padding: 20px;\n");
      out.write("            background: white;\n");
      out.write("            overflow-y: auto;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .hidden {\n");
      out.write("            display: none;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .active {\n");
      out.write("            display: block;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        table {\n");
      out.write("            width: 100%;\n");
      out.write("            border-collapse: collapse;\n");
      out.write("            margin-top: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        table,\n");
      out.write("        th,\n");
      out.write("        td {\n");
      out.write("            border: 1px solid #ddd;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        th,\n");
      out.write("        td {\n");
      out.write("            padding: 10px;\n");
      out.write("            text-align: left;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        th {\n");
      out.write("            background-color: #333;\n");
      out.write("            color: white;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .btn {\n");
      out.write("            padding: 8px 16px;\n");
      out.write("            margin: 5px 0;\n");
      out.write("            background-color: #333;\n");
      out.write("            color: white;\n");
      out.write("            text-decoration: none;\n");
      out.write("            border-radius: 5px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .btn:hover {\n");
      out.write("            background-color: #555;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <header>\n");
      out.write("        <h1>Admin Dashboard</h1>\n");
      out.write("    </header>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"sidebar\">\n");
      out.write("            <a onclick=\"showSection('assign-task')\">Assign Tasks</a>\n");
      out.write("            <a onclick=\"taskServlet()\">Task Responses (Pending)</a>\n");
      out.write("            <a onclick=\"completedtasks('task-status')\">Task Status</a>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"content\">\n");
      out.write("            <div id=\"assign-task\" class=\"hidden\">\n");
      out.write("                <h2>Assign Task</h2>\n");
      out.write("                <form onsubmit=\"taskassign(event)\">\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                <label for=\"user_id\">User ID:</label>\n");
      out.write("                                <input type=\"text\" id=\"user_id\" name=\"user_id\" required>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                <label for=\"task_name\">Task Title:</label>\n");
      out.write("                                <input type=\"text\" id=\"task_name\" name=\"task_name\" required>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                <label for=\"task_description\">Task Description:</label>\n");
      out.write("                                <input type=\"text\" id=\"task_description\" name=\"task_description\" required>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                <label for=\"due_date\">Task Deadline:</label>\n");
      out.write("                                <input type=\"date\" id=\"due_date\" name=\"due_date\" required>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                <center><button type=\"submit\" class=\"btn\">Create Task</button></center>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"pending-tasks\" class=\"hidden\">\n");
      out.write("                <!-- Pending tasks will be populated here dynamically -->\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("           \n");
      out.write("\n");
      out.write("            <div id=\"task-status\" class=\"hidden\">\n");
      out.write("               \n");
      out.write("            </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        function taskassign(event) {\n");
      out.write("            event.preventDefault();\n");
      out.write("\n");
      out.write("            const userId = document.getElementById('user_id').value;\n");
      out.write("            const taskName = document.getElementById('task_name').value;\n");
      out.write("            const taskDescription = document.getElementById('task_description').value;\n");
      out.write("            const dueDate = document.getElementById('due_date').value;\n");
      out.write("\n");
      out.write("            const xhr = new XMLHttpRequest();\n");
      out.write("            xhr.onreadystatechange = function () {\n");
      out.write("                if (xhr.readyState === 4) {\n");
      out.write("                    if (xhr.status === 200) {\n");
      out.write("                        alert('Task assigned successfully!');\n");
      out.write("                        document.getElementById('user_id').value = '';\n");
      out.write("                        document.getElementById('task_name').value = '';\n");
      out.write("                        document.getElementById('task_description').value = '';\n");
      out.write("                        document.getElementById('due_date').value = '';\n");
      out.write("                    } else {\n");
      out.write("                        alert('Error: Unable to assign task.');\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            };\n");
      out.write("\n");
      out.write("            xhr.open('POST', 'createTask.do', true);\n");
      out.write("            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');\n");
      out.write("            xhr.send(`user_id=${encodeURIComponent(userId)}&task_name=${encodeURIComponent(taskName)}&task_description=${encodeURIComponent(taskDescription)}&due_date=${encodeURIComponent(dueDate)}`);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function showSection(sectionId) {\n");
      out.write("            const sections = document.querySelectorAll('.content > div');\n");
      out.write("            sections.forEach((section) => {\n");
      out.write("                section.classList.add('hidden');\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            const section = document.getElementById(sectionId);\n");
      out.write("            if (section) {\n");
      out.write("                section.classList.remove('hidden');\n");
      out.write("                if (sectionId === 'pending-tasks') {\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function taskServlet() {\n");
      out.write("            const xhr = new XMLHttpRequest();\n");
      out.write("            xhr.onreadystatechange = function () {\n");
      out.write("                if (xhr.readyState === 4) {\n");
      out.write("                    const taskSection = document.getElementById(\"pending-tasks\");\n");
      out.write("                    if (xhr.status === 200) {\n");
      out.write("                        taskSection.innerHTML = xhr.responseText;\n");
      out.write("                        showSection(\"pending-tasks\");\n");
      out.write("                    } else {\n");
      out.write("                        taskSection.innerHTML = `<p style=\"color: red;\">Error fetching tasks. Please try again later.</p>`;\n");
      out.write("                        showSection(\"pending-tasks\");\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            };\n");
      out.write("\n");
      out.write("            xhr.open(\"GET\", `TaskServlet.do`, true);\n");
      out.write("            xhr.send();\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        // Show reassign modal\n");
      out.write("        function showReassignModal(taskId) {\n");
      out.write("            document.getElementById('reassign_task_id').value = taskId;\n");
      out.write("            document.getElementById('reassignModal').classList.remove('hidden');\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        // Close reassign modal\n");
      out.write("        function closeReassignModal() {\n");
      out.write("            document.getElementById('reassignModal').classList.add('hidden');\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        // Update task with new user ID\n");
      out.write("        function reassignTask(taskId) {\n");
      out.write("    // Get the new user ID from the input field\n");
      out.write("    const newUserId = document.getElementById('reassign_user_id' + taskId).value;\n");
      out.write("\n");
      out.write("    if (!newUserId) {\n");
      out.write("        alert('Please enter a valid User ID.');\n");
      out.write("        return;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    // Create a new XMLHttpRequest object\n");
      out.write("    const xhr = new XMLHttpRequest();\n");
      out.write("\n");
      out.write("    // Set up the request with the appropriate action\n");
      out.write("    xhr.open('POST', 'TaskReassign.do', true);\n");
      out.write("    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');\n");
      out.write("\n");
      out.write("    // Handle the response\n");
      out.write("    xhr.onreadystatechange = function () {\n");
      out.write("        if (xhr.readyState === 4) {\n");
      out.write("            if (xhr.status === 200) {\n");
      out.write("                alert('Task reassigned successfully!');\n");
      out.write("                // Optionally refresh the task list or perform other actions\n");
      out.write("                fetchPendingTasks();\n");
      out.write("            } else {\n");
      out.write("                alert(`Error: ${xhr.responseText}`);\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    };\n");
      out.write("\n");
      out.write("    // Send the request with taskId and newUserId as parameters\n");
      out.write("    const params = `action=reassignTask&task_id=${encodeURIComponent(taskId)}&user_id=${encodeURIComponent(newUserId)}`;\n");
      out.write("    xhr.send(params);\n");
      out.write("}\n");
      out.write("\n");
      out.write("function completedtasks() {\n");
      out.write("            const xhr = new XMLHttpRequest();\n");
      out.write("            xhr.onreadystatechange = function () {\n");
      out.write("                if (xhr.readyState === 4) {\n");
      out.write("                    const taskSection = document.getElementById(\"task-status\");\n");
      out.write("                    if (xhr.status === 200) {\n");
      out.write("                        taskSection.innerHTML = xhr.responseText;\n");
      out.write("                        showSection(\"task-status\");\n");
      out.write("                    } else {\n");
      out.write("                        taskSection.innerHTML = `<p style=\"color: red;\">Error fetching tasks. Please try again later.</p>`;\n");
      out.write("                        showSection(\"task-status\");\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            };\n");
      out.write("\n");
      out.write("            xhr.open(\"GET\", `completedtask.do`, true);\n");
      out.write("            xhr.send();\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("        ");
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
