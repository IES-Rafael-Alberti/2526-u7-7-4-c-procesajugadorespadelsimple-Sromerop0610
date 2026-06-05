package org.iesra.procesapadel.domain.model

data class Result (
    val couples: List<Couple>? = null,
    val matches: List<Match>? = null,
    val issue: List<FileIssue>
)