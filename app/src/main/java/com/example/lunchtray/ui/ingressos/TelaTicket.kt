
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.lunchtray.R
import com.example.lunchtray.ui.ingressos.Museum
import com.example.lunchtray.ui.ingressos.TicketViewModel
import kotlinx.coroutines.launch

data class Ticket(
    val museum: Museum,
    val time: String,
    val quantity: Int,
    val totalPrice: Double
)


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TelaTicket(
    navController: NavController,
    ticketViewModel: TicketViewModel = viewModel(),
    onTicketConfirmed: (Ticket) -> Unit,
    onTicketUpdated: (Ticket) -> Unit
) {
    val savedStateHandle = navController.previousBackStackEntry?.savedStateHandle
    val ticket = savedStateHandle?.get<Ticket>("ticket")
    val selectedTime = savedStateHandle?.get<String>("selectedTime") ?: "10:00"
    val selectedQuantity = savedStateHandle?.get<Int>("selectedQuantity") ?: 1

    val museum = remember { mutableStateOf(ticket?.museum ?: Museum(99, "Padrão", "Descrição Padrão", R.drawable.logo, 0.0)) }
    val time = remember { mutableStateOf(selectedTime) }
    val quantity = remember { mutableIntStateOf(selectedQuantity) }
    val totalPrice = remember { mutableDoubleStateOf(ticket?.totalPrice ?: (10.0 * selectedQuantity)) }

    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()


    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) {
        TicketCard(
            museum = museum,
            time = time,
            quantity = quantity,
            totalPrice = totalPrice,
            onConfirmTicket = { newTicket ->
                if (ticket == null) {
                    onTicketConfirmed(newTicket)
                } else {
                    onTicketUpdated(newTicket)
                }
                coroutineScope.launch {
                    snackbarHostState.showSnackbar("Ticket confirmado!")
                    ticketViewModel.addTicket(newTicket)
                    navController.navigate("TelaIngressos") {
                        popUpTo("TelaIngressos") { inclusive = true }
                    }
                }
            },
            onEditTicket = {
                navController.popBackStack()
            }
        )
    }
}
@Composable
fun TicketCard(
    museum: MutableState<Museum>,
    time: MutableState<String>,
    quantity: MutableState<Int>,
    totalPrice: MutableState<Double>,
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
            Text("Museu: ${museum.value.name}", fontSize = 18.sp, color = Color.Gray)
            TextField(
                value = time.value,
                onValueChange = { time.value = it },
                label = { Text("Horário") },
                modifier = Modifier.padding(vertical = 8.dp)
            )
            TextField(
                value = quantity.value.toString(),
                onValueChange = { quantity.value = it.toIntOrNull() ?: 0 },
                label = { Text("Quantidade de ingressos") },
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text("Preço Total: R\$ ${"%.2f".format(totalPrice.value)}", fontSize = 18.sp, color = Color.Gray)

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        val ticket = Ticket(museum.value, time.value, quantity.value, totalPrice.value)
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