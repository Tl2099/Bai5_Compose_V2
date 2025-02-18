package tl209.bai5_compose_figma_v2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tl209.bai5_compose_figma_v2.ui.components.ContentCard
import tl209.bai5_compose_figma_v2.ui.components.GradientBackground
import tl209.bai5_compose_figma_v2.ui.components.TopicSelectionGrid
import tl209.bai5_compose_figma_v2.ui.components.UserIcon
import tl209.bai5_compose_figma_v2.ui.theme.Bai5_Compose_Figma_V2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Bai5_Compose_Figma_V2Theme {
                MainScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewContentCard() {
    ContentCard(
        title = "New Compose for Wear OS codelab",
        description = "In this codelab, you can learn how Wear OS can work with Compose, what Wear OS specific composables are available, and more!",
        tags = listOf("Compose", "Events", "Performance","Compose", "Events", "Performance", "Compose", "Events", "Performance")
    )
}
@Preview(showBackground = true)
@Composable
fun MainScreen() {
    GradientBackground {
        Scaffold(
            bottomBar = { BottomNavigationBar() }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                //.background(MaterialTheme.colorScheme.background)
            ) {
                TopHeader()
                ContentUnderHeader()
                UserAvatarRow()
                TopicSelectionGrid()
                DoneButton()
                ContentUnderDoneBt()
                TopicsZone()
            }

        }
    }
}

@Composable
fun ContentUnderDoneBt() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Browse topics",
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun TopicsZone() {

}

@Composable
fun ContentUnderHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "What are you interested in?",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "Updates from interests you follow will appear here. Follow some things to get started.",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
//FCFCFC

//201A1B
@Composable
fun BottomNavigationBar() {
    var selectedItem by remember { mutableStateOf("For you") } // Lưu trạng thái button đang chọn
    val isDarkMode = isSystemInDarkTheme()

    val navBackgroundColor = if (isDarkMode) Color(0xFF201A1B) else Color(0xFFFCFCFC)

    NavigationBar(
        modifier = Modifier
            .fillMaxWidth(),
        containerColor = navBackgroundColor // Màu nền chung của Bottom Bar
    ) {
        val items = listOf(
            "For you" to R.drawable.nav_icon1,
            "Episodes" to R.drawable.nav_icon2,
            "Saved" to R.drawable.nav_icon3,
            "Interests" to R.drawable.nav_icon4
        )

        items.forEach { (title, iconRes) ->
            val isSelected = title == selectedItem

            // Màu nền khi chọn
            val backgroundColor = if (isSelected) {
                if (isDarkMode) Color(0xFFFFA9FE) else Color(0xFFFFD6FA)
            } else {
                Color.Transparent
            }

            // Màu icon
            val iconColor = if (isSelected) {
                if (isDarkMode) Color(0xFF560A5D) else Color(0xFF36003C)
            } else {
                if (isDarkMode) Color(0xFFD0BCFF) else Color.Black // Màu mặc định
            }

            // Màu chữ
            val textColor = if (isSelected) {
                if (isDarkMode) Color(0xFFFFD6FA) else Color(0xFF36003C)
            } else {
                if (isDarkMode) Color(0xFFD0BCFF) else Color.Black // Màu mặc định
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .clickable { selectedItem = title }, // Click vào sẽ thay đổi trạng thái
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .width(70.dp)
                        .height(40.dp)
                        .background(
                            color = backgroundColor,
                            shape = RoundedCornerShape(20.dp) // Tạo vùng chọn tròn bao quanh icon
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = iconRes),
                        contentDescription = title,
                        tint = iconColor,
                        modifier = Modifier.size(28.dp)
                    )
                }
                Spacer(modifier = Modifier.height(2.dp)) // Giữ khoảng cách với chữ
                Text(
                    title,
                    color = textColor,
                    fontSize = MaterialTheme.typography.labelLarge.fontSize
                )
            }
        }
    }
}


@Composable
fun DoneButton() {
    var isClicked by remember { mutableStateOf(false) }

    val isDarkMode = isSystemInDarkTheme()

    val buttonColor = when {
        isClicked && isDarkMode -> Color(0xFFFFA9FE)
        isClicked -> Color(0xFF362F30)
        isDarkMode -> Color(0xFF4A3447)
        else -> Color(0xFFC6C8D2)
    }
    val textColor = when {
        isClicked && isDarkMode -> Color(0xFF560A5D)
        isClicked -> Color(0xFFFAEEEF)
        isDarkMode -> Color(0xFF867581)
        else -> Color(0xFF868991)
    }

    Button(
        onClick = { isClicked = !isClicked },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
    ) {
        Text(
            text = "Done",
            fontWeight = FontWeight.Bold,
            color = textColor
        )
    }
}


