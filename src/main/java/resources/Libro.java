package resources;

import java.util.Date;

public class Libro {
    private static int autoincrement = 10000;

    private String titulo;
    private String autor;
    private int nPag;
    private int isbn;
    private int stock;
    private Date anoPublicacion;

    public Libro(String titulo, String autor, int nPag, int stock, Date anoPublicacion) {
        isbn = autoincrement++;
        this.titulo = titulo;
        this.autor = autor;
        this.nPag = nPag;
        this.stock = stock;
        this.anoPublicacion = anoPublicacion;
    }

    public void reducirCantidad (){

    }
    public void aumentarCantidad (){

    }
    public int consultarCantidad (){
        return stock;
    }


}
