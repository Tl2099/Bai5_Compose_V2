package tl209.bai5_compose_figma_v2.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
    var expandedTopics by remember { mutableStateOf(setOf<String>()) } // Lưu trữ các topic đã mở rộng
    var isDoneEnabled by remember { mutableStateOf(false) } // Trạng thái nút Done

//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .horizontalScroll(rememberScrollState()) // Kéo ngang
//    ) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()) // Cho phép cuộn ngang
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .padding(12.dp)
                    .width(500.dp), // Đặt chiều rộng lớn hơn màn hình để có thể cuộn
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(topics) { (title, icon) ->
                    TopicCard(
                        title = title,
                        icon = icon,
                        isSelected = selectedTopics[title] == true,
                        onClick = {
                            selectedTopics[title] = !(selectedTopics[title] ?: false)
                            expandedTopics = if (selectedTopics[title] == true) {
                                expandedTopics + title
                            } else {
                                expandedTopics - title
                            }
                            isDoneEnabled = expandedTopics.isNotEmpty()
                        }
                    )
                }
            }
        }

        Button(
            onClick = {},
            enabled = isDoneEnabled,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isDoneEnabled) Color(0xFF362F30) else Color(0xFFC6C8D2),
                contentColor = if (isDoneEnabled) Color(0xFFFAEEEF) else Color(0xFF868991)
            )
        ) {
            Text(text = "Done", fontWeight = FontWeight.Bold)
        }

        if (expandedTopics.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                items(expandedTopics.toList()) { topic ->
                    ContentCard(
                        title = "New Compose for $topic",
                        description = "In this codelab, you can learn how Compose works for $topic, what specific composables are available, and more!",
                        tags = listOf(topic, "Compose", "Performance")
                    )
                }
            }
        }
    }
}