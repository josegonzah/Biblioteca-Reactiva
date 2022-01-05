package co.com.sofka.bibliotecaReactiva.services;

import co.com.sofka.bibliotecaReactiva.dtos.RecursoDto;
import co.com.sofka.bibliotecaReactiva.mapper.RecursoMapper;
import co.com.sofka.bibliotecaReactiva.models.Recurso;
import co.com.sofka.bibliotecaReactiva.repositories.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecursoService {

    @Autowired
    RecursoRepository repository;
    RecursoMapper mapper = new RecursoMapper();

    public List<RecursoDto> getTodos(){
        return repository.findAll()
                .stream()
                .map(recurso -> mapper.fromCollection(recurso))
                .collect(Collectors.toList());
    }

    public RecursoDto getById(String id){
        return repository.findById(id).stream()
                .map(recurso -> mapper.fromCollection(recurso))
                .findFirst()
                .orElseThrow();
    }

    public List<RecursoDto> getByTipo(String tipo){
        return repository.findByTipo(tipo)
                .stream()
                .map(recurso -> mapper.fromCollection(recurso))
                .collect((Collectors.toList()));
    }

    public List<RecursoDto> getByTematica(String tematica){
        return repository.findByTematica(tematica)
                .stream()
                .map(recurso -> mapper.fromCollection(recurso))
                .collect((Collectors.toList()));
    }

    public RecursoDto guardar(RecursoDto recursoDto){
        Recurso response = repository.save(mapper.fromD(recursoDto));
        return mapper.fromCollection(response);
    }

    public RecursoDto update(RecursoDto recursoDto){
        Recurso recurso = mapper.fromD(recursoDto);
        repository.findById(recurso.getId()).orElseThrow(() -> new RuntimeException("No se encuentra el recurso"));
        return mapper.fromCollection(repository.save(recurso));
    }

    public void delete(String id){
        repository.deleteById(id);
    }

    public Boolean isDisponible(String id){
        try{
            return this.getById(id).isPrestado();
        } catch (Exception e){
            return false;
        }
    }

    public Boolean prestarRecurso(String id){
        if(isDisponible(id)){
            RecursoDto recursoDto = getById(id);
            recursoDto.setPrestado(true);
            recursoDto.setFechaPrestamo(LocalDate.now());
            update(recursoDto);
            return true;
        }
        return false;
    }

    public Boolean devolverRecurso(String id){
        RecursoDto recursoDto = getById(id);
        if(recursoDto.getId() != null){
            recursoDto.setPrestado(false);
            this.update(recursoDto);
            return this.isDisponible(recursoDto.getId());
        }
        return this.isDisponible(recursoDto.getId());
    }

}
