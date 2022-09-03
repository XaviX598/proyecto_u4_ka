package com.uce.edu.demo.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//tambien debemos decir que es una entidad
@Entity
//para decir que la clase representa la tablla se utiliza anotaciones de javax.persistence
@Table(name = "persona")

@NamedQuery(name = "Persona.buscarPorCedula", query = "SELECT p FROM Persona p WHERE p.cedula = :datoCedula")
@NamedQuery(name = "Persona.buscarPorNombreApellido", query = "SELECT p FROM Persona p WHERE p.nombre = :datoNombre AND p.apellido = :datoApellido")
//@NamedNativeQuery(name = "Persona.buscarPorcCedulaNative", query = "SELECT * FROM persona Where pers_cedula=:datoCedula", resultClass = Persona.class)
//@NamedNativeQuery(name = "Persona.buscarPorcCedulaNativeApellido", query = "SELECT * FROM persona Where pers_cedula=:datoCedula", resultClass = Persona.class)

@NamedNativeQueries({
		@NamedNativeQuery(name = "Persona.buscarPorCedulaNative", query = "SELECT * FROM persona Where pers_cedula=:datoCedula", resultClass = Persona.class),
		@NamedNativeQuery(name = "Persona.buscarPorCedulaNativeApellido", query = "SELECT * FROM persona Where pers_cedula=:datoCedula AND pers_apellido=:datoApellido", resultClass = Persona.class) })
/*
 * @NamedQueries({
 * 
 * @NamedQuery(name = "Persona.buscarPorCedula", query =
 * "SELECT p FROM Persona p WHERE p.cedula = :datoCedula"),
 * 
 * @NamedQuery(name = "Persona.buscarPorNombreApellido", query =
 * "SELECT p FROM Persona p WHERE p.nombre = :datoNombre AND p.apellido = :datoApellido"
 * ) })
 */
public class Persona {

	// para realizar el mapeo se una anotacion para cada atributo @Column( name =
	// "nombreatributo")
	// para el atributo identificador se usa una anotacion@Id
	// nunca usar mapas primitivos sino emvoltorios osea no int, float, double, sino
	// Integer...
	@Id
	@Column(name = "pers_id")
	// Con la secuencia ya no hace falta poner un id ya que esta en secuencia
	// secuencia, no es necesario que se llame igual que en la abse
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pers_id_seq")
	// secuencia de la base, obigario el mismo nombre (En el segundo "") y luego
	// ponemos el incremento por defento en 50
	@SequenceGenerator(name = "pers_id_seq", sequenceName = "pers_id_seq", allocationSize = 1)
	private Integer id;
	@Column(name = "pers_nombre")
	private String nombre;
	@Column(name = "pers_apellido")
	private String apellido;
	@Column(name = "pers_genero")
	private String genero;
	@Column(name = "pers_cedula")
	private String cedula;

	// set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", genero=" + genero
				+ ", cedula=" + cedula + "]";
	}

}
