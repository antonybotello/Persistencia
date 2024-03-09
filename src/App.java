import java.util.List;
import java.util.Scanner;

import Controller.LibroController;
import Models.Autor;
import Models.Biblioteca;
import Models.Libro;
import Utils.FileManager;
import com.fasterxml.jackson.core.type.TypeReference;

public class App {
    public static void main(String[] args) throws Exception {

        try {
            FileManager fileManager = new FileManager();

            LibroController libroController = new LibroController();

            // Cargar libros desde el archivo al inicio
            libroController.cargarLibrosDesdeArchivo("libros.json");

            Scanner scanner = new Scanner(System.in);

            int opcion;

            do {
                System.out.println("\nMenú:");
                System.out.println("1. Mostrar libros existentes");
                System.out.println("2. Agregar un nuevo libro");
                System.out.println("3. Eliminar un libro");
                System.out.println("4. Buscar un libro por título");
                System.out.println("0. Salir");

                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        libroController.mostrarLibros();
                        break;
                    case 2:
                        Libro nuevoLibro = new Libro();
                        scanner.nextLine();
                        // Solicitar detalles del nuevo libro al usuario
                        System.out.print("Ingrese el título del nuevo libro: ");
                        String nuevoTitulo = scanner.nextLine();
                        // Crear una nueva instancia de Libro con los detalles proporcionados
                        // Solicitar detalles del autor
                        System.out.print("Ingrese el nombre del autor: ");
                        String nombreAutor = scanner.nextLine();
                        System.out.print("Ingrese el apellido del autor: ");
                        String apellidoAutor = scanner.nextLine();
                        // Crear una nueva instancia de Autor con los detalles proporcionados
                        Autor nuevoAutor = new Autor();
                        nuevoAutor.setNombre(nombreAutor);
                        nuevoAutor.setApellido(apellidoAutor);

                        // Solicitar detalles de la biblioteca
                        System.out.print("Ingrese el nombre de la biblioteca: ");
                        String nombreBiblioteca = scanner.nextLine();
                        System.out.print("Ingrese la dirección de la biblioteca: ");
                        String direccionBiblioteca = scanner.nextLine();

                        // Crear una nueva instancia de Biblioteca con los detalles proporcionados
                        Biblioteca nuevaBiblioteca = new Biblioteca();
                        nuevaBiblioteca.setNombre(nombreBiblioteca);
                        nuevaBiblioteca.setDireccion(direccionBiblioteca);

                        // Crear una nueva instancia de Libro con los detalles proporcionados
                        nuevoLibro.setTitulo(nuevoTitulo);
                        nuevoLibro.setAutor(nuevoAutor);
                        nuevoLibro.setBiblioteca(nuevaBiblioteca);
                        // Puedes agregar más detalles según sea necesario

                        // Agregar el nuevo libro a la lista
                        libroController.agregarLibro(nuevoLibro);

                        // Mostrar mensaje de éxito
                        System.out.println("Libro agregado exitosamente: " + nuevoLibro);
                        fileManager.agregarEnJSON("libros.json", libroController.getListaLibros());


                        break;
                    case 3:
                        break;
                    case 4:
                    System.out.println("Escriba el titulo de libro: ");
                    scanner.nextLine();
                    String tituloBusqueda= scanner.nextLine();
                    Libro busquedaLibro=libroController.buscarLibroPorTitulo(tituloBusqueda);
                    if (busquedaLibro == null){
                        System.out.println("El libro "+tituloBusqueda+" No existe en esta biblioteca");
                    }else{
                        System.out.println(busquedaLibro+"| autor: "+busquedaLibro.getAutor());
                    }
                        break;
                    case 0:
                        // Guardar libros en el archivo antes de salir
                        fileManager.guardarEnJSON("libros.json", libroController.getListaLibros());
                        System.out.println("Saliendo del programa.");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } while (opcion != 0);
            
            // Cargar libros desde el archivo
            List<Libro> librosCargados = fileManager.cargarDesdeJSON("libros.json", new TypeReference<List<Libro>>() {
            });
            libroController.getListaLibros().clear(); // Limpiar la lista existente antes de agregar los libros cargados
            libroController.getListaLibros().addAll(librosCargados);

            // Imprimir la lista de libros después de cargar desde el archivo
            System.out.println("Libros cargados desde JSON:");
            libroController.getListaLibros().forEach(libro -> System.out.println(libro.getTitulo()));

        } catch (Exception e) {
            e.printStackTrace();
            // Manejar la excepción de manera adecuada según tus necesidades
        }
    }
}