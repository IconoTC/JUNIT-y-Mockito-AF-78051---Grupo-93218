package com.example.ejemplos;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.example.test.annotation.Smoke;
import com.example.test.utils.PrivateMethod;

@DisplayName("Pruebas de la clase Calculadora")
@DisplayNameGeneration(ReplaceUnderscores.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
class CalculadoraTest {
	Calculadora calculadora;

	@BeforeEach
	void setUp() throws Exception {
		calculadora = new Calculadora();
	}

	@Nested
	@DisplayName("Método Suma")
	@Order(1)
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
				assertEquals(3, calculadora.suma(2.0, 1.0));
			}

			@Test
			void testIEEE() {
				assertEquals(0.3, (new Calculadora()).suma(0.1, 0.2));
				assertEquals(0.1, (new Calculadora()).suma(1.0, -0.9));
			}

			@Test
			@Disabled
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
	@DisplayName("Método Resta")
	@Order(10)
	class RestaTest {
		@Nested
		@DisplayName("Casos validos")
		class OK {
			@ParameterizedTest(name = "Caso {index} => {0} - {1} = {2}")
			@CsvSource({ "1,1,0", "1,-1,2", "-2,1,-3", "-3,-4,1", "0,0,0", "0,1,-1", })
			@DisplayName("Resta dos entero")
			// @Tag("smoke")
			@Smoke
			void RestaEnteros(int operando1, int operando2, int resultado) {
				assertEquals(resultado, calculadora.resta(operando1, operando2));
			}

			@ParameterizedTest(name = "Caso {index} => {0} - {1} = {2}")
			@CsvSource({ "2,1,1", "1,0.9,0.1", })
			@DisplayName("Resta dos reales")
			void RestaReales(double operando1, double operando2, double resultado) {
				assertEquals(resultado, calculadora.resta(operando1, operando2));
			}
		}
	}

	@Nested
	@DisplayName("Método Divide")
	@Order(40)
	class DivideTest {
		@Nested
		@DisplayName("Casos validos")
		@Tag("smoke")
		@Order(1)
		class OK {
			@Test
			void divideDosEnteros() {
				assertEquals(1, (new Calculadora()).divide(3, 2));
				assumeFalse(true, "Prueba a medias");
			}

			@Test
//			@Disabled
			void divideDosReales() {
				assertEquals(1.5, (new Calculadora()).divide(3.0, 2));
			}

			@Test
//			@Disabled
			void dividePeriodico() {
				assertEquals(0.33, calculadora.divide(1.0, 3), 2);
			}
		}

		@Nested
		@DisplayName("Casos invalidos")
		@Order(2)
		class KO {
			@Test
			void dividePorCeroConTry() {
				try {
					assertEquals(10, calculadora.divide(3, 0));
					fail("Excepcion no controlada");
				} catch (Exception e) {
				}
			}

			@Test
			void dividePorCeroConAssertThrows() {
				var ex = assertThrows(ArithmeticException.class, () -> calculadora.divide(3, 0));
				assertEquals("/ by zero", ex.getMessage());
			}

			@Test
			void dividePorCeroDouble() {
				var ex = assertThrows(ArithmeticException.class, () -> calculadora.divide(3.0, 0));
				assertEquals("/ by zero", ex.getMessage());
			}

		}

	}

	@Nested
	@DisplayName("Método esBisiesto")
	@Order(40)
	class EsBisiesto {
		@ParameterizedTest(name = "Caso {index} => {0} es bisiento")
		@ValueSource(ints = {2024, 2000})
		void es_bisiesto(int caso) {
			assertTrue(calculadora.esBisiesto(caso));
		}
		@ParameterizedTest(name = "Caso {index} => {0} es bisiento")
		@ValueSource(ints = {2026, 1900})
		void no_es_bisiesto(int caso) {
			assertFalse(calculadora.esBisiesto(caso));
		}

//		@Test
//		void es_multiplo_de_4_y_no_es_multiplo_de_100() {
//			var caso = 2024;
//			
//			assertTrue(calculadora.esBisiesto(caso));
//		}
//		@Test
//		void es_multiplo_de_4_y_no_es_multiplo_de_100_o_es_multiplo_de_400() {
//			var caso = 2000;
//			
//			assertTrue(calculadora.esBisiesto(caso));
//		}
//		@Test
//		void no_es_multiplo_de_4() {
//			var caso = 2026;
////			var calculadora = mock(Calculadora.class);
////			when(calculadora.esBisiesto(2026)).thenReturn(false);
//			assertFalse(calculadora.esBisiesto(caso));
//		}
//		@Test
//		void es_multiplo_de_4_y_es_multiplo_de_100() {
//			var caso = 1900;
////			var calculadora = mock(Calculadora.class);
////			when(calculadora.esBisiesto(1900)).thenReturn(false);
//			assertFalse(calculadora.esBisiesto(caso));
//		}
	}

	@Nested
	@DisplayName("Otros ejemplos")
	@Order(100)
	class OtrosTest {
		@Test
		@DisplayName("Probar métodos privado")
		void Privado() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
			assertEquals(0.3, PrivateMethod.exec(calculadora, "roundIEEE754", new Class[] { double.class }, (0.1 + 0.2)));
			assertEquals(0.1, PrivateMethod.exec(calculadora, "roundIEEE754", new Class[] { double.class }, (1 - 0.9)));
		}
		
		@TestFactory
		Collection<DynamicTest> testFactory() {
			List<DynamicTest> testBattery = new ArrayList<DynamicTest>();
			DynamicTest testKO = dynamicTest("Should fail", () -> assertTrue(false));
			DynamicTest testOK = dynamicTest("Should pass", () -> assertTrue(true));
			int state = 1; // entity.getState();
			boolean rslt = false; // entity.isEnabled();
			if (rslt)
				testBattery.add(dynamicTest("Enabled", () -> assertTrue(true)));
			else
				testBattery.add(dynamicTest("Disabled", () -> assertTrue(true)));
			switch (state) {
			case 1:
				testBattery.add(testOK);
				break;
			case 2:
				testBattery.add(testKO);
				break;
			case 3:
				testBattery.add(testOK);
				testBattery.add(testKO);
				break;
			}
			return testBattery;
		}
		
		@Test
		@DisplayName("Probar métodos no determinista")
		@Disabled
		void tempodependiente() {
			int edad = 25; 
			var nacimiento = LocalDate.of(2000, 3, 25);
			assertAll("Edades",
					() -> assertEquals(edad, calculadora.edad(nacimiento.plusDays(1)), "aun no ha cumplido años"),
					() -> assertEquals(edad + 1, calculadora.edad(nacimiento), "hoy cumple años"),
					() -> assertEquals(edad + 1, calculadora.edad(nacimiento.minusDays(1)), "ya ha cumplido años")
					);
		}
	}
}
