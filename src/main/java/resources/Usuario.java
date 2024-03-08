package resources;

import librerias.GenericDynamicArray;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Usuario {
    private static int autoincrement = 1;
    private static int autoincrementPrestamos = 0;
    private String nombre;
    private int id;
    private GenericDynamicArray<Prestamo> historialPrestamos = new GenericDynamicArray<Prestamo>(5);
    private int MAX_PRESTAMOS = 5;
    public Usuario() {
    }

    public Usuario(String nombre) {
        id = autoincrement;
        this.nombre = nombre;
        autoincrement++;
    }

    public void consultarPrestamos(int id) {

    }
    public void devolverLibro(int idLibro){

    }

    public boolean prestarLibro(Libro libro){
        if (historialPrestamos.size()>=MAX_PRESTAMOS){
         return false;
        }
        Prestamo prestamo = new Prestamo(libro);
        historialPrestamos.add(prestamo);
        return true;
    }

    public int consultarId (){
        return id;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                '}';
    }
}
