package com.dqv.servlets;

import com.dqv.CValidaciones;
import com.dqv.conexion.DBConexion;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.driver.OracleSQLException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ezequ on 6/20/2016.
 */
@javax.servlet.annotation.WebServlet(name = "ServletInsert")
public class ServletInsert extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        DBConexion conexion = new DBConexion();
        CValidaciones validaciones = new CValidaciones();

        try {

            /**
             * Variables para las fecha de Registro y Actualizacion
             * */
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = sdf.parse(request.getParameter("txtFechaN"));
            /**
             * Query  de Insercccion de Personas a a la base de Datos, a traves del ORACLEPREPAREDSTATEMENT(OJO: no se hace en el servlet)
             * */

            String query = "INSERT INTO PERSONAS(NOMBRE, APELLIDO, CEDULA, CORREELECTRONICO,ESTADO, FECHANACIMIENTO,FECHAREGISTRO, FECHAACTUALIZACION) values (?,?,?,?,?,?,sysdate,sysdate)";
            //  String store = "{call SP_INSERTA_PERSONAS(?,?,?,?,?,?,sysdate,sysdate)}";
            /**
             * Obtencion de parametros del formulario  y envio a la base de Datos
             * */

            OraclePreparedStatement callableStatement = (OraclePreparedStatement) conexion.getConnection().prepareStatement(query);

            callableStatement.setString(1, request.getParameter("txtNombre"));
            callableStatement.setString(2, request.getParameter("txtApellido"));

            if (validaciones.validaExisteCedula(request.getParameter("txtCedula"))){
                callableStatement.setString(3, request.getParameter("txtCedula"));
            }else {
                //request.getRequestDispatcher("errorCedula.jsp").forward(request, response);
            }


            callableStatement.setString(4, request.getParameter("txtEmail"));
            callableStatement.setString(5,request.getParameter("cbEstado"));
            callableStatement.setDate(6, new java.sql.Date(fecha.getTime()));

            /**
             * Ejecucion del Query
             * */
            callableStatement.execute();
            callableStatement.close();
            request.setAttribute("mensaje", "Registro insertado Correctamente");
            request.getRequestDispatcher("exito.jsp").forward(request, response);

        } catch (OracleSQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        } finally {
            conexion.closeCon();
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getRequestDispatcher("insertar.jsp").forward(request, response);
    }
}
