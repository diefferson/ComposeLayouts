package br.diefferson.composelayouts.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = White,
    onPrimary = Black,
    primaryContainer = White,
    onPrimaryContainer = Black,
    secondary = Grey1,
    onSecondary = White,
    secondaryContainer = Grey1,
    onSecondaryContainer = White,
    tertiary = Grey2,
    onTertiary = Black,
    tertiaryContainer = Grey2,
    onTertiaryContainer = Black,
    background = Black,
    onBackground = White,
    surface = Black,
    onSurface = White,
    surfaceVariant = Black,
    onSurfaceVariant = White,
    error = Red1,
    onError = White,
    errorContainer = Red2,
    onErrorContainer = Red1,
    outline = Grey1,
    outlineVariant = Grey3,
)

private val LightColorScheme = lightColorScheme(
    primary = White,
    onPrimary = Black,
    primaryContainer = White,
    onPrimaryContainer = Black,
    secondary = Grey1,
    onSecondary = White,
    secondaryContainer = Grey1,
    onSecondaryContainer = White,
    tertiary = Grey2,
    onTertiary = Black,
    tertiaryContainer = Grey2,
    onTertiaryContainer = Black,
    background = Blue2,
    onBackground = White,
    surface = Blue2,
    onSurface = White,
    surfaceVariant = Black2,
    onSurfaceVariant = White,
    error = Red1,
    onError = White,
    errorContainer = Red2,
    onErrorContainer = Red1,
    outline = Grey1,
    outlineVariant = Grey3,
)

@Composable
fun ComposeLayoutsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}