public class DescuentoPorcentaje implements EstrategiaDescuento {
    private double porcentaje;

    public DescuentoPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public double calcularDescuento(double subtotal, int cantidad) {
        return subtotal * (porcentaje / 100.0);
    }
}
