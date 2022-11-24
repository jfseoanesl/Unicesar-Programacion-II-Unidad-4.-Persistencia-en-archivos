package datos;

import entidades.Asignatura;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jairo F
 */
public class AObjeto implements IArchivoCrud {

    private File manejadorArchivo;
    private FileOutputStream modoEscritura;
    private FileInputStream modoLectura;

    public AObjeto() {
        this("MisAsignaturas.bin");
    }

    public AObjeto(String name) {
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

    private void guardar(ArrayList<Asignatura> lista) throws IOException{
        ObjectOutputStream oos = null;
        try {
            this.modoEscritura = new FileOutputStream(manejadorArchivo);
            oos = new ObjectOutputStream(this.modoEscritura);
            oos.writeObject(lista);

        } catch (FileNotFoundException fne) {
            throw new IOException("Error al abrir archivo obj en modo escritura");
        } catch (SecurityException se) {
            throw new IOException("Error, no tiene privilegios para abrir archivo obj en modo escritura");
        } catch (IOException ioe) {
            throw new IOException("Error al crear objetor de escritura");
        } catch (NullPointerException npe) {
            throw new IOException("Error el archivo a escribir es nulo");
        } finally {
            if (oos != null) {
                oos.close();
            }
        }
    }
    
    private ArrayList<Asignatura> leer()throws IOException{
        ArrayList<Asignatura> lista;
        if(!this.manejadorArchivo.exists()){
            lista = new ArrayList();
            return lista;
        }
       
        ObjectInputStream ois = null;
        try {
            this.modoLectura = new FileInputStream(this.manejadorArchivo);
            lista = new ArrayList();
            ois = new ObjectInputStream(this.modoLectura);
            lista = (ArrayList<Asignatura>) ois.readObject();
            return lista;
            
        } catch (FileNotFoundException fne) {
            throw new IOException("Error al abrir archivo obj en modo lectura");
        } catch (SecurityException se) {
            throw new IOException("Error, no tiene privilegios para abrir archivo obj en modo lectura");
        } catch (IOException ioe) {
            throw new IOException("Error al crear objeto de lectura");
        } catch (NullPointerException npe) {
            throw new IOException("Error el archivo a leer es nulo");
        } catch (ClassNotFoundException ex) {
           throw new IOException("Error el leer objeto de archivo");
        } 
        finally{
            if(ois!=null)
                ois.close();
        }
    }
    
    @Override
    public void registrarAsignatura(Asignatura a) throws IOException {
        ArrayList<Asignatura> lista = this.leer();
        lista.add(a);
        this.guardar(lista);

    }

    @Override
    public ArrayList<Asignatura> leerAsignaturas() throws IOException {
        return this.leer();
    }

    @Override
    public Asignatura buscarAsignaturas(String codigo) throws IOException {
        ArrayList<Asignatura> lista = this.leer();
        Asignatura buscada = null;
        for(Asignatura a: lista){
            if(a.getCoodigo().equals(codigo)){
                buscada = a;
                break;
            }
        }
        
//        if(buscada==null)
//            throw new IOException("La asignatura no se encuentra registrada");
        
        return buscada;
    }

    @Override
    public ArrayList<Asignatura> getAsignaturasHomologableGanadas() throws IOException {
     return null;
    }

}
