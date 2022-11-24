package entidades;

import java.io.Serializable;

/**
 *
 * @author Jairo F
 */
public class Mascota implements Serializable {
    private int idMascota;
    private String nombre;
    private String especie;
    private int edad;
    private double peso;
    private boolean rastreable;

    public Mascota() {
    }

    public Mascota(int idMascota, String nombre, String especie, int edad, double peso, boolean rastreable) {
        this.idMascota = idMascota;
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.peso = peso;
        this.rastreable = rastreable;
    }

    /**
     * @return the idMascota
     */
    public int getIdMascota() {
        return idMascota;
    }

    /**
     * @param idMascota the idMascota to set
     */
    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
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
     * @return the especie
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * @param especie the especie to set
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @return the rastreable
     */
    public boolean isRastreable() {
        return rastreable;
    }

    /**
     * @param rastreable the rastreable to set
     */
    public void setRastreable(boolean rastreable) {
        this.rastreable = rastreable;
    }

    @Override
    public String toString() {
        return "Mascota{" + "idMascota=" + idMascota + ", nombre=" + nombre + ", especie=" + especie + ", edad=" + edad + ", peso=" + peso + ", rastreable=" + rastreable + '}';
    }
    
    
}
