package resources;

import java.util.Date;

public class Libro {
    private static int autoincrement = 1000;

    private String titulo;
    private String autor;
    private Date anoPublicacion;
    private int nPag;
    private int isbn;
    private int stock;

    public Libro(String titulo, String autor, int nPag, int stock, Date anoPublicacion) {
        isbn = autoincrement++;
        this.titulo = titulo;
        this.autor = autor;
        this.nPag = nPag;
        this.stock = stock;
        this.anoPublicacion = anoPublicacion;
    }
    public int consultarIsbn (){
        return isbn;
    }
    public boolean reducirCantidad (int cantidad){
        if (cantidad > stock)
            return false;
        stock = stock - cantidad;
        return true;
    }
    public void aumentarCantidad (){

        stock = stock + 1;
    }
    public int consultarCantidad (){
        return stock;
    }


}
