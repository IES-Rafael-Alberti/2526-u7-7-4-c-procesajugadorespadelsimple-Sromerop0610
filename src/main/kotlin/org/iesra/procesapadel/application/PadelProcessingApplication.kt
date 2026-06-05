package org.iesra.procesapadel.application

import org.iesra.procesapadel.cli.CliOptions
import org.iesra.procesapadel.domain.infrastructure.OutputWriter
import org.iesra.procesapadel.domain.infrastructure.PairMaker
import org.iesra.procesapadel.domain.infrastructure.levelNormalizer
import org.iesra.procesapadel.domain.infrastructure.playerFileRepository
import org.iesra.procesapadel.domain.infrastructure.playerParser
import org.iesra.procesapadel.domain.infrastructure.SummaryPrinter
import org.iesra.procesapadel.domain.model.FileIssue
import org.iesra.procesapadel.domain.model.Player
import org.iesra.procesapadel.domain.model.ProcessingSummary
import java.nio.file.Files
import java.nio.file.Path

class PadelProcessingApplication {

    fun run(options: CliOptions) {

        println("Torneo recibido: ${options.tournament}")
        println("Directorio de trabajo: ${options.path}")

        val playerFileRepository = playerFileRepository()
        val playerParser = playerParser()
        val levelNormalizer = levelNormalizer()
        val pairMaker = PairMaker()
        val outputWriter = OutputWriter()
        val summaryPrinter = SummaryPrinter()

        // ####################### Entrada: Lectura de datos, conversión a estructuras

        // 1. Pedir a una clase repositorio que localice los `.txt` de entrada.
        val inputFiles = playerFileRepository.findInputFiles(options.path)

        // 2. Crear colecciones donde guardar jugadores válidos e incidencias.
        val players = mutableListOf<Player>()
        val issues = mutableListOf<FileIssue>()

        // 3. Recorrer cada fichero y delegar el parseo en un objeto parser.
        for (file in inputFiles) {

            val player = playerParser.parse(file)

            // 4. Si el parser detecta errores, guardar incidencias.
            if (player == null) {

                issues.add(
                    FileIssue(
                        fileName = file.fileName.toString(),
                        message = "Jugador inválido: falta algún campo o nivel/horario incorrecto"
                    )
                )

            } else {

                // 5. Si el parser obtiene un jugador correcto, guardarlo como objeto `Player`.
                players.add(player)
            }

            // 6. Delegar el movimiento a `procesados` a un repositorio o gestor de ficheros.
            playerFileRepository.moveToProcessed(file)
        }

        // ####################### Procesamiento: de datos de entrada, y generación de datos de salida

        // 7. Para cada Player, calcular su nivel normalizado y validar su disponibilidad.
        levelNormalizer.normalize(players)

        // 8. Delegar la creación de parejas equilibradas a una clase especializada.
        val validPlayers = players

        val pairs = pairMaker.createPairs(validPlayers)

        // 9. Delegar la generación de partidos evitando repetir horarios.
        val matches = pairMaker.createMatches(pairs)

        // ####################### Salida: ficheros de salida y resumen

        // 10. Delegar la escritura de ficheros de salida a un escritor.
        outputWriter.writePairs(pairs, options.path)
        outputWriter.writeMatches(matches, options.path)

        // 11. Finalmente, construir un resumen y mostrarlo por consola.
        val summary = ProcessingSummary(
            filesProcessed = inputFiles.size,
            validPlayers = players.size,
            issues = issues.size,
            couples = pairs.size,
            matches = matches.size
        )

        summaryPrinter.print(summary)

        printSuggestedDesign()
    }

    private fun printSuggestedDesign() {
        println()
        println("Sugerencia de diseño orientado a objetos:")
        println("- PlayerFileRepository: localiza, lee y mueve ficheros.")
        println("- PlayerParser: convierte un fichero en un objeto Player.")
        println("- LevelNormalizer: convierte el nivel textual en un valor comparable.")
        println("- PairMaker: crea parejas equilibradas según nivel y preferencia.")
        println("- MatchScheduler: genera partidos entre parejas y horarios disponibles.")
        println("- OutputWriter: escribe los ficheros CSV y TXT.")
        println("- SummaryPrinter: muestra el resumen final.")
    }
}