package tl209.bai5_boundservices_ac_v1

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    private var randomNumberService: RandomNumberService? = null
    private var isBound by mutableStateOf(false)

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as RandomNumberService.LocalBinder
            randomNumberService = binder.getService()
            isBound = true
            Log.i("Thread", "$isBound")
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            isBound = false
            randomNumberService = null
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("Thread", "Zo roi")
        Intent(this, RandomNumberService::class.java).also { intent ->
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }
    }

    override fun onStop() {
        super.onStop()
        if (isBound) {
            unbindService(connection)
            isBound = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RandomNumberApp(isBound, randomNumberService)
//            Bai5_BoundServices_AC_V1Theme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
        }
    }
}

@Composable
fun RandomNumberApp(isBound: Boolean, randomNumberService: RandomNumberService?) {
    var randomNumber by remember { mutableIntStateOf(0) }
    var textValue by remember { mutableStateOf("") }
    var intValue by remember { mutableIntStateOf(0) }
    var peopleList by remember { mutableStateOf(emptyList<People>()) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Random Number Generator", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Random Number: $randomNumber", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (isBound) {
                    randomNumber = randomNumberService?.getRandomNumber() ?: 0
                }
            },
            enabled = isBound
        ) {
            Text("Generate Random Number")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Text from Service: $textValue", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (isBound) {
                    textValue = randomNumberService?.getText() ?: ""
                }
            },
            enabled = isBound
        ) {
            Text("Get Text")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Integer from Service: $intValue", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (isBound) {
                    intValue = randomNumberService?.getInt() ?: 0
                }
            },
            enabled = isBound
        ) {
            Text("Get Integer")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "People List: ", style = MaterialTheme.typography.bodyLarge)
        peopleList.forEach { person ->
            Text("${person.name} - ${person.age} years old")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (isBound) {
                    peopleList = randomNumberService?.getArray() ?: emptyList()
                }
            },
            enabled = isBound
        ) {
            Text("Get People List")
        }
    }

}

