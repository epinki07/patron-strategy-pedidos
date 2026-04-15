public class DescuentoDosXUno implements EstrategiaDescuento {
    private double precioUnitario;

    public DescuentoDosXUno(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public double calcularDescuento(double subtotal, int cantidad) {
        return precioUnitario * (cantidad / 2);
    }
}
