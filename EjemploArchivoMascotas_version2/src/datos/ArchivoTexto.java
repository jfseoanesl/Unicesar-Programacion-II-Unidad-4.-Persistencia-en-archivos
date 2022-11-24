package datos;

import entidades.Mascota;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jairo F
 */
public class ArchivoTexto implements IArchivo {

    private File manejadorArchivo;
    private FileWriter modoEscritura;
    private Scanner modoLectura;

    public ArchivoTexto() {
        this("MisMascotas.dat");
    }

    public ArchivoTexto(String name) {
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
    public void registrarMascota(Mascota m) throws IOException {
        PrintWriter pw = null;
        try {
            this.modoEscritura = new FileWriter(this.manejadorArchivo, true);
            pw = new PrintWriter(this.modoEscritura);
            pw.printf("%d;%s;%s;%d;%.2f;%s%n", 
                      m.getIdMascota(),
                      m.getNombre(),
                      m.getEspecie(),
                      m.getEdad(),
                      m.getPeso(), 
                      m.isRastreable());
                    
        } catch (FileNotFoundException fne) {
            throw new IOException("Error al escribir en el archivo");
        } catch (IOException ioe) {
            throw new IOException("Error al abrir archivo en modo escritura");
        } catch (SecurityException se) {
            throw new IOException("No tiene privilegios para escribir en el archivo");
        }
        finally{
            if(pw!=null)
                pw.close();
        }

    }
    
    private Mascota cargarMascota(String dato[]){
        
        int id = Integer.valueOf(dato[0]);
        String nombre = dato[1];
        String especie = dato[2];
        int edad = Integer.valueOf(dato[3]);
        double peso = Double.valueOf(dato[4].replace(',', '.'));
        boolean rastreable = Boolean.valueOf(dato[5]);
        
        Mascota m = new Mascota(id, nombre, especie, edad, peso, rastreable);
        return m;
    }

    @Override
    public ArrayList<Mascota> readAllMascotas() throws IOException {
        ArrayList<Mascota> listado = null;
        try{
            this.modoLectura = new Scanner(this.manejadorArchivo);
            listado = new ArrayList();
            while(this.modoLectura.hasNext()){
                String datos[] = this.modoLectura.nextLine().split(";");
                Mascota m = this.cargarMascota(datos);
                listado.add(m);
            }
            return listado;
            
        }catch(FileNotFoundException fne){
            throw new IOException("Error al abrir archivo en modo lectura");
        }  
        catch(SecurityException se){
            throw new IOException("No tiene privilegios para leer archivo");
        }
        finally{
          if(this.modoLectura!=null)
              this.modoLectura.close();
        }
        
    }

    @Override
    public Mascota buscarMascotaPorId(int id) throws IOException {
        Mascota buscada = null;
        try{
            this.modoLectura = new Scanner(this.manejadorArchivo);
            while(this.modoLectura.hasNext()){
                String datos[] = this.modoLectura.nextLine().split(";");
                Mascota m = this.cargarMascota(datos);
                if(m.getIdMascota()==id){
                    buscada = m;
                    break;
                }
                
            }
            
//            if(buscada == null)
//                throw new IOException("La mascota no esta registrada");
            
            return buscada;
            
        }catch(FileNotFoundException fne){
            throw new IOException("Error al abrir archivo en modo lectura");
        }  
        catch(SecurityException se){
            throw new IOException("No tiene privilegios para leer archivo");
        }
        finally{
          if(this.modoLectura!=null)
              this.modoLectura.close();
        }
    }

}
