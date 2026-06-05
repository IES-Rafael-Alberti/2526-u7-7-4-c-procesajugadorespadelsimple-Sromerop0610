package org.iesra.procesapadel.domain.model

data class Match (
    var couple1 : Couple,
    var couple2 : Couple,
    var level: String,
    var time: String,
)