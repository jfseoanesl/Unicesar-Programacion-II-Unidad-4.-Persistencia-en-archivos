package vista;

import entidades.Mascota;
import java.io.IOException;
import java.util.ArrayList;
import modelo.GestionMascota;

/**
 *
 * @author Jairo F
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Mascota m = new Mascota(123, "Firulais", "Perro", 2, 2.35, true);
        Mascota m2 = new Mascota(234, "Nemo", "Pez", 1, 0.35, false);
        Mascota m3 = new Mascota(345, "Garfield", "Gato", 2, 4.5, true);

        GestionMascota modelo = new GestionMascota();

        try {
//            //Escribir en el archivo
//            modelo.registrarMascota(m);
//            modelo.registrarMascota(m2);
//            modelo.registrarMascota(m3);

            // leer archivo
            ArrayList<Mascota> lista = modelo.leerMascotas();
            for (Mascota ma : lista) {
                System.out.println(ma);
            }

            // busqueda por id
            Mascota buscada = modelo.buscarMascotaPorId(123);
            if (buscada == null) {
                System.out.println("mascota no registrada");
            } else {
                System.out.println("");
                System.out.println(buscada);
            }

        } catch (IOException ioe) {
            System.out.println("Excepcion: " + ioe.getMessage());
        }

    }

}
