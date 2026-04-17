# Sistema de Pedidos con Patron Strategy

Implementacion en Java del Patron Strategy para gestionar distintos tipos de descuento en un sistema de pedidos. Incluye persistencia en CSV y separacion por capas.

## Que hace

El sistema permite crear pedidos y aplicar diferentes estrategias de descuento (porcentaje, fijo, 2x1 o sin descuento) de forma intercambiable, sin modificar la logica del pedido. El menu y los pedidos se leen y escriben en archivos CSV.

## Por que este diseno

El Patron Strategy permite agregar o cambiar reglas de descuento sin tocar el codigo central. Cada estrategia es una clase independiente que implementa la misma interfaz, lo que hace el sistema extensible sin romper lo que ya funciona.

```java
interface DescuentoStrategy {
    double aplicar(double precioTotal);
}

class PorcentajeStrategy implements DescuentoStrategy {
    private int porcentaje;
    public double aplicar(double precioTotal) {
        return precioTotal * (1 - porcentaje / 100.0);
    }
}
```

## Como correrlo

```bash
git clone https://github.com/epinki07/patron-strategy-pedidos.git
cd patron-strategy-pedidos
javac -d out src/**/*.java
java -cp out com.pedidos.Main
```

## Estructura

```
patron-strategy-pedidos/
├── src/
│   ├── Main.java
│   ├── model/
│   ├── strategy/
│   │   ├── DescuentoStrategy.java
│   │   ├── PorcentajeStrategy.java
│   │   ├── FijoStrategy.java
│   │   ├── DosXUnoStrategy.java
│   │   └── SinDescuentoStrategy.java
│   └── repository/
│       └── CSVRepository.java
└── data/
    ├── menu.csv
    └── pedidos.csv
```

## Tech Stack

Java 11+, POO, persistencia en CSV.

## Autor

Diego Ramirez Magana — [LinkedIn](https://www.linkedin.com/in/diego-ramirez-maga%C3%B1a-b15022298/) | [GitHub](https://github.com/epinki07) | dramirezmagana@gmail.com
