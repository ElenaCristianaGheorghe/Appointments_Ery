package org.ery.project.core.domain.model

data class Facility(
    val name: String,
    val duration: Int,
    val price: Float,
    val id: Long = 0
)