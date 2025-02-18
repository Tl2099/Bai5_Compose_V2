package tl209.bai5_compose_figma_v2.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import tl209.bai5_compose_figma_v2.R
import tl209.bai5_compose_figma_v2.ui.theme.IconDarkMode
import tl209.bai5_compose_figma_v2.ui.theme.IconLightMode

@Composable
fun TopicCard(title: String, icon: Int, isSelected: Boolean, onClick: () -> Unit) {
    val isDarkMode = isSystemInDarkTheme()

    //val cardBackground = if (isDarkMode) DarkCardBackground else MaterialTheme.colorScheme.surface
    val cardBackground = if (isDarkMode) Color.Black else Color.White
    val textColor = MaterialTheme.colorScheme.onSurface
    val iconColor = if (isDarkMode) IconDarkMode else IconLightMode
    //val textColor = if (isDarkMode) DarkPink else MaterialTheme.colorScheme.onSurface
    val checkBackground = if (isDarkMode) Color(0xFFFFA9FE) else Color(0xFFFFD6FA)
    val checkColor = if (isDarkMode) Color(0xFF560A5D) else Color(0xFF4D444C)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = cardBackground),
        //elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = title,
                    tint = iconColor,
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    color = textColor
                )
            }
            Box(
                modifier = Modifier
                    .size(28.dp)
                    .background(
                        color = if (isSelected) checkBackground else Color.Transparent,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                IconButton(
                    onClick = onClick,
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        painter = painterResource(id = if (isSelected) R.drawable.ic_checked else R.drawable.ic_add),
                        contentDescription = "Select $title",
                        tint = if (isSelected) checkColor else textColor,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

        }

    }
}