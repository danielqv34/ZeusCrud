package com.dqv.servlets;

import com.dqv.beans.BeanPersona;
import com.dqv.conexion.DBConexion;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.driver.OracleSQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ezequ on 6/21/2016.
 */
@WebServlet(name = "ServletUpdate")
public class ServletUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBConexion conexion = new DBConexion();


        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = sdf.parse(request.getParameter("txtFechaN"));

            String query = "update personas set NOMBRE=?,APELLIDO=?,CEDULA=?,CORREELECTRONICO=?,ESTADO=?,FECHANACIMIENTO=?,FECHAACTUALIZACION=sysdate where ID=?";
            OraclePreparedStatement preparedStatement = (OraclePreparedStatement) conexion.getConnection().prepareStatement(query);
            preparedStatement.setString(1, request.getParameter("txtNombre"));
            preparedStatement.setString(2, request.getParameter("txtApellido"));
            preparedStatement.setString(3, request.getParameter("txtCedula"));
            preparedStatement.setString(4, request.getParameter("txtEmail"));
            preparedStatement.setString(5, request.getParameter("cbEstado"));
            preparedStatement.setDate(6, new java.sql.Date(fecha.getTime()));
            preparedStatement.setString(7, request.getParameter("txtID"));
            preparedStatement.execute();

            preparedStatement.close();
            request.getRequestDispatcher("consultar.jsp").forward(request, response);


        } catch (OracleSQLException ex) {
            ex.printStackTrace();
            System.out.println("Error con papa Oracle " + ex.getMessage());
        } catch (SQLDataException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
            ex.getMessage();
        } finally {
            conexion.closeCon();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBConexion conexion = new DBConexion();

        try {
            String query = "select * from personas where id=? order by ID asc";
            OraclePreparedStatement preparedStatement = (OraclePreparedStatement) conexion.getConnection().prepareStatement(query);
            preparedStatement.setString(1, request.getParameter("id"));

            OracleResultSet resultSet = (OracleResultSet) preparedStatement.executeQuery();

            BeanPersona persona = new BeanPersona();
            while (resultSet.next()) {
                persona.setId(resultSet.getInt("ID"));
                persona.setNombre(resultSet.getString("NOMBRE"));
                persona.setApellido(resultSet.getString("APELLIDO"));
                persona.setCedula(resultSet.getString("CEDULA"));
                persona.setCorreoElectronico(resultSet.getString("CORREELECTRONICO"));
                persona.setEstado(resultSet.getString("ESTADO"));
                persona.setFechaNacimiento(resultSet.getDate("FECHANACIMIENTO"));
                persona.setFechaRegistro(resultSet.getDate("FECHAREGISTRO"));
                persona.setFechaActualizacion(resultSet.getDate("FECHAACTUALIZACION"));

            }
            preparedStatement.close();
            resultSet.close();

            request.setAttribute("persona", persona);
            request.getRequestDispatcher("actualizar.jsp").forward(request, response);

        } catch (SQLDataException ex) {
            ex.printStackTrace();
        } catch (OracleSQLException ex) {
            ex.printStackTrace();
            System.out.println("Error de Oracle " + ex.getMessage());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
