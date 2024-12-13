package com.savvasdalkitsis.uhuruphotos.foundation.theme.api.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.savvasdalkitsis.uhuruphotos.foundation.strings.api.R.string
import com.savvasdalkitsis.uhuruphotos.foundation.theme.api.themes.ThemeContrast.HIGH
import com.savvasdalkitsis.uhuruphotos.foundation.theme.api.themes.ThemeContrast.MEDIUM
import com.savvasdalkitsis.uhuruphotos.foundation.theme.api.themes.ThemeContrast.NORMAL
import com.savvasdalkitsis.uhuruphotos.foundation.theme.api.themes.ThemeMode.DARK_MODE
import com.savvasdalkitsis.uhuruphotos.foundation.theme.api.themes.ThemeMode.LIGHT_MODE

data object GreenTheme : StaticTheme() {

    override val label = string.green

    override val lightScheme = lightColorScheme(
        primary = Color(0xFF4C662B),
        onPrimary = Color(0xFFFFFFFF),
        primaryContainer = Color(0xFFCDEDA3),
        onPrimaryContainer = Color(0xFF102000),
        secondary = Color(0xFF586249),
        onSecondary = Color(0xFFFFFFFF),
        secondaryContainer = Color(0xFFDCE7C8),
        onSecondaryContainer = Color(0xFF151E0B),
        tertiary = Color(0xFF386663),
        onTertiary = Color(0xFFFFFFFF),
        tertiaryContainer = Color(0xFFBCECE7),
        onTertiaryContainer = Color(0xFF00201E),
        error = Color(0xFFBA1A1A),
        onError = Color(0xFFFFFFFF),
        errorContainer = Color(0xFFFFDAD6),
        onErrorContainer = Color(0xFF410002),
        background = Color(0xFFF9FAEF),
        onBackground = Color(0xFF1A1C16),
        surface = Color(0xFFF9FAEF),
        onSurface = Color(0xFF1A1C16),
        surfaceVariant = Color(0xFFE1E4D5),
        onSurfaceVariant = Color(0xFF44483D),
        outline = Color(0xFF75796C),
        outlineVariant = Color(0xFFC5C8BA),
        scrim = Color(0xFF000000),
        inverseSurface = Color(0xFF2F312A),
        inverseOnSurface = Color(0xFFF1F2E6),
        inversePrimary = Color(0xFFB1D18A),
        surfaceDim = Color(0xFFDADBD0),
        surfaceBright = Color(0xFFF9FAEF),
        surfaceContainerLowest = Color(0xFFFFFFFF),
        surfaceContainerLow = Color(0xFFF3F4E9),
        surfaceContainer = Color(0xFFEEEFE3),
        surfaceContainerHigh = Color(0xFFE8E9DE),
        surfaceContainerHighest = Color(0xFFE2E3D8),
    )

    override val darkScheme = darkColorScheme(
        primary = Color(0xFFB1D18A),
        onPrimary = Color(0xFF1F3701),
        primaryContainer = Color(0xFF354E16),
        onPrimaryContainer = Color(0xFFCDEDA3),
        secondary = Color(0xFFBFCBAD),
        onSecondary = Color(0xFF2A331E),
        secondaryContainer = Color(0xFF404A33),
        onSecondaryContainer = Color(0xFFDCE7C8),
        tertiary = Color(0xFFA0D0CB),
        onTertiary = Color(0xFF003735),
        tertiaryContainer = Color(0xFF1F4E4B),
        onTertiaryContainer = Color(0xFFBCECE7),
        error = Color(0xFFFFB4AB),
        onError = Color(0xFF690005),
        errorContainer = Color(0xFF93000A),
        onErrorContainer = Color(0xFFFFDAD6),
        background = Color(0xFF12140E),
        onBackground = Color(0xFFE2E3D8),
        surface = Color(0xFF12140E),
        onSurface = Color(0xFFE2E3D8),
        surfaceVariant = Color(0xFF44483D),
        onSurfaceVariant = Color(0xFFC5C8BA),
        outline = Color(0xFF8F9285),
        outlineVariant = Color(0xFF44483D),
        scrim = Color(0xFF000000),
        inverseSurface = Color(0xFFE2E3D8),
        inverseOnSurface = Color(0xFF2F312A),
        inversePrimary = Color(0xFF4C662B),
        surfaceDim = Color(0xFF12140E),
        surfaceBright = Color(0xFF383A32),
        surfaceContainerLowest = Color(0xFF0C0F09),
        surfaceContainerLow = Color(0xFF1A1C16),
        surfaceContainer = Color(0xFF1E201A),
        surfaceContainerHigh = Color(0xFF282B24),
        surfaceContainerHighest = Color(0xFF33362E),
    )

    override val mediumContrastLightColorScheme = lightColorScheme(
        primary = Color(0xFF314A12),
        onPrimary = Color(0xFFFFFFFF),
        primaryContainer = Color(0xFF617D3F),
        onPrimaryContainer = Color(0xFFFFFFFF),
        secondary = Color(0xFF3C462F),
        onSecondary = Color(0xFFFFFFFF),
        secondaryContainer = Color(0xFF6E785E),
        onSecondaryContainer = Color(0xFFFFFFFF),
        tertiary = Color(0xFF1A4A47),
        onTertiary = Color(0xFFFFFFFF),
        tertiaryContainer = Color(0xFF4F7D79),
        onTertiaryContainer = Color(0xFFFFFFFF),
        error = Color(0xFF8C0009),
        onError = Color(0xFFFFFFFF),
        errorContainer = Color(0xFFDA342E),
        onErrorContainer = Color(0xFFFFFFFF),
        background = Color(0xFFF9FAEF),
        onBackground = Color(0xFF1A1C16),
        surface = Color(0xFFF9FAEF),
        onSurface = Color(0xFF1A1C16),
        surfaceVariant = Color(0xFFE1E4D5),
        onSurfaceVariant = Color(0xFF404439),
        outline = Color(0xFF5D6155),
        outlineVariant = Color(0xFF787C70),
        scrim = Color(0xFF000000),
        inverseSurface = Color(0xFF2F312A),
        inverseOnSurface = Color(0xFFF1F2E6),
        inversePrimary = Color(0xFFB1D18A),
        surfaceDim = Color(0xFFDADBD0),
        surfaceBright = Color(0xFFF9FAEF),
        surfaceContainerLowest = Color(0xFFFFFFFF),
        surfaceContainerLow = Color(0xFFF3F4E9),
        surfaceContainer = Color(0xFFEEEFE3),
        surfaceContainerHigh = Color(0xFFE8E9DE),
        surfaceContainerHighest = Color(0xFFE2E3D8),
    )

    override val highContrastLightColorScheme = lightColorScheme(
        primary = Color(0xFF142700),
        onPrimary = Color(0xFFFFFFFF),
        primaryContainer = Color(0xFF314A12),
        onPrimaryContainer = Color(0xFFFFFFFF),
        secondary = Color(0xFF1C2511),
        onSecondary = Color(0xFFFFFFFF),
        secondaryContainer = Color(0xFF3C462F),
        onSecondaryContainer = Color(0xFFFFFFFF),
        tertiary = Color(0xFF002725),
        onTertiary = Color(0xFFFFFFFF),
        tertiaryContainer = Color(0xFF1A4A47),
        onTertiaryContainer = Color(0xFFFFFFFF),
        error = Color(0xFF4E0002),
        onError = Color(0xFFFFFFFF),
        errorContainer = Color(0xFF8C0009),
        onErrorContainer = Color(0xFFFFFFFF),
        background = Color(0xFFF9FAEF),
        onBackground = Color(0xFF1A1C16),
        surface = Color(0xFFF9FAEF),
        onSurface = Color(0xFF000000),
        surfaceVariant = Color(0xFFE1E4D5),
        onSurfaceVariant = Color(0xFF21251C),
        outline = Color(0xFF404439),
        outlineVariant = Color(0xFF404439),
        scrim = Color(0xFF000000),
        inverseSurface = Color(0xFF2F312A),
        inverseOnSurface = Color(0xFFFFFFFF),
        inversePrimary = Color(0xFFD6F7AC),
        surfaceDim = Color(0xFFDADBD0),
        surfaceBright = Color(0xFFF9FAEF),
        surfaceContainerLowest = Color(0xFFFFFFFF),
        surfaceContainerLow = Color(0xFFF3F4E9),
        surfaceContainer = Color(0xFFEEEFE3),
        surfaceContainerHigh = Color(0xFFE8E9DE),
        surfaceContainerHighest = Color(0xFFE2E3D8),
    )

