package edu.unimagdalena.covid.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name = "casos")
public class Caso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern= "dd-MM-yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date fecha;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name="ciudad_id", nullable=false)
	private Ciudad ciudad;
	
	@Enumerated(EnumType.STRING)
    @Column(length = 16)
	private Tipo tipo;
	@Enumerated(EnumType.STRING)
    @Column(length = 16)
	private Ubicacion ubicacion;
	@Enumerated(EnumType.STRING)
    @Column(length = 16)
	private Estado estado;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="iniciosintomas")
	private Date fechaInicioSintomas;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="diagnostico")
	private Date fechaDiagnostico;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="recuperacion")
	private Date fechaRecuperacion;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="muerte")
	private Date fechaMuerte;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
	private Persona persona;

	public Caso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Date getFechaInicioSintomas() {
		return fechaInicioSintomas;
	}

	public void setFechaInicioSintomas(Date fechaInicioSintomas) {
		this.fechaInicioSintomas = fechaInicioSintomas;
	}

	public Date getFechaDiagnostico() {
		return fechaDiagnostico;
	}

	public void setFechaDiagnostico(Date fechaDiagnostico) {
		this.fechaDiagnostico = fechaDiagnostico;
	}

	public Date getFechaRecuperacion() {
		return fechaRecuperacion;
	}

	public void setFechaRecuperacion(Date fechaRecuperacion) {
		this.fechaRecuperacion = fechaRecuperacion;
	}

	public Date getFechaMuerte() {
		return fechaMuerte;
	}

	public void setFechaMuerte(Date fechaMuerte) {
		this.fechaMuerte = fechaMuerte;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	
	
	
	
}
