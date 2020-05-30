package edu.unimagdalena.covid.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "personas")
public class Persona {
	@Override
	public String toString() {
		return "Persona [Id=" + Id + ", nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo + ", direccion="
				+ direccion + ", barrio=" + barrio + ", fechaNacimiento=" + fechaNacimiento + ", comorbilidades="
				+ comorbilidades + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long Id;
	@Column
	private String nombre;
	@Column
	private int edad;
	@Enumerated(EnumType.STRING)
	@Column(length = 3)
	private Sexo sexo;
	@Column
	private String direccion;
	@Column
	private String barrio;
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date fechaNacimiento;
	@Column
	private String comorbilidades;
	@JsonIgnore
	@OneToOne(mappedBy = "persona")
	private Caso caso;
	
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getComorbilidades() {
		return comorbilidades;
	}
	public void setComorbilidades(String comorbilidades) {
		this.comorbilidades = comorbilidades;
	}
	
	
	
}
