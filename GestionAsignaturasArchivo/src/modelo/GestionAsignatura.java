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
    
    public void adicionarAsignatura(Asignatura a) throws IOException{
        
        this.archivo.registrarAsignatura(a);
        
    }
    
    public ArrayList<Asignatura> leerAsignaturas()throws IOException{
        return this.archivo.leerAsignaturas();
    }
    
}
