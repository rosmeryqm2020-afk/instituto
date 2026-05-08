package com.instituto.service;

import org.springframework.stereotype.Service;

@Service
public class AulaService {

    // Matriz 5 filas x 15 columnas
    // 0 = asiento libre, 1 = asiento ocupado
    private final int[][] aula = new int[5][15];

    public AulaService() {
        // Inicializar todos los asientos como libres (0)
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 15; j++) {
                aula[i][j] = 0;
            }
        }
    }

    // Ocupar un asiento
    public String ocuparAsiento(int fila, int columna) {
        if (!esValido(fila, columna)) {
            return "❌ Posición inválida. Fila: 0-4, Columna: 0-14";
        }
        if (aula[fila][columna] == 1) {
            return "❌ El asiento [" + fila + "][" + columna + "] ya está ocupado.";
        }
        aula[fila][columna] = 1;
        return "✅ Asiento [" + fila + "][" + columna + "] ocupado.";
    }

    // Liberar un asiento
    public String liberarAsiento(int fila, int columna) {
        if (!esValido(fila, columna)) {
            return "❌ Posición inválida. Fila: 0-4, Columna: 0-14";
        }
        if (aula[fila][columna] == 0) {
            return "❌ El asiento [" + fila + "][" + columna + "] ya está libre.";
        }
        aula[fila][columna] = 0;
        return "✅ Asiento [" + fila + "][" + columna + "] liberado.";
    }

    // Mostrar la matriz completa
    public int[][] mostrarMatriz() {
        return aula;
    }

    // Contar asientos ocupados
    public int contarOcupados() {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 15; j++) {
                if (aula[i][j] == 1) count++;
            }
        }
        return count;
    }

    // Validar que la posición sea correcta
    private boolean esValido(int fila, int columna) {
        return fila >= 0 && fila < 5 && columna >= 0 && columna < 15;
    }
}
