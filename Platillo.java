public class Platillo {

    private String nombre;
    private double precio;
    private String categoria;

    public Platillo(String nombre, double precio, String categoria) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }
        this.nombre = nombre;
        this.precio = precio;
        if (categoria == null) {
            this.categoria = "";
        } else {
            this.categoria = categoria;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public String toCSV() {
        return nombre + "," + precio + "," + categoria;
    }

    public static Platillo fromCSV(String linea) {
        if (linea == null || linea.isEmpty()) {
            throw new IllegalArgumentException("La linea no puede estar vacia");
        }
        String[] partes = linea.split(",");
        if (partes.length != 3) {
            throw new IllegalArgumentException("La linea debe tener 3 campos: " + linea);
        }
        double precio;
        try {
            precio = Double.parseDouble(partes[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El precio no es numerico: " + partes[1]);
        }
        return new Platillo(partes[0], precio, partes[2]);
    }

    @Override
    public String toString() {
        return nombre + " - $" + precio + " (" + categoria + ")";
    }
}
