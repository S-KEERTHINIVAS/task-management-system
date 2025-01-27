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

@WebServlet("/completedtask.do")
public class completedtask extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try (Connection con = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3311/taskmanage", "root", "root")) {
            String query = "SELECT tm.task_name, tm.task_description, tm.user_id,tm.updated_at " +
                           "FROM task_management tm " +
                           "JOIN task_respons tr ON tr.task_id = tm.task_id " +
                           "WHERE tm.comple_status = 1 AND tr.status = 1";

            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            out.println("<h2>Completed Tasks</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>Task Name</th><th>Task Description</th><th>User ID</th><th>Completed Date</th></tr>");

            boolean hasResults = false;
            while (rs.next()) {
                hasResults = true;
                out.println("<tr>");
                out.println("<td>" + rs.getString("task_name") + "</td>");
                out.println("<td>" + rs.getString("task_description") + "</td>");
                out.println("<td>" + rs.getString("user_id") + "</td>");
                out.println("<td>" + rs.getString("updated_at") + "</td>");
                out.println("</tr>");
            }

            if (!hasResults) {
                out.println("<tr><td colspan='3'>No completed tasks found.</td></tr>");
            }

            out.println("</table>");
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<p>Error fetching tasks: " + e.getMessage() + "</p>");
        }
    }
}
