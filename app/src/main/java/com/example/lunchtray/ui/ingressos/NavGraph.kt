package com.example.lunchtray.ui.ingressos

import TelaTicket
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NavGraph(navController: NavHostController) {
    val ticketViewModel: TicketViewModel = viewModel()
    NavHost(navController = navController, startDestination = "TelaIngressos") {
        composable("TelaIngressos") {
            TelaIngressos(navController)
        }
        composable("TelaMuseus") {
            TelaMuseus(navController)
        }
        composable(
            route = "TelaConfirmaMuseu/{museumId}",
            arguments = listOf(navArgument("museumId") { type = NavType.IntType })
        ) { backStackEntry ->
            val museumId = backStackEntry.arguments?.getInt("museumId")
            if (museumId != null) {
                TelaConfirmaMuseu(navController = navController, museumId = museumId) // Passando museumId como parâmetro
            }
        }
        composable("TelaTicket") {
            TelaTicket(
                navController = navController,
                ticketViewModel = ticketViewModel,
                onTicketConfirmed = { ticket ->
                },
                onTicketUpdated = { ticket ->
                }
            )
        }
        composable("TelaDeTicketsSalvos") {
            TelaDeTicketsSalvos(navController, ticketViewModel)
        }
    }
}
@Preview
@Composable
fun NavGraphPreview() {
    val navController = rememberNavController()
    NavGraph(navController)
}
