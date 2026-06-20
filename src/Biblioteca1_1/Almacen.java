/*Omar Garcia
Version 1.2
La version 1.0 solo guarda archivos mientras el progrma este vivo.
Reemplazar con un txt para poder guardar correctamente.
Version 1.2 admite busqueda de libros por texto y eliminacion de libros por titulo o todo el archivo.

 */

package Biblioteca1_1;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Almacen {
    private ArrayList<String> books;
    private final String NOMBRE_ARCHVO = "Libros.txt";

    public Almacen(){
        this.books = new ArrayList<>();
        cargarLibrosArchivo();
    }

    public void agregarLibros(String libro){
        this.books.add(libro);
        guardar(libro);
    }

    public void mostrarLibros(){
        System.out.println("---Libros disponibles---");
        if (this.books.isEmpty()){
            System.out.println("El almacen esta vacio");
        }
        else{
            for (String libro : this.books){
                System.out.println("- " + libro);
            }
        }
    }

    public void buscarLibroPorTitulo(String tituloBuscar) {
        System.out.println("--- Resultados de la búsqueda para: \"" + tituloBuscar + "\" ---");
        boolean encontrado = false;
        for (String libro : this.books) {
            if (libro.toLowerCase().contains(tituloBuscar.toLowerCase())) {
                System.out.println("- " + libro);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún libro con ese título.");
        }
    }


    public boolean borrarLibro(String libroABorrar) {
        boolean eliminado = false;
        // Buscamos coincidencia exacta (ignorando mayúsculas/minúsculas)
        for (int i = 0; i < this.books.size(); i++) {
            if (this.books.get(i).equalsIgnoreCase(libroABorrar)) {
                this.books.remove(i);
                eliminado = true;
                break; // Rompe el ciclo al borrar el primero que coincida
            }
        }

        // Si se eliminó de la lista, reescribimos el archivo txt completo
        if (eliminado) {
            reescribirArchivoCompleto();
        }
        return eliminado;
    }


    public void borrarTodo() {
        this.books.clear(); // Vacía la lista en memoria
        reescribirArchivoCompleto(); // Sobrescribe el archivo dejándolo vacío
    }
    private void reescribirArchivoCompleto() {
        try (FileWriter fw = new FileWriter(NOMBRE_ARCHVO, false); PrintWriter pw = new PrintWriter(fw)){
            for (String libro : this.books) {
                pw.println(libro);
            }
        } catch (IOException e){
            System.out.println("Error al actualizar el archivo: " + e.getMessage());
        }
    }

    private void guardar(String libro){
        try (FileWriter fw = new FileWriter(NOMBRE_ARCHVO,true); PrintWriter pw = new PrintWriter(fw)){
            pw.println(libro);
        }
        catch (IOException e){
            System.out.println("Error al guardar el archivo: "+ e.getMessage());
        }
    }

    private void cargarLibrosArchivo(){
        File archivo = new File(NOMBRE_ARCHVO);
        if (!archivo.exists()){
            return;
        }
        try (FileReader fr = new FileReader(archivo); BufferedReader br = new BufferedReader(fr)){
            String linea;
            while ((linea = br.readLine()) != null){
                if (!linea.trim().isEmpty()){
                    this.books.add(linea);
                }
            }
        }
        catch (IOException e){
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
    }
}
