package com.example.calculator.Screen

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.orange


@Composable
fun Sandar(san:String , OnClick: ()->Unit) {
    Spacer(modifier = Modifier.padding(5.dp))
    Box(modifier = Modifier
        .clickable {
        OnClick()
    }
        .size(80.dp)
        .clip(CircleShape)
        .background(Color.Gray) , contentAlignment = Alignment.Center ){
        Text(text =san , fontSize = 55.sp  , fontWeight = FontWeight.W300 , color = Color.White )
    }
}


@Composable
fun Operation(operation:String , OnClick:()->Unit) {
    Spacer(modifier = Modifier.padding(5.dp))
    Box(modifier = Modifier
        .size(80.dp).clip(CircleShape).background(orange).clickable {
        OnClick()
    } , contentAlignment = Alignment.Center  ){
        Text(text =operation  , fontSize = 55.sp  , fontWeight = FontWeight.W300 , color = Color.White )
    }
}










