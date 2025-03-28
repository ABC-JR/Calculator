package com.example.calculator.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun Screen2( map :MutableMap<String , String>,onClick: () -> Unit ) {
    Column (modifier = Modifier.fillMaxSize().background(Color.Black).padding(top = 10.dp , bottom = 40.dp , start =5.dp ) ) {
        LazyColumn {
            itemsIndexed(map.entries.toList()) { index, entry ->
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(text = "${index + 1}. ${entry.key} = ${entry.value}", color = Color.White ,  modifier = Modifier.clickable {
                        map.remove(entry.key , entry.value)
                    })
                }
            }
        }
        Button(onClick={onClick}) {
            Text(text = "Back")
        }


    }
}
