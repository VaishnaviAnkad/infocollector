package com.AvirantEnterprises.InfoCollector_AE.service.business;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.sql.*;

@WebServlet("/submitTask")
@MultipartConfig
public class TaskAssignmentForm extends HttpServlet {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "your_password";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskName = request.getParameter("taskName");
        String taskDescription = request.getParameter("taskDescription");
        String taskDeadline = request.getParameter("taskDeadline");
        String assigneeName = request.getParameter("assigneeName");
        String assigneeEmail = request.getParameter("assigneeEmail");

        Part attachment = request.getPart("attachment");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "INSERT INTO tasks (taskName, taskDescription, taskDeadline, assigneeName, assigneeEmail, attachment) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, taskName);
            statement.setString(2, taskDescription);
            statement.setString(3, taskDeadline);
            statement.setString(4, assigneeName);
            statement.setString(5, assigneeEmail);

            InputStream inputStream = attachment.getInputStream();
            if (inputStream != null) {
                statement.setBlob(6, inputStream);
            }

            int rows = statement.executeUpdate();
            if (rows > 0) {
                out.println("<!DOCTYPE html>");
                out.println("<html lang='en'>");
                out.println("<head>");
                out.println("<meta charset='UTF-8'>");
                out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
                out.println("<title>Submission Success</title>");
                out.println("<style>");
                out.println("body { font-family: Arial, sans-serif; background-color: #f5f5f5; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }");
                out.println(".container { background: #fff; padding: 20px 30px; border-radius: 8px; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); text-align: center; width: 400px; }");
                out.println(".container h1 { color: #007bff; margin-bottom: 20px; }");
                out.println(".container p { font-size: 16px; margin-bottom: 20px; }");
                out.println(".btn { background-color: #007bff; color: white; padding: 10px; border: none; border-radius: 4px; cursor: pointer; font-size: 16px; text-decoration: none; }");
                out.println(".btn:hover { background-color: #0056b3; }");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class='container'>");
                out.println("<h1>Task Submitted Successfully!</h1>");
                out.println("<p>Your Task Assignment Form has been successfully submitted.</p>");
                out.println("<a href='dashboard.html' class='btn'>Return to Dashboard</a>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("Error: " + e.getMessage());
        }
    }
}
