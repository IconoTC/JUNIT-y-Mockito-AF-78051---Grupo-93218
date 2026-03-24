package com.example.ejemplos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

	@Test
	void testSuma1() {
		var c = new Calculadora();		

		var result = c.suma(2.0, 2.0);
		
		assertEquals(4, result);
	}

	@Test
	void testSuma2() {
		assertEquals(3, (new Calculadora()).suma(2.0, 1.0));
	}

	@Test
	void testSuma3() {
//		assertEquals(0.3, (new Calculadora()).suma(0.1, 0.2));
		assertEquals(0.1, (new Calculadora()).suma(1.0, -0.9));
	}

	@Test
	void testSuma4() {
		assertTrue((new Calculadora()).suma(Integer.MAX_VALUE, 1) >= 0);
	}

}
