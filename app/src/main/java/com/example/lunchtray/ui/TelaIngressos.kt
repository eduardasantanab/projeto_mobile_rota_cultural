package com.example.lunchtray.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.lunchtray.R

data class Museum(
    val name: String,
    val description: String,
    val imageRes: Int,
    val ticketPrice: Double
)

@Composable
fun TelaCompraIngressos(
    modifier: Modifier = Modifier
) {
    val museums = listOf(
        Museum("Instituto Ricardo Brennand", "Um museu com uma vasta coleção de armas brancas e obras de arte.", R.drawable.brennand, 20.0),
        Museum("Museu Cais do Sertão", "Museu interativo dedicado à cultura sertaneja.", R.drawable.cais_do_sertao, 15.0),
        Museum("Museu do Recife", "Museu com exposições sobre a história da cidade.", R.drawable.cidade_do_recife, 10.0),
        Museum("Museu Gilberto Fryre", "Museu interativo dedicado à cultura sertaneja.", R.drawable.gilberto_freyre, 22.0),
        Museum("Homem do nordeste", "Museu com exposições sobre a história da cidade.", R.drawable.homem_do_nordeste2, 30.0),
        ).sortedBy { it.name }

    var selectedMuseum by remember { mutableStateOf<Museum?>(null) }
    var selectedTime by remember { mutableStateOf<String?>(null) }
    var ticketQuantity by remember { mutableStateOf(1) }
    var showTicket by remember { mutableStateOf(false) }
    var showMuseumList by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(14.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (showTicket && selectedMuseum != null && selectedTime != null) {
            TicketCard(
                museum = selectedMuseum!!,
                time = selectedTime!!,
                quantity = ticketQuantity,
                totalPrice = selectedMuseum!!.ticketPrice * ticketQuantity
            )
        } else {
            if (selectedMuseum == null) {
                if (!showMuseumList) {
                    Button(
                        onClick = { showMuseumList = true },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEABC17))
                    ) {
                        Text("Comprar ingressos")
                    }
                } else {
                    MuseumList(museums = museums, onMuseumSelected = { selectedMuseum = it })
                }
            } else {
                MuseumDetails(
                    museum = selectedMuseum!!,
                    onTimeSelected = { selectedTime = it },
                    onQuantityChanged = { ticketQuantity = it },
                    onConfirm = { showTicket = true }
                )
            }
        }
    }
}
@Composable
fun MuseumList(museums: List<Museum>, onMuseumSelected: (Museum) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        items(museums) { museum ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { onMuseumSelected(museum) },
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = museum.imageRes),
                        contentDescription = museum.name,
                        modifier = Modifier
                            .size(64.dp)
                            .padding(end = 16.dp)
                    )
                    Column {
                        Text(
                            text = museum.name,
                            fontSize = 20.sp,
                            color = Color.Black,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                        Text(
                            text = museum.description,
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MuseumDetails(
    museum: Museum,
    onTimeSelected: (String) -> Unit,
    onQuantityChanged: (Int) -> Unit,
    onConfirm: () -> Unit
) {
    val times = listOf("10:00", "12:00", "14:00", "16:00")
    var selectedTime by remember { mutableStateOf<String?>(null) }
    var ticketQuantity by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(museum.name, fontSize = 24.sp, color = Color.Black)
        Text(museum.description, fontSize = 16.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(16.dp))

        Text("Escolha um horário:", fontSize = 18.sp)
        times.forEach { time ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { selectedTime = time }
                    .padding(vertical = 4.dp)
            ) {
                RadioButton(
                    selected = (selectedTime == time),
                    onClick = { selectedTime = time }
                )
                Text(text = time, fontSize = 16.sp)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Quantidade de ingressos:", fontSize = 18.sp)
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = { if (ticketQuantity > 1) ticketQuantity-- }) {
                Text("-", fontSize = 20.sp)
            }
            Text("$ticketQuantity", fontSize = 20.sp, modifier = Modifier.padding(horizontal = 8.dp))
            IconButton(onClick = { ticketQuantity++ }) {
                Text("+", fontSize = 20.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        val totalPrice = museum.ticketPrice * ticketQuantity
        Text("Preço total: R\$ ${"%.2f".format(totalPrice)}", fontSize = 18.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (selectedTime != null) {
                    onTimeSelected(selectedTime!!)
                    onQuantityChanged(ticketQuantity)
                    onConfirm()
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE))
        ) {
            Text("Confirmar")
        }
    }
}



@Composable
fun TicketCard(museum: Museum, time: String, quantity: Int, totalPrice: Double) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Seu Ticket", fontSize = 24.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Museu: ${museum.name}", fontSize = 18.sp, color = Color.Gray)
            Text("Horário: $time", fontSize = 18.sp, color = Color.Gray)
            Text("Quantidade: $quantity", fontSize = 18.sp, color = Color.Gray)
            Text("Preço Total: R\$ ${"%.2f".format(totalPrice)}", fontSize = 18.sp, color = Color.Gray)
        }
    }
}
@Preview
@Composable
private fun LojaScreenPreview() {
    TelaCompraIngressos()
}

