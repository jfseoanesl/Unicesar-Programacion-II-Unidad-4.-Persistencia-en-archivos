package datos;

import entidades.Mascota;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jairo F
 */
public class ArchivoObjeto implements IArchivo {

    private File manejadorArchivo;
    private FileInputStream modoLectura;
    private FileOutputStream modoEscritura;

    public ArchivoObjeto() {
        this("MisMascotas.bin");
    }

    public ArchivoObjeto(String name) {
        this.manejadorArchivo = new File(name);
    }

    /**
     * @return the manejadorArchivo
     */
    public File getManejadorArchivo() {
        return manejadorArchivo;
    }

    /**
     * @param manejadorArchivo the manejadorArchivo to set
     */
    public void setManejadorArchivo(File manejadorArchivo) {
        this.manejadorArchivo = manejadorArchivo;
    }

    /**
     * @return the modoLectura
     */
    public FileInputStream getModoLectura() {
        return modoLectura;
    }

    /**
     * @param modoLectura the modoLectura to set
     */
    public void setModoLectura(FileInputStream modoLectura) {
        this.modoLectura = modoLectura;
    }

    /**
     * @return the modoEscritura
     */
    public FileOutputStream getModoEscritura() {
        return modoEscritura;
    }

    /**
     * @param modoEscritura the modoEscritura to set
     */
    public void setModoEscritura(FileOutputStream modoEscritura) {
        this.modoEscritura = modoEscritura;
    }
    
    private void guardar(ArrayList<Mascota> lista)throws IOException{
        ObjectOutputStream oos = null;
        try {
            this.modoEscritura = new FileOutputStream(this.manejadorArchivo);
            oos = new ObjectOutputStream(this.modoEscritura);
            oos.writeObject(lista);

        } catch (FileNotFoundException fne) {
            throw new IOException("Error al abir el archivo obj en modo escritura");
        } catch (SecurityException se) {
            throw new IOException("No tiene privilegio para el archivo en modo escritura");
        } catch (IOException ioe) {
            throw new IOException("Error al crear objeto que escribe en el archivo");
        } catch (NullPointerException npe) {
            throw new IOException("Error el archivo modo escritura es nulo");
        } finally {
            if (oos != null) {
                oos.close();
            }
        }
    }
    
    private ArrayList<Mascota> leer()throws IOException{
       ObjectInputStream ois = null;
       ArrayList<Mascota> lista = null;
       
       if(!this.manejadorArchivo.exists()){
           lista = new ArrayList();
           return lista;
       }
        try {
            this.modoLectura = new FileInputStream(this.manejadorArchivo);
            lista = new ArrayList();
            ois = new ObjectInputStream(this.modoLectura);
            lista = (ArrayList<Mascota>)ois.readObject();
            return lista;
            
        } catch (FileNotFoundException fne) {
            throw new IOException("Error al abir el archivo obj en modo lectura");
        } catch (SecurityException se) {
            throw new IOException("No tiene privilegio para el archivo en modo lectura");
        } catch (IOException ioe) {
            throw new IOException("Error al crear objeto lector de archivo");
        } catch (NullPointerException npe) {
            throw new IOException("Error el archivo modo lectura es nulo");
        } catch (ClassNotFoundException ex) {
           throw new IOException("Error al leer del archivo");
        }
    }

    @Override
    public void registrarMascota(Mascota m) throws IOException {
        ArrayList<Mascota> lista = this.leer();
        lista.add(m);
        this.guardar(lista);
    }

    @Override
    public ArrayList<Mascota> readAllMascotas() throws IOException {
       return this.leer();
    }

    @Override
    public Mascota buscarMascotaPorId(int id) throws IOException {
         ArrayList<Mascota> lista = this.leer();
         Mascota buscada= null;
         for(Mascota m: lista){
             if(m.getIdMascota()==id){
                buscada = m;
                break;
             }
         
         }
//            if(buscada == null)
//                throw new IOException("La mascota no esta registrada");
        return buscada;
    }

}
