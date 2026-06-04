# Casos de prueba

Este directorio contiene un conjunto de ficheros para validar lectura, escritura, gestión de errores, creación de parejas, generación de partidos y movimiento a `procesados`.

## Cobertura de casos

| Fichero | Caso que prueba | Resultado esperado |
| --- | --- | --- |
| `ana-garcia.txt` | Jugadora válida de nivel intermedio con franja tarde | Jugadora válida |
| `marta-ruiz.txt` | Jugadora válida de nivel intermedio con franja tarde | Incidencia de jugadora sin pareja |
| `elena-martin.txt` | Jugadora válida de nivel intermedio con franja tarde | Jugadora válida |
| `sergio-castro.txt` | Jugador válido de nivel intermedio con franja tarde | Segunda pareja intermedia de tarde |
| `hugo-molina.txt` | Jugador válido de nivel intermedio | Forma pareja intermedia de tarde |
| `irene-gomez.txt` | Jugadora válida de iniciación con franja mañana | Jugadora válida |
| `carlos-pena.txt` | Jugador válido de iniciación con franja mañana | Pareja de iniciación de tarde por regla de menor carga |
| `laura-blanco.txt` | Jugadora válida de iniciación con franja tarde | Pareja de iniciación de mañana por desempate |
| `diego-santos.txt` | Jugador válido de iniciación con franja tarde | Pareja de iniciación de tarde sin partido |
| `marcos-rubio.txt` | Jugador avanzado con franja indiferente | Usa la franja concreta de su pareja |
| `pablo-torres.txt` | Jugador avanzado con franja tarde | Pareja avanzada de tarde |
| `beatriz-luna.txt` | Jugadora avanzada con franja mañana | Jugadora válida |
| `nicolas-vega.txt` | Jugador avanzado con franja tarde | Conflicto mañana/tarde, desempate por menor carga |
| `olivia-marin.txt` | Jugadora avanzada con franja indiferente | Jugadora válida |
| `raul-cortes.txt` | Jugador avanzado con franja indiferente | Pareja con dos indiferentes |
| `lucia-sin-nivel.txt` | Nivel no válido | Incidencia de nivel no reconocido |
| `horario-invalido.txt` | Horario no válido | Incidencia de horario no reconocido |
| `incompleto.txt` | Falta el campo `Horario` | Incidencia de formato incompleto |

Con las reglas del enunciado, `marta-ruiz.txt` queda como jugadora válida sin pareja porque el nivel `INTERMEDIO` tiene cinco personas válidas.

## Posibilidades cubiertas

- Niveles válidos exactos: `iniciación`, `intermedio` y `avanzado`.
- Franjas válidas exactas: `mañana`, `tarde` e `indiferente`.
- Pareja con misma franja.
- Pareja con una persona `indiferente` y otra con franja concreta.
- Pareja con dos personas `indiferente`.
- Pareja con conflicto entre `mañana` y `tarde`.
- Jugador válido sin pareja.
- Pareja válida sin partido.
- Nivel no válido.
- Horario no válido.
- Fichero incompleto.
