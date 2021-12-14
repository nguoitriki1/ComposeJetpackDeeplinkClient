package com.example.deeplinkclient

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.example.deeplinkclient.ui.theme.DeeplinkClientTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeeplinkClientTheme {
                DefaultPreview()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val context = LocalContext.current
    Column(modifier = Modifier
        .background(Color.Yellow)
        .fillMaxSize()
        .padding(32.dp),Arrangement.Center,Alignment.CenterHorizontally) {
        val dataText = "Hello, I'm Client Deeplink"
        Text(text = "Send Data To App HasDeeplink - String : Hello, I'm Client Deeplink")
        Button(onClick = {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.abc.com/screen1/$dataText")
            context.startActivity(intent)
        }) {

        }
        Text(text = "Go to screen2 Host App")
        Button(onClick = {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.abc.com/screen2")
            context.startActivity(intent)
        }) {

        }
    }
}