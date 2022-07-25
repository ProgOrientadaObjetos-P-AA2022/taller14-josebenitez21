/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema02;

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

    /**
     * Connect to a sample database
     *
     * @return
     */
    private Connection conn;

    public void establecerConexion() {

        try {
            // db parameters  
            String url = "jdbc:sqlite:bd/base001.base";
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

    public void insertarCalificacion(Calificaciones calificacion) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO estudiante (cedula, nombre, correo, sueldo, mes) "
                    + "values ('%s', '%s', '%s', '%.2f', '%s')", calificacion.obtenerNombre(),
                    calificacion.obtenerApellido(), calificacion.obtenerCalificacion1(),
                    calificacion.obtenerCalificacion2(),
                    calificacion.obtenerCalificacion3());
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarEstudiante");
            System.out.println(e.getMessage());

        }
    }

    public ArrayList<Calificaciones> obtenerDataCalificaciones() {
        ArrayList<Calificaciones> lista = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from estudiante;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                Calificaciones calificacion = new Calificaciones(rs.getString("nombre"),
                        rs.getString("apellido"), rs.getDouble("calificacion1"),
                        rs.getDouble("calificacion2"), rs.getDouble("calificacion3"));
                calificacion.establecerPromedio();
                lista.add(calificacion);
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarCalificacion");
            System.out.println(e.getMessage());

        }
        return lista;
    }

}
