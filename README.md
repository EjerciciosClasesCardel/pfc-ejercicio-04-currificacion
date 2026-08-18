# Ejercicio 4 — Currificación

Fundamentos de Programación Funcional y Concurrente
Escuela de Ingeniería de Sistemas y Computación, Universidad del Valle
Carlos Andrés Delgado Saavedra

Una sola función que, según cómo se la aplique, suma cuadrados, suma cubos o
suma impares. La idea es que lo que cambia entre esos casos viaje como
argumento en lugar de escribirse tres veces.

## Currificar

Currificar es partir una función de varios argumentos en una cadena de
funciones de un argumento. En Scala se escribe con varias listas de
parámetros:

```scala
def suma(x: Int, y: Int): Int = x + y      // una lista, dos parámetros
def suma(x: Int)(y: Int): Int = x + y      // dos listas, una currificada
```

Lo que se gana es la aplicación parcial: si se entregan algunos argumentos y
no todos, lo que queda es una función que espera el resto.

```scala
val sumar5 = suma(5) _     // función que espera un entero
sumar5(3)                  // 8
```

## Lo que hay que resolver

En `app/src/main/scala/taller/Ejercicio.scala`:

```scala
def opCurrified(n: Int)(p: Int)(f: (Int, Int) => Int)(g: Int => Int): Int
```

La función recorre `n` términos. El primero es 1 y cada uno se obtiene del
anterior aplicando `g`. Cada término se eleva a la potencia `p`, y los
resultados se combinan con `f`.

| Parámetro | Qué es |
|---|---|
| `n` | cuántos términos se recorren |
| `p` | a qué potencia se eleva cada término |
| `f` | cómo se combinan dos resultados |
| `g` | cómo se pasa de un término al siguiente |

### Ejemplos

```scala
opCurrified(3)(2)((x, y) => x + y)(x => x + 1)
```

Los términos son 1, 2 y 3, porque `g` suma uno cada vez. Elevados al
cuadrado: 1, 4 y 9. Combinados con la suma: **14**.

```scala
opCurrified(3)(3)((x, y) => x + y)(x => x + 1)
```

Mismos términos, elevados al cubo: 1, 8 y 27. Suman **36**.

```scala
opCurrified(3)(1)((x, y) => x + y)(x => x + 2)
```

Ahora `g` suma dos, así que los términos son 1, 3 y 5. Con potencia 1 quedan
igual y suman **9**.

```scala
opCurrified(10)(1)((x, y) => x + y)(x => x + 2)
```

Los diez primeros impares: 1, 3, 5, …, 19. Suman **100**.

```scala
opCurrified(1)(4)((x, y) => x + y)(x => x + 1)
```

Un solo término, el 1, elevado a la cuarta. Como no hay con quién combinarlo,
el resultado es **1**. Este es el caso base y conviene escribirlo primero:
con un solo término, `f` no llega a usarse.

## Una advertencia sobre el caso base

La función no recibe un elemento neutro, así que el caso base no puede
devolver 0. Si lo hiciera, un `f` de multiplicación daría siempre cero. El
caso de un término tiene que devolver ese término.

## Cómo está organizado el proyecto

```
app/src/main/scala/taller/
    App.scala          programa de arranque
    Ejercicio.scala    aquí va el ejercicio

app/src/test/scala/taller/
    AppSuite.scala        comprueba que el entorno quedó bien
    EjercicioTest.scala   los cinco casos de arriba
```

Su código va en `main`. Las pruebas viven aparte y no se tocan.

## Cómo se ejecuta

```bash
./gradlew test    # corre las pruebas
```

Las pruebas arrancan en rojo y el trabajo es ponerlas en verde. El informe
completo queda en `app/build/reports/tests/test/index.html`.

## Cómo se trabaja

1. Haga fork de este repositorio.
2. En su fork, abra la pestaña **Actions** y habilítelas. GitHub las deja
   desactivadas en las copias hasta que el dueño lo confirme.
3. Clone, resuelva, haga commit y suba a `main`.
4. Verifique en **Actions** que la última ejecución quedó en verde.

## Restricciones

Este curso trabaja sin estado mutable: nada de `var`, `while`, `return` ni
variables que cambien. El resultado correcto por el camino equivocado no
cuenta como resultado correcto.
