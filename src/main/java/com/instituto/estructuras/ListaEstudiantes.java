package com.instituto.estructuras;

import com.instituto.model.Estudiante;
import java.util.ArrayList;
import java.util.List;

public class ListaEstudiantes {

    private Nodo cabeza;
    private int tamanio;

    public ListaEstudiantes() {
        this.cabeza = null;
        this.tamanio = 0;
    }

    // Insertar un estudiante al final de la lista
    public void insertar(Estudiante estudiante) {
        Nodo nuevo = new Nodo(estudiante);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        tamanio++;
    }

    // Mostrar todos los estudiantes como lista
    public List<Estudiante> mostrarTodos() {
        List<Estudiante> lista = new ArrayList<>();
        Nodo actual = cabeza;
        while (actual != null) {
            lista.add(actual.estudiante);
            actual = actual.siguiente;
        }
        return lista;
    }

    // Buscar estudiante por nombre
    public Estudiante buscarPorNombre(String nombre) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.estudiante.getNombre().equalsIgnoreCase(nombre)) {
                return actual.estudiante;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    // Ordenar solo aprobados (puntaje >= 60) de mayor a menor usando Bubble Sort
    public List<Estudiante> ordenarAprobadosPorPuntaje() {
        // Primero recoger solo los aprobados
        List<Estudiante> aprobados = new ArrayList<>();
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.estudiante.getPuntaje() >= 60) {
                aprobados.add(actual.estudiante);
            }
            actual = actual.siguiente;
        }

        // Bubble Sort de mayor a menor
        int n = aprobados.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (aprobados.get(j).getPuntaje() < aprobados.get(j + 1).getPuntaje()) {
                    // Intercambiar
                    Estudiante temp = aprobados.get(j);
                    aprobados.set(j, aprobados.get(j + 1));
                    aprobados.set(j + 1, temp);
                }
            }
        }

        return aprobados;
    }

    public int getTamanio() {
        return tamanio;
    }
}
