package datos;

import entidades.Asignatura;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Jairo F
 */
public interface IArchivoCrud {
     
    void registrarAsignatura(Asignatura a) throws IOException;
    ArrayList<Asignatura> leerAsignaturas() throws IOException;
    
}
