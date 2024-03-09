package Models;
enum EstadoLibro {
    DISPONIBLE,
    PRESTADO,
    REPARACION,
    DESCONTINUADO
}
public class Libro {
    private String titulo;
    private Autor autor;
    private Biblioteca biblioteca;
    private EstadoLibro estado; // Enum para representar el estado
    public Libro() {
        this.estado = EstadoLibro.DISPONIBLE;
    }
    
   
    public Libro( String titulo, Autor autor, Biblioteca biblioteca) {
        
        this.titulo = titulo;
        this.autor = autor;
        this.biblioteca = biblioteca;
        this.estado = EstadoLibro.DISPONIBLE;

      
    }
   
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Autor getAutor() {
        return autor;
    }
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }
    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
    public EstadoLibro getEstado() {
        return estado;
    }
    public void setEstado(EstadoLibro estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return titulo;
    }
    

}
