package datos;

import entidades.SeleccionFutbol;
import java.io.*;
import java.io.IOException;
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
        this("SeleccionesCatar2022.dat");
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
    public void registrarSeleccion(SeleccionFutbol s) throws IOException {
        PrintWriter pw = null;
        try {
            this.modoEscritura = new FileWriter(this.manejadorArchivo, true);
            pw = new PrintWriter(this.modoEscritura);
            pw.printf("%d;%s;%d;%s;%.2f;%s%n",
                    s.getIdSeleccion(),
                    s.getNombre(),
                    s.getnJugadoresConvocados(),
                    s.isClasificada(),
                    s.getpRendimiento(),
                    s.getConfederacion());

        } catch (FileNotFoundException fne) {
            throw new IOException("Error al escribir en el archivo");
        } catch (IOException ioe) {
            throw new IOException("Error al abrir archvio en modo escritura");
        } catch (SecurityException se) {
            throw new IOException("No tiene privilegios para abrir el archivo");
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }
    
    private SeleccionFutbol cargarSeleccion(String dato[]){
        int id = Integer.valueOf(dato[0]);
        String nombre= dato[1];
        int nJugadores = Integer.valueOf(dato[2]);
        boolean clasificada = Boolean.valueOf(dato[3]);
        double rendimiento = Double.valueOf(dato[4].replace(',', '.'));
        String confe = dato[5];
        SeleccionFutbol s = new SeleccionFutbol(id, nombre, nJugadores, clasificada, rendimiento, confe);
        return s;
    }

    @Override
    public ArrayList<SeleccionFutbol> leerSelecciones() throws IOException {
        ArrayList<SeleccionFutbol> lista = null;
        try {
            this.modoLectura = new Scanner(this.manejadorArchivo);
            lista = new ArrayList();
            while (this.modoLectura.hasNext()) {
                String dato[] = this.modoLectura.nextLine().split(";");
                SeleccionFutbol s = this.cargarSeleccion(dato);
                lista.add(s);
            }
            return lista;
        } catch (FileNotFoundException fne) {
            throw new IOException("Error al abrir archivo en modo lectura");
        } catch (SecurityException se) {
            throw new IOException("No tiene privilegios para leer el archivo");
        }
        finally{
            if(this.modoLectura!=null)
                this.modoLectura.close();
        }
    }

    @Override
    public SeleccionFutbol buscarSeleccionPorId(int id) throws IOException {
        
        SeleccionFutbol buscada = null;
        try {
            this.modoLectura = new Scanner(this.manejadorArchivo);
            while (this.modoLectura.hasNext()) {
                String dato[] = this.modoLectura.nextLine().split(";");
                SeleccionFutbol s = this.cargarSeleccion(dato);
                if(s.getIdSeleccion()==id){
                    buscada = s;
                    break;
                }
            }
            if(buscada == null)
                throw new IOException("la seleccion no esta registrada");
            
            return buscada;
            
        } catch (FileNotFoundException fne) {
            throw new IOException("Error al abrir archivo en modo lectura");
        } catch (SecurityException se) {
            throw new IOException("No tiene privilegios para leer el archivo");
        }
        finally{
            if(this.modoLectura!=null)
                this.modoLectura.close();
        }
    }

}
