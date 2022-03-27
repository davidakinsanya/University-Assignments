package com.indieproject.client.`interface`

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.indieproject.client.data.iot.EnvironmentData
import com.indieproject.client.data.iot.MonitorData

@Composable
fun CardDemo(mon: MonitorData?, env: EnvironmentData?, msg: String) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .padding(15.dp),
    elevation = 10.dp
  ) {
    Row(
      modifier = Modifier.padding(10.dp)
    ) {
      Column (Modifier.padding(10.dp)) {
        Text("ENV")
      }
      Spacer(Modifier.padding(15.dp))
      Column (Modifier.padding(10.dp)) {
        Text("World")
      }
      Spacer(Modifier.padding(15.dp))
      Column (Modifier.padding(10.dp)) {
        Text("Mfs")
      }
    }
  }
}

