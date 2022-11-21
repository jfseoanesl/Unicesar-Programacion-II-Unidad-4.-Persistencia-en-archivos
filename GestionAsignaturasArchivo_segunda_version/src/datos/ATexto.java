package datos;

import entidades.Asignatura;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jairo F
 */
public class ATexto implements IArchivoCrud{
    private File manejadoArchivo;
    private FileWriter modoEscritura;
    private Scanner modoLectura;

    public ATexto() {
        this("MyAsignaturas.dat");
    }

    public ATexto(String nameFile) {
        this.manejadoArchivo = new File(nameFile);
    }

    /**
     * @return the manejadoArchivo
     */
    public File getManejadoArchivo() {
        return manejadoArchivo;
    }

    /**
     * @param manejadoArchivo the manejadoArchivo to set
     */
    public void setManejadoArchivo(File manejadoArchivo) {
        this.manejadoArchivo = manejadoArchivo;
    }

    /**
     * @return the modoEscritura
     */
    public FileWriter getModoEscritura() {
        return modoEscritura;
    }

    /**
     * @param modoEscritura the modoEscritura to set
     */
    public void setModoEscritura(FileWriter modoEscritura) {
        this.modoEscritura = modoEscritura;
    }

    /**
     * @return the modoLectura
     */
    public Scanner getModoLectura() {
        return modoLectura;
    }

    /**
     * @param modoLectura the modoLectura to set
     */
    public void setModoLectura(Scanner modoLectura) {
        this.modoLectura = modoLectura;
    }

    @Override
    public void registrarAsignatura(Asignatura a) throws IOException {
        PrintWriter pw =  null;
        try{
            this.modoEscritura = new FileWriter(this.manejadoArchivo, true);
            pw = new PrintWriter(this.modoEscritura);
            pw.printf("%s;%s;%d;%s;%.2f%n", 
                      a.getCoodigo(),
                      a.getNombre(),
                      a.getCreditos(),
                      a.isHomologable(),
                      a.getNota());
            
            
        }catch(FileNotFoundException fne){
          throw new IOException("No es posible escribir en el archivo"); 
        }
        catch(IOException ioe){
            throw new IOException("No es posible abrir el archivo para escritura");
        } 
        catch(SecurityException se){
            throw new IOException("No tiene privilegio para escribir en el archivo");
        }
        finally{
            if(pw!=null)
                pw.close();
        }
        
    }
    
    private Asignatura cargarAsignatura(String datos[]){
        String codigo = datos[0]        ;
        String nombre = datos[1]        ;
        int credito = Integer.valueOf(datos[2]);
        double nota= Double.valueOf(datos[4].replace(',', '.'));
        boolean homologable = Boolean.valueOf(datos[3]);
        
        return new Asignatura(codigo, nombre, credito, homologable, nota);
        
    }
    
    @Override
    public ArrayList<Asignatura> leerAsignaturas() throws IOException  {
        ArrayList<Asignatura> listado=null;
        try{
        
            this.modoLectura = new Scanner(this.manejadoArchivo);
            listado = new ArrayList();
            while(this.modoLectura.hasNext()){
                String dato[] = this.modoLectura.nextLine().split(";");
                Asignatura a = this.cargarAsignatura(dato);
                listado.add(a);
            }
            return listado;
        
        }catch(FileNotFoundException fne){
            throw new IOException("Error al abrir archivo para lectura");
        }
        finally{
            if(this.modoLectura!=null)
                this.modoLectura.close();
        
        }
        
    }

    @Override
    public Asignatura buscarAsignaturas(String codigo) throws IOException {
        Asignatura buscada=null;
        try{
            this.modoLectura = new Scanner(this.manejadoArchivo);
            while(this.modoLectura.hasNext()){
                String dato[] = this.modoLectura.nextLine().split(";");
                Asignatura asignatura = this.cargarAsignatura(dato);
                if(asignatura.getCoodigo().equalsIgnoreCase(codigo)){
                    buscada = asignatura;
                    break;
                }
            }
            return buscada;
            
        }catch(FileNotFoundException fne){
           throw new IOException("Error al abrir archivo para busqueda"); 
        }
        finally{
            if(this.modoLectura!=null)
                this.modoLectura.close();
        }
        
    }

    @Override
    public ArrayList<Asignatura> getAsignaturasHomologableGanadas() throws IOException {
        ArrayList<Asignatura> listado=null;
        try{
        
            this.modoLectura = new Scanner(this.manejadoArchivo);
            listado = new ArrayList();
            while(this.modoLectura.hasNext()){
                String dato[] = this.modoLectura.nextLine().split(";");
                Asignatura a = this.cargarAsignatura(dato);
                if(a.getNota()>=IArchivoCrud.NOTA_GANADA && a.isHomologable()){
                    listado.add(a);
                }
                
            }
            return listado;
        
        }catch(FileNotFoundException fne){
            throw new IOException("Error al abrir archivo para lectura");
        }
        finally{
            if(this.modoLectura!=null)
                this.modoLectura.close();
        
        }
    }
    
    
    
}
