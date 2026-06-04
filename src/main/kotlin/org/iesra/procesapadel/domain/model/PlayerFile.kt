package org.iesra.procesapadel.domain.model

import java.nio.file.Path

/**
 * Representa un fichero de entrada de una persona inscrita al torneo.
 *
 * Es util para recordar que en orientacion a objetos tambien podemos modelar conceptos del sistema que no son solo personas.
 */
data class PlayerFile(
    val path: Path,
)
