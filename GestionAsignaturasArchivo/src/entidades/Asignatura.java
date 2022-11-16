package entidades;

/**
 *
 * @author Jairo F
 */
public class Asignatura {
    private String coodigo;
    private String nombre;
    private int creditos;
    private boolean homologable;
    private double nota;

    public Asignatura() {
    }

    public Asignatura(String coodigo, String nombre, int creditos, boolean homologable, double nota) {
        this.coodigo = coodigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.homologable = homologable;
        this.nota = nota;
    }

    /**
     * @return the coodigo
     */
    public String getCoodigo() {
        return coodigo;
    }

    /**
     * @param coodigo the coodigo to set
     */
    public void setCoodigo(String coodigo) {
        this.coodigo = coodigo;
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
     * @return the creditos
     */
    public int getCreditos() {
        return creditos;
    }

    /**
     * @param creditos the creditos to set
     */
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    /**
     * @return the homologable
     */
    public boolean isHomologable() {
        return homologable;
    }

    /**
     * @param homologable the homologable to set
     */
    public void setHomologable(boolean homologable) {
        this.homologable = homologable;
    }

    /**
     * @return the nota
     */
    public double getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "coodigo=" + coodigo + ", nombre=" + nombre + ", creditos=" + creditos + ", homologable=" + homologable + ", nota=" + nota + '}';
    }
    
    
}
