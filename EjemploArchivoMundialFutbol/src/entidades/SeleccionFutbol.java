package entidades;

/**
 *
 * @author Jairo F
 */
public class SeleccionFutbol {
    private int idSeleccion;
    private String nombre;
    private int nJugadoresConvocados;
    private boolean clasificada;
    private double pRendimiento;
    private String confederacion;

    public SeleccionFutbol() {
    }

    public SeleccionFutbol(int idSeleccion, String nombre, int nJugadoresConvocados, boolean clasificada, double pRendimiento, String confederacion) {
        this.idSeleccion = idSeleccion;
        this.nombre = nombre;
        this.nJugadoresConvocados = nJugadoresConvocados;
        this.clasificada = clasificada;
        this.pRendimiento = pRendimiento;
        this.confederacion = confederacion;
    }

    /**
     * @return the idSeleccion
     */
    public int getIdSeleccion() {
        return idSeleccion;
    }

    /**
     * @param idSeleccion the idSeleccion to set
     */
    public void setIdSeleccion(int idSeleccion) {
        this.idSeleccion = idSeleccion;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the nJugadoresConvocados
     */
    public int getnJugadoresConvocados() {
        return nJugadoresConvocados;
    }

    /**
     * @param nJugadoresConvocados the nJugadoresConvocados to set
     */
    public void setnJugadoresConvocados(int nJugadoresConvocados) {
        this.nJugadoresConvocados = nJugadoresConvocados;
    }

    /**
     * @return the clasificada
     */
    public boolean isClasificada() {
        return clasificada;
    }

    /**
     * @param clasificada the clasificada to set
     */
    public void setClasificada(boolean clasificada) {
        this.clasificada = clasificada;
    }

    /**
     * @return the pRendimiento
     */
    public double getpRendimiento() {
        return pRendimiento;
    }

    /**
     * @param pRendimiento the pRendimiento to set
     */
    public void setpRendimiento(double pRendimiento) {
        this.pRendimiento = pRendimiento;
    }

    /**
     * @return the confederacion
     */
    public String getConfederacion() {
        return confederacion;
    }

    /**
     * @param confederacion the confederacion to set
     */
    public void setConfederacion(String confederacion) {
        this.confederacion = confederacion;
    }

    @Override
    public String toString() {
        return "SeleccionFutbol{" + "idSeleccion=" + idSeleccion + ", nombre=" + nombre + ", nJugadoresConvocados=" + nJugadoresConvocados + ", clasificada=" + clasificada + ", pRendimiento=" + pRendimiento + ", confederacion=" + confederacion + '}';
    }
    
    
}
