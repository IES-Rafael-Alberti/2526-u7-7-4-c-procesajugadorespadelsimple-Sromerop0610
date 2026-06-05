package org.iesra.procesapadel.domain.infrastructure

import com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time
import org.iesra.procesapadel.domain.model.Couple
import org.iesra.procesapadel.domain.model.Player

class SimplePadelCoupleGenerator {

    fun contadorTime(mañana: Int, tarde: Int): String {
        if (mañana>tarde)
            return "tarde"
        if (mañana < tarde)
            return "mañana"
        else (mañana == tarde)
            return "mañana"
    }

    fun generator(player: List<Player>) : MutableList<Couple> {

        val levels = player.groupBy { it.level }
        val times = mutableMapOf<String, List<Couple>>()
        var indice = 0
        var couples: MutableList<Couple> = mutableListOf<Couple>()
        var mañana = 0
        var tarde = 0
        var time = ""

        for ((level, players) in levels) {
            val orderplayer = players.sortedBy { it.time }

            while (indice + 1 < players.size) {

                var player1 = orderplayer.get(indice)
                var player2 = orderplayer.get(indice + 1)

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

                indice + 2

                couples.add(Couple(
                    player1,
                    player2,
                    level,
                    time,
                ))
            }
        }
        return couples
    }
}