package com.task.MainPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/fetchTasksServlet.do")
public class FetchTasksServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        // Get user ID from session
        String userid = (String) req.getSession().getAttribute("userid");
        if (userid == null) {
            out.println("<p>User not logged in or session expired.</p>");
            return;
        }

        try (Connection con = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3311/taskmanage", "root", "root")) {
            String query = "SELECT tm.task_id, tm.task_name, tm.task_deadline, tm.task_description FROM task_management tm JOIN task_respons tr ON tr.task_id = tm.task_id WHERE tm.user_id = ? AND tm.comple_status = 0 AND tr.status = 0";
            
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, userid);
            ResultSet rs = ps.executeQuery();

            if (!rs.isBeforeFirst()) { // Check if ResultSet is empty
                out.println("<p>No tasks found for this user.</p>");
                return;
            }

            out.println("<h2>Tasks</h2>");
            out.println("<table>");
            out.println("<tr><th>Task Name</th><th>Task Description</th><th>Task Deadline</th><th>Actions</th></tr>");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString("task_name") + "</td>");
                out.println("<td>" + rs.getString("task_description") + "</td>");
                out.println("<td>" + rs.getTimestamp("task_deadline") + "</td>");
                out.println("<td>");
                out.println("<button onclick=\"acceptTask('" + rs.getInt("task_id") + "')\">Accept</button>");
                out.println("<button onclick=\"showRejectReason('" + rs.getInt("task_id") + "')\">Reject</button>");
                out.println("<div id='reject-reason-" + rs.getInt("task_id") + "' style='display:none;'>");
                out.println("<textarea id='reason-" + rs.getInt("task_id") + "' placeholder='Enter rejection reason'></textarea>");
                out.println("<button onclick=\"submitRejection('" + rs.getInt("task_id") + "')\">Submit</button>");
                out.println("</div>");
                out.println("</td>");
                out.println("</tr>");
            }

            out.println("</table>");
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<p>Error fetching tasks. Please try again later.</p>");
        }
    }
}



