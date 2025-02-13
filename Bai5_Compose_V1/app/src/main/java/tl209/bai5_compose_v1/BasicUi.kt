package tl209.bai5_compose_v1

import android.content.pm.ModuleInfo
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import tl209.bai5_compose_v1.ui.theme.Black

@Composable
fun BasicUi() {
    //State luu tru giá trị cua cac truong nhap lieu
    var name by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("Nam") }

    //State luu tru gia tri ngay, thang, nam sinh
    var selectedDay by remember { mutableStateOf("1") }
    var selectedMonth by remember { mutableStateOf("1") }
    var selectedYear by remember { mutableStateOf("2000") }

    //Danh sach ngay, thang, nam co the chon
    val days = (1..31).map { it.toString() }
    val months = (1..12).map { it.toString() }
    val years = (1950..2025).map { it.toString() }

    //State lưu tru trang thai checkbox so thich
    var sportChecked by remember { mutableStateOf(false) }
    var readingChecked by remember { mutableStateOf(false) }
    var gamingChecked by remember { mutableStateOf(false) }

    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize() //Lap day toan bo man hinh
                .padding(16.dp), //Tao khoang cach vien ngoai
            horizontalAlignment = Alignment.CenterHorizontally //Can chinh theo chieu doc
        ) {
            val uiColor = if (isSystemInDarkTheme()) Color.White else Black
            Spacer(modifier = Modifier.height(50.dp))
            //Tieu de cua form
            Text(
                text = "Nhập Thông Tin Người Dùng",
                style = MaterialTheme.typography.headlineMedium, // Kieu chu lon
                fontWeight = FontWeight.Bold, //Chu in dam
                modifier = Modifier.padding(bottom = 16.dp) //Khoang cach duoi tieu de
            )

            //Hop chua cac truong nhap lieu, co nen mau khac va bo goc
            Box(
                modifier = Modifier
                    .fillMaxWidth() //Chieu rong day du
                    .background(
                        Color(0xFFF0F0F0),
                        shape = RoundedCornerShape(16.dp)
                    )  //Nen xam nhat
                    .padding(16.dp), //Khoang cach ben trong hop

            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    //Anh dai dien bo tron goc
                    Image(
                        painter = painterResource(id = R.drawable.ic_dog), //Hinh anh dai dien
                        contentDescription = "Avatar", //Mo ta hinh anh
                        modifier = Modifier
                            .size(100.dp) //Kich thuoc 100dp
                            .clip(CircleShape) //Bo tron hinh anh
                            .border(2.dp, Color.Gray, CircleShape) //Vien anh mau xam
                    )
                    Spacer(modifier = Modifier.height(16.dp)) //Khoang cach giua hinh anh va o nhap ten

                    //O nhap ho ten
                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Họ và Tên") },
                        modifier = Modifier.fillMaxWidth() //O nhap day du chieu rong
                    )
                    Spacer(modifier = Modifier.height(16.dp)) //Khoang cach giua cac thanh phan

                    //Chon gioi tinh (RadioButton)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween // Đẩy nội dung về hai phía
                    ) {
                        Text(
                            "Giới tính:",
                            modifier = Modifier.align(Alignment.CenterVertically)
                        ) // Căn sát lề trái

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = selectedGender == "Nam",
                                onClick = { selectedGender = "Nam" }
                            )
                            Text("Nam")
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = selectedGender == "Nữ",
                                onClick = { selectedGender = "Nữ" }
                            )
                            Text("Nữ")
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    //Hop checkbox chon so thich
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text("Sở thích:")
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("Thể thao")
                            Checkbox(
                                checked = sportChecked,
                                onCheckedChange = { sportChecked = it }
                            )
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("Đọc sách")
                            Checkbox(
                                checked = readingChecked,
                                onCheckedChange = { readingChecked = it }
                            )
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("Chơi game")
                            Checkbox(
                                checked = gamingChecked,
                                onCheckedChange = { gamingChecked = it }
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    //Chon ngay sinh bang DropdownMenu
                    Column(horizontalAlignment = Alignment.Start) {
                        Text("Ngày tháng năm sinh: ")
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly //Phan tu dau tien sat mep trai
                            //Phan tu cuoi cung sat mep phai
                            //Cac phan tu o giua co khoang cach deu nhau
                        ) {
                            DropdownMenuField("Ngày", selectedDay, days) { selectedDay = it }
                            DropdownMenuField("Tháng", selectedMonth, months) { selectedMonth = it }
                            DropdownMenuField("Năm", selectedYear, years) { selectedYear = it }

                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    //O nhap dia chi
                    OutlinedTextField( //O nhap lieu co vien == EditText trong XML cu, ko vien thi la TextField
                        value = address, //Luu trang thai van ban dang nhap: address la mot bien luu tru noi dung trong o nhap lieu
                        onValueChange = {
                            address = it
                        }, //Khi nguoi dung nhap or thay doi noi dung, gia tri moi se duoc cap nhat vao bien Address, it la gia tri moi duoc nhap
                        //Note: De OutlinedTextField hoat dong dung can mot bien trang thai remember
                        //var address by remember { mutableStateOf("") }
                        label = { Text("Địa chỉ") }, //Hien thi nhan tren o nhap lieu, khi o trong nhan se nam o trong o nhap, khi nhap thi nhan se duoc di chuyen len tren nhu la mot goi y
                        modifier = Modifier.fillMaxWidth() // Chiem toan bo chieu rong cua man hinh
                    )
                    Spacer(modifier = Modifier.height(24.dp))

                    //Nut Submit
                    Button(
                        onClick = {},
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Xac nhan")
                    }
                }
            }
        }
    }
}

//List<String>, onValueChange: (String) -> Unit
@Composable
fun DropdownMenuField(
    label: String,
    selectedValue: String,
    options: List<String>,
    onValueChange: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }//Trang thai mo rong dropdown

    Box(
        modifier = Modifier
            .width(100.dp)//Dat kich thuoc co dinh cho dropdown
            .clickable { expanded = true } // Bat menu khi bam vao
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp)) //Vien bo goc
            .padding(8.dp) // Khoang cach ben trong
    ) {
        Text(text = "$label: $selectedValue", modifier = Modifier.align(Alignment.Center))
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            //Kiem tra neu expanded = true thi menu se hien thi
            //Khi nguoi dung cham ra ngoai menu, no se tu dong dong

            //Tao danh sach cac muc trong menu
            options.forEach { option -> //Duyet qua tung phan tu trong danh sach options
                DropdownMenuItem( //Tao mot muc chon trong menu
                    text = { Text(option) }, //Hien thi van ban cua tung muc
                    onClick = { //Khi nguoi dung chon mot muc goi onVaCha de cap nhat gia tri dong thoi dong menu
                        onValueChange(option) //Cap nhat gia tri duoc chon
                        expanded = false // Dong menu sau khi duoc chon
                    }
                )
            }
        }
    }
}
