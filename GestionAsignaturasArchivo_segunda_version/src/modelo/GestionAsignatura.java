package modelo;

import datos.ATexto;
import datos.IArchivoCrud;
import entidades.Asignatura;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Jairo F
 */
public class GestionAsignatura {

    private IArchivoCrud archivo;

    public GestionAsignatura() {
        this.archivo = new ATexto();
    }

    public void adicionarAsignatura(Asignatura a) throws IOException {

        this.archivo.registrarAsignatura(a);

    }

    public ArrayList<Asignatura> leerAsignaturas() throws IOException {
        return this.archivo.leerAsignaturas();
    }

    public Asignatura buscarByCodigo(String codigo) throws IOException {
        return this.archivo.buscarAsignaturas(codigo);

    }

    public ArrayList<Asignatura> leerAsignaturasHomologablesGanadas() throws IOException {
        return this.archivo.getAsignaturasHomologableGanadas();
    }

    public Asignatura buscarByMayorNota() throws IOException {
        ArrayList<Asignatura> listado = this.leerAsignaturas();
        if (listado.size() > 0) {
            int i = 0;
            Asignatura mayor = listado.get(0);

            for (Asignatura a : listado) {
                if (i != 0) {
                    if (a.getNota() > mayor.getNota()) {
                        mayor = a;
                    }
                }
                i++;
            }
            
            return mayor;

        } else {
            throw new IOException("No hay asignaturas registradas en el archivo");
        }

    }

}
