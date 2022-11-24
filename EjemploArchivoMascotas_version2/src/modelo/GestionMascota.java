package modelo;

import datos.ArchivoObjeto;
import datos.ArchivoTexto;
import datos.IArchivo;
import entidades.Mascota;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Jairo F
 */
public class GestionMascota {
    
    private IArchivo archivo;

    public GestionMascota() {
        //this.archivo = new ArchivoTexto();
        this.archivo = new ArchivoObjeto();
    }
    
    public void registrarMascota(Mascota m) throws IOException{
        this.archivo.registrarMascota(m);
    }
    
    
    public ArrayList leerMascotas() throws IOException {
        return this.archivo.readAllMascotas();
    }
    
    public Mascota buscarMascotaPorId(int id) throws IOException {
        return this.archivo.buscarMascotaPorId(id);
    }
    
}
