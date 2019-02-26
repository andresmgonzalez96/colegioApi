package co.udea.colegio.api.repository;

import org.springframework.data.repository.CrudRepository;

import co.udea.colegio.api.model.Materias;

public interface MateriaRepository extends CrudRepository<Materias,Long>{
	Materias findById(long studentId);

}
