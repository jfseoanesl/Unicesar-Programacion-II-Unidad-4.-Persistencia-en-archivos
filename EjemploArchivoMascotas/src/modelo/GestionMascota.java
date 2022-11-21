/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

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
        this.archivo = new ArchivoTexto();
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
