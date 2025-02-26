package org.ery.project

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime

expect fun formatDateTime(dateTime: LocalDateTime): String
expect fun formatDate(date: LocalDate): String

expect fun parseDateTime(dateTime: String): LocalDateTime
expect fun parseDate(date: String): LocalDate

const val patternDateTime = "dd/MM/yyyy - HH:mm"
const val patternDate = "dd/MM/yyyy"

