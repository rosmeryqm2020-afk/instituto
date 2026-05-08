package com.instituto.controller;

import com.instituto.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/aula")
public class AulaController {

    @Autowired
    private AulaService service;

    // GET /aula → muestra la matriz completa
    @GetMapping
    public Map<String, Object> mostrarAula() {
        Map<String, Object> resp = new HashMap<>();
        resp.put("matriz_5x15", service.mostrarMatriz());
        resp.put("leyenda", "0 = libre, 1 = ocupado");
        resp.put("asientos_ocupados", service.contarOcupados());
        resp.put("asientos_libres", 75 - service.contarOcupados());
        return resp;
    }

    // GET /aula/ocupados
    @GetMapping("/ocupados")
    public Map<String, Object> ocupados() {
        Map<String, Object> resp = new HashMap<>();
        resp.put("ocupados", service.contarOcupados());
        resp.put("libres", 75 - service.contarOcupados());
        resp.put("total", 75);
        return resp;
    }

    // GET /aula/ocupar?fila=1&columna=2
    @GetMapping("/ocupar")
    public Map<String, Object> ocupar(@RequestParam int fila, @RequestParam int columna) {
        Map<String, Object> resp = new HashMap<>();
        resp.put("mensaje", service.ocuparAsiento(fila, columna));
        resp.put("matriz", service.mostrarMatriz());
        return resp;
    }

    // GET /aula/liberar?fila=1&columna=2
    @GetMapping("/liberar")
    public Map<String, Object> liberar(@RequestParam int fila, @RequestParam int columna) {
        Map<String, Object> resp = new HashMap<>();
        resp.put("mensaje", service.liberarAsiento(fila, columna));
        resp.put("matriz", service.mostrarMatriz());
        return resp;
    }
}
