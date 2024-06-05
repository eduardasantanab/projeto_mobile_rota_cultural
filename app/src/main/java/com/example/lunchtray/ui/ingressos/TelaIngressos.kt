package com.example.lunchtray.ui.ingressos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun TelaIngressos(navController: NavController) {
    Button(
        onClick = {
            navController.navigate("TelaInicial") {
                popUpTo(navController.graph.startDestinationId) { inclusive = true }
            }
        },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEABC17)),
        modifier = Modifier.padding(top = 16.dp, start = 16.dp)
    ) {
        Text("Voltar")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                navController.navigate("TelaMuseus")
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEABC17))
        ) {
            Text("Comprar ingressos")
        }
        Button(
            onClick = {
                navController.navigate("TelaDeTicketsSalvos")
            },
            modifier = Modifier.padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE))
        ) {
            Text("Ver meus tickets")
        }
    }
}