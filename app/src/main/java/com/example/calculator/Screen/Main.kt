package com.example.calculator.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.R



@Composable
fun Main( trushlist:MutableMap<String , String> , onClick:() ->Unit) {
    val textfield = remember { mutableStateOf("") }

    Column(modifier = Modifier.background(Color.Black).padding(top = 10.dp , bottom = 40.dp)) {

        Image(painter = painterResource(R.drawable.basket2)  , contentDescription = "imagebasket", modifier = Modifier.clickable {
            onClick()
        })


        Box(
            modifier = Modifier
                .fillMaxHeight(0.46f)
                .fillMaxWidth()  , contentAlignment = Alignment.BottomEnd

        ) {
            TextField(

                value = textfield.value,
                onValueChange = { textfield.value = it },
                modifier = Modifier.fillMaxWidth(),
                readOnly = true ,
                textStyle = TextStyle(textAlign = TextAlign.Right  , background = Color.Black  , fontSize = 80.sp  , fontWeight = FontWeight.Bold , color = Color.White) ,
                colors = TextFieldDefaults.colors( unfocusedContainerColor = Color.Black ,
                    cursorColor = Color.Black,
                    focusedIndicatorColor = Color.Transparent ,
                    unfocusedIndicatorColor = Color.Transparent

                    )

            )
        }



        Column(
            modifier = Modifier
                .fillMaxWidth().fillMaxHeight().align(Alignment.End)
        ) {
            Row {
                Sandar("AC") { MyOnClick("AC", textfield , trushlist) }
                Sandar("⌫") { MyOnClick("⌫", textfield , trushlist) }
                Sandar("√") { MyOnClick("√", textfield  , trushlist) }
                Operation("÷") { MyOnClick("÷", textfield , trushlist) }
            }
            Row {
                for (i in 7..9) {
                    Sandar(i.toString()) { MyOnClick(i.toString(), textfield , trushlist) }
                }
                Operation("×") { MyOnClick("*", textfield , trushlist) }
            }
            Row {
                for (i in 4..6) {
                    Sandar(i.toString()) { MyOnClick(i.toString(), textfield , trushlist) }
                }
                Operation("-") { MyOnClick("-", textfield , trushlist) }
            }
            Row {
                for (i in 1..3) {
                    Sandar(i.toString()) { MyOnClick(i.toString(), textfield , trushlist) }
                }
                Operation("+") { MyOnClick("+", textfield , trushlist) }
            }
            Row {
                Sandar("00") { MyOnClick("00", textfield ,  trushlist) }
                Sandar("0") { MyOnClick("0", textfield , trushlist) }
                Sandar(",") { MyOnClick(",", textfield , trushlist) }
                Operation("=") { MyOnClick("=", textfield , trushlist) }
            }
        }
    }
}


fun MyOnClick(operation: String, textfield: MutableState<String> , trushlist: MutableMap<String, String>) {
    if (operation.all { it.isDigit() }) {
        textfield.value += operation
    } else {
        when (operation) {
            "," -> textfield.value += "."
            "+" -> textfield.value += "+"
            "*" -> textfield.value += "*"
            "-" -> textfield.value += "-"
            "÷" -> textfield.value += "/"
            "√" ->{
                val san = textfield.value.toDouble()
                textfield.value = Math.sqrt(san).toString()
            }
            "⌫" -> if (textfield.value.isNotEmpty()) {
                textfield.value = textfield.value.dropLast(1)
            }
            "AC" -> textfield.value = ""
            "=" -> {

                val answer: String
                textfield.value = try {
                    val expression = textfield.value ?: ""
                    answer = evaluateExpression(expression).toString()

                    trushlist.put(expression, answer)
                    answer
                } catch (e: Exception) {
                    "Error"
                }




            }
        }
    }
}


fun evaluateExpression(expression: String): Double {

    return when {

        expression.contains("+") -> {
            val parts = expression.split("+").map { it.toDouble() }
            parts[0] + parts[1]
        }
        expression.contains("-") -> {
            val parts = expression.split("-").map { it.toDouble() }
            parts[0] - parts[1]
        }
        expression.contains("*") -> {
            val parts = expression.split("*").map { it.toDouble() }
            parts[0] * parts[1]
        }
        expression.contains("/") -> {
            val parts = expression.split("/").map { it.toDouble() }
            parts[0] / parts[1]
        }
        else -> expression.toDouble()
    }
}

