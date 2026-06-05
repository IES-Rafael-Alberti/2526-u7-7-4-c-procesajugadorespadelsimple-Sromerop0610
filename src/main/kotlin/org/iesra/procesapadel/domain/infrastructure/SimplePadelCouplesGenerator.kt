package org.iesra.procesapadel.domain.infrastructure

import org.iesra.procesapadel.domain.model.Player

class SimplePadelCouplesGenerator {
    fun generate(player: Player) {
        val matchLevels: MutableMap<String, MutableList<Player>> = mutableMapOf()

        val requestedLevel = player.level

        matchLevels.computeIfAbsent(requestedLevel) { mutableListOf() }.add(player)

        val couples: MutableList<String> = mutableListOf()

        matchLevels.forEach { string, players ->
            if(players.size % 2 != 0){

            }
        }
    }
}