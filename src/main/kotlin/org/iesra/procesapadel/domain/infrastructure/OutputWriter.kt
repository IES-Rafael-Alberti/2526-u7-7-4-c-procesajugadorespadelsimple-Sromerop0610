package org.iesra.procesapadel.domain.infrastructure

import org.iesra.procesapadel.domain.model.Couple
import org.iesra.procesapadel.domain.model.Match
import org.iesra.procesapadel.domain.model.Player
import java.nio.file.Files
import java.nio.file.Path

class OutputWriter {
    fun writePairs(
        couples: List<Couple>,
        outputDir: Path
    ) {

        val file = outputDir.resolve("torneo-parejas.csv")

        val lines = buildList {
        var indice = 0

            for (couple in couples) {
                add("pareja|jugador1|jugador2|nivel|franja")
                add("P$indice ${couple.player1.name} | ${couple.player2.name} | ${couple.level.uppercase()} | Horario: ${couple.time}")

                add("")
                indice += 1
            }
        }

        Files.write(file, lines)
    }

    fun writeMatches(
        matches: List<Match>,
        outputDir: Path
    ) {

        val file = outputDir.resolve("torneo-partidos.txt")

        val lines = buildList {

            var indice = 1

            for (match in matches) {

                add("[Partido-$indice]")

                add("Nivel: ${match.level.uppercase()}")

                add("Franja: ${match.time}")

                add("P${indice * 2 - 1}: ${match.couple1.player1.name} / ${match.couple1.player2.name}")

                add("P${indice * 2}: ${match.couple2.player1.name} / ${match.couple2.player2.name}")

                add("")

                indice += 1
            }
        }

        Files.write(file, lines)
    }
}
