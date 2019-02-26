package co.udea.colegio.api.service;

import java.util.List;
import java.util.Optional;

import co.udea.colegio.api.model.Alumnos;

public interface ColegioService {
	
	public List<Alumnos> getAlumnos();
	public Alumnos getAlumno(int id) ;
	
	public Optional<Alumnos> searchHeroes(String name);
	
	
	public void deleteAlumno(int id);
	public void deleteAlumno(Alumnos alumno);
	public Alumnos addAlumno(Alumnos alumno);
	public Alumnos updateAlumno(Alumnos alumno);

}
