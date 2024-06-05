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
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.lunchtray.R


data class Avaliacao(
    val id: Int,
    val name: String,
    val description: String,
    val imageRes: Int,
)

val museus = listOf(
    Avaliacao(
        id = 1,
        name = "Museu da Cidade do Recife",
        description = "Conheça a história de Pernambuco!",
        R.drawable.cidade_do_recife
    ),
    Avaliacao(
        id = 2,
        name = "Instituto Ricardo Brennand",
        description = "Um museu repleto de arte e cultura!",
        imageRes = R.drawable.brennand
    ),
    Avaliacao(
        id = 3,
        name = "Museu do Homem do Nordeste",
        description = "Explore a cultura nordestina!",
        imageRes = R.drawable.homem_do_nordeste
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaAvaliaMuseus() {
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
            AvaliacaoLazyCol()
        }
    }
}

@Composable
fun AvaliacaoLazyCol() {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(museus) { museu ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { /* Ação ao clicar no item */ }
                    .padding(vertical = 8.dp)
            ) {
                AvaliacaoItem(museu)
            }
        }
    }
}


@Composable
fun AvaliacaoItem(avaliacao: Avaliacao) {
    var rating by remember { mutableStateOf(0) }

    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Image(
                painter = painterResource(id = avaliacao.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .height(220.dp)
                    .fillMaxWidth()
                    .background(color = Color.LightGray),
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = avaliacao.name,
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = avaliacao.description,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                modifier = Modifier.padding(bottom = 4.dp)
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
}


