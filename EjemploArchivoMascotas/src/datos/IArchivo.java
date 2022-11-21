package datos;

import entidades.Mascota;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Jairo F
 */
public interface IArchivo {
    void registrarMascota(Mascota m) throws IOException;
    ArrayList<Mascota> readAllMascotas()throws IOException;
    Mascota buscarMascotaPorId( int id ) throws IOException;
}
