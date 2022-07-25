/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problema01;

import java.util.ArrayList;

/**
 *
 * @author M S I
 */
public class InfoTrabajador {

    private String nombre;
    private String cedula;
    private String correo;
    private double sueldo;
    private String sueldoMes;

    public InfoTrabajador(String a, String b, String c, double d, String e) {
        nombre = a;
        cedula = b;
        correo = c;
        sueldo = d;
        sueldoMes = e;
    }

    public InfoTrabajador() {
    }
    

    public void establecerNombre(String a) {
        nombre = a;
    }

    public void establecerCedula(String a) {
        cedula = a;
    }

    public void establecerCorreo(String a) {
        correo = a;
    }

    public void establecerSueldo(double a) {
        sueldo = a;
    }

    public void establecerSueldoMes(String a) {
        sueldoMes = a;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerCedula() {
        return cedula;
    }

    public String obtenerCorreo() {
        return correo;
    }

    public double obtenerSueldo() {
        return sueldo;
    }

    public String obtenerSueldoMes() {
        return sueldoMes;
    }

    @Override
    public String toString() {
        String Cadena;
        Cadena = String.format("""
                               INFORMACION
                               Nombre: %s
                               Cedula: %s
                               Correo: %s
                               Sueldo: %.2f
                               Sueldo Mes: %s
                               """,
                nombre,
                cedula,
                correo,
                sueldo,
                sueldoMes);
        return Cadena;
    }

}
