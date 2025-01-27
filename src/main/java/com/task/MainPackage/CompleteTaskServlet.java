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

@WebServlet("/CompleteTaskServlet.do")
public class CompleteTaskServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String taskId = req.getParameter("task_id");

        resp.setContentType("text/plain");
        if (taskId == null || taskId.isEmpty()) {
            resp.getWriter().write("Invalid task ID");
            return;
        }

        try (Connection con = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3311/taskmanage", "root", "root")) {
            String query = "UPDATE task_management SET comple_status = 1, updated_at = CURRENT_TIMESTAMP WHERE task_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(taskId));

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                resp.getWriter().write("Task marked as completed successfully.");
            } else {
                resp.getWriter().write("Failed to update task. Task ID may not exist.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resp.getWriter().write("An error occurred while updating the task.");
        }
    }
}
