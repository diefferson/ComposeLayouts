package br.diefferson.composelayouts.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)
val Black2 = Color(0x03000000)
val Grey1 = Color(0x29FFFFFF)
val Grey2 = Color(0x52FFFFFF)
val Grey3 = Color(0x7AFFFFFF)
val Red1 =  Color(0xFFCC3C21)
val Red2 =  Color(0x52CC3C21)
val Blue1 = Color(0xFF214ECC)
val Blue2 = Color(0xFF0C1D4D)

val BackgroundGradient = Brush.linearGradient(
    colors = listOf(
        Blue2,
        Blue1,
    )
)