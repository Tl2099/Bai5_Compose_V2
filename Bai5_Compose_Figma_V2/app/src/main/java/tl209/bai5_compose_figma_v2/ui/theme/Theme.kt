package tl209.bai5_compose_figma_v2.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = Color.Transparent, //Dat thanh trong suot de khong ghi de gradient
    surface = Color.Transparent,

            onPrimary = DarkTextColor, // 🛑 Màu chữ trong Dark Mode
    onSecondary = DarkTextColor,
    onTertiary = DarkTextColor,
    onBackground = DarkTextColor,
    onSurface = DarkTextColor // 🛑 Áp dụng màu chữ cho toàn bộ Dark Mode
    

)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = Color.Transparent,
    surface = Color.Transparent,

    onPrimary = LightTextColor, // 🛑 Màu chữ trong Light Mode
    onSecondary = LightTextColor,
    onTertiary = LightTextColor,
    onBackground = LightTextColor,
    onSurface = LightTextColor // 🛑 Áp dụng màu chữ cho toàn bộ Light Mode



    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)
@Composable
fun Bai5_Compose_Figma_V2Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false, //Tat de tranh mau ngau nhien tu Android 12+
    content: @Composable () -> Unit
) {
    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}