package co.com.sofka.bibliotecaReactiva.controllers;

import co.com.sofka.bibliotecaReactiva.dtos.RecursoDto;
import co.com.sofka.bibliotecaReactiva.services.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioteca")
public class RecursosController {

    @Autowired
    RecursoService service;

    @GetMapping()
    public ResponseEntity<List<RecursoDto>> getTodos(){
        return new ResponseEntity<>(service.getTodos(), HttpStatus.OK);
    }

    @GetMapping("/biblioteca/{id}")
    public ResponseEntity<RecursoDto> getById(@PathVariable("id") String id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @GetMapping("/biblioteca/tematica/{tematica}")
    public ResponseEntity<List<RecursoDto>> recomendarPorTematica(@PathVariable("tematica") String tematica){
        return new ResponseEntity<>(service.getByTematica(tematica), HttpStatus.OK);
    }

    @GetMapping("/biblioteca/tipo/{tipo}")
    public ResponseEntity<List<RecursoDto>> recomendarPorTipo(@PathVariable("tipo") String tipo){
        return new ResponseEntity<>(service.getByTipo(tipo), HttpStatus.OK);
    }

    @GetMapping("/biblioteca/disponible/{id}")
    public ResponseEntity<String> disponibilidad(@PathVariable("id") String id){
        if (service.isDisponible(id))
            return new ResponseEntity<>("Resourse avaible", HttpStatus.OK);
        return new ResponseEntity<>("Resourse unavaible", HttpStatus.OK);
    }

    @GetMapping("/biblioteca/prestar/{id}")
    public ResponseEntity<String> prestarRecurso(@PathVariable("id") String id){
        if (service.prestarRecurso(id))
            return new ResponseEntity<>("Prestado con satisfaccion", HttpStatus.OK);
        return new ResponseEntity<>("No se pudo prestar", HttpStatus.UNAUTHORIZED);
    }
    @GetMapping("/biblioteca/devolver/{id}")
    public ResponseEntity<String> devolverRecurso(@PathVariable("id") String id){
        if(service.devolverRecurso(id))
            return new ResponseEntity<>("Se pudo devolver", HttpStatus.OK);
        return new ResponseEntity<>("No se pudo devolver", HttpStatus.CONFLICT);
    }

    @PostMapping
    public ResponseEntity<RecursoDto> guardar(@RequestBody RecursoDto recursoDto){
        return new ResponseEntity<>(service.guardar(recursoDto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<RecursoDto> actualizar(@RequestBody RecursoDto recursoDto){
        return new ResponseEntity<>(service.update(recursoDto), HttpStatus.OK);
    }

    @DeleteMapping("/biblioteca/{id}")
    public void delete(@PathVariable("id") String id){
        service.delete(id);
    }



}
