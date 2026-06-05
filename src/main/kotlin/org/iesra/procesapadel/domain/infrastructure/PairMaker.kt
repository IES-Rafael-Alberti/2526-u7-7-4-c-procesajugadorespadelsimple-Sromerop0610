package org.iesra.procesapadel.domain.infrastructure

import org.iesra.procesapadel.domain.model.Couple
import org.iesra.procesapadel.domain.model.Match
import org.iesra.procesapadel.domain.model.Player
import org.iesra.procesapadel.domain.model.Result

class PairMaker {

    fun contadorTime(mañana: Int, tarde: Int): String {
        if (mañana > tarde)
            return "tarde"
        if (mañana < tarde)
            return "mañana"
        else (mañana == tarde)
        return "mañana"
    }

    fun couplesGenerator(player: List<Player>): MutableList<Couple> {

        val levels = player.groupBy { it.level }
        val times = mutableMapOf<String, List<Couple>>()
        var indice = 0
        var couples: MutableList<Couple> = mutableListOf<Couple>()
        var finalCouples: MutableList<Result> = mutableListOf()
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

                couples.add(
                    Couple(
                        player1,
                        player2,
                        level,
                        time,
                    )
                )

            }
        }
        return couples
    }
}
/*
    fun matchGenerator(couples: List<Couple>) : MutableList<Match> {
        val matches = mutableListOf<Match>()
        val couples = couples.sortedBy { it.time }

        for (couple in couples){
            if (couple.time == "mañana")
                mañana += couple

        }
        var couplesMañana = couples.filter{}

        if (couples.size % 2 == 0){
            while (indice + 1 < couples.size) {
                if (couple1.time == couple2.time) {
                    if (couple1.level == couple2.level) {
                        matches.add(Match(couple1, couple2, couple1.level, couple2.time))
                        indice + 2
                    } else{
                        indice + 1
                        couple2 =  couple
                } }
            }
        } else{
            while (indice < couples.size) {
                if (couple1.time == couple2.time) {
                    if (couple1.level == couple2.level) {
                        matches.add(Match(couple1, couple2, couple1.level, couple2.time))
                        indice + 2
                    }
                }
            }
        }



        return matches

    }


 */