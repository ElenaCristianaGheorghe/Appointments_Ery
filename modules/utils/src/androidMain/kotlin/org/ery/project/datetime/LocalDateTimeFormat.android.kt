package org.ery.project.datetime

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.toJavaLocalDate
import kotlinx.datetime.toJavaLocalDateTime
import kotlinx.datetime.toKotlinLocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

actual fun formatDateTime(dateTime: LocalDateTime): String {
    return DateTimeFormatter
        .ofPattern(patternDateTime, Locale.getDefault())
        .format(dateTime.toJavaLocalDateTime())
}

actual fun formatDate(date: LocalDate): String {
    return DateTimeFormatter
        .ofPattern(patternDate, Locale.getDefault())
        .format(date.toJavaLocalDate())
}

actual fun parseDateTime(dateTime: String): LocalDateTime {
    val formatter = DateTimeFormatter.ofPattern(patternDateTime, Locale.getDefault())
    return java.time.LocalDateTime
        .parse(dateTime, formatter)
        .toKotlinLocalDateTime()
}

actual fun parseDate(date: String): LocalDate {
    val formatter = DateTimeFormatter.ofPattern(patternDate, Locale.getDefault())
    return java.time.LocalDateTime
        .parse(date, formatter)
        .toKotlinLocalDateTime()
        .date
}