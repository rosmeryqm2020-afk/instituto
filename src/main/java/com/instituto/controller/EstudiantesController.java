package com.instituto.controller;

import com.instituto.model.Estudiante;
import com.instituto.service.EstudiantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/estudiantes")
public class EstudiantesController {

    @Autowired
    private EstudiantesService service;

    // GET /estudiantes/agregar?nombre=Ana&puntaje=95&id=1
    @GetMapping("/agregar")
    public Map<String, Object> agregar(
            @RequestParam int id,
            @RequestParam String nombre,
            @RequestParam double puntaje) {
        Map<String, Object> resp = new HashMap<>();
        resp.put("mensaje", service.agregarEstudiante(id, nombre, puntaje));
        return resp;
    }

    // GET /estudiantes → muestra todos los estudiantes
    @GetMapping
    public Map<String, Object> mostrarTodos() {
        Map<String, Object> resp = new HashMap<>();
        List<Estudiante> lista = service.mostrarTodos();
        resp.put("estudiantes", lista);
        resp.put("total", lista.size());
        return resp;
    }

    // GET /estudiantes/ordenados → aprobados ordenados de mayor a menor puntaje
    @GetMapping("/ordenados")
    public Map<String, Object> ordenados() {
        Map<String, Object> resp = new HashMap<>();
        List<Estudiante> lista = service.mostrarOrdenados();
        resp.put("aprobados_ordenados", lista);
        resp.put("total_aprobados", lista.size());
        resp.put("criterio", "Puntaje >= 60, de mayor a menor");
        return resp;
    }

    // GET /estudiantes/buscar/{nombre}
    @GetMapping("/buscar/{nombre}")
    public Map<String, Object> buscar(@PathVariable String nombre) {
        Map<String, Object> resp = new HashMap<>();
        Estudiante e = service.buscarPorNombre(nombre);
        if (e != null) {
            resp.put("encontrado", true);
            resp.put("estudiante", e);
        } else {
            resp.put("encontrado", false);
            resp.put("mensaje", "No se encontró el estudiante con nombre: " + nombre);
        }
        return resp;
    }
}
