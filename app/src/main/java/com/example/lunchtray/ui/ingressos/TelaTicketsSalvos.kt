package com.example.lunchtray.ui.ingressos

import Ticket
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment

@Composable
fun TelaDeTicketsSalvos(navController: NavController, ticketViewModel: TicketViewModel = viewModel()) {
    val savedTicketsState: List<Ticket> by ticketViewModel.savedTickets.observeAsState(emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Tickets Salvos",
            fontSize = 24.sp,
            color = Color.Black,
            modifier = Modifier.padding(top = 34.dp)
        )
        LazyColumn {
            items(savedTicketsState) { ticket ->
                TicketItem(ticket = ticket, onDeleteClick = { ticketViewModel.deleteTicket(ticket) }, onClick = {})
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { navController.navigate("TelaIngressos") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEABC17))
        ) {
            Text("Voltar")
        }
    }
}
@Composable
fun TicketItem(ticket: Ticket, onDeleteClick: () -> Unit, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF9C9999))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column {
                    Text("Museu: ${ticket.museum.name}", fontSize = 24.sp, color = Color.Black)
                    Text("Horário: ${ticket.time}", fontSize = 18.sp, color = Color.Black)
                    Text("Quantidade: ${ticket.quantity}", fontSize = 18.sp, color = Color.Black)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Preço Total: R\$ ${"%.2f".format(ticket.totalPrice)}",
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }
            Button(
                onClick = onDeleteClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDA0909)),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text("Deletar")
            }
        }
    }
}

