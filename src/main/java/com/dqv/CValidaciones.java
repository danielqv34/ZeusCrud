package com.dqv;

import com.dqv.conexion.DBConexion;
import oracle.jdbc.OracleResultSet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ezequ on 9/24/2016.
 */
public class CValidaciones {

    DBConexion conexion = new DBConexion();
    PreparedStatement statement;
    OracleResultSet resultSet;


    public boolean validaExisteCedula(String cedula) throws SQLException {
        boolean cuentaCedula = false;

        try {
            String consulta = "SELECT 'S' FROM PERSONAS WHERE CEDULA = ?";
            resultSet = (OracleResultSet) conexion.getConnection().prepareStatement(consulta);
            while (!resultSet.next()) {
                cuentaCedula = true;
            }
            if (cuentaCedula){
                System.out.println("Registro Insertado");
            }else {
                System.out.println("Ya existe este registro");
            }

        } catch (SQLException ex) {
            ex.getMessage();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return cuentaCedula;
    }
}
