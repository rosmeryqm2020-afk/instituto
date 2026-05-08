package com.instituto.controller;

import com.instituto.service.CalificacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/notas")
public class CalificacionesController {

    @Autowired
    private CalificacionesService service;

    // GET /notas/agregar?valor=85
    @GetMapping("/agregar")
    public Map<String, Object> agregar(@RequestParam double valor) {
        Map<String, Object> resp = new HashMap<>();
        resp.put("mensaje", service.agregarCalificacion(valor));
        resp.put("total_ingresadas", service.getCantidad());
        return resp;
    }

    // GET /notas → muestra todas las calificaciones ingresadas
    @GetMapping
    public Map<String, Object> mostrarTodas() {
        Map<String, Object> resp = new HashMap<>();
        resp.put("calificaciones", service.mostrarTodas());
        resp.put("aprobados", service.mostrarAprobados());
        resp.put("total", service.getCantidad());
        return resp;
    }

    // GET /notas/promedio
    @GetMapping("/promedio")
    public Map<String, Object> promedio() {
        Map<String, Object> resp = new HashMap<>();
        resp.put("promedio", service.calcularPromedio());
        return resp;
    }

    // GET /notas/max
    @GetMapping("/max")
    public Map<String, Object> max() {
        Map<String, Object> resp = new HashMap<>();
        resp.put("nota_maxima", service.obtenerMax());
        return resp;
    }

    // GET /notas/min
    @GetMapping("/min")
    public Map<String, Object> min() {
        Map<String, Object> resp = new HashMap<>();
        resp.put("nota_minima", service.obtenerMin());
        return resp;
    }
}
