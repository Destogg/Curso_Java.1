/*Omar Garcia
Version 1.1
La version 1.0 solo guarda archivos mientras el progrma este vivo.
Reemplazar con un txt para poder guardar correctamente.
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
    //Declarar Almacen
    private ArrayList<String> books;
    private final String NOMBRE_ARCHVO = "Libros.txt";
    //Constructor para ingresar libros al txt
    public Almacen(){
        this.books = new ArrayList<>();
        cargarLibrosArchivo();
    }
    //agregar libros a la consola
    public void agregarLibros(String libro){
        this.books.add(libro);
        guardar(libro);
    }
    //mostrar libros al usuario
    public void mostrarLibros(){
        System.out.println("---Libros disponibles---");
        //Vacio mensaje de error
        if (this.books.isEmpty()){
            System.out.println("El almacen esta vacio");
        }
        //Con elementos se muestra
        else{
            for (String libro : this.books){
                System.out.println("- " + libro);
            }

        }
    }
    //metodo para pasar los datos al txt
    private void guardar(String libro){
        //true ayuda a que no se borre lo anterior en el archivo
        try (FileWriter fw = new FileWriter(NOMBRE_ARCHVO,true); PrintWriter pw = new PrintWriter(fw)){
            pw.println(libro);

        }
        catch (IOException e){
            System.out.println("Error al guardar el archivo: "+ e.getMessage());

        }

    }
    //El nombre lo dice crack, metodo para mostrar los datos del txt
    private void cargarLibrosArchivo(){
        File archivo = new File(NOMBRE_ARCHVO);
        if (!archivo.exists()){
            return;
        }
        try (FileReader fr = new FileReader(archivo); BufferedReader br = new BufferedReader(fr)){
            String linea;
            //lee el arhivo hasta el final
            while ((linea = br.readLine()) != null){
                if (!linea.trim().isEmpty()){
                    this.books.add(linea);//añade el libro
                }
            }
        }
        catch (IOException e){
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
    }
}
