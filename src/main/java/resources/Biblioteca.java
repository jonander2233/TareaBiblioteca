package resources;

import net.datafaker.Faker;

public class Biblioteca {
    private Libro[] libros;
    private Usuario[] usuarios;
    private int capacidadLibros;
    private int capacidadUsuarios;

    Faker faker = new Faker();


    public Biblioteca(int capacidadLibros,int capacidadUsuarios) {
        this.capacidadLibros = capacidadLibros;
        this.capacidadUsuarios = capacidadUsuarios;
        libros = new Libro[capacidadLibros];
        usuarios = new Usuario[capacidadUsuarios];
    }
    public void genUsuarios(){
        for (int i = 0; i < usuarios.length; i++) {
            usuarios[i] = new Usuario(faker.name().name());
        }
    }
    public void genLibros(){
        for (int i = 0; i < libros.length; i++) {
            libros[i] = new Libro(faker.book().title(),faker.book().author(),faker.random().nextInt(50,
                    300),faker.random().nextInt(5,50),faker.date().birthday() );
        }
    }
    public void prestarLibro(int isbn,int idUsuario){
        for (int i = 0; i < libros.length; i++) {
            if (isbn == libros[i].consultarIsbn()){
                libros[i].reducirCantidad(1);
                usuarios[i].consultarId();
            }
        }
    }
    public void recibirLibro(){

    }
    public String consultarUsuario(int id){
        for (int i = 0; i < usuarios.length; i++) {
            if (id == usuarios[i].consultarId()){
                return usuarios[i].toString();
            }
        }
        return ("no existe el usuario con id"+id);
    }
    public String consultarTodos(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < usuarios.length; i++) {
            sb.append(usuarios[i]).append("\n");
        }
        return sb.toString();
    }
}
