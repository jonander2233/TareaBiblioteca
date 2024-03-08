package resources;

import java.util.Date;

public class Prestamo {
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private Libro libro;
    public Prestamo(Libro libro) {
        Date fechaAcual = new Date();
        this.fechaPrestamo = fechaAcual ;
        this.libro = libro;
    }
    public void prestarLibro(Libro libro){

    }
    public void devolverLibro(int idLibro){

    }
}
