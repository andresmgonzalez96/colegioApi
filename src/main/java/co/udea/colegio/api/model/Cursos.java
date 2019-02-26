package co.udea.colegio.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

public class Cursos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_Sequence")
	@SequenceGenerator(name	= "course_Sequence", sequenceName = "COURSE_SEQ")
	private Long id;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy	= "course")
	private List<Alumnos> students;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Alumnos> getStudents() {
		return students;
	}

	public void setStudents(List<Alumnos> students) {
		this.students = students;
	}

}
