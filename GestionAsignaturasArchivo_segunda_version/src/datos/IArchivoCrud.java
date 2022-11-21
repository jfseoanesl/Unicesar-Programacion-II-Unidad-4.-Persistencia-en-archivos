package datos;

import entidades.Asignatura;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Jairo F
 */
public interface IArchivoCrud {
    
    double NOTA_GANADA = 3;
     
    void registrarAsignatura(Asignatura a) throws IOException;
    ArrayList<Asignatura> leerAsignaturas() throws IOException;
    Asignatura buscarAsignaturas(String codigo) throws IOException;
    ArrayList<Asignatura> getAsignaturasHomologableGanadas() throws IOException;
}
