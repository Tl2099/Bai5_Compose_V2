package tl209.bai5_compose_figma_v2.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import tl209.bai5_compose_figma_v2.ui.theme.DarkGradientEnd
import tl209.bai5_compose_figma_v2.ui.theme.DarkGradientStart
import tl209.bai5_compose_figma_v2.ui.theme.LightGradientEnd
import tl209.bai5_compose_figma_v2.ui.theme.LightGradientStart

@Composable
fun GradientBackground(content: @Composable () -> Unit) {
    val gradientColors = if (isSystemInDarkTheme()){
        listOf(DarkGradientStart, DarkGradientEnd)
    }else{
        listOf(LightGradientStart, LightGradientEnd)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    gradientColors
                )
            )
    ){
        content()
    }
}