package com.dqv.servlets;


import com.dqv.conexion.DBConexion;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.driver.OracleSQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLDataException;
import java.sql.SQLException;/**
 * Created by ezequ on 6/21/2016.
 */
@WebServlet(name = "ServletDelete")
public class ServletDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBConexion conexion = new DBConexion();

        try {
            String query = "delete from personas where ID = ?";
            OraclePreparedStatement preparedStatement = (OraclePreparedStatement) conexion.getConnection().prepareStatement(query);
            preparedStatement.setString(1, request.getParameter("id"));
            preparedStatement.execute();
            preparedStatement.close();

            request.getRequestDispatcher("eliminar.jsp").forward(request, response);


        } catch (OracleSQLException ex) {
            ex.printStackTrace();
            System.out.println("Error de ejecucion en Oracle " + ex.getMessage());
        } catch (SQLDataException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }

    }
}

