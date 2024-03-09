package Models;

public class Prestamo {
    private int id;
    private Libro libro;
    private String fechaPrestamo;
    private String fechaEntrega;
    public Prestamo() {
    }
    public Prestamo(int id, Libro libro, String fechaPrestamo, String fechaEntrega) {
        this.id = id;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Libro getLibro() {
        return libro;
    }
    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    public String getFechaPrestamo() {
        return fechaPrestamo;
    }
    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
    public String getFechaEntrega() {
        return fechaEntrega;
    }
    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    @Override
    public String toString() {
        return "#"+ id;
    } 
    
}
