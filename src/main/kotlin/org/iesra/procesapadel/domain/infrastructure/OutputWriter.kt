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

        val file = outputDir.resolve("torneo-grupos.txt")

        val lines = buildList {
        val indice = 0

            for (couple in couples) {
                add("[Pareja $indice")
                add("- Nombre primer jugador: ${couple.player1} Nombre segundo jugador: ${couple.player2} Nivel: ${couple.level} Horario: ${couple.time}")

                add("")
                indice + 1
            }
        }

        Files.write(file, lines)
    }
}
