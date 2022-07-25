/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author reroes
 */
public class Enlace {

    private Connection conn;

    public void establecerConexion() {

        try {
            // db parameters  
            String url = "jdbc:sqlite:bd/base01.bd";
            // create a connection to the database  
            conn = DriverManager.getConnection(url);
            // System.out.println(conn.isClosed());
            // System.out.println("Connection to SQLite has been established.");  

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Connection obtenerConexion() {
        return conn;
    }

    public void insertarTrabajadores(InfoTrabajador trabajadores) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO trabajadores (nombre,"
                    + "cedula,correo,sueldo,mes) "
                    + "values ('%s','%s','%s','%.2f','%s')",
                    trabajadores.obtenerNombre(),
                    trabajadores.obtenerCedula(),
                    trabajadores.obtenerCorreo(),
                    trabajadores.obtenerSueldo(),
                    trabajadores.obtenerSueldoMes());
            System.out.println(data);
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception:");
            System.out.println(e.getMessage());

        }
    }

    public ArrayList<InfoTrabajador> obtenerDataTrabajador() {
        ArrayList<InfoTrabajador> lista = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from trabajadores;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
//                InfoTrabajador infoT = new InfoTrabajador();
//                infoT.establecerNombre(rs.getString("nombre"));
//                infoT.establecerCedula(rs.getString("cedula"));
//                infoT.establecerCorreo(rs.getString("correo"));
//                infoT.establecerSueldo(rs.getDouble("sueldo"));
//                infoT.establecerSueldoMes(rs.getString("mes"));
                InfoTrabajador infoT = new InfoTrabajador(rs.getString("nombre"),
                        rs.getString("cedula"), rs.getString("correo"),
                        rs.getDouble("sueldo"), rs.getString("mes"));
                lista.add(infoT);
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarTrabajores");
            System.out.println(e.getMessage());

        }
        return lista;
    }

}
