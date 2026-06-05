# ENTREGA

SARA ROMERO PERALTA, 1ºDAW A

> Sustituye cada `TODO` por tu respuesta.
> Usa enlaces permanentes de GitHub cuando se pidan enlaces al código.

## Descripción breve de la solución

Para implementar los requisitos pedidos, he seguido el flujo marcado por PadelProcessingApplication.kt, donde primero buscamos los archivos con el método findInputFiles de playerFileRepository.kt, parseamos los archivos con playerParser.kt y pasamos a procesados los archivos con el método moveToProcessed de playerFileRepository.kt.

Una vez con los datos parseados, hacemos uso de SimplePadelLevelAgrupation para agrupar a todos los jugadores en el mismo nivel, y SimplePadelCoupleGenerator para crear las parejas del mismo nivel.

Cuando tenemos las parejas hechas, usamos SimplePadelMatchesCreator.kt para crear los partidos.

Por último, con el SimpleOutputWriter creamos el archivo .csv y el archivo .txt, y con SummaryPrinter.kt mostramos un resumen de los datos procesados y los resultados obtenidos.

## Ejemplo de ejecución

### Fichero de parejas

```text
TODO
```

### Fichero de partidos

```text
TODO
```

### Salida por consola con incidencias

```text
TODO
```

### Carpeta `procesados` con los ficheros movidos

TODO: Evidencia o captura de pantalla.

## Preguntas: COMPLEMENTA LAS RESPUESTAS CON ENLACES PERMANENTES DE GITHUB

### [CE 5.a] 1.a. Muestra cómo tu programa recibe y utiliza los argumentos `--torneo` y `--path`.

Incluye:

- Enlace permanente al código donde se procesan los argumentos.
  TODO
- Breve explicación.
  TODO
- Ejemplo de ejecución real con comando y salida por consola.
  TODO

### [CE 5.b] 2.a. Muestra la salida completa por consola tras procesar varios ficheros.

Explica brevemente y no olvides enlaces permanentes al código:

- Qué información muestras.
  TODO
- Cómo has estructurado el formato para que sea legible.
  TODO
- Ejemplo de ejecución real con comando y salida por consola.
  TODO

### [CE 5.c] 3.a. Indica qué clases o métodos has utilizado para trabajar con ficheros y por qué los has elegido.

Incluye:

- Enlace permanente al código donde se ejemplifica su uso.
  TODO
- Descripción del código anterior.
  TODO
- Justificación de por qué usas esas clases o métodos y no otros.
  TODO

### [CE 5.d] 4.a. Muestra cómo interpretas el formato del fichero de entrada y cómo validas que sea correcto.

Incluye:

- Enlace permanente al código de lectura y validación.
  TODO
- Descripción del código anterior.
  TODO
- Un ejemplo de error detectado por tu programa y cómo se gestiona.
  TODO

### [CE 5.e] 5.a. Breve comentario sobre tu código, con enlaces permanentes, acerca de cómo realizas:

- Describe la lectura de ficheros.
  TODO
- Describe la escritura de resultados CSV y TXT.
  TODO
- Describe el movimiento de ficheros a la carpeta `procesados`.
  TODO

Incluye un enlace permanente a cada caso y una breve explicación.

## Checklist final

- [ ] He rellenado todos los `TODO`.
- [ ] He añadido enlaces permanentes de GitHub.
- [ ] He incluido ejemplos reales de ejecución y salida.
- [ ] He revisado el formato final.
