package org.iesra.procesapadel.domain.infrastructure

import org.iesra.procesapadel.domain.model.Player
import java.nio.file.Files
import java.nio.file.Path

class playerParser {


    fun parse(path: Path): Player? {
        val lines = Files.readAllLines(path)

        val name = lines
            .firstOrNull { it.startsWith("Nombre:") }
            ?.substringAfter(":")
            ?.trim()
            .orEmpty()

        val surname = lines
            .firstOrNull { it.startsWith("Apellidos:") }
            ?.substringAfter(":")
            ?.trim()
            .orEmpty()

        val level = lines
            .firstOrNull { it.startsWith("Nivel:") }
            ?.substringAfter(":")
            ?.trim()
            .orEmpty()

        val time = lines
            .firstOrNull { it.startsWith("Horario =") }
            ?.substringAfter("=")
            ?.trim()
            .orEmpty()

        if (name.isBlank() || surname.isBlank() || level.isBlank() || time.isBlank()) {
            return null
        }

        if (level != "iniciación" && level != "intermedio" && level != "avanzado" || time != "mañana" && time != "tarde" && time != "indiferente") {
            return null
        }

        return Player(
            name = name,
            surname = surname,
            level = level,
            time = time,
            fileName = path.fileName.toString()
        )
    }
}

