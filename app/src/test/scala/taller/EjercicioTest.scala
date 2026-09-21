package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class EjercicioTest extends AnyFunSuite {
  val objEjer = new Ejercicio()

  // Punto 1: opCurrified

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

  test("Con multiplicación el caso base no puede ser 0") {
    assert(objEjer.opCurrified(4)(1)((x, y) => x * y)(x => x + 1) == 24)
  }

  // Punto 2: suma4

  test("suma4 con los tres pares de la sesión") {
    assert(objEjer.suma4(x => x)(x => x + 1)(1, 10) == 55)
    assert(objEjer.suma4(x => x * x)(x => x + 1)(1, 10) == 385)
    assert(objEjer.suma4(x => x)(x => x + 2)(1, 10) == 25)
  }

  test("suma4 con un prox que duplica y con un rango vacío") {
    assert(objEjer.suma4(x => x)(x => x * 2)(1, 16) == 31)
    assert(objEjer.suma4(x => x)(x => x + 1)(10, 1) == 0)
  }

  test("sumaCuadradosSuc es suma4 con dos grupos fijados") {
    assert(objEjer.sumaCuadradosSuc(1, 5) == 55)
    assert(objEjer.sumaCuadradosSuc(1, 10) == 385)
  }

  // Punto 3: reducirC

  test("reducirC reproduce la suma y el producto") {
    assert(objEjer.reducirC((x, y) => x + y)(0)(x => x, x => x + 1)(1, 4) == 10)
    assert(objEjer.reducirC((x, y) => x * y)(1)(x => x, x => x + 1)(1, 4) == 24)
  }

  test("reducirC con otra f, otro prox y otra operación") {
    assert(objEjer.reducirC((x, y) => x + y)(0)(x => x * x, x => x + 2)(1, 7) == 84)
    assert(objEjer.reducirC((x, y) => math.max(x, y))(Int.MinValue)(x => 10 - x, x => x + 4)(1, 13) == 9)
  }

  test("reducirC con un rango vacío devuelve inicio") {
    assert(objEjer.reducirC((x, y) => x * y)(1)(x => x, x => x + 1)(5, 4) == 1)
  }

  test("producto y factorialHOF salen de reducirC") {
    assert(objEjer.producto(x => x, x => x + 1, 1, 5) == 120)
    assert(objEjer.producto(x => x * x, x => x + 1, 1, 3) == 36)
    assert(objEjer.factorialHOF(0) == 1)
    assert(objEjer.factorialHOF(5) == 120)
  }

  // Punto 4: componer, aplicarN y sumador

  test("componer aplica primero la de la derecha") {
    assert(objEjer.componer(x => x + 1)(x => x * 2)(5) == 11)
    assert(objEjer.componer(x => x * 2)(x => x + 1)(5) == 12)
  }

  test("aplicarN repite una función n veces") {
    assert(objEjer.aplicarN(x => x * 2)(3)(1) == 8)
    assert(objEjer.aplicarN(x => x + 3)(0)(7) == 7)
    assert(objEjer.aplicarN(x => x * x)(2)(3) == 81)
  }

  test("sumador fabrica funciones y se combina con las otras") {
    assert(objEjer.sumador(5)(3) == 8)
    assert(objEjer.aplicarN(objEjer.sumador(3))(4)(0) == 12)
    assert(objEjer.componer(objEjer.sumador(5))(objEjer.sumador(-5))(42) == 42)
  }
}
