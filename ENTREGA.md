# ENTREGA

SARA ROMERO PERALTA, 1ºDAW A

> Sustituye cada `TODO` por tu respuesta.
> Usa enlaces permanentes de GitHub cuando se pidan enlaces al código.

## Descripción breve de la solución

Para implementar los requisitos pedidos, he seguido el flujo marcado por `PadelProcessingApplication.kt`, donde primero buscamos los archivos con el método `0findInputFiles` de `playerFileRepository.kt`, parseamos los archivos con `playerParser.kt` y pasamos a procesados los archivos con el método `moveToProcessed`.

Una vez con los datos parseados, los jugadores válidos se agrupan por nivel y con eso se generan las parejas de dos en dos dentro de cada nivel mediante `PairMaker`.

Después, a partir de las parejas creadas, se generan los partidos con `matchGenerator`, asegurando que sean del mismo nivel y franja horaria.

Por último, con `OutputWriter` se generan los ficheros csv y txt, y con `SummaryPrinter` se muestra un resumen con los datos procesados, jugadores válidos, parejas, partidos e incidencias.
## Ejemplo de ejecución

### Fichero de parejas

```text
pareja|jugador1|jugador2|nivel|franja
P0 Ana | Elena | INTERMEDIO | Horario: tarde

pareja|jugador1|jugador2|nivel|franja
P1 Hugo | Marta | INTERMEDIO | Horario: tarde

pareja|jugador1|jugador2|nivel|franja
P2 Marcos | Olivia | AVANZADO | Horario: mañana

pareja|jugador1|jugador2|nivel|franja
P3 Raúl | Beatriz | AVANZADO | Horario: mañana

pareja|jugador1|jugador2|nivel|franja
P4 Nicolás | Pablo | AVANZADO | Horario: tarde

pareja|jugador1|jugador2|nivel|franja
P5 Carlos | Irene | INICIACIÓN | Horario: mañana

pareja|jugador1|jugador2|nivel|franja
P6 Diego | Laura | INICIACIÓN | Horario: tarde


```

### Fichero de partidos

```text
T[Partido-1]
Nivel: AVANZADO
Franja: mañana
P1: Marcos / Olivia
P2: Raúl / Beatriz

[Partido-2]
Nivel: INTERMEDIO
Franja: tarde
P3: Ana / Elena
P4: Hugo / Marta


```

### Salida por consola con incidencias

```text
Torneo recibido: PADEL-1
Directorio de trabajo: .\src\test\resources\jugadores-ejemplo
===== RESUMEN DEL TORNEO =====
Ficheros procesados: 18
Jugadores v´┐¢lidos: 15
Incidencias: 3
Parejas creadas: 7
Partidos generados: 2
- Error: FileIssue(fileName=horario-invalido.txt, message=Jugador inv´┐¢lido: falta alg´┐¢n campo o nivel/horario incorrecto) 
- Error: FileIssue(fileName=incompleto.txt, message=Jugador inv´┐¢lido: falta alg´┐¢n campo o nivel/horario incorrecto) 
- Error: FileIssue(fileName=lucia-sin-nivel.txt, message=Jugador inv´┐¢lido: falta alg´┐¢n campo o nivel/horario incorrecto) 
================================

Sugerencia de dise´┐¢o orientado a objetos:
- PlayerFileRepository: localiza, lee y mueve ficheros.
- PlayerParser: convierte un fichero en un objeto Player.
- LevelNormalizer: convierte el nivel textual en un valor comparable.
- PairMaker: crea parejas equilibradas seg´┐¢n nivel y preferencia.
- MatchScheduler: genera partidos entre parejas y horarios disponibles.
- OutputWriter: escribe los ficheros CSV y TXT.
- SummaryPrinter: muestra el resumen final.
```

### Carpeta `procesados` con los ficheros movidos

![Prueba1](src/assets/Captura%20de%20pantalla%202026-06-05%20184429.png)

## Preguntas: COMPLEMENTA LAS RESPUESTAS CON ENLACES PERMANENTES DE GITHUB

### [CE 5.a] 1.a. Muestra cómo tu programa recibe y utiliza los argumentos `--torneo` y `--path`.
Los argumentos se leen desde la línea de comandos en CliOptions.
El parámetro --torneo indica el nombre del torneo y --path indica la carpeta donde están los ficheros de entrada.
Si no se pasa --path, se usa el directorio actual.

Ejemplo de ejecución:
```bash
--torneo PADEL-1 --path src/test/resources/jugadores-ejemplo
```

Salida:
Torneo recibido: PADEL-1
Directorio de trabajo: src/test/resources/jugadores-ejemplo

PERMALINK: https://github.com/IES-Rafael-Alberti/2526-u7-7-4-c-procesajugadorespadelsimple-Sromerop0610/blob/024314a3564897a524d0c2a97bd6869540b56a64/src/main/kotlin/org/iesra/procesapadel/cli/CliOptions.kt#L1-L17

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
