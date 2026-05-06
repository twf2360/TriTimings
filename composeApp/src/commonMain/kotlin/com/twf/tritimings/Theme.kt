package com.twf.tritimings

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val ThemePrimary = Color(0xFF2D5A27)
val ThemeOnPrimary = Color(0xFFFFFFFF)
val ThemePrimaryContainer = Color(0xFFEEF9EA)
val ThemeOnPrimaryContainer = Color(0xFF002204)

val ThemeSecondary = Color(0xFFE07A5F)
val ThemeOnSecondary = Color(0xFFFFFFFF)
val ThemeSecondaryContainer = Color(0xFFFFDBD1)
val ThemeOnSecondaryContainer = Color(0xFF3B0900)

val ThemeTertiary = Color(0xFFF2CC8F)
val ThemeOnTertiary = Color(0xFF452B00)
val ThemeTertiaryContainer = Color(0xFFFFDDB1)
val ThemeOnTertiaryContainer = Color(0xFF2B1700)

val ThemeSurface = Color(0xFFFCF9F2)
val ThemeOnSurface = Color(0xFF1C1C17)
val ThemeSurfaceVariant = Color(0xFFE5E3D9)
val ThemeOnSurfaceVariant = Color(0xFF47473F)

val ThemeLightColorScheme = lightColorScheme(
    primary = ThemePrimary,
    onPrimary = ThemeOnPrimary,
    primaryContainer = ThemePrimaryContainer,
    onPrimaryContainer = ThemeOnPrimaryContainer,
    secondary = ThemeSecondary,
    onSecondary = ThemeOnSecondary,
    secondaryContainer = ThemeSecondaryContainer,
    onSecondaryContainer = ThemeOnSecondaryContainer,
    tertiary = ThemeTertiary,
    onTertiary = ThemeOnTertiary,
    tertiaryContainer = ThemeTertiaryContainer,
    onTertiaryContainer = ThemeOnTertiaryContainer,
    surface = ThemeSurface,
    onSurface = ThemeOnSurface,
    surfaceVariant = ThemeSurfaceVariant,
    onSurfaceVariant = ThemeOnSurfaceVariant,
    background = ThemeSurface,
    onBackground = ThemeOnSurface
)

val ThemeTypography = Typography(
    headlineLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = (-0.5).sp
    ),
    headlineMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.SemiBold,
        fontSize = 28.sp,
        lineHeight = 36.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 28.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)

@Composable
fun TriTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme =ThemeLightColorScheme,
        typography = ThemeTypography,
        content = content
    )
}
