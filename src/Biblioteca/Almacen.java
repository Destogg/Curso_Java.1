/* Omar Garcia.
Version 1.0
Sistema de bilioteca
*/
package Biblioteca;

//Importar clase Array
//Ingresar datos con clase Scanner
import java.util.ArrayList;

public class Almacen {
    private ArrayList<String> books;

    public Almacen(String primerLibro){
        this.books = new ArrayList<>();
        this.books.add(primerLibro);

    }
    public void mostrarLibros(){
        System.out.println("---Libros disponible---");
        for(String libro : this.books){
            System.out.println("- " + libro);
        }
    }

}
