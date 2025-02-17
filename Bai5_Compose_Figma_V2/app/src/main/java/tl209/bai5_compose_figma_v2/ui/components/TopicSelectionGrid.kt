package tl209.bai5_compose_figma_v2.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import tl209.bai5_compose_figma_v2.R

@Composable
fun TopicSelectionGrid() {
    val topics = listOf(
        "Accessibility" to R.drawable.accessibility1,
        "Android Auto" to R.drawable.android_tv1,
        "Android TV" to R.drawable.android_tv1,
        "Architecture" to R.drawable.architecture1,
        "Android Studio" to R.drawable.android_studio1,
        "Compose" to R.drawable.compose1
    )
    val selectedTopics = remember { mutableStateMapOf<String, Boolean>() }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()) // Kéo ngang
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(16.dp)
                .width(600.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(topics) { (title, icon) ->
                TopicCard(
                    title =title,
                    icon = icon,
                    isSelected = selectedTopics[title] == true,
                    onClick = {
                        selectedTopics[title] = !(selectedTopics[title] ?: false)
                    }
                )
            }
        }
    }
}