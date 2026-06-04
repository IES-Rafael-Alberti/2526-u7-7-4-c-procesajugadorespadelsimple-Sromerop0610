package org.iesra.procesapadel.cli

import java.nio.file.Path
import kotlin.io.path.Path

/**
 * Se encarga de una única responsabilidad:
 * convertir los argumentos de línea de comandos en un objeto `CliOptions`.
 *
 * Esta clase es un buen primer ejemplo de orientación a objetos:
 * agrupamos en un mismo lugar el comportamiento relacionado con el parseo.
 */
class CommandLineParser {

    /**
     * Analiza las opciones recibidas desde `main`.
     *
     * Opciones soportadas:
     * - `--torneo <NOMBRE>` obligatorio
     * - `--path <RUTA>` opcional
     *
     * @param args argumentos recibidos al ejecutar el programa.
     * @return objeto con los parámetros ya interpretados.
     * @throws IllegalStateException si falta `--torneo`, si una opción no tiene valor
     * o si se usa una opción no reconocida.
     */
    fun parse(args: Array<String>): CliOptions {
        var tournament: String? = null
        var path: Path = Path(".")
        var index = 0

        while (index < args.size) {
            when (args[index]) {
                OPTION_TOURNAMENT -> {
                    tournament = args.getOrNull(index + 1)?.takeIf(String::isNotBlank)
                        ?: error("La opción $OPTION_TOURNAMENT necesita un valor. Uso: --torneo <NOMBRE> [--path <RUTA>]")
                    index += 2
                }

                OPTION_PATH -> {
                    val rawPath = args.getOrNull(index + 1)?.takeIf(String::isNotBlank)
                        ?: error("La opción $OPTION_PATH necesita un valor. Uso: --torneo <NOMBRE> [--path <RUTA>]")
                    path = Path(rawPath)
                    index += 2
                }

                else -> error("Opción no reconocida: ${args[index]}. Uso: --torneo <NOMBRE> [--path <RUTA>]")
            }
        }

        return CliOptions(
            tournament = tournament ?: error("La opción --torneo es obligatoria."),
            path = path,
        )
    }

    companion object {
        private const val OPTION_TOURNAMENT = "--torneo"
        private const val OPTION_PATH = "--path"
    }
}
