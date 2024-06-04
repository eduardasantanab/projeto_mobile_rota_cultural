package com.example.lunchtray.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.lunchtray.R
import androidx.compose.runtime.Composable


data class Museum(
    val id: Int,
    val name: String,
    val description: String,
    val imageRes: Int,
    val ticketPrice: Double
)
data class Ticket(
    val museum: Museum,
    val time: String,
    val quantity: Int,
    val totalPrice: Double
)
// Defina os possíveis estados da tela

@Composable
fun TelaCompraIngressos(
    modifier: Modifier = Modifier
) {

    val museums = listOf(
        Museum(
            1,
            "Homem do nordeste",
            "15 mil peças retratando a formação do povo nordestino, um dos mais importantes museus antropológicos do Brasil.",
            R.drawable.homem_do_nordeste2,
            30.0
        ),
        Museum(
            2,
            "Museu Murilo La Greca",
            "Acervo de 14 mil desenhos e 160 pinturas de Murilo La Greca, com cartas trocadas com Portinari e Giacometti.",
            R.drawable.museu_murio_la_grega,
            25.0
        ),
        Museum(
            3,
            "Museu da cidade do Recife",
            "Museu com exposições sobre a história da cidade.",
            R.drawable.cidade_do_recife,
            10.0
        ),
        Museum(
            4,
            "Museu Militar",
            "Localizado no Forte do Brum, século XVI, cenário de importantes acontecimentos históricos",
            R.drawable.museu_militar_forte_brum,
            21.0
        ),
        Museum(
            5,
            "Museu de Arte Moderna Aloísio Magalhães",
            "Integra o circuito de museus de arte moderna do Brasil e tem seu forte nas exposições temporárias.",
            R.drawable.museu_aloisio_magalhaes,
            20.0
        ),
        Museum(
            6,
            "Museu Franciscano de Arte Sacra",
            "Valiosas peças católicas no Recife, localizado na Capela Dourada, exemplo do barroco brasileiro.",
            R.drawable.museu_franciscano_arte_sacra,
            25.0
        ),
        Museum(
            7,
            "Casa-Museu Gilberto Fryre",
            "Casa preservada do escritor Gilberto Freyre em Apipucos, com objetos e livros originais..",
            R.drawable.gilberto_freyre,
            22.0
        ),
        Museum(
            8,
            "Oficina Brennand",
            "Mais de 2 mil esculturas e obras de Francisco Brennand na Várzea.",
            R.drawable.museu_oficina_brennand,
            35.0
        ),
        Museum(
            9,
            "Instituto Ricardo Brennand",
            "Castelo medieval com coleção de armas, telas do Brasil Colonial e obras de Frans Post.",
            R.drawable.brennand,
            20.0
        ),
        Museum(
            10,
            "Museu da Abolição",
            "No bairro da Madalena, trata da escravidão e abolição, preservando a memória do povo negro.",
            R.drawable.museu_da_abolicao,
            45.0
        ),
        Museum(
            12,
            "Instituto Arqueológico Histórico e Geográfico de Pernambuco",
            "Centro de pesquisa com documentos e itens históricos de Pernambuco.",
            R.drawable.museu_instituto_arqueologico,
            24.0
        ),
        Museum(
            13,
            "Museu de Arte Popular",
            "Coleção de obras em madeira, gesso e cerâmica representando o Nordeste brasileiro.",
            R.drawable.museu_arte_popular_recife,
            24.0
        ),
        Museum(
            14,
            "Museu Cais do Sertão",
            "Museu interativo dedicado à cultura sertaneja.",
            R.drawable.cais_do_sertao,
            15.0
        ),
        Museum(
            15,
            "Casa do Carnaval",
            "Acervo de documentos sobre manifestações da cultura popular.",
            R.drawable.museu_casa_do_carnaval,
            18.50
        ),
        Museum(
            16,
            "Observatório Cultural Torre Malakoff",
            "Observatório astronômico do século XIX e centro cultural com exposições temporárias.",
            R.drawable.museu_observatorio_malakoff,
            25.0
        ),
        Museum(
            17,
            "Sinagoga Kahal Zur Israel",
            "Primeira sinagoga das Américas, com exposição de itens históricos judaicos.",
            R.drawable.museu_sinagoga_kahal,
            15.0
        ),
        Museum(
            18,
            "Paço do Frevo",
            "Espaço cultural dedicado à história do Frevo, com escola de dança e música.",
            R.drawable.museu_paco_do_frevo,
            10.0
        ),
        Museum(
            19,
            "Memorial Chico Science",
            "Memorial dedicado ao artista Chico Science e ao movimento Manguebeat.",
            R.drawable.museu_chico_science,
            5.0
        ),
        Museum(
            20,
            "Memorial Luiz Gonzaga",
            "Preserva e difunde a obra de Luiz Gonzaga, com núcleos de pesquisa e música.",
            R.drawable.museu_luiz_gonzaga,
            20.0
        ),
        Museum(
            21,
            "Museu do Trem",
            "História do trem em Pernambuco, com locomotivas expostas.",
            R.drawable.museu_do_trem,
            25.0
        ),
        Museum(
            22,
            "Museu de Artes Afro-Brasil Rolando Toro",
            "Obras afro-brasileiras promovendo diversas linguagens artísticas.",
            R.drawable.museu_de_artes_afro_rolando_toro,
            35.0
        )
    )

    var selectedMuseum by remember { mutableStateOf<Museum?>(null) }
    var selectedTime by remember { mutableStateOf<String?>(null) }
    var ticketQuantity by remember { mutableStateOf(1) }
    var showTicket by remember { mutableStateOf(false) }
    var showMuseumList by remember { mutableStateOf(false) }
    val confirmedTickets = remember { mutableStateListOf<Ticket>() }
    val savedTickets = remember { mutableStateListOf<Ticket>() }
    var showSavedTickets by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(14.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        if (showTicket && selectedMuseum != null && selectedTime != null) {
            TicketCard(
                museum = selectedMuseum ?: Museum(0, "", "", 0, 0.0),
                time = selectedTime ?: "",
                quantity = ticketQuantity,
                totalPrice = (selectedMuseum?.ticketPrice ?: 0.0) * ticketQuantity,
                onConfirmTicket = { ticket -> confirmedTickets.add(ticket) },
                onEditTicket = {
                    showTicket = false
                    showMuseumList = false
                }
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
                    MuseumList(museums = museums) { museum ->
                        selectedMuseum = museum
                    }
                }
            } else {
                MuseumDetails(
                    museum = selectedMuseum ?: Museum(0, "", "", 0, 0.0),
                    onTimeSelected = { time ->
                        selectedTime = time
                    },
                    onQuantityChanged = { quantity ->
                        ticketQuantity = quantity
                    },
                    onConfirm = {
                        showTicket = true
                    }
                )
            }
        }
        /*
        Spacer(modifier = Modifier.height(16.dp))
        Button( // esse botão vai levar para a tela dos meus ingressos depois
            onClick = { showSavedTickets = true }, // ele nao faz nada ainda, estou testando o layout
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEABC17))
        ) {
            Text("Ver Meus Ingressos")
        }
        if (showSavedTickets) {
            SavedTicketsScreen(tickets = savedTickets) {
                showSavedTickets = false
            }
        }
         */
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
fun TicketCard(
    museum: Museum,
    time: String,
    quantity: Int,
    totalPrice: Double,
    onConfirmTicket: (Ticket) -> Unit,
    onEditTicket: () -> Unit
) {
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

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        val ticket = Ticket(museum, time, quantity, totalPrice)
                        onConfirmTicket(ticket)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE))
                ) {
                    Text("Confirmar Ticket")
                }

                Button(
                    onClick = { onEditTicket() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEABC17))
                ) {
                    Text("Editar Ticket")
                }
            }
        }
    }
}
@Composable
fun SavedTicketsScreen(tickets: List<Ticket>, onBackPressed: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Meus Tickets", modifier = Modifier.padding(bottom = 8.dp))

        if (tickets.isEmpty()) {
            Text("Nenhum ticket salvo ainda.")
        } else {
            LazyColumn {
                items(tickets) { ticket ->
                    TicketItem(ticket)
                }
            }
        }
    }
}

@Composable
private fun TicketItem(ticket: Ticket) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text("Museu: ${ticket.museum}")
        Text("Horário: ${ticket.time}")
        Text("Quantidade: ${ticket.quantity}")
        Text("Preço Total: R\$ ${"%.2f".format(ticket.totalPrice)}")
    }
}

@Preview
@Composable
private fun LojaScreenPreview() {
    TelaCompraIngressos()
}

