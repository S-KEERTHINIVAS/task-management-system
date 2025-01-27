package com.task.MainPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/TaskServlet.do")
public class TaskServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        try (Connection conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3311/taskmanage", "root", "root")) {
            String query = "SELECT tm.task_id, tm.task_name, tm.user_id, tr.reason " +
                           "FROM task_management tm " +
                           "JOIN task_respons tr ON tm.task_id = tr.task_id WHERE tr.status = -1";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            PrintWriter out = response.getWriter();
            out.println("<h2>Task Responses</h2>");
            out.println("<table>");
            out.println("<tr><th>Task Name</th><th>User ID</th><th>Rejected Reason</th><th>Action</th></tr>");

            while (rs.next()) {
                int taskId = rs.getInt("task_id");
                String taskName = rs.getString("task_name");
                String userId = rs.getString("user_id");
                String reason = rs.getString("reason");

                out.println("<tr>");
                out.println("<td>" + taskName + "</td>");
                out.println("<td>" + userId + "</td>");
                out.println("<td>" + reason + "</td>");
                out.println("<td>");
                out.println("<input type='text' id='reassign_user_id" + taskId + "' placeholder='Enter User ID'>");
                out.println("<button onclick=\"reassignTask('" + taskId + "')\">Assign</button>");
                out.println("</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

}

    


