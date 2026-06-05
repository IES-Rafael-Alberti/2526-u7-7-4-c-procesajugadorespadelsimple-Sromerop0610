package org.iesra.procesapadel.domain.infrastructure

import org.iesra.procesapadel.domain.model.FileIssue
import org.iesra.procesapadel.domain.model.ProcessingSummary
import kotlin.collections.mutableListOf

class SummaryPrinter {

    fun print(summary: ProcessingSummary, issues: MutableList<FileIssue>) {

        println("===== RESUMEN DEL TORNEO =====")

        println("Ficheros procesados: ${summary.filesProcessed}")
        println("Jugadores válidos: ${summary.validPlayers}")
        println("Incidencias: ${summary.issues}")
        println("Parejas creadas: ${summary.couples}")
        println("Partidos generados: ${summary.matches}")

        for (issue in issues){
            println("- Error: ${issue.message} ")
        }
        println("================================")
    }
}