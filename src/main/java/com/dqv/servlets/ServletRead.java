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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ezequ on 6/21/2016.
 */
@WebServlet(name = "ServletRead")
public class ServletRead extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBConexion conexion = new DBConexion();
        try {

            String query = "select * from personas order by ID ASC";

            OraclePreparedStatement preparedStatement = (OraclePreparedStatement) conexion.getConnection().prepareStatement(query);
            OracleResultSet resultSet = (OracleResultSet) preparedStatement.executeQuery();

            Collection<BeanPersona> personaList = new ArrayList<BeanPersona>();

            while (resultSet.next()) {

                BeanPersona persona = new BeanPersona();
                persona.setId(resultSet.getInt("ID"));
                persona.setNombre(resultSet.getString("NOMBRE"));
                persona.setApellido(resultSet.getString("APELLIDO"));
                persona.setCedula(resultSet.getString("CEDULA"));
                persona.setCorreoElectronico(resultSet.getString("CORREELECTRONICO"));
                persona.setEstado(resultSet.getString("ESTADO"));
                persona.setFechaNacimiento(resultSet.getDate("FECHANACIMIENTO"));
                persona.setFechaRegistro(resultSet.getDate("FECHAREGISTRO"));
                persona.setFechaActualizacion(resultSet.getDate("FECHAACTUALIZACION"));

                personaList.add(persona);

            }
            preparedStatement.close();
            resultSet.close();

            request.setAttribute("personaList", personaList);
            request.getRequestDispatcher("consultar.jsp").forward(request, response);

        } catch (OracleSQLException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            conexion.closeCon();
        }

    }
}
