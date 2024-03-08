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




    public void prestarLibro(int idLibro,int idUsuario){
        boolean existeLibro = false;
        boolean existeUsuario = false;
        Usuario usuarioAPrestar = new Usuario();
        Libro libroAPrestar = new Libro();
        for (int i = 0; i < usuarios.length; i++) {
            if (idUsuario == usuarios[i].consultarId()){
                existeUsuario = true;
                usuarios[i] = usuarioAPrestar;
            }
        }

        if (existeUsuario == false){
            System.out.println("El usuario no existe");
            return;
        }

        for (int i = 0; i < libros.length; i++) {
            if (idLibro == libros[i].consultarIsbn()){
                existeLibro = true;
                libros[i] = libroAPrestar;
            }
        }

        if (existeLibro = false){
            System.out.println("El libro no existe");
        }

        boolean hayLibros;
        for (int i = 0; i < libros.length; i++) {
            if (idLibro == libros[i].consultarIsbn()){

                hayLibros = libros[i].reducirCantidad(1);

            }
        }

        if (hayLibros = false){
            System.out.println("no queda stock de este libro");
            return;
        }

        boolean sePuedePrestar = usuarioAPrestar.prestarLibro(libroAPrestar);

        if ( sePuedePrestar == false){
            System.out.println("no se pueden prestar mas libros a este usuario");
        }else{
            System.out.println("libro prestado con exito");
        }
    }





    public void recibirLibro(int idLibro, int idUsuario){

    }
    public void consultarPrestamos(int idUsuario){

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
