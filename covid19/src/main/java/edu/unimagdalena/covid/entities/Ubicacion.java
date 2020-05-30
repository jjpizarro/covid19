package edu.unimagdalena.covid.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Ubicacion {
	CASA, HOSPITAL, FALLECIDO;
}
