package co.udea.colegio.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import co.udea.colegio.api.model.Alumnos;

public interface AlumnosRepository extends JpaRepository<Alumnos, String>{

	public Optional<Alumnos> findById(int id); 
	
	public Optional<Alumnos> findByName(String term);
	
}
