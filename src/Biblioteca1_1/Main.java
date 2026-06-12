/* Omar Garcia
Sistema de biblioteca 1.1
Se ajusto el menu de usuario para mayor facilidad.
Se modifico el archivo almacen para guardar los libros en un txt
Se ajustan metodos guardar y mostrar para que no colapse con el txt
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
            // menú de opciones agregen las que necesiten
            System.out.println("\n--- MENÚ DE OPCIONES ---");
            System.out.println("1. Registrar un nuevo libro");
            System.out.println("2. Ver todos los libros disponibles");
            System.out.println("3. Salir del sistema");
            System.out.print("Selecciona una opción (1-3): ");

            int opcion = teclado.nextInt();
            teclado.nextLine();

            // Switch case para que sea mas limpio
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
                    //Aqui se cambia el valor de salir false a true
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