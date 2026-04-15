import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PedidoServicio {
    private List<Platillo> platillos;
    private PlatilloArchivo archivo;
    private double totalDelDia;

    public PedidoServicio(String rutaArchivo) throws IOException {
        this.archivo = new PlatilloArchivo(rutaArchivo);
        this.platillos = archivo.cargar();
    }

    public void agregarPlatillo(Platillo platillo) throws IOException {
        if (buscarPlatillo(platillo.getNombre()) != null) {
            throw new IllegalArgumentException("Ya existe un platillo con el nombre: " + platillo.getNombre());
        }
        platillos.add(platillo);
        archivo.guardar(platillos);
    }

    public Platillo buscarPlatillo(String nombre) {
        if (nombre == null) {
            return null;
        }

        for (int i = 0; i < platillos.size(); i++) {
            Platillo platillo = platillos.get(i);
            if (platillo.getNombre().equals(nombre)) {
                return platillo;
            }
        }
        return null;
    }

    public double hacerPedido(String nombre, int cantidad, EstrategiaDescuento descuento) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }

        Platillo platillo = buscarPlatillo(nombre);
        if (platillo == null) {
            throw new IllegalArgumentException("Platillo no encontrado: " + nombre);
        }

        double subtotal = platillo.getPrecio() * cantidad;
        double descuentoAplicado = descuento.calcularDescuento(subtotal, cantidad);
        if (descuentoAplicado < 0) {
            descuentoAplicado = 0;
        }
        if (descuentoAplicado > subtotal) {
            descuentoAplicado = subtotal;
        }

        double total = subtotal - descuentoAplicado;
        totalDelDia = totalDelDia + total;
        return total;
    }

    public List<Platillo> filtrarPorCategoria(String categoria) {
        List<Platillo> resultado = new ArrayList<>();
        if (categoria == null) {
            return resultado;
        }

        for (int i = 0; i < platillos.size(); i++) {
            Platillo platillo = platillos.get(i);
            if (platillo.getCategoria().equals(categoria)) {
                resultado.add(platillo);
            }
        }
        return resultado;
    }

    public double getTotalDelDia() {
        return totalDelDia;
    }
}
