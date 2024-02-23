package resources;

public class Usuario {
    private static int autoincrement = 1;
    private String nombre;
    private int id;
    Prestamo[] historialPrestamos = new Prestamo[50];

    public Usuario(String nombre) {
        id = autoincrement;
        this.nombre = nombre;
        autoincrement++;
    }
    public void consultarPrestamos (int id){
        for (int i = 0; i < historialPrestamos.length; i++) {

        }
    }
    public int consultarId (){
        return id;
    }
}
