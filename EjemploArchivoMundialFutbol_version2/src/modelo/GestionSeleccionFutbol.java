package modelo;

import datos.*;
import datos.IArchivo;
import entidades.SeleccionFutbol;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Jairo F
 */
public class GestionSeleccionFutbol {
    
    private IArchivo archivo;

    public GestionSeleccionFutbol() {
        //this.archivo = new ArchivoTexto();
        this.archivo = new ArchivoObjeto();
    }
    
    
    
    public void registrarSeleccion(SeleccionFutbol s)throws IOException{
        this.archivo.registrarSeleccion(s);
    }
    
    public ArrayList<SeleccionFutbol> leerSelecciones() throws IOException{
        return this.archivo.leerSelecciones();
    }
    
    public SeleccionFutbol buscarSeleccionPorId(int id) throws IOException{
        return this.archivo.buscarSeleccionPorId(id);
    }
}
