# Trabajo de Consulta: Programación Funcional y Reactiva

**Tema:** Funciones de Orden Superior y Método de Simpson 1/3  
[cite_start]**Asignatura:** Programación Funcional y Reactiva

---

## 1. Objetivos
* [cite_start]Aplicar los conocimientos sobre funciones de orden superior.
* [cite_start]Enviar una función como parámetro en Scala.
* [cite_start]Implementar el algoritmo de Simpson 1/3 para la integración numérica.

---

## 2. Marco Teórico: Método de Simpson 1/3

El método de Simpson 1/3 es un procedimiento de integración numérica utilizado para encontrar una aproximación del área bajo una curva definida por una función $f(x)$ en un intervalo $[a, b]$.

[cite_start]La fórmula general establecida es:

$$\int_{a}^{b}f(x)dx \cong (b-a) \frac{f(a)+4f(\bar{x})+f(b)}{6}$$

[cite_start]Donde $\bar{x}$ corresponde al punto medio del intervalo:

$$\bar{x} = \frac{a+b}{2}$$

### Cálculo del Error
[cite_start]Para verificar la precisión del algoritmo, se calcula el error absoluto comparando el valor aproximado obtenido mediante el código y el valor matemático esperado:

$$Error = |valorEsperado - valorObtenido|$$

---

## 3. Desarrollo de la Solución

A continuación se presenta la implementación en **Scala**. Se ha creado una función llamada `integracion` que recibe como parámetro la función matemática a evaluar, cumpliendo con el concepto de **High Order Functions** (Funciones de Orden Superior).

    scala
    def integracion(f: Double => Double, a: Double, b: Double): Double =
      val x = (a + b) / 2.0 // x barra
      (b - a) * (f(a) + 4 * f(x) + f(b)) / 6.0
    
    def error(valorEsperado: Double, valorObtenido: Double): Double =
      Math.abs(valorEsperado - valorObtenido)



---
## 4. Análisis de Resultados y Pruebas

Para validar la implementación, se realizaron pruebas con 7 integrales definidas distintas. En cada caso, se comparó el valor devuelto por la función `integracion` (Implementación de Simpson 1/3) con el valor esperado teórico.

El cálculo del error se realizó mediante la fórmula:
$$Error = |ValorEsperado - ValorObtenido|$$

### Tabla de Resultados

| # | Función Integral | Intervalo $[a, b]$ | Valor Esperado  | Valor Obtenido (Código) | Margen de Error |
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

1. **Aplicación de Funciones de Orden Superior:** Se cumplió con el objetivo principal [cite: 5] al implementar la función `integracion`, la cual recibe otra función como parámetro (`f: Double => Double`). Esto permitió desacoplar la lógica del algoritmo numérico de las ecuaciones matemáticas específicas, facilitando la reutilización del código.
2. **Eficacia del Método:** La implementación en Scala demostró ser una herramienta confiable para la aproximación de integrales, obteniendo resultados muy cercanos a los valores analíticos esperados [cite: 28, 29] con un esfuerzo computacional mínimo.
3.  **Paradigma Funcional:** El uso de la inmutabilidad y las expresiones lambda simplificó la sintaxis del algoritmo matemático, resultando en un código más limpio y legible en comparación con enfoques imperativos tradicionales.
