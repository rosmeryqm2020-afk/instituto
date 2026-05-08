# Instituto - Sistema para administrar

API REST desarrollada con **Spring Boot** para gestionar calificaciones, asientos de aula y estudiantes.

## Tecnologías
- Java 17
- Spring Boot 
- Maven

## Estructura del Proyecto
```
src/main/java/com/instituto/
 ├── controller/
 │   ├── CalificacionesController.java
 │   ├── AulaController.java
 │   └── EstudiantesController.java
 ├── model/
 │   └── Estudiante.java
 ├── service/
 │   ├── CalificacionesService.java
 │   ├── AulaService.java
 │   └── EstudiantesService.java
 └── estructuras/
     ├── Nodo.java
     └── ListaEstudiantes.java
```

## como se ejecuta, de esta siguente manera:

### Requisitos
- Java 17 instalado
- Maven instalado

### Pasos
```bash
git clone <URL_DEL_REPOSITORIO>
cd instituto
mvn spring-boot:run
```
La aplicacion estara disponible en: `http://localhost:8080`

---

## Endpoints disponibles

### Parte 1 – Calificaciones (Arreglo Unidimensional)
| Endpoint | Descripción |
|---|---|
| `GET /notas/agregar?valor=85` | Agregar calificación |
| `GET /notas` | Ver todas las notas y aprobados |
| `GET /notas/promedio` | Ver promedio |
| `GET /notas/max` | Ver nota máxima |
| `GET /notas/min` | Ver nota mínima |

**Ejemplos de prueba:**
```
http://localhost:8080/notas/agregar?valor=85
http://localhost:8080/notas/agregar?valor=45
http://localhost:8080/notas/agregar?valor=72
http://localhost:8080/notas
http://localhost:8080/notas/promedio
http://localhost:8080/notas/max
http://localhost:8080/notas/min
```

---

### Parte 2 – Aula (Arreglo Bidimensional 5x15)
| Endpoint | Descripción |
|---|---|
| `GET /aula` | Ver matriz completa |
| `GET /aula/ocupados` | Cantidad de asientos ocupados |
| `GET /aula/ocupar?fila=1&columna=2` | Ocupar un asiento |
| `GET /aula/liberar?fila=1&columna=2` | Liberar un asiento |

> Filas: 0–4 | Columnas: 0–14

**Ejemplos de prueba:**
```
http://localhost:8080/aula
http://localhost:8080/aula/ocupar?fila=0&columna=0
http://localhost:8080/aula/ocupar?fila=2&columna=5
http://localhost:8080/aula/liberar?fila=0&columna=0
http://localhost:8080/aula/ocupados
```

---

### Parte 3 – Estudiantes (Lista Enlazada + Ordenamiento)
| Endpoint | Descripción |
|---|---|
| `GET /estudiantes/agregar?nombre=Ana&puntaje=95&id=1` | Agregar estudiante |
| `GET /estudiantes` | Ver todos los estudiantes |
| `GET /estudiantes/ordenados` | Aprobados ordenados de mayor a menor puntaje |
| `GET /estudiantes/buscar/{nombre}` | Buscar estudiante por nombre |

**Ejemplos de prueba:**
```
http://localhost:8080/estudiantes/agregar?id=1&nombre=Ana&puntaje=95
http://localhost:8080/estudiantes/agregar?id=2&nombre=Luis&puntaje=45
http://localhost:8080/estudiantes/agregar?id=3&nombre=Maria&puntaje=78
http://localhost:8080/estudiantes
http://localhost:8080/estudiantes/ordenados
http://localhost:8080/estudiantes/buscar/Ana
```

---

## Git - Commits realizados
1. `Inicialización del proyecto Spring Boot`
2. `Parte 1: Implementación de CalificacionesService y CalificacionesController`
3. `Parte 2: Implementación de AulaService con matriz 5x15`
4. `Parte 3: Lista enlazada con Nodo, ListaEstudiantes y ordenamiento Bubble Sort`
5. `Finalización: README y ajustes finales`
