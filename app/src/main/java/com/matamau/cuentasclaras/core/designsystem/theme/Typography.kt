package com.matamau.cuentasclaras.core.designsystem.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object AppTypography {
    val displayXxl = TextStyle(
        fontFamily = Montserrat,
        fontSize = 64.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 71.68.sp,
        letterSpacing = (-1.32).sp
    )
    val displayLg = TextStyle(
        fontFamily = Montserrat,
        fontSize = 50.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 56.sp,
        letterSpacing = (-0.6).sp
    )
    val displayMd = TextStyle(
        fontFamily = Montserrat,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 40.sp,
        letterSpacing = (-0.256).sp
    )
    val headingLg = TextStyle(
        fontFamily = Montserrat,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 31.92.sp
    )
    val headingMd = TextStyle(
        fontFamily = Montserrat,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 31.92.sp
    )
    val bodyLg = TextStyle(
        fontFamily = Montserrat,
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 27.9.sp
    )
    val bodyMd = TextStyle(
        fontFamily = Montserrat,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 24.8.sp
    )
    val caption = TextStyle(
        fontFamily = Montserrat,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 20.02.sp
    )
    val buttonMd = TextStyle(
        fontFamily = Montserrat,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 22.08.sp,
        letterSpacing = 0.2.sp
    )
    val microCap = TextStyle(
        fontFamily = Montserrat,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 12.sp,
        letterSpacing = 0.96.sp
    )
}