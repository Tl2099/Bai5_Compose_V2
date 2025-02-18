package tl209.bai5_compose_figma_v2.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import tl209.bai5_compose_figma_v2.R

@Composable
fun ContentCard(title: String, description: String, tags: List<String>) {
    val isDarkMode = isSystemInDarkTheme()
    var isBookmarked by remember { mutableStateOf(false) }

    val cardBackground = if (isDarkMode) Color(0xFF201A1B) else Color(0xFFFCFCFC)
    val textColor = if (isDarkMode) Color(0xFFECDFE0) else Color(0xFF201A1B)
    val bookmarkBackground = if (isDarkMode) Color(0xFF4A3447) else Color(0xFFFFD6FA)
    val dotColor = if (isDarkMode) Color(0xFFFFA9FE) else Color(0xFF8B418F)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = cardBackground),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            // Hình ảnh tiêu đề
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_content),
                    contentDescription = "Topic Image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Column(modifier = Modifier.padding(15.dp)) {
                // Phần hiển thị tác giả
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .background(if (isDarkMode) Color(0xFF352830) else Color(0xFFF0E0E6), shape = CircleShape)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Author",
                        style = MaterialTheme.typography.labelSmall,
                        color = textColor
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Tiêu đề bài viết + Bookmark
                Box(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = textColor,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 50.dp)
                    )
                    // Biểu tượng lưu bài viết
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .size(40.dp)
                            .background(
                                color = if (isBookmarked) bookmarkBackground else Color.Transparent,
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        IconButton(
                            onClick = { isBookmarked = !isBookmarked },
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_bookmark),
                                contentDescription = "Bookmark",
                                tint = if (isDarkMode) Color(0xFFECDFE0) else MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Ngày tháng & nguồn
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(7.dp)
                            .background(dotColor, shape = CircleShape)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "January 1, 2021  developer.android.com",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Bold,
                        color = textColor
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Nội dung mô tả
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = textColor
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Danh sách tag chủ đề
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    LazyRow(
                        modifier = Modifier.weight(1f),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(tags) { tag ->
                            val isSelected = remember { mutableStateOf(false) }
                            val backgroundColor =
                                if (isSelected.value) (if (isDarkMode) Color(0xFFFFA9FE) else Color(0xFFFFD6FA))
                                else (if (isDarkMode) Color(0xFF352830) else Color(0xFFF0E0E6))

                            val textColor =
                                if (isSelected.value) (if (isDarkMode) Color(0xFF560A5D) else Color(0xFF36003C))
                                else (if (isDarkMode) Color(0xFFECDFE0) else Color(0xFF4D444C))

                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(50))
                                    .background(backgroundColor)
                                    .clickable { isSelected.value = !isSelected.value }
                                    .padding(horizontal = 12.dp, vertical = 6.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = tag,
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = if (isSelected.value) FontWeight.Bold else FontWeight.Normal,
                                    color = textColor
                                )
                            }
                        }
                    }
                    IconButton(
                        modifier = Modifier.size(32.dp),
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_more),
                            contentDescription = "More",
                            tint = textColor,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}
