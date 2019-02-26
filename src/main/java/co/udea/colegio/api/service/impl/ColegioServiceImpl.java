package co.udea.colegio.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import co.udea.colegio.api.exception.DataNotFoundException;
import co.udea.colegio.api.model.Alumnos;
import co.udea.colegio.api.repository.AlumnosRepository;
import co.udea.colegio.api.service.ColegioService;
import co.udea.colegio.api.util.Messages;

@Service
public class ColegioServiceImpl implements ColegioService {
	
	private final Logger log = LoggerFactory.getLogger(ColegioServiceImpl.class);
	
	private Messages messages;	
	private AlumnosRepository heroRepository;

	public ColegioServiceImpl(AlumnosRepository heroRepository, Messages messages) {
		this.heroRepository = heroRepository;
		this.messages = messages;
	}

	@Override
	public List<Alumnos> getAlumnos() {
		log.debug("Inicio getHeroes");
		List<Alumnos> alumnos= heroRepository.findAll();
		log.debug("Fin getHeroes");
		return alumnos;
	}
	
	@Override
	public Alumnos getAlumno(int id) {
		log.debug("Inicio getAlumno: id = {}", id);
		Optional<Alumnos> alumno = heroRepository.findById(id);
		if(!alumno.isPresent()){
			throw new DataNotFoundException(messages.get("exception.data_not_found.hero"));
		}
		log.debug("Fin getAlumno: alumno = {}", alumno.get());
		return alumno.get();
	}
	
	@Override
	public Optional<Alumnos> searchHeroes(String name) {
		log.debug("Inicio getAlumno: name = {}", name);
		Optional<Alumnos> alumno = heroRepository.findByName(name);
		if(!alumno.isPresent()){
			throw new DataNotFoundException(messages.get("exception.data_not_found.hero"));
		}
		log.debug("Fin getAlumno: alumno = {}", alumno.get());
		return alumno;
	}
	
	@Override
	public void deleteAlumno(int id) {
		log.debug("Inicio getAlumno: id = {}", id);
		Optional<Alumnos> alumno = heroRepository.findById(id);
		heroRepository.delete(alumno.get());
	}
	
	@Override
	public void deleteAlumno(Alumnos alumno) {
		heroRepository.delete(alumno);		
	}
	
	@Override
	public Alumnos updateAlumno(Alumnos alumno) {
		return heroRepository.save(alumno);
	}
	
	@Override
	public Alumnos addAlumno(Alumnos alumno) {
		List<Alumnos> alumnos= heroRepository.findAll();
		alumno.setId(alumnos.size());
		return heroRepository.save(alumno);
	}

}
