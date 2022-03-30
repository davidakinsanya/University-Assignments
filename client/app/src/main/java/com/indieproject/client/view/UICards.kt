package com.indieproject.client.view


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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

@Composable
fun EnvCard(env: EnvironmentData?, msg: String) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .padding(15.dp)
      .clickable{},
    elevation = 10.dp
  ) {
    Row(
      modifier = Modifier.padding(10.dp)
    ) {
      Column (Modifier.padding(10.dp)) {
        Text("Hello")
        // Text("ENV: " + env!!.getEnvironment() + " ID: " + env.getIdentifier())
      }
      Spacer(Modifier.padding(start=100.dp))
      Column (Modifier.padding(10.dp)) {
        Text(text = "View log")
      }
      }
    }
  }


@Composable
fun MonitorCard(mon: MonitorData?, msg: String) {
    Card(
      modifier = Modifier
        .fillMaxWidth()
        .padding(15.dp)
        .clickable {},
      elevation = 10.dp
    ) {
      Row(
        modifier = Modifier.padding(10.dp)
      ) {
        Column(Modifier.padding(10.dp)) {
          // Text("MON ID: " + mon.getMonitorNumber())
        }
        Spacer(Modifier.padding(start = 120.dp))
        Column(Modifier.padding(10.dp)) {
          Text(text = "View log")

          //TODO: Get some images for the UI.
        }
      }
    }
}