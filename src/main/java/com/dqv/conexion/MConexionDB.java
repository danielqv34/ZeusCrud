package com.dqv.conexion;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by ezequ on 7/9/2016.
 */
public class MConexionDB {
    private final String url = "jdbc:mysql://localhost:3306/springcrud";
    private final String user = "dquiroz";
    private final String pass = "abc123";
    Connection connection = null;

    public MConexionDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(url,user,pass);
            System.out.println("Conexion Exitosa");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public Connection conectarMySQL(){
        return connection;
    }


}
