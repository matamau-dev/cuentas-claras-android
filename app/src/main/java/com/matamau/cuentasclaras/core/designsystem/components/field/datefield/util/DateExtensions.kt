package com.matamau.cuentasclaras.core.designsystem.components.field.datefield.util

import java.time.Instant
import java.time.LocalDate
import java.time.ZoneOffset

fun LocalDate.toUtcMillis(): Long =
    atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli()

fun Long.toLocalDateUtc(): LocalDate =
    Instant.ofEpochMilli(this).atZone(ZoneOffset.UTC).toLocalDate()