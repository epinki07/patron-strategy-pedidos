import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PlatilloArchivo {
    private String rutaArchivo;

    public PlatilloArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public void guardar(List<Platillo> platillos) throws IOException {
        try (PrintWriter escritor = new PrintWriter(new FileWriter(rutaArchivo))) {
            for (Platillo platillo : platillos) {
                escritor.println(platillo.toCSV());
            }
        }
    }

    public List<Platillo> cargar() throws IOException {
        List<Platillo> platillos = new ArrayList<>();
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            return platillos;
        }

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                try {
                    platillos.add(Platillo.fromCSV(linea));
                } catch (IllegalArgumentException e) {
                    System.err.println("Advertencia: se ignoro una linea invalida: " + linea);
                }
            }
        }
        return platillos;
    }
}
