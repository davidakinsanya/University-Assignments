package com.indieproject.client

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.indieproject.client.db.DbHelper
import com.indieproject.client.repository.MonitorRepository
import com.indieproject.client.repository.EnvRepository
import com.indieproject.client.ui.theme.ClientTheme
import com.indieproject.client.view.LogCard

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ClientTheme {
        Surface(color = MaterialTheme.colors.background) {
          val db = DbHelper(this)
          // db.deleteDatabase()
          Column(
            Modifier
              .fillMaxHeight()
              .fillMaxWidth()
              .padding(top = 100.dp, bottom = 320.dp, start = 30.dp, end = 30.dp)
              .background(color = Color.LightGray, shape = RoundedCornerShape(50.dp))) {
                        val env = EnvRepository()
                        val mon = MonitorRepository()

                        LazyColumn(
                          Modifier
                            .fillMaxHeight(1.0f)
                            .fillMaxWidth(1.0f)
                            .padding(15.dp)
                            .background(
                              color = Color.Transparent,
                              shape = RoundedCornerShape(50.dp)
                            ))
                          {
                            item (1) {
                              // mon.logData(db)
                              // env.logData(db)
                              for (item in db.getAllCards())
                                LogCard(item, applicationContext)

                            }
                        }
            }
          }
        }
      }
    }
  }