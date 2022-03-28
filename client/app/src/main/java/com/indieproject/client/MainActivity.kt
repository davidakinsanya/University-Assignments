package com.indieproject.client

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
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
import com.indieproject.client.`interface`.EnvCard
import com.indieproject.client.repository.MonitorRepository
import com.indieproject.client.repository.EnvRepository
import com.indieproject.client.ui.theme.ClientTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ClientTheme {
        Surface(color = MaterialTheme.colors.background) {
          Text("")
          val env = EnvRepository()
          env.getDisplayLog().invoke()
          /*
          Column(
            Modifier
              .fillMaxHeight()
              .fillMaxWidth()
              .padding(top = 200.dp, bottom = 120.dp, start = 30.dp, end = 30.dp)
              .background(color = Color.LightGray, shape = RoundedCornerShape(50.dp))) {
                        Column(
                          Modifier
                            .fillMaxHeight(1.0f)
                            .fillMaxWidth(1.0f)
                            .padding(15.dp)
                            .verticalScroll(rememberScrollState())
                            .background(
                              color = Color.Transparent,
                              shape = RoundedCornerShape(50.dp)
                            )) {
                          val env = EnvRepository()
                          val mon = MonitorRepository()
                          env.getDisplayLog().invoke()
                          }
                        }*/
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