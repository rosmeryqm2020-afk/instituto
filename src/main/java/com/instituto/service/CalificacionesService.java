package com.instituto.service;

import org.springframework.stereotype.Service;

@Service
public class CalificacionesService {

    // Arreglo unidimensional de exactamente 110 estudiantes
    private final double[] calificaciones = new double[110];
    private int cantidad = 0; // cuántas notas se han ingresado

    // Agregar una calificación
    public String agregarCalificacion(double valor) {
        if (cantidad >= 110) {
            return "❌ El arreglo está lleno. Máximo 110 calificaciones.";
        }
        calificaciones[cantidad] = valor;
        cantidad++;
        return "✅ Calificación " + valor + " agregada. Total: " + cantidad + "/110";
    }

    // Mostrar todas las calificaciones ingresadas
    public double[] mostrarTodas() {
        double[] resultado = new double[cantidad];
        for (int i = 0; i < cantidad; i++) {
            resultado[i] = calificaciones[i];
        }
        return resultado;
    }

    // Mostrar solo las notas de aprobación (>= 60)
    public double[] mostrarAprobados() {
        int count = 0;
        for (int i = 0; i < cantidad; i++) {
            if (calificaciones[i] >= 60) count++;
        }
        double[] aprobados = new double[count];
        int j = 0;
        for (int i = 0; i < cantidad; i++) {
            if (calificaciones[i] >= 60) {
                aprobados[j] = calificaciones[i];
                j++;
            }
        }
        return aprobados;
    }

    // Calcular promedio
    public double calcularPromedio() {
        if (cantidad == 0) return 0;
        double suma = 0;
        for (int i = 0; i < cantidad; i++) {
            suma += calificaciones[i];
        }
        return suma / cantidad;
    }

    // Obtener nota mayor (máxima)
    public double obtenerMax() {
        if (cantidad == 0) return -1;
        double max = calificaciones[0];
        for (int i = 1; i < cantidad; i++) {
            if (calificaciones[i] > max) {
                max = calificaciones[i];
            }
        }
        return max;
    }

    // Obtener nota menor (mínima)
    public double obtenerMin() {
        if (cantidad == 0) return -1;
        double min = calificaciones[0];
        for (int i = 1; i < cantidad; i++) {
            if (calificaciones[i] < min) {
                min = calificaciones[i];
            }
        }
        return min;
    }

    public int getCantidad() {
        return cantidad;
    }
}
