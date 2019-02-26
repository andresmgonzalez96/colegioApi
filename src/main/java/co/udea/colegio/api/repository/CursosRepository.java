package co.udea.colegio.api.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.udea.colegio.api.model.Cursos;

public interface CursosRepository extends CrudRepository<Cursos,Long>{
	Optional<Cursos> findById(long courseId);	

}
