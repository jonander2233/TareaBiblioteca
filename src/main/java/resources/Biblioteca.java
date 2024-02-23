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
}