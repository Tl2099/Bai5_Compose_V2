package tl209.bai5_compose_figma_v2.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tl209.bai5_compose_figma_v2.R

@Preview(showBackground = true)
@Composable
fun UserIcon() {
    val isDarkMode = isSystemInDarkTheme()

    // Gradient dành cho thân người
    val gradientBrush = Brush.linearGradient(
        colors = if (isDarkMode) {
            listOf(Color(0xFFFFB59B), Color(0xFFFFA9FE)) // Dark Mode
        } else {
            listOf(Color(0xFFA23F16), Color(0xFF8B418F)) // Light Mode
        },
        start = Offset(100f, 0f), // Góc trên phải
        end = Offset(0f, 100f) // Góc dưới trái
    )

    Box(
        modifier = Modifier
            .size(64.dp) // Tổng kích thước icon
            .padding(4.dp), // Khoảng cách giữa viền và icon
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier.size(48.dp) // Kích thước vùng vẽ
        ) {
            val centerX = size.width / 2
            val centerY = size.height / 2

            // Vẽ đầu người (màu đen)
            drawCircle(
                color = Color.Black,
                radius = size.minDimension / 6,
                center = Offset(centerX, centerY - size.minDimension / 4)
            )

            // Vẽ thân người với gradient (dạng nửa oval)
            drawPath(
                path = androidx.compose.ui.graphics.Path().apply {
                    moveTo(centerX - size.width / 4, centerY) // Bắt đầu từ góc trái
                    lineTo(centerX + size.width / 4, centerY) // Đến góc phải
                    arcTo(
                        rect = Rect(
                            offset = Offset(centerX - size.width / 4, centerY),
                            size = Size(size.width / 2, size.height / 4)
                        ),
                        startAngleDegrees = 0f,
                        sweepAngleDegrees = 180f,
                        forceMoveTo = false
                    ) // Bo cong thành nửa oval
                    close()
                },
                brush = gradientBrush // Gradient cho thân người
            )
        }
    }
}










//@Composable
//fun UserIcon() {
//    val isDarkMode = isSystemInDarkTheme()
//
//    // Gradient dành cho hình người bên trong
//    val gradientBrush = Brush.linearGradient(
//        colors = if (isDarkMode) {
//            listOf(Color(0xFFFFB59B), Color(0xFFFFA9FE)) // Dark Mode
//        } else {
//            listOf(Color(0xFFA23F16), Color(0xFF8B418F)) // Light Mode
//        },
//        start = Offset(100f, 0f), // Góc trên phải
//        end = Offset(0f, 100f) // Góc dưới trái
//    )
//
//    // Màu viền xung quanh icon
//    val borderColor = if (isDarkMode) Color(0xFF201A1B) else Color(0xFFEDDEE8)
//
//    Box(
//        modifier = Modifier
//            .size(64.dp) // Tăng kích thước tổng thể để viền rõ hơn
//            .background(borderColor, shape = CircleShape) // Viền ngoài
//            .padding(4.dp), // Khoảng cách giữa viền và icon
//        contentAlignment = Alignment.Center
//    ) {
//        Canvas(
//            modifier = Modifier.size(48.dp) // Kích thước vùng gradient
//        ) {
//            drawCircle(
//                brush = gradientBrush, // Gradient áp dụng cho hình người
//                radius = size.minDimension / 2
//            )
//        }
//        Icon(
//            painter = painterResource(id = R.drawable.ic_user), // Sử dụng XML vector drawable
//            contentDescription = "User Icon",
//            tint = Color.Unspecified, // Để giữ gradient và không áp dụng màu cứng
//            modifier = Modifier.size(40.dp) // Đảm bảo vừa khung gradient
//        )
//    }
//}
