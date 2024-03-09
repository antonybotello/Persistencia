package Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileManager {
    private ObjectMapper objectMapper;

    public FileManager() {
        this.objectMapper = new ObjectMapper();
    }

    public <T> T cargarDesdeJSON(String nombreArchivo, TypeReference<T> typeReference) {
        try (FileReader fileReader = new FileReader(nombreArchivo)) {
            return objectMapper.readValue(fileReader, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al cargar desde JSON.");
            return null;
        }
    }

    public void guardarEnJSON(String nombreArchivo, Object objeto) {
        try (FileWriter fileWriter = new FileWriter(nombreArchivo)) {
            objectMapper.writeValue(fileWriter, objeto);
            System.out.println("Objeto guardado en JSON correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al guardar en JSON.");
        }
    }
    public void agregarEnJSON(String nombreArchivo, Object objeto) {
        try (FileWriter fileWriter = new FileWriter(nombreArchivo)) {
            String objetoComoString = objectMapper.writeValueAsString(objeto);
            fileWriter.write(objetoComoString);
            fileWriter.write(System.lineSeparator());  // Agregar un salto de línea para separar objetos en el archivo JSON
            System.out.println("Objeto agregado en JSON correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al agregar en JSON.");
        }
    }
    
}
