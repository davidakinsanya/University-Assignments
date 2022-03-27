package com.indieproject.client

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.indieproject.client.`interface`.CardDemo
import com.indieproject.client.repository.MonitorRepository
import com.indieproject.client.repository.EnvRepository
import com.indieproject.client.ui.theme.ClientTheme


class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ClientTheme {
       // val repo = EnvRepository()
       // repo.getDisplayLog()
        Surface(color = MaterialTheme.colors.background) {

          Column(
            Modifier
              .fillMaxHeight(1.0f)
              .fillMaxWidth(1.06f)
              .padding(40.dp)
              .background(color = Color.LightGray, shape = RoundedCornerShape(50.dp))) {
                        Column(

                          Modifier
                            .fillMaxHeight(1.0f)
                            .fillMaxWidth(1.0f)
                            .padding(10.dp)
                            .background(
                              color = Color.Transparent,
                              shape = RoundedCornerShape(50.dp)
                            )) {
                          CardDemo(null, null, "")
                        }
          }
        }
      }
    }
  }
}

@Composable
fun Greeting(name: String) {
  Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  ClientTheme {
    Greeting("Android")
  }
}