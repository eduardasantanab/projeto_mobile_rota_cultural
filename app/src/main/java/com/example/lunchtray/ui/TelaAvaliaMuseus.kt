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

package com.example.lunchtray.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaAvaliaMuseus() {
    val museus = listOf("Museu do Estado de Pernambuco", "Instituto Ricardo Brennand", "Museu do Homem do Nordeste")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Avaliação de Museus") }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)

        ) {
            Text(
                text = "Faça sua avaliação dos Museus do Recife!",
                fontSize = 26.sp,
                modifier = Modifier.padding(bottom = 26.dp)

            )
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(museus) { museu ->
                    AvaliacaoMuseuItem(museu = museu)
                }
            }
        }
    }
}

@Composable
fun AvaliacaoMuseuItem(museu: String) {
    var rating by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = museu,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            for (i in 1..5) {
                IconToggleButton(
                    checked = rating >= i,
                    onCheckedChange = {
                        rating = i
                    }
                ) {
                    Icon(
                        imageVector = if (rating >= i) Icons.Filled.Star else Icons.Outlined.Star,
                        contentDescription = null,
                        tint = if (rating >= i) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}
