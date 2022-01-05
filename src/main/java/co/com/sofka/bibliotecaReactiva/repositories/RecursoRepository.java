package co.com.sofka.bibliotecaReactiva.repositories;

import co.com.sofka.bibliotecaReactiva.models.Recurso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecursoRepository extends MongoRepository<Recurso, String> {
    List<Recurso> findByTematica(String tematica);
    List<Recurso> findByTipo(String tipo);
}
