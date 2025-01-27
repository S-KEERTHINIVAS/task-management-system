package com.task.MainPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/TaskReassign.do")
public class TaskReassign extends HttpServlet {
    private static final String DB_URL = "jdbc:mariadb://127.0.0.1:3311/taskmanage";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("reassignTask".equals(action)) {
            // Get parameters from request
            int taskId;
            String userId;

            try {
                taskId = Integer.parseInt(request.getParameter("task_id"));
                userId = request.getParameter("user_id");
            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("Invalid task ID.");
                return;
            }

            // Database queries
            String updateTaskQuery = "UPDATE task_management SET user_id = ? WHERE task_id = ?";
            String resetStatusQuery = "UPDATE task_respons SET status = 0 WHERE task_id = ?";

            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement updateStmt = conn.prepareStatement(updateTaskQuery);
                 PreparedStatement resetStatusStmt = conn.prepareStatement(resetStatusQuery)) {

                // Set query parameters and execute updates
                updateStmt.setString(1, userId);
                updateStmt.setInt(2, taskId);
                int rowsUpdated = updateStmt.executeUpdate();

                if (rowsUpdated > 0) {
                    resetStatusStmt.setInt(1, taskId);
                    resetStatusStmt.executeUpdate();

                    // Success response
                    response.setStatus(HttpServletResponse.SC_OK);
                    response.getWriter().write("Task reassigned successfully!");
                } else {
                    // Task not found
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    response.getWriter().write("Task not found or invalid task ID.");
                }

            } catch (SQLException e) {
                // Log and send error response
                e.printStackTrace();
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().write("Error reassigning task: " + e.getMessage());
            }
        } else {
            // Invalid action
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Invalid action.");
        }
    }
}
