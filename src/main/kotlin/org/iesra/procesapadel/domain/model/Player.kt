package org.iesra.procesapadel.domain.model

data class Player(
    val name: String,
    val surname: String,
    val level: String,
    val time: String,
    var coupleNumber: Int? = null
)
