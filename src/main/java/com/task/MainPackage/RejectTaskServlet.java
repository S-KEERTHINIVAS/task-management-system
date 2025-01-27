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

@WebServlet("/rejectTaskServlet.do")
public class RejectTaskServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int taskid = Integer.parseInt(req.getParameter("task_id"));
        String reason = req.getParameter("reason");

        try (Connection con = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3311/taskmanage", "root", "root")) {
            PreparedStatement ps = con.prepareStatement("UPDATE task_respons SET status = '-1', reason = ? WHERE task_id = ?");
            ps.setString(1, reason);
            ps.setInt(2, taskid);
            int rows = ps.executeUpdate();

            resp.setContentType("text/plain");
            if (rows > 0) {
                resp.getWriter().write("Success");
            } else {
                resp.getWriter().write("Failure");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resp.getWriter().write("Error");
        }
    }
}
