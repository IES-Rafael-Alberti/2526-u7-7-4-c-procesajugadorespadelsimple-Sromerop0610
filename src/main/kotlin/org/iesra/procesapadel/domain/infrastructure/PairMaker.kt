package org.iesra.procesapadel.domain.infrastructure

import org.iesra.procesapadel.domain.model.Couple
import org.iesra.procesapadel.domain.model.FileIssue
import org.iesra.procesapadel.domain.model.Match
import org.iesra.procesapadel.domain.model.Player

class PairMaker {
    val errors = mutableListOf<FileIssue>()
    fun contadorTime(mañana: Int, tarde: Int): String {
        if (mañana > tarde)
            return "tarde"
        if (mañana < tarde)
            return "mañana"
        else (mañana == tarde)
        return "mañana"
    }

    fun createPairs(player: List<Player>): MutableList<Couple> {

        val levels = player.groupBy { it.level }
        var couples: MutableList<Couple> = mutableListOf()
        var mañana = 0
        var tarde = 0
        var time = ""

        for ((level, players) in levels) {
            var indice = 0
            val orderplayer = players.sortedBy { it.time }

            while (indice + 1 < players.size) {

                val player1 = orderplayer[indice]
                val player2 = orderplayer[indice + 1]

                if (player1.time == player2.time && player1.time != "indiferente") {
                    time = player1.time
                    if (time == "mañana") mañana++ else tarde++
                }
                if (player1.time == player2.time && player1.time == "indiferente") {
                    time = contadorTime(mañana, tarde)
                    if (time == "mañana") mañana++ else tarde++
                }
                if (player1.time == "indiferente" && player2.time != "indiferente") {
                    time = player2.time
                    if (time == "mañana") mañana++ else tarde++
                }
                if (player2.time == "indiferente" && player1.time != "indiferente") {
                    time = player1.time
                    if (time == "mañana") mañana++ else tarde++
                }

                indice += 2

                couples.add(
                    Couple(
                        player1,
                        player2,
                        level,
                        time,
                    )
                )

                if (indice < orderplayer.size){
                    val playerWithoutCouple = orderplayer[indice]

                    errors.add(
                        FileIssue(
                            playerWithoutCouple.fileName,
                            "Jugador sin pareja: \${playerWithoutCouple.name} nivel \$level"
                        )
                    )
                }
            }
        }
        return couples
    }

    fun createMatches(couples: List<Couple>): MutableList<Match> {

        val matches = mutableListOf<Match>()

        var indice = 0

        val orderedCouples = couples.sortedBy { it.time }

        while (indice < orderedCouples.size) {

            val couple1 = orderedCouples[indice]

            var indice2 = indice + 1

            var encontrado = false

            while (indice2 < orderedCouples.size && !encontrado) {

                val couple2 = orderedCouples[indice2]

                if (couple1.time == couple2.time && couple1.level == couple2.level) {
                    matches.add(
                        Match(
                            couple1,
                            couple2,
                            couple1.level,
                            couple1.time
                        )
                    )
                    encontrado = true
                }

                indice2 += 1
            }

            if (!encontrado) {
                errors.add(
                    FileIssue(
                        couple1.player1.fileName,
                        "Pareja sin rival: ${couple1.player1.name} / ${couple1.player2.name}"
                    )
                )
            }

            indice +=1
        }

        return matches
    }
}