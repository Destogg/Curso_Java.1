/* Omar Garcia
Sistema de biblioteca 1.2
Se ajusto el menu de usuario para mayor facilidad.
Se modifico el archivo almacen para guardar los libros en un txt
Se ajustan metodos guardar y mostrar para que no colapse con el txt
Se agrego sistema de busqueda y eliminacion de libros
*/
package Biblioteca1_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        Almacen mialmacen = new Almacen();

        System.out.println("**** Bienvenido al Sistema de Biblioteca ****");

        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENÚ DE OPCIONES ---");
            System.out.println("1. Registrar un nuevo libro");
            System.out.println("2. Ver todos los libros disponibles");
            System.out.println("3. Buscar un libro por título");
            System.out.println("4. Borrar un libro específico"); // <- Nueva
            System.out.println("5. VACIAR todo el almacén (Borrar archivo)"); // <- Nueva
            System.out.println("6. Salir del sistema");
            System.out.print("Selecciona una opción (1-6): ");

            int opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresar nombre del libro: ");
                    String libroUsuario = teclado.nextLine();
                    mialmacen.agregarLibros(libroUsuario);
                    System.out.println("¡Libro guardado con éxito!");
                    break;

                case 2:
                    mialmacen.mostrarLibros();
                    break;

                case 3:
                    System.out.print("Ingresa el título (o parte de él) a buscar: ");
                    String libroABuscar = teclado.nextLine();
                    mialmacen.buscarLibroPorTitulo(libroABuscar);
                    break;

                case 4:
                    System.out.print("Ingresa el nombre exacto del libro que deseas borrar: ");
                    String libroABorrar = teclado.nextLine();
                    boolean exito = mialmacen.borrarLibro(libroABorrar);
                    if (exito) {
                        System.out.println("¡El libro fue eliminado correctamente!");
                    } else {
                        System.out.println("No se encontró ningún libro con ese nombre exacto.");
                    }
                    break;

                case 5:
                    System.out.print("¿Estás seguro de que quieres borrar TODOS los libros? (S/N): ");
                    String confirmacion = teclado.nextLine();
                    if (confirmacion.equalsIgnoreCase("S")) {
                        mialmacen.borrarTodo();
                        System.out.println("¡Almacén vaciado y archivo Libros.txt limpiado!");
                    } else {
                        System.out.println("Operación cancelada.");
                    }
                    break;

                case 6:
                    System.out.println("¡Gracias por usar el sistema! Cerrando...");
                    salir = true;
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, intenta de nuevo.");
                    break;
            }
        }
        teclado.close();
    }
}
