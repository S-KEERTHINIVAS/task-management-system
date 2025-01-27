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

@WebServlet("/createTask.do")
public class task extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userid = req.getParameter("user_id");
        String taskname = req.getParameter("task_name");
        String taskdescription = req.getParameter("task_description");
        String taskdeadline = req.getParameter("due_date");
        int a=0;
        Connection con = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3311/taskmanage", "root", "root");

            PreparedStatement ps = con.prepareStatement("insert into task_management (task_name,task_description,user_id,task_deadline) values (?,?,?,?)");
            PreparedStatement sp=con.prepareStatement("insert into task_respons (status) value(?)");
            ps.setString(1, taskname);
            ps.setString(2, taskdescription);
            ps.setString(3, userid);
            ps.setString(4, taskdeadline);
            sp.setInt(1, a);

            ps.executeQuery();
            sp.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
