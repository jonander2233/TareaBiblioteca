import librerias.Eys;
import librerias.Menu;
import resources.Biblioteca;

public class Main {
    private static final int CAPACIDAD_USUARIOS = 20;
    private static Biblioteca biblioteca = new Biblioteca(50,CAPACIDAD_USUARIOS);
    public static void main(String[] args){
        biblioteca.genLibros();
        biblioteca.genUsuarios();
        String[] opciones1 = new String[]{"Gestion de usuarios","gestion de inventario"};
        boolean salir = false;
        do{
            int seleccion = Menu.mostrar("Biblioteca",opciones1,"Salir");
            switch (seleccion){
                case 0:
                    salir = true;
                    break;
                case 1:
                    gestionUsuarios();
                    break;
                case 2:
                    break;
                default:
                    break;
            }
        }while (salir == false);
    }
    private static void gestionUsuarios(){
        String[] opciones = new String[]{"Consultar por id","Consultar por nombre","Consultar todos los usuarios"};
        int seleccion = Menu.mostrar("Biblioteca",opciones,"Volver");
        switch (seleccion){
            case 0:
                break;
            case 1:
                int id = Eys.imprimirYLeerInt("Introduce la id del usuario",1,CAPACIDAD_USUARIOS);
                Eys.imprimir(biblioteca.consultarUsuario(id));
                break;
            case 2:
                String nombre = Eys.imprimirYLeer("Introduce el nombre del usuario",1,CAPACIDAD_USUARIOS);
                break;
            case 3:
                Eys.imprimir(biblioteca.consultarTodos());

                break;
            default:
                break;
        }
    }
}
