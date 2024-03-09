package Controller;

import Models.Libro;
import Utils.FileManager;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;

public class LibroController {
    private List<Libro> listaLibros;
    private FileManager fileManager;

    public LibroController() {
        this.listaLibros = new ArrayList<>();
        this.fileManager = new FileManager();
    }

    public void agregarLibro(Libro libro) {
        listaLibros.add(libro);
    }

    public List<Libro> getListaLibros() {
        return listaLibros;
    }

 

    public void cargarLibrosDesdeArchivo(String nombreArchivo) {
        List<Libro> librosCargados = fileManager.cargarDesdeJSON(nombreArchivo, new TypeReference<List<Libro>>() {});
        listaLibros.clear(); // Limpiar la lista existente antes de agregar los libros cargados
        listaLibros.addAll(librosCargados);
    }

    public void guardarLibrosEnArchivo(String nombreArchivo) {
        fileManager.guardarEnJSON(nombreArchivo, listaLibros);
    }

    public void mostrarLibros() {
        System.out.println("\nLibros existentes:");
        for (Libro libro : listaLibros) {
            System.out.println(libro);
        }
    }

    public Libro buscarLibroPorTitulo(String titulo) {
        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro; // Devolver el libro si se encuentra
            }
        }
        return null; // Devolver null si no se encuentra el libro con el título proporcionado
    }

}
