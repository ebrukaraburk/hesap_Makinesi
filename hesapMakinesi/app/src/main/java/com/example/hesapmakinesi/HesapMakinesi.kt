package com.example.hesapmakinesi



import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun HesapMakinesi() {
    var input by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Hesap makinesi", style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = input, style = MaterialTheme.typography.titleLarge, modifier = Modifier.padding(16.dp))

        Button(onClick = {
            result = try {
                calculateSum(input)
            } catch (e: Exception) {
                "Error"
            }
        }) {
            Text("Hesapla")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = result, style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Column {
            Row {
                Butonn("1") { input += "1" }
                Butonn("2") { input += "2" }
                Butonn("3") { input += "3" }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Butonn("4") { input += "4" }
                Butonn("5") { input += "5" }
                Butonn("6") { input += "6" }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Butonn("7") { input += "7" }
                Butonn("8") { input += "8" }
                Butonn("9") { input += "9" }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Butonn("*") { input += "*" }
                Butonn("/") { input += "/" }
                Butonn("%") { input += "%" }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Butonn("0") { input += "0" }
                Butonn("C") { input = ""; result = "" }
                Butonn("+") { input += " + " }
            }

        }
    }
}

fun calculateSum(expression: String): String {
    val parts = expression.split(" + ")
    return try {
        val sum = parts.sumOf { it.toDouble() }
        sum.toString()
    } catch (e: Exception) {
        "Error"
    }
}

