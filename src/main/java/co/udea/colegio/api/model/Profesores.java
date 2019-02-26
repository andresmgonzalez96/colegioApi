package co.udea.colegio.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


@Entity
public class Profesores {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_Sequence")
	@SequenceGenerator(name	= "teacher_Sequence", sequenceName = "TEACHER_SEQ")
	private Long id;
	
	@Column(name	=	"nombreProfesor")
	private String	name;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy	= "teacher")
	private List<Profesores> teachers;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Profesores> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Profesores> teachers) {
		this.teachers = teachers;
	}

}
