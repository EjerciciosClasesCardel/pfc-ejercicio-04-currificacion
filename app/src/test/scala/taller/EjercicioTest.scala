package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class EjercicioTest extends AnyFunSuite {
  val objEjer = new Ejercicio()

  test("Suma de los cuadrados de 1, 2 y 3") {
    assert(objEjer.opCurrified(3)(2)((x, y) => x + y)(x => x + 1) == 14)
  }

  test("Suma de los cubos de 1, 2 y 3") {
    assert(objEjer.opCurrified(3)(3)((x, y) => x + y)(x => x + 1) == 36)
  }

  test("Suma de los tres primeros impares") {
    assert(objEjer.opCurrified(3)(1)((x, y) => x + y)(x => x + 2) == 9)
  }

  test("Suma de los diez primeros impares") {
    assert(objEjer.opCurrified(10)(1)((x, y) => x + y)(x => x + 2) == 100)
  }

  test("Un solo término devuelve ese término") {
    assert(objEjer.opCurrified(1)(4)((x, y) => x + y)(x => x + 1) == 1)
  }
}
