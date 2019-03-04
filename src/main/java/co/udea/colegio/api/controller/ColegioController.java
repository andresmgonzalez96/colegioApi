package co.udea.colegio.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.udea.colegio.api.exception.DataNotFoundException;
import co.udea.colegio.api.model.Alumnos;
import co.udea.colegio.api.repository.AlumnosRepository;
import co.udea.colegio.api.service.ColegioService;
import co.udea.colegio.api.util.Messages;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/colegio")
public class ColegioController {
	
	private static Logger log = LoggerFactory.getLogger(ColegioController.class);
	
	@Autowired
	private ColegioService colegioService;
	
	@Autowired
	private AlumnosRepository studentRepository;
	
	@Autowired
    private Messages messages;	
	
	public ColegioController(ColegioService heroService) {
		this.colegioService = heroService;
	}
	
	@GetMapping(value = "listar", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Buscar todos", response = Page.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Los alumnos fueron buscados", response = Page.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<List<Alumnos>> getAlumnos(){
		log.debug("REST request listar todos los alumnos");
		return ResponseEntity.ok(colegioService.getAlumnos());		
	}
		
	@GetMapping(value = "consultar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Consultar alumno por id", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Alumno encontrado", response = Alumnos.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<Alumnos> getAlumno( @PathVariable("id") int id){
		 log.debug("REST request getAlumno id : {}", id);
		return ResponseEntity.ok(colegioService.getAlumno(id));
	}
	
	@GetMapping(value = "saludo/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Consultar alumno por id", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Alumno encontrado", response = Alumnos.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public String saludo( @PathVariable("name") String name){
		return "Hola " + name;
	}
	
	
	@RequestMapping(value = "borrar", method=RequestMethod.DELETE)
    @ApiOperation(value = "Eliminar heroe", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Heroe eliminado", response = Alumnos.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public void deleteHero(@RequestBody Alumnos alumno){
		log.debug("REST request deleteAlumno id : {}", alumno.getId());
		colegioService.deleteAlumno(alumno);
	}
	
	@DeleteMapping(value = "borrar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Borrar alumno por id", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Alumno encontrado", response = Alumnos.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public void deleteHero( @PathVariable("id") int id){
		 log.debug("REST request deleteAlumno id : {}", id);
		colegioService.deleteAlumno(id);
	}
	
	@PutMapping(value = "actualizar/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Actualizar Alumno", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Alumno actualizado", response = Alumnos.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public void updateHero(@RequestBody Alumnos alumno ){
		 log.debug("REST request updateAlumno id : {}", alumno.getId());
		colegioService.updateAlumno(alumno);
	}
	
	@RequestMapping(value="crear", method=RequestMethod.POST)
	public Alumnos addHero(@RequestBody Alumnos alumno) throws DataNotFoundException{
		log.debug("Entro a crear");
		if(alumno == null){
			throw new DataNotFoundException(messages.get("exception.data_not_found.hero"));
		}
		return colegioService.addAlumno(alumno);		
		
	}
	

}
