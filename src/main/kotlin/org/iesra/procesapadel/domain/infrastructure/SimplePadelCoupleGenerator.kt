package org.iesra.procesapadel.domain.infrastructure

import org.iesra.procesapadel.domain.model.Player

class SimplePadelCoupleGenerator {
    fun generator(player: Player) {
        val couples: MutableMap<String, List<Player?>> = mutableMapOf()

        val aux = SimplePadelLevelAgrupation()
        val levels = aux.matchLevels(player)

        levels.forEach {
            var playerList = mutableListOf<Player>()

            var player1 = playerList.firstOrNull()
            var player2 = playerList.getOrNull(1)

            var group = "A"
            var indice = 2

            while (player1 != null){
                if (player2 == null){
                    couples[group] = listOf(player2)
                }else {

                var couple = listOf(player1, player2)
                couples[group] = couple

                player1 = playerList[indice]
                player2 = playerList[indice+1]
                group + 2
                }

            }
        }
    }
}
