/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.lunchtray

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lunchtray.ui.TelaAvaliaMuseus
import com.example.lunchtray.ui.TelaCompraIngressos
import com.example.lunchtray.ui.TelaLojaProdutos
import com.example.lunchtray.ui.TelaContato
import com.example.lunchtray.ui.TelaInicial

enum class RotaCultural(@StringRes val title: Int) {
    TelaInicial(title = R.string.app_name),
    Contato(title = R.string.start_order),
    AvaliaMuseus(title = R.string.screen1_title),
    Loja(title = R.string.screen2_title),
    Ingressos(title = R.string.screen3_title),
}


/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RotaCulturalAppBar(
    @StringRes currentScreenTitle: Int,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = { Text(stringResource(currentScreenTitle)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@Composable
fun RotaCulturalApp() {
    //Create NavController
    val navController = rememberNavController()
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = RotaCultural.valueOf(
        backStackEntry?.destination?.route ?: RotaCultural.TelaInicial.name
    )

    Scaffold(
        topBar = {
            RotaCulturalAppBar(
                currentScreenTitle = currentScreen.title,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = RotaCultural.TelaInicial.name,
        ) {
            composable(route = RotaCultural.TelaInicial.name) {
                TelaInicial(
                    onStartOrderButtonClicked = {
                        navController.navigate(RotaCultural.Contato.name)
                    },
                    onScreenMuseumClicked = {
                        navController.navigate(RotaCultural.AvaliaMuseus.name)
                    },
                    onScreenShoplicked = {
                        navController.navigate(RotaCultural.Loja.name)
                    },
                    onScreenTicketsClicked = {
                        navController.navigate(RotaCultural.Ingressos.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                )
            }

            composable(route = RotaCultural.Contato.name) {
                TelaContato(
                    onStartOrderButtonClicked = {
                        navController.navigate(RotaCultural.AvaliaMuseus.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                )
            }

            composable(route = RotaCultural.AvaliaMuseus.name) {
                TelaAvaliaMuseus()
            }

            composable(route = RotaCultural.Loja.name) {
                TelaLojaProdutos()
            }

            composable(route = RotaCultural.Ingressos.name) {
                TelaCompraIngressos()
            }
        }
    }
}
