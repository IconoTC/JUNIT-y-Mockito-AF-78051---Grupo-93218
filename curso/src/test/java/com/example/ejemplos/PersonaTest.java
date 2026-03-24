package com.example.ejemplos;

import static org.assertj.core.api.Assertions.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.example.test.utils.Smoke;

class PersonaTest {

	@Test
	@Smoke
	void CrearPersona() {
		var p = new Persona(0, "Pepito", "Grillo", null);
		
		// assertEquals(new Persona(0, "Pepito", "Grilloooo", null), p);
		assertNotNull(p);
		assertAll("Persona", 
				() -> assertEquals(0, p.getId()),
				() -> assertEquals("Pepito", p.getNombre(), "nombre"),
				() -> assertEquals("Grillo", p.getApellidos(), "apellidos"),
				() -> assertNull(p.getfNacimiento())
				);
//		assertThat(p, allOf(
//				hasProperty("id", greaterThanOrEqualTo(0)),
//				hasProperty("nombre", equalTo("Pepito")),
//				hasProperty("apellidos", equalTo("Grillo"))));
	}

}
