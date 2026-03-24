package com.example.ejemplos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Pruebas de la clase Calculadora")
@DisplayNameGeneration(ReplaceUnderscores.class)
class CalculadoraTest {

	@Nested
	@DisplayName("Método Suma")
	class SumaTest {
		@Nested
		@DisplayName("Casos validos")
		class OK {
			@Test
			@DisplayName("Suma dos valores positivos")
			void testSuma1() {
				var c = new Calculadora();		

				var result = c.suma(2.0, 2.0);
				
				assertEquals(4, result);
			}

			@Test
			void Suma_dos_valores_distintos() {
				assertEquals(3, (new Calculadora()).suma(2.0, 1.0));
			}

			@Test
			void testSuma3() {
//				assertEquals(0.3, (new Calculadora()).suma(0.1, 0.2));
				assertEquals(0.1, (new Calculadora()).suma(1.0, -0.9));
			}

			@Test
			void testSuma4() {
				assertTrue((new Calculadora()).suma(Integer.MAX_VALUE, 1) >= 0);
			}
			
		}
		@Nested
		@DisplayName("Casos invalidos")
		class KO {
			
		}
		
	}
	@Nested
	@DisplayName("Método Divide")
	class DivideTest {
		@Nested
		@DisplayName("Casos validos")
		class OK {
			@Test
			void divideDosEnteros() {
				assertEquals(1, (new Calculadora()).divide(3, 2));
			}
			@Test
			void divideDosReales() {
				assertEquals(1.5, (new Calculadora()).divide(3.0, 2));
			}
		}
		@Nested
		@DisplayName("Casos invalidos")
		class KO {
			
		}
		
	}

}
