import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            PedidoServicio servicio = new PedidoServicio("menu.csv");

            if (servicio.buscarPlatillo("Tacos") == null) {
                servicio.agregarPlatillo(new Platillo("Tacos", 45.0, "Mexicana"));
            }
            if (servicio.buscarPlatillo("Quesadilla") == null) {
                servicio.agregarPlatillo(new Platillo("Quesadilla", 55.0, "Mexicana"));
            }
            if (servicio.buscarPlatillo("Pizza") == null) {
                servicio.agregarPlatillo(new Platillo("Pizza", 120.0, "Italiana"));
            }
            if (servicio.buscarPlatillo("Limonada") == null) {
                servicio.agregarPlatillo(new Platillo("Limonada", 30.0, "Bebidas"));
            }

            double totalPedido1 = servicio.hacerPedido("Tacos", 2, new DescuentoPorcentaje(15));
            System.out.println("Pedido 1: 2x Tacos");
            System.out.println("Total: $" + totalPedido1);

            double totalPedido2 = servicio.hacerPedido("Pizza", 1, new DescuentoFijo(25));
            System.out.println("Pedido 2: 1x Pizza");
            System.out.println("Total: $" + totalPedido2);

            Platillo quesadilla = servicio.buscarPlatillo("Quesadilla");
            double totalPedido3 = servicio.hacerPedido("Quesadilla", 3, new DescuentoDosXUno(quesadilla.getPrecio()));
            System.out.println("Pedido 3: 3x Quesadilla");
            System.out.println("Total: $" + totalPedido3);

            System.out.println();
            System.out.println("Platillos de la categoria Mexicana:");
            List<Platillo> platillosMexicanos = servicio.filtrarPorCategoria("Mexicana");
            for (Platillo platillo : platillosMexicanos) {
                System.out.println(platillo);
            }

            System.out.println();
            System.out.println("Total de ventas del dia: $" + servicio.getTotalDelDia());
        } catch (IOException e) {
            System.err.println("Error de archivo: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error de validacion: " + e.getMessage());
        }
    }
}
