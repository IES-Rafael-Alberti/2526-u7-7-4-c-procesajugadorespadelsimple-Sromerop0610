package org.iesra.procesapadel.domain.infrastructure

import org.iesra.procesapadel.domain.model.Couple
import org.iesra.procesapadel.domain.model.Player

class levelNormalizer {
    fun normalize(player: List<Player>) : Map<String, List<Player>> {
        val levels = player.groupBy { it.level }
        return levels
    }
}