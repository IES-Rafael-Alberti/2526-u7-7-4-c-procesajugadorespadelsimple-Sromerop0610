package org.iesra.procesapadel.domain.model

/**
 * Resume el resultado final de la ejecución.
 *
 * Esta clase todavía es mínima, pero sirve para enseñar que el resumen también puede modelarse como un objeto.
 */
data class ProcessingSummary(
    val detectedFiles: Int,
    val validPlayers: Int,
    val issues: List<FileIssue>,
)
