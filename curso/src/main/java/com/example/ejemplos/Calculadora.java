package com.example.ejemplos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.function.BooleanSupplier;

public class Calculadora {
	public double suma(double a, double b) {
		return roundIEEE754(a + b);
	}
	public int suma(int a, int b) {
		return a + b;
	}
	public double resta(double a, double b) {
		return roundIEEE754(a - b);
	}
	public int resta(int a, int b) {
		return a - b;
	}
	public double multiplica(double a, double b) {
		return roundIEEE754(a * b);
	}
	public int multiplica(int a, int b) {
		return a * b;
	}
	public double divide(double a, double b) {
		if(b == 0)
			throw new ArithmeticException("/ by zero");
		return roundIEEE754(a / b);
	}
	public int divide(int a, int b) {
		return a / b;
	}
	
	public byte edad(LocalDate fechaDeNacimiento) {
		if(fechaDeNacimiento == null)
			throw new IllegalArgumentException("El argumento no puede ser nulo.");
		if(fechaDeNacimiento.isAfter(LocalDate.now()))
			throw new IllegalArgumentException("El argumento no puede una fecha futura.");
		return (byte) ChronoUnit.YEARS.between(fechaDeNacimiento, LocalDate.now());
	}
	
	public boolean esBisiesto(int año) {
		return esMultiploDe400(año) || esMultiploDe4(año) && noEsMultiploDe100(año);
	}
	private boolean esMultiploDe4(int año) {
		return año % 4 == 0;
	}
	private boolean esMultiploDe100(int año) {
		return año % 100 == 0;
	}
	private boolean noEsMultiploDe100(int año) {
		return !esMultiploDe100(año);
	}
	private boolean esMultiploDe400(int año) {
		return año % 400 == 0;
	}

	private double roundIEEE754(double o) {
		return BigDecimal.valueOf(o)
				.setScale(16, RoundingMode.HALF_UP)
				.doubleValue();
	}
}