@Composable
fun UserAvatarRow() {
    val isDarkMode = isSystemInDarkTheme()

    val avatarBackgroundColor = if (isDarkMode) Color(0xFF352830) else Color(0xFFEDDEE8)
    val userIconColor = if (isDarkMode) Color(0xFFFFA9FE) else Color(0xFFA23F16)
    val addIconColor = if (isDarkMode) Color(0xFFECDFE0) else Color(0xFF201A1B)
    val addIconBackground = if (isDarkMode) Color(0xFF201A1B) else Color(0xFFFCFCFC)

    val users = listOf(
        "Fernando" to R.drawable.ic_user,
        "Alex" to R.drawable.ic_user,
        "Sam" to R.drawable.ic_user, // hinh nguoi: FFA9FE, bg: CFC4C5, dau cong: ECDFE0, bgIcon: 201A1B
        "Lee" to R.drawable.ic_user,
        "John" to R.drawable.ic_user, // Thêm nhiều người để có thể kéo ngang
        "Emma" to R.drawable.ic_user
    )
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp),
        horizontalArrangement = Arrangement.spacedBy(25.dp)
    ) {
        itemsIndexed(users) { index, (name, avatar) ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(start = if (index == 0) 50.dp else 0.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.size(60.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .background(avatarBackgroundColor),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = avatar),
                            contentDescription = name,
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape),
                            colorFilter = ColorFilter.tint(userIconColor)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .size(25.dp)
                            .align(Alignment.BottomEnd)
                            .background(addIconBackground, shape = CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_add),
                            contentDescription = "Add",
                            tint = addIconColor,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                }


                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = name,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
//Hinh nguoi mau: FFB59B, background: CFC4C5u, dau cong:ECDFE0, background dau cong: 201A1B
}

@Composable
fun TopHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search Icon",
            modifier = Modifier.size(30.dp)
        )
        Text(
            text = "Now in Android",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_account),
            contentDescription = "Profile Icon",
            modifier = Modifier.size(30.dp)
        )
    }
    //Icon và Chu: 36003C
    //Vien: FFD6FA

    //icon: 560A5D
    //Vien: FFA9FE
    //Chu: FFD6FA

//@Composable
//fun TopicSelectionGrid() {
//    val topics = listOf(
//        "Accessibility" to R.drawable.accessibility1,
//        "Android Auto" to R.drawable.android_tv1,
//        "Android TV" to R.drawable.android_tv1,
//        "Architecture" to R.drawable.architecture1,
//        "Android Studio" to R.drawable.android_studio1,
//        "Compose" to R.drawable.compose1
//    )
//    val selectedTopics = remember { mutableStateMapOf<String, Boolean>() }
//
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .horizontalScroll(rememberScrollState()) // Kéo ngang
//    ) {
//        LazyVerticalGrid(
////            columns = GridCells.Fixed(2),
////            modifier = Modifier
////                .padding(16.dp)
////                .width(500.dp), // Đặt chiều rộng lớn hơn màn hình để có thể cuộn
////            horizontalArrangement = Arrangement.spacedBy(8.dp),
////            verticalArrangement = Arrangement.spacedBy(8.dp)
//            columns = GridCells.Fixed(2),
//            modifier = Modifier
//                .padding(16.dp)
//                .width(600.dp),
//            horizontalArrangement = Arrangement.spacedBy(8.dp),
//            verticalArrangement = Arrangement.spacedBy(8.dp)
//        ) {
//            items(topics) { (title, icon) ->
//                Card(
//                    modifier = Modifier
//                        .width(150.dp)
//                        .padding(4.dp),
//                    colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface),
//                    elevation = CardDefaults.cardElevation(4.dp)
//                ) {
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(4.dp),
//                        verticalAlignment = Alignment.CenterVertically,
//                        horizontalArrangement = Arrangement.SpaceBetween
//                    ) {
//                        Row(
//                            verticalAlignment = Alignment.CenterVertically
//                        ) {
//                            Spacer(modifier = Modifier.width(8.dp))
//                            Icon(
//                                painter = painterResource(id = icon),
//                                contentDescription = title,
//                                modifier = Modifier
//                                    .size(32.dp)
//                                    .padding(end = 5.dp)
//                            )
//                            Spacer(modifier = Modifier.width(8.dp))
//                            Text(
//                                text = title,
//                                style = MaterialTheme.typography.bodyLarge
//                            )
//                        }
//
//                        // Dấu + hoặc ✓
//                        IconButton(
//                            onClick = {
//                                selectedTopics[title] = !(selectedTopics[title] ?: false)
//                            }
//                        ) {
//                            Icon(
//                                painter = painterResource(
//                                    id = if (selectedTopics[title] == true)
//                                        R.drawable.ic_checked // Hình dấu ✓
//                                    else
//                                        R.drawable.ic_add // Hình dấu +
//                                ),
//                                contentDescription = "Select $title",
//                                modifier = Modifier.size(24.dp),
//                                tint = if (selectedTopics[title] == true) Color(0xFFFF80AB) else Color.Gray
//                            )
//                        }
//                    }
//                }
//            }
//        }
//    }
//}


}
