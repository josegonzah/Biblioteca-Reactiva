package co.com.sofka.bibliotecaReactiva.controllers;

import co.com.sofka.bibliotecaReactiva.dtos.RecursoDto;
import co.com.sofka.bibliotecaReactiva.services.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
