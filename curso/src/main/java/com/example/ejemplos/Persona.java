package com.example.ejemplos;

import java.time.LocalDate;

public class Persona {
	private int id;
	private String nombre;
	private String apellidos;
	private LocalDate fNacimiento;
	
	public Persona(int id, String nombre, String apellidos, LocalDate fNacimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fNacimiento = fNacimiento;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public LocalDate getfNacimiento() {
		return fNacimiento;
	}
	public void setfNacimiento(LocalDate fNacimiento) {
		this.fNacimiento = fNacimiento;
	}
	
	
}
