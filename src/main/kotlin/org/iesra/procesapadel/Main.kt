package org.iesra.procesapadel

import org.iesra.procesapadel.application.PadelProcessingApplication
import org.iesra.procesapadel.cli.CommandLineParser

/**
 * Punto de entrada del proyecto base.
 *
 * La idea didáctica es separar responsabilidades:
 * - `main` solo coordina objetos.
 * - `CommandLineParser` interpreta los argumentos.
 * - `PadelProcessingApplication` representa el flujo principal del programa.
 */
fun main(args: Array<String>) {
    val parser = CommandLineParser()
    val options = parser.parse(args)

    val application = PadelProcessingApplication()
    application.run(options)
}
