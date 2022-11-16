package vista;

import entidades.Asignatura;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.GestionAsignatura;

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

        GestionAsignatura modelo = new GestionAsignatura();
        try {
            Scanner entrada = new Scanner(System.in);
//            System.out.print("codigo: ");
//            String codigo = entrada.next();
//            System.out.print("Nombre: ");
//            String nombre = entrada.next();
//            System.out.print("Creditos: ");
//            int credito = entrada.nextInt();
//            System.out.print("Es homogable [1-si][2-no]: ");
//            int val = entrada.nextInt();
//            boolean homologable = (val == 1) ? true : false;
//            System.out.print("nota: ");
//            double nota = entrada.nextDouble();

            //Escribir en el archivo
            //Asignatura asignatura = new Asignatura(codigo, nombre, credito, homologable, nota);
            //modelo.adicionarAsignatura(asignatura);
            
            //leer del archivo
            ArrayList<Asignatura> leidas = modelo.leerAsignaturas();
            for(Asignatura a: leidas){
                System.out.println(a);
            }
            
        } catch (IOException ioe) {
            System.out.println("Excepcion: " + ioe);
        }

    }

}
