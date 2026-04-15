# 🧩 Patrón Strategy - Sistema de Pedidos

Implementación en **Java** del **Patrón Strategy** para gestionar distintos tipos de descuentos en un sistema de pedidos.

## 📋 ¿Qué hace?

- **Gestión de descuentos**: Porcentaje, fijo, 2x1 y sin descuento
- **Persistencia CSV**: Lectura/escritura de menú y pedidos
- **Diseño orientado a objetos**: Aplicación de patrones de diseño
- **Separación de responsabilidades**: Código limpio y mantenible

## 🛠️ Tech Stack

| Lenguaje | Patrón | Persistencia |
|----------|--------|--------------|
| Java 11+ | Strategy | CSV |
| POO | Factory | File I/O |

## 🚀 Cómo correrlo localmente

### Prerrequisitos

```bash
java --version  # JDK 11+
```

### Instalación

```bash
# Clonar repositorio
git clone https://github.com/epinki07/patron-strategy-pedidos.git
cd patron-strategy-pedidos

# Compilar
javac -d out src/**/*.java

# Ejecutar
java -cp out com.pedidos.Main
```

## 📁 Estructura del proyecto

```
patron-strategy-pedidos/
├── src/
│   ├── Main.java
│   ├── model/
│   │   ├── Pedido.java
│   │   ├── Producto.java
│   │   └── Descuento.java
│   ├── strategy/
│   │   ├── DescuentoStrategy.java  # Interface
│   │   ├── PorcentajeStrategy.java
│   │   ├── FijoStrategy.java
│   │   ├── DosXUnoStrategy.java
│   │   └── SinDescuentoStrategy.java
│   └── repository/
│       └── CSVRepository.java
├── data/
│   ├── menu.csv
│   └── pedidos.csv
└── README.md
```

## 📖 Patrón Strategy

El **Patrón Strategy** permite definir una familia de algoritmos, encapsular cada uno y hacerlos intercambiables.

```java
// Interface común
interface DescuentoStrategy {
    double aplicar(double precioTotal);
}

// Implementación concreta
class PorcentajeStrategy implements DescuentoStrategy {
    private int porcentaje;
    
    public double aplicar(double precioTotal) {
        return precioTotal * (1 - porcentaje / 100.0);
    }
}
```

### Beneficios

- ✅ **Open/Closed**: Abierto a extensión, cerrado a modificación
- ✅ **Single Responsibility**: Cada estrategia tiene una responsabilidad
- ✅ **Fácil testing**: Strategies aisladas y testeables
- ✅ **Mantenible**: Cambiar descuentos no afecta el core

## 💡 Qué aprendí

- **Patrones de diseño**: Strategy, Factory, Repository
- **Arquitectura limpia**: Separación por capas
- **Manejo de CSV**: Lectura/escritura en Java
- **POO avanzada**: Interfaces, clases abstractas, polimorfismo

## 🤝 Autor

**Diego Ramirez Magaña**

- 📧 dramirezmagana@gmail.com
- 🔗 [LinkedIn](https://www.linkedin.com/in/diego-ramirez-maga%C3%B1a-b15022298/)
- 🐙 [GitHub](https://github.com/epinki07)
