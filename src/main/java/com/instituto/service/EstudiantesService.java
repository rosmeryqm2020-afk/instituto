package com.instituto.service;

import com.instituto.estructuras.ListaEstudiantes;
import com.instituto.model.Estudiante;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudiantesService {

    private final ListaEstudiantes lista = new ListaEstudiantes();

    public String agregarEstudiante(int id, String nombre, double puntaje) {
        Estudiante e = new Estudiante(id, nombre, puntaje);
        lista.insertar(e);
        return "✅ Estudiante '" + nombre + "' con id=" + id + " y puntaje=" + puntaje + " agregado.";
    }

    public List<Estudiante> mostrarTodos() {
        return lista.mostrarTodos();
    }

    public List<Estudiante> mostrarOrdenados() {
        return lista.ordenarAprobadosPorPuntaje();
    }

    public Estudiante buscarPorNombre(String nombre) {
        return lista.buscarPorNombre(nombre);
    }
}
