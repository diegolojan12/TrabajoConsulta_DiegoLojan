def integracion(f: Double => Double, a: Double, b: Double): Double =
  val x = (a + b) / 2.0 // x barra
  (b - a) * (f(a) + 4 * f(x) + f(b)) / 6.0

def error(valorEsperado: Double, valorObtenido: Double): Double =
  Math.abs(valorEsperado - valorObtenido)

// Pruebas 
val a1 = integracion(x => -x*x + 8*x - 12, 3, 5)
val e1 = error(7.33, a1)

val a2 = integracion(x => 3 * x * x, 0, 2)
val e2 = error(8, a2)

val a3 = integracion(x => x + 2 * Math.pow(x, 2) - Math.pow(x, 3) + 5 * Math.pow(x, 4), -1, 1)
val e3 = error(3.333, a3)

val a4 = integracion(x => (2 * x + 1) / (Math.pow(x, 2) + x), 1, 2)
val e4 = error(1.09861, a4)

val a5 = integracion(x => Math.exp(x), 0, 1)
val e5 = error(1.71828, a5)

val a6 = integracion(x => 1 / Math.sqrt(x - 1), 2, 3)
val e6 = error(0.828427, a6)

val a7 = integracion(x => 1 / (1 + Math.pow(x, 2)), 0, 1)
val e7 = error(0.785398, a7)

