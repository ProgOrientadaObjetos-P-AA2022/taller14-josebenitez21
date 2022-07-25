/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package problema01;

import java.util.ArrayList;
import java.util.Scanner;
import java.sql.SQLException;

/**
 *
 * @author M S I
 */
public class Principal {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        String nombre;
        String cedula;
        String correo;
        double sueldo;
        String sueldoMes;
        boolean bandera = true;
        String respuesta;

        // ArrayList<InfoTrabajador> listaObreros = new ArrayList<>();
        do {

            System.out.println("Bienvenido al Sistema de Registro Laboral");
            System.out.println("Ingrese la cedula del usuario");
            cedula = entrada.nextLine();
            System.out.println("Ingrese el nombre del usuario");
            nombre = entrada.nextLine();
            System.out.println("Ingrese el correo del usuario");
            correo = entrada.nextLine();
            System.out.println("Ingrese el sueldo del usuario");
            sueldo = entrada.nextDouble();
            entrada.nextLine();
            System.out.println("Ingrese el mes del sueldo");
            sueldoMes = entrada.nextLine();
            System.out.println("Desea seguir ingresar datos\n[SI]\n[NO]");
            respuesta = entrada.nextLine().toUpperCase();
            InfoTrabajador trabajador = new InfoTrabajador(nombre, cedula,
                    correo, sueldo, sueldoMes);
            trabajador.establecerNombre(nombre);
            trabajador.establecerCedula(cedula);
            trabajador.establecerCorreo(correo);
            trabajador.establecerSueldo(sueldo);
            trabajador.establecerSueldoMes(sueldoMes);

            Enlace c = new Enlace();
            c.insertarTrabajadores(trabajador);
            if (respuesta.equals("NO")) {
                bandera = false;
            }

        } while (bandera);

//        String cadena = "";
//        for (InfoTrabajador info : listaObreros) {
//            cadena += info + "\n";
//        }
//        System.out.println(cadena);
//        InfoTrabajador trabajador = new InfoTrabajador(nombre, cedula,
//                correo, sueldo, sueldoMes);
//        listaObreros.add(trabajador);
//        c.insertarTrabajadores(trabajador);
//        for (int i = 0; i < c.obtenerDataTrabajador().size(); i++) {
//            System.out.printf("%s\n", c.obtenerDataTrabajador().get(i));
//        }
    }

}
