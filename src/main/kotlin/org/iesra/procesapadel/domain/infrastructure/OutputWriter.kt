package org.iesra.procesapadel.domain.infrastructure

import org.iesra.procesapadel.domain.model.Couple
import org.iesra.procesapadel.domain.model.Player
import java.nio.file.Files
import java.nio.file.Path

class OutputWriter {
    fun writePair(
        couples: List<Couple>,
        outputDir: Path
    ) {

        val file = outputDir.resolve("torneo-parejas.csv")

        val lines = buildList {
        val indice = 0

            for (couple in couples) {
                add("pareja|jugador1|jugador2|nivel|franja")
                add("P$indice ${couple.player1} | ${couple.player2} | ${couple.level.uppercase()} | Horario: ${couple.time}")

                add("")
                indice + 1
            }
        }

        Files.write(file, lines)
    }
}
