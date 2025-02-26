package org.ery.project

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.convert
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toKotlinInstant
import kotlinx.datetime.toLocalDateTime
import platform.Foundation.NSCalendar
import platform.Foundation.NSDate
import platform.Foundation.NSDateComponents
import platform.Foundation.NSDateFormatter
import platform.Foundation.NSLocale
import platform.Foundation.currentLocale

@OptIn(ExperimentalForeignApi::class)
private fun LocalDateTime.toNsDateTime(includeTime: Boolean = false): NSDate? {
    val calendar = NSCalendar.currentCalendar
    val components = NSDateComponents()
    components.year = this.year.convert()
    components.month = this.monthNumber.convert()
    components.day = this.dayOfMonth.convert()
    components.hour = this.hour.convert()
    components.minute = this.minute.convert()
    components.second = this.second.convert()
    return calendar.dateFromComponents(components)
}

@OptIn(ExperimentalForeignApi::class)
private fun LocalDate.toNsDate(): NSDate? {
    val calendar = NSCalendar.currentCalendar
    val components = NSDateComponents()
    components.year = this.year.convert()
    components.month = this.monthNumber.convert()
    components.day = this.dayOfMonth.convert()
    return calendar.dateFromComponents(components)
}

actual fun formatDateTime(dateTime: LocalDateTime): String {
    val date = dateTime.toNsDateTime()
        ?: throw IllegalStateException("Failed to convert LocalDateTime $LocalDateTime to NSDate")
    val formatter = NSDateFormatter().apply {
        dateFormat = patternDateTime
        locale = NSLocale.currentLocale
    }
    return formatter.stringFromDate(date)
}

actual fun formatDate(date: LocalDate): String {


    val formatter = NSDateFormatter().apply {
        dateFormat = patternDate
        locale = NSLocale.currentLocale
    }
    return formatter.stringFromDate(date.toNsDate() ?: throw IllegalStateException("Failed to convert LocalDateTime $LocalDateTime to NSDate"))
}

actual fun parseDateTime(dateTime: String): LocalDateTime {
    val formatter = NSDateFormatter().apply {
        dateFormat = patternDateTime
        locale = NSLocale.currentLocale
    }
    return formatter
        .dateFromString(dateTime)
        // extensions functions provided by kotlinx.datetime
        ?.toKotlinInstant()
        ?.toLocalDateTime(TimeZone.currentSystemDefault())
        ?: throw IllegalStateException("Failed to convert String $dateTime to LocalDateTime")
}

actual fun parseDate(date: String): LocalDate {
    val formatter = NSDateFormatter().apply {
        dateFormat = patternDate
        locale = NSLocale.currentLocale
    }
    return formatter
        .dateFromString(date)
        // extensions functions provided by kotlinx.datetime
        ?.toKotlinInstant()
        ?.toLocalDateTime(TimeZone.currentSystemDefault())
        ?.date
        ?: throw IllegalStateException("Failed to convert String $date to LocalDateTime")
}