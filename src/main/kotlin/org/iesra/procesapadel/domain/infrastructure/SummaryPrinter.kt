package org.iesra.procesapadel.domain.infrastructure

import org.iesra.procesapadel.domain.model.ProcessingSummary

class SummaryPrinter {

    fun print(summary: ProcessingSummary) {

        println("===== RESUMEN DEL TORNEO =====")

        println("Ficheros procesados: ${summary.filesProcessed}")
        println("Jugadores válidos: ${summary.validPlayers}")
        println("Incidencias: ${summary.issues}")
        println("Parejas creadas: ${summary.couples}")
        println("Partidos generados: ${summary.matches}")

        println("================================")
    }
}