package com.task.MainPackage;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/signin.do")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userid = req.getParameter("user_id");
        String userpassword = req.getParameter("user_password");

        Connection con = null;
        RequestDispatcher dispatcher = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3311/taskmanage", "root", "root");

            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE user_id = ? AND user_password = ?");
            ps.setString(1, userid);
            ps.setString(2, userpassword);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");

                HttpSession session = req.getSession();
                session.setAttribute("userid", rs.getString("user_id"));
                session.setAttribute("role", role);

                if ("admin".equalsIgnoreCase(role)) {
                    dispatcher = req.getRequestDispatcher("admin.jsp");
                } else if ("user".equalsIgnoreCase(role)){
                    dispatcher = req.getRequestDispatcher("user.jsp");
                }
            } else {
                req.setAttribute("status", "failed");
                dispatcher = req.getRequestDispatcher("login.jsp");
            }

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

        if (dispatcher != null) {
            dispatcher.forward(req, resp);
        }
    }
}
