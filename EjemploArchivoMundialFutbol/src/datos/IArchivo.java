package datos;

import entidades.SeleccionFutbol;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Jairo F
 */
public interface IArchivo {
        
    void registrarSeleccion(SeleccionFutbol s)throws IOException;
    ArrayList<SeleccionFutbol> leerSelecciones() throws IOException;
    SeleccionFutbol buscarSeleccionPorId(int id) throws IOException;
    
}
