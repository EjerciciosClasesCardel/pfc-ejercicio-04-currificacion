package taller

class Ejercicio() {
  // prueba git
  // Punto 1. Recorre n términos: el primero es 1 y cada uno sale del
  // anterior aplicando g. Cada término se eleva a la p y se combina con f.
  // Tal como está devuelve siempre 0 y las pruebas quedan en rojo.
  def opCurrified(n: Int)(p: Int)(f: (Int, Int) => Int)(g: Int => Int): Int = {
    0 // Completar
  }

  // Punto 2. La suma de la sesión con tres grupos de parámetros.
  def suma4(f: Int => Int)(prox: Int => Int)(a: Int, b: Int): Int = {
    0 // Completar
  }

  // suma4 con f y prox ya fijados: cuadrados de uno en uno.
  def sumaCuadradosSuc: (Int, Int) => Int = {
    (a, b) => 0 // Completar con una aplicación parcial de suma4
  }

  // Punto 3. La operación y su valor inicial en los dos primeros grupos.
  def reducirC(op: (Int, Int) => Int)(inicio: Int)
              (f: Int => Int, prox: Int => Int)
              (a: Int, b: Int): Int = {
    0 // Completar
  }

  // producto y factorialHOF se escriben con reducirC y nada más.
  def producto(f: Int => Int, prox: Int => Int, a: Int, b: Int): Int = {
    0 // Completar
  }

  def factorialHOF(n: Int): Int = {
    0 // Completar
  }

  // Punto 4. Funciones que devuelven funciones.
  def componer(f: Int => Int)(g: Int => Int): Int => Int = {
    (x: Int) => 0 // Completar
  }

  def aplicarN(f: Int => Int)(n: Int): Int => Int = {
    (x: Int) => 0 // Completar
  }

  def sumador(n: Int): Int => Int = {
    (x: Int) => 0 // Completar
  }
}
