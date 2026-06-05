package org.iesra.procesapadel.domain.infrastructure

import org.iesra.procesapadel.domain.model.Player

class SimplePadelLevelAgrupation {
    fun matchLevels(player: Player) : MutableMap<String, MutableList<Player>>{
        val levels: MutableMap<String, MutableList<Player>> = mutableMapOf()

        val requestedLevel = player.level

        levels.computeIfAbsent(requestedLevel) { mutableListOf() }
            .add(player)

        return levels
    }
}