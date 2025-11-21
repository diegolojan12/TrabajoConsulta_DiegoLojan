# Trabajo de Consulta: Programación Funcional y Reactiva

**Tema:** Funciones de Orden Superior y Método de Simpson 1/3  
[cite_start]**Asignatura:** Programación Funcional y Reactiva [cite: 1, 2]

---

## 1. Objetivos
* [cite_start]Aplicar los conocimientos sobre funciones de orden superior[cite: 6].
* [cite_start]Enviar una función como parámetro en Scala[cite: 6].
* [cite_start]Implementar el algoritmo de Simpson 1/3 para la integración numérica[cite: 8].

---

## 2. Marco Teórico: Método de Simpson 1/3

El método de Simpson 1/3 es un procedimiento de integración numérica utilizado para encontrar una aproximación del área bajo una curva definida por una función $f(x)$ en un intervalo $[a, b]$.

[cite_start]La fórmula general establecida es[cite: 8, 10]:

$$\int_{a}^{b}f(x)dx \cong (b-a) \frac{f(a)+4f(\bar{x})+f(b)}{6}$$

[cite_start]Donde $\bar{x}$ corresponde al punto medio del intervalo[cite: 11]:

$$\bar{x} = \frac{a+b}{2}$$

### Cálculo del Error
[cite_start]Para verificar la precisión del algoritmo, se calcula el error absoluto comparando el valor aproximado obtenido mediante el código y el valor matemático esperado[cite: 27, 28]:

$$Error = |valorEsperado - valorObtenido|$$

---

## 3. Desarrollo de la Solución

A continuación se presenta la implementación en **Scala**. [cite_start]Se ha creado una función llamada `integracion` que recibe como parámetro la función matemática a evaluar, cumpliendo con el concepto de **High Order Functions** (Funciones de Orden Superior)[cite: 4, 15].

    scala
    object SimpsonIntegration {

        /**
        * Función de integración numérica usando Simpson 1/3.
        * @param f Función matemática a evaluar (Double => Double)
        * @param a Límite inferior del intervalo
        * @param b Límite superior del intervalo
        * @return Valor aproximado de la integral
        */
        def integracion(f: Double => Double, a: Double, b: Double): Double = {
            val x = (a + b) / 2.0 // Cálculo de x barra (punto medio)
            (b - a) * (f(a) + 4 * f(x) + f(b)) / 6.0
        }

        /**
        * Calcula el error absoluto de la aproximación.
        */
        def error(valorEsperado: Double, valorObtenido: Double): Double = {
            Math.abs(valorEsperado - valorObtenido)
        }

        // Bloque principal para ejecución de pruebas
        def main(args: Array[String]): Unit = {
            
            // 1. Ejercicio 1
            val res1 = integracion(x => -Math.pow(x, 2) + 8 * x - 12, 3, 5)
            println(s"Ejercicio 1: Aproximación = $res1 | Error = ${error(7.33, res1)}")

            // 2. Ejercicio 2
            val res2 = integracion(x => 3 * Math.pow(x, 2), 0, 2)
            println(s"Ejercicio 2: Aproximación = $res2 | Error = ${error(8, res2)}")

            // 3. Ejercicio 3
            val res3 = integracion(x => x + 2 * Math.pow(x, 2) - Math.pow(x, 3) + 5 * Math.pow(x, 4), -1, 1)
            println(s"Ejercicio 3: Aproximación = $res3 | Error = ${error(3.333, res3)}")

            // 4. Ejercicio 4
            val res4 = integracion(x => (2 * x + 1) / (Math.pow(x, 2) + x), 1, 2)
            println(s"Ejercicio 4: Aproximación = $res4 | Error = ${error(1.09861, res4)}")

            // 5. Ejercicio 5
            val res5 = integracion(x => Math.exp(x), 0, 1)
            println(s"Ejercicio 5: Aproximación = $res5 | Error = ${error(1.71828, res5)}")

            // 6. Ejercicio 6
            val res6 = integracion(x => 1 / Math.sqrt(x - 1), 2, 3)
            println(s"Ejercicio 6: Aproximación = $res6 | Error = ${error(0.828427, res6)}")

            // 7. Ejercicio 7
            val res7 = integracion(x => 1 / (1 + Math.pow(x, 2)), 0, 1)
            println(s"Ejercicio 7: Aproximación = $res7 | Error = ${error(0.785398, res7)}")
        }
    }



---
## 4. Análisis de Resultados y Pruebas

Para validar la implementación, se realizaron pruebas con 7 integrales definidas distintas. En cada caso, se comparó el valor devuelto por la función `integracion` (Implementación de Simpson 1/3) con el valor esperado teórico.

El cálculo del error se realizó mediante la fórmula:
$$Error = |ValorEsperado - ValorObtenido|$$

### Tabla de Resultados

| # | Función Integral | Intervalo $[a, b]$ | [cite_start]Valor Esperado [cite: 20-26] | Valor Obtenido (Código) | Margen de Error |
|:-:|:---|:---:|:---:|:---:|:---:|
| **1** | $\int (-x^{2}+8x-12)dx$ | $[3, 5]$ | 7.33 | 7.33333 | 0.00333 |
| **2** | $\int 3x^{2}dx$ | $[0, 2]$ | 8.0 | 8.00000 | 0.00000 |
| **3** | $\int (x+2x^{2}-x^{3}+5x^{4})dx$ | $[-1, 1]$ | 3.333 | 4.66667 | 1.33367 |
| **4** | $\int \frac{2x+1}{x^{2}+x}dx$ | $[1, 2]$ | 1.09861 | 1.10000 | 0.00139 |
| **5** | $\int e^{x}dx$ | $[0, 1]$ | 1.71828 | 1.71886 | 0.00058 |
| **6** | $\int \frac{1}{\sqrt{x-1}}dx$ | $[2, 3]$ | 0.828427 | 0.82885 | 0.00042 |
| **7** | $\int \frac{1}{1+x^{2}}dx$ | $[0, 1]$ | 0.785398 | 0.78333 | 0.00206 |

### Observaciones
* **Precisión General:** En la mayoría de los casos (ejercicios 1, 4, 5, 6 y 7), el margen de error es extremadamente bajo ($< 0.004$), lo que demuestra que la implementación del método Simpson 1/3 es correcta y efectiva para estas funciones.
* **Caso Exacto (Ejercicio 2):** El error es $0.0$ absoluto. Esto ocurre porque el método de Simpson 1/3 utiliza parábolas (polinomios de grado 2) para aproximar la curva, por lo que es matemáticamente exacto para funciones cuadráticas como $3x^2$.
* **Mayor Desviación (Ejercicio 3):** Se observa un error significativo ($1.33$) en la función polinómica de cuarto grado ($5x^4$). Esto es un comportamiento esperado, ya que el método de Simpson 1/3 simple pierde precisión con polinomios de grado superior a 3 si no se aplica en intervalos múltiples (Simpson Compuesto).

---

## 5. Conclusiones

1.  [cite_start]**Aplicación de Funciones de Orden Superior:** Se cumplió con el objetivo principal [cite: 5] al implementar la función `integracion`, la cual recibe otra función como parámetro (`f: Double => Double`). Esto permitió desacoplar la lógica del algoritmo numérico de las ecuaciones matemáticas específicas, facilitando la reutilización del código.
2.  [cite_start]**Eficacia del Método:** La implementación en Scala demostró ser una herramienta confiable para la aproximación de integrales, obteniendo resultados muy cercanos a los valores analíticos esperados [cite: 28, 29] con un esfuerzo computacional mínimo.
3.  **Paradigma Funcional:** El uso de la inmutabilidad y las expresiones lambda simplificó la sintaxis del algoritmo matemático, resultando en un código más limpio y legible en comparación con enfoques imperativos tradicionales.
