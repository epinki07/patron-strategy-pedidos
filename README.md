# Patron Strategy Pedidos

Sistema de pedidos en Java que implementa el patron Strategy para aplicar descuentos intercambiables sin modificar la logica central del pedido.

## Funcionalidades

- Carga de platillos desde `menu.csv`.
- Registro de platillos si no existen.
- Aplicacion de descuentos por estrategia.
- Ejemplo de separacion entre servicio, modelo y reglas de descuento.

## Estrategias incluidas

| Clase | Regla |
|---|---|
| `SinDescuento` | Mantiene el precio original. |
| `DescuentoPorcentaje` | Aplica porcentaje sobre el total. |
| `DescuentoFijo` | Resta una cantidad fija. |
| `DescuentoDosXUno` | Simula promocion 2x1. |

## Estructura

```text
patron-strategy-pedidos/
├── Main.java
├── PedidoServicio.java
├── Platillo.java
├── PlatilloArchivo.java
├── EstrategiaDescuento.java
├── DescuentoPorcentaje.java
├── DescuentoFijo.java
├── DescuentoDosXUno.java
├── SinDescuento.java
└── menu.csv
```

## Ejecucion

```bash
javac *.java
java Main
```

## Stack

Java, POO, patron Strategy, persistencia CSV.

## Derechos

Codigo publicado para revision profesional. Sin licencia de reutilizacion; todos los derechos reservados.
