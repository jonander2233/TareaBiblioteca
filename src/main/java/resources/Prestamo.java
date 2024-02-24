package resources;

import java.util.Date;

public class Prestamo {
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private int idUsuario;

    public Prestamo(Date fechaPrestamo, int idUsuario) {
        this.fechaPrestamo = fechaPrestamo;
        this.idUsuario = idUsuario;
    }
    public void prestarLibro(int idLibro){

    }
    public void devolverLibro(int idLibro){

    }
}
