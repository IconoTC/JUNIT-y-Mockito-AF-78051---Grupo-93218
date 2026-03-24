package com.example.ejemplos;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.example.test.annotation.Smoke;

class PersonaTest {

	@Test
	@Smoke
	void CrearPersona() {
		var actual = new Persona(0, "Pepito", "Grillo", null);
		
		// assertEquals(new Persona(0, "Pepito", "Grilloooo", null), actual);
		assertNotNull(actual);
		assertAll("Persona", 
				() -> assertEquals(0, actual.getId()),
				() -> assertEquals("Pepito", actual.getNombre(), "nombre"),
				() -> assertEquals("Grillo", actual.getApellidos(), "apellidos"),
				() -> assertNull(actual.getFNacimiento())
				);
		// hamcrest
		assertThat(actual, allOf(
				hasProperty("id", greaterThanOrEqualTo(0)),
				hasProperty("nombre", equalTo("Pepito")),
				hasProperty("apellidos", equalTo("Grillo")),
				hasProperty("FNacimiento", nullValue())));
		// assertj
		org.assertj.core.api.Assertions.assertThat(actual)
			.isNotNull()
			.hasFieldOrPropertyWithValue("id", 0)
			.hasFieldOrPropertyWithValue("nombre", "Pepito")
			.hasFieldOrPropertyWithValue("apellidos", "Grillo")
			.hasFieldOrPropertyWithValue("FNacimiento", null)
			;

	}

}
