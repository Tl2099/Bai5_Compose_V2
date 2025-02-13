package tl209.bai5_compose_v1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tl209.bai5_compose_v1.ui.theme.Bai5_Compose_V1Theme
import tl209.bai5_compose_v1.ui.theme.CustomLoginTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Bai5_Compose_V1Theme {
                var showBasicUI by remember { mutableStateOf(false) }

                if (showBasicUI) {
                    BasicUi()
                } else {
                    LoginScreen(onLoginClick = { showBasicUI = true })
                }

            }
        }
    }
}

//@Composable
//fun LoginScreen(isDarkTheme: Boolean, onThemeToggle: () -> Unit){
//    //remember giúp lưu trang thai khi UI thay doi
//    var username by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//
//    val backgroundColor by animateColorAsState(targetValue = MaterialTheme.colorScheme.background)
//
//    Column (//Sap xep cac phan tu theo chieu doc
//        modifier = Modifier
//            .fillMaxSize() //Chiem toan bo man hinh
//            .background(backgroundColor) //Dat mau nen
//            .padding(16.dp), //Tao khoang cach le
//        verticalArrangement = Arrangement.Center, //Can giua cac phan tu theo chieu doc
//        horizontalAlignment = Alignment.CenterHorizontally // Can giua theo chieu ngang
//    ){
//        Image(
//            painter = if(isDarkTheme) painterResource(id = R.drawable.ic_sun)
//            else painterResource(id = R.drawable.ic_moon),
//            contentDescription = "Toggle Theme",
//            modifier = Modifier
//                .size(50.dp)
//                .clickable { onThemeToggle() }
//        )
//        Text(text = "Login", fontSize = 24.sp, color = MaterialTheme.colorScheme.primary) //Hien thi chu, co chu, Dung mau chinh cua Theme
//        Spacer(modifier = Modifier.height(20.dp)) //Tao khoang cach 20dp
//        OutlinedTextField( //O nhap lieu co vien
//            value = username, //Lay du lieu tu username
//            onValueChange = {username = it},//Cap nhat gia tri khi nguoi dung nhap
//            label = { Text("Username") },//Hien thi nhan "Username"
//            modifier = Modifier.fillMaxWidth()//Chieu rong bang man hinh
//        )
//        Spacer(modifier = Modifier.height(10.dp))
//        OutlinedTextField(
//            value = password,
//            onValueChange = {password = it},
//            label = { Text("Password") },
//            visualTransformation = PasswordVisualTransformation(),//Giau ki tu nhap vao (***)
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(20.dp)) //Tao khoang cach 20dp
//        Button(
//            onClick = {}, //Xu ly logic
//            modifier = Modifier.fillMaxWidth(), //Nut rong bang man hinh
//            shape = RoundedCornerShape(8.dp) //Bo goc 8dp
//        ) {
//            Text(text = "Login") //Noi dung nut
//        }
//    }
//}