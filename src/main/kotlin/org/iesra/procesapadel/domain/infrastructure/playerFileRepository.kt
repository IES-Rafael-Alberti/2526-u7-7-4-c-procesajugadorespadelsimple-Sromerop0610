package org.iesra.procesapadel.domain.infrastructure

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption
import kotlin.io.path.isRegularFile

// Clase que se encarga de trabajar con los archivos
class playerFileRepository {

    // Función que busca los archivos .txt a procesar
    fun findInputFiles(directory: Path): List<Path>{
        return Files.list(directory).use { stream ->
            stream
                .filter {it.isRegularFile() && it.toString().endsWith(".txt")}
                .toList()
        }
    }

    // Función que mueve los archivos .txt a la carpeta procesados desde el path introducido
    fun moveToProcessed(path: Path) {

        val processedDir = path.resolve("procesados")

        if (!Files.exists(processedDir))
            Files.createDirectories(processedDir)

        val target = processedDir.resolve(path.fileName)

        Files.move(path, target, StandardCopyOption.REPLACE_EXISTING)
    }
}