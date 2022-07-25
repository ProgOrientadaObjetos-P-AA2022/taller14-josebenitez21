/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package problema02;

/**
 *
 * @author M S I
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Enlace e = new Enlace();
//
//        for (int i = 0; i < e.obtenerDataCalificaciones().size(); i++) {
//            System.out.printf("%s", e.obtenerDataCalificaciones().get(i));
//        }
//    }
        Enlace c = new Enlace();
        String cadena = String.format("Promedios de estudiantes\n");
        for (int i = 0; i < c.obtenerDataCalificaciones().size(); i++) {
            cadena = String.format("%s%s\n",
                    cadena, c.obtenerDataCalificaciones().get(i));

        }
        System.out.println(cadena);
    }

}
