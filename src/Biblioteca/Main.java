/*Version 1.0
Interfaz de usario
Llamar a clase y metodo Almacen */
package Biblioteca;
import java.util.Scanner;



public class Main {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        System.out.println("****Bienvenido****");
        System.out.println("Ingresar libro: ");
        String libroUsuario = teclado.nextLine();
        Almacen mialmacen = new Almacen(libroUsuario);
        System.out.println("Libro guardado correctamente");

        //Mostrar libros
        mialmacen.mostrarLibros();

    }
}

