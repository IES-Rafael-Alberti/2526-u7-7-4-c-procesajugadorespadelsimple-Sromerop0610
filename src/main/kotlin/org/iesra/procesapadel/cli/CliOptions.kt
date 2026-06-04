package org.iesra.procesapadel.cli

import java.nio.file.Path

/**
 * Objeto de datos con los parámetros ya interpretados.
 *
 * Este tipo de clase suele llamarse DTO o Value Object,
 * porque solo transporta datos entre objetos.
 *
 * @property tournament identificador del torneo o jornada, por ejemplo `PADEL-1`.
 * @property path carpeta donde se buscarán los ficheros de entrada.
 */
data class CliOptions(
    val tournament: String,
    val path: Path,
)
