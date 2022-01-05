package co.com.sofka.bibliotecaReactiva.repositories;

import co.com.sofka.bibliotecaReactiva.models.Recurso;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RecursoRepository extends MongoRepository<Recurso, String> {
    List<Recurso> findByTematica(String tematica);
    List<Recurso> findByTipo(String tipo);
}