    override val mediumContrastDarkColorScheme = darkColorScheme(
        primary = Color(0xFFB5D58E),
        onPrimary = Color(0xFF0C1A00),
        primaryContainer = Color(0xFF7D9A59),
        onPrimaryContainer = Color(0xFF000000),
        secondary = Color(0xFFC4CFB1),
        onSecondary = Color(0xFF101907),
        secondaryContainer = Color(0xFF8A9579),
        onSecondaryContainer = Color(0xFF000000),
        tertiary = Color(0xFFA4D4D0),
        onTertiary = Color(0xFF001A19),
        tertiaryContainer = Color(0xFF6B9995),
        onTertiaryContainer = Color(0xFF000000),
        error = Color(0xFFFFBAB1),
        onError = Color(0xFF370001),
        errorContainer = Color(0xFFFF5449),
        onErrorContainer = Color(0xFF000000),
        background = Color(0xFF12140E),
        onBackground = Color(0xFFE2E3D8),
        surface = Color(0xFF12140E),
        onSurface = Color(0xFFFBFCF0),
        surfaceVariant = Color(0xFF44483D),
        onSurfaceVariant = Color(0xFFC9CCBE),
        outline = Color(0xFFA1A497),
        outlineVariant = Color(0xFF818578),
        scrim = Color(0xFF000000),
        inverseSurface = Color(0xFFE2E3D8),
        inverseOnSurface = Color(0xFF282B24),
        inversePrimary = Color(0xFF364F17),
        surfaceDim = Color(0xFF12140E),
        surfaceBright = Color(0xFF383A32),
        surfaceContainerLowest = Color(0xFF0C0F09),
        surfaceContainerLow = Color(0xFF1A1C16),
        surfaceContainer = Color(0xFF1E201A),
        surfaceContainerHigh = Color(0xFF282B24),
        surfaceContainerHighest = Color(0xFF33362E),
    )

    override val highContrastDarkColorScheme = darkColorScheme(
        primary = Color(0xFFF4FFDF),
        onPrimary = Color(0xFF000000),
        primaryContainer = Color(0xFFB5D58E),
        onPrimaryContainer = Color(0xFF000000),
        secondary = Color(0xFFF4FFDF),
        onSecondary = Color(0xFF000000),
        secondaryContainer = Color(0xFFC4CFB1),
        onSecondaryContainer = Color(0xFF000000),
        tertiary = Color(0xFFEAFFFC),
        onTertiary = Color(0xFF000000),
        tertiaryContainer = Color(0xFFA4D4D0),
        onTertiaryContainer = Color(0xFF000000),
        error = Color(0xFFFFF9F9),
        onError = Color(0xFF000000),
        errorContainer = Color(0xFFFFBAB1),
        onErrorContainer = Color(0xFF000000),
        background = Color(0xFF12140E),
        onBackground = Color(0xFFE2E3D8),
        surface = Color(0xFF12140E),
        onSurface = Color(0xFFFFFFFF),
        surfaceVariant = Color(0xFF44483D),
        onSurfaceVariant = Color(0xFFF9FCED),
        outline = Color(0xFFC9CCBE),
        outlineVariant = Color(0xFFC9CCBE),
        scrim = Color(0xFF000000),
        inverseSurface = Color(0xFFE2E3D8),
        inverseOnSurface = Color(0xFF000000),
        inversePrimary = Color(0xFF1A3000),
        surfaceDim = Color(0xFF12140E),
        surfaceBright = Color(0xFF383A32),
        surfaceContainerLowest = Color(0xFF0C0F09),
        surfaceContainerLow = Color(0xFF1A1C16),
        surfaceContainer = Color(0xFF1E201A),
        surfaceContainerHigh = Color(0xFF282B24),
        surfaceContainerHighest = Color(0xFF33362E),
    )

}

@Preview
@Composable
private fun PreviewThemeNormal() {
    PreviewTheme(GreenTheme, LIGHT_MODE, NORMAL)
}

@Preview
@Composable
private fun PreviewThemeMedium() {
    PreviewTheme(GreenTheme, LIGHT_MODE, MEDIUM)
}

@Preview
@Composable
private fun PreviewThemeHome() {
    PreviewTheme(GreenTheme, LIGHT_MODE, HIGH)
}

@Preview
@Composable
private fun PreviewThemeDark() {
    PreviewTheme(GreenTheme, DARK_MODE, NORMAL)
}

@Preview
@Composable
private fun PreviewThemeDarkMedium() {
    PreviewTheme(GreenTheme, DARK_MODE, MEDIUM)
}

@Preview
@Composable
private fun PreviewThemeDarkHome() {
    PreviewTheme(GreenTheme, DARK_MODE, HIGH)
}