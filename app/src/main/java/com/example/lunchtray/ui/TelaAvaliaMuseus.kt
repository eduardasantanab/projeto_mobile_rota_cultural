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

// data class para as avaliações de museus
data class Avaliacao(
    val id: Int,
    val name: String,
    val description: String,
    val imageRes: Int,
)

// lista de avaliações de museus
val museus = listOf(
    Avaliacao(
        id = 1,
        name = "Museu da Cidade do Recife",
        description = "Faça uma avaliação sobre o Museu da Cidade do Recife! Conheça a história de Pernambuco!",
        imageRes = R.drawable.cidade_do_recife
    ),
    Avaliacao(
        id = 2,
        name = "Instituto Ricardo Brennand",
        description = "Faça uma avaliação sobre o Instituto Ricardo Brennand! Um museu repleto de arte e cultura!",
        imageRes = R.drawable.brennand
    ),
    Avaliacao(
        id = 3,
        name = "Museu do Homem do Nordeste",
        description = "Faça uma avaliação sobre o Museu do Homem do Nordeste! Explore a cultura nordestina!",
        imageRes = R.drawable.homem_do_nordeste
    ),
    Avaliacao(
        id = 4,
        name = "Museu da Abolição",
        description = "Faça uma avaliação sobre o Museu da Abolição!",
        imageRes = R.drawable.museu_da_abolicao
    ),
    Avaliacao(
        id = 5,
        name = "Cais do Sertão",
        description = "Faça uma avaliação sobre o Cais do Sertão!",
        imageRes = R.drawable.cais_do_sertao
    ),
    Avaliacao(
        id = 6,
        name = "Casa-Museu Gilberto Freyre",
        description = "Faça uma avaliação sobre a Casa-Museu Gilberto Freyre!",
        imageRes = R.drawable.gilberto_freyre
    ),
    Avaliacao(
        id = 7,
        name = "Museu de Arte Moderna Aloísio Magalhães",
        description = "Faça uma avaliação sobre o Museu de Arte Moderna Aloísio Magalhães!",
        imageRes = R.drawable.museu_aloisio_magalhaes
    ),
    Avaliacao(
        id = 8,
        name = "Museu de Arte Popular",
        description = "Faça uma avaliação sobre o Museu de Arte Popular!",
        imageRes = R.drawable.museu_arte_popular_recife
    ),
    Avaliacao(
        id = 9,
        name = "Casa do Carnaval",
        description = "Faça uma avaliação sobre a Casa do Carnaval!",
        imageRes = R.drawable.museu_casa_do_carnaval
    ),
    Avaliacao(
        id = 10,
        name = "Memorial Chico Science",
        description = "Faça uma avaliação sobre o Memorial Chico Science!",
        imageRes = R.drawable.museu_chico_science
    ),
    Avaliacao(
        id = 11,
        name = "Museu de Artes Afro-Brasil Rolando Toro",
        description = "Faça uma avaliação sobre o Museu de Artes Afro-Brasil Rolando Toro!",
        imageRes = R.drawable.museu_de_artes_afro_rolando_toro
    ),
    Avaliacao(
        id = 12,
        name = "Museu do Trem",
        description = "Faça uma avaliação sobre o Museu do Trem!",
        imageRes = R.drawable.museu_do_trem
    ),
    Avaliacao(
        id = 13,
        name = "Museu Franciscano de Arte Sacra",
        description = "Faça uma avaliação sobre o Museu Franciscano de Arte Sacra!",
        imageRes = R.drawable.museu_franciscano_arte_sacra
    ),
    Avaliacao(
        id = 14,
        name = "Instituto Arqueológico Histórico e Geográfico de Pernambuco",
        description = "Faça uma avaliação sobre o Instituto Arqueológico Histórico e Geográfico de Pernambuco!",
        imageRes = R.drawable.museu_instituto_arqueologico
    ),
    Avaliacao(
        id = 15,
        name = "Memorial Luiz Gonzaga",
        description = "Faça uma avaliação sobre o Memorial Luiz Gonzaga!",
        imageRes = R.drawable.museu_luiz_gonzaga
    ),
    Avaliacao(
        id = 16,
        name = "Observatório Cultural Torre Malakoff",
        description = "Faça uma avaliação sobre o Observatório Cultural Torre Malakoff!",
        imageRes = R.drawable.museu_malakoff
    ),
    Avaliacao(
        id = 17,
        name = "Museu Militar",
        description = "Faça uma avaliação sobre o Museu Militar!",
        imageRes = R.drawable.museu_militar_forte_brum
    ),
    Avaliacao(
        id = 18,
        name = "Museu Murilo La Greca",
        description = "Faça uma avaliação sobre o Museu Murilo La Greca!",
        imageRes = R.drawable.museu_murio_la_grega
    ),
    Avaliacao(
        id = 19,
        name = "Sinagoga Kahal Zur Israel",
        description = "Faça uma avaliação sobre o Sinagoga Kahal Zur Israel!",
        imageRes = R.drawable.museu_sinagoga_kahal
    ),
    Avaliacao(
        id = 20,
        name = "Paço do Frevo",
        description = "Faça uma avaliação sobre o Paço do Frevo!",
        imageRes = R.drawable.paco_frevo
    )
)


// tela principal
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
                text = "Avalie os Museus do Recife!",
                fontSize = 26.sp,
                modifier = Modifier.padding(bottom = 26.dp)
            )
            AvaliacaoLazyCol()
        }
    }
}

// coluna lazy pra exibir avaliações
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
                    .clickable { /* ação ao clicar no item */ }
                    .padding(vertical = 8.dp)
            ) {
                AvaliacaoItem(museu)
            }
        }
    }
}

// avaliação individual de museus
@Composable
fun AvaliacaoItem(avaliacao: Avaliacao) {
    var rating by remember { mutableStateOf(0) }
    var comentario by remember { mutableStateOf("") }
    var showTextArea by remember { mutableStateOf(false) }

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
            // exibir imagem do museu
            Image(
                painter = painterResource(id = avaliacao.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .height(220.dp)
                    .fillMaxWidth()
                    .background(color = Color.LightGray),
            )
            Spacer(modifier = Modifier.height(6.dp))
            // exibir nome do museu
            Text(
                text = avaliacao.name,
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            // exibir descrição do museu
            Text(
                text = avaliacao.description,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                modifier = Modifier.padding(bottom = 4.dp)
            )
            // exibir classificação por estrelas
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                for (i in 1..5) {
                    IconToggleButton(
                        checked = rating >= i,
                        onCheckedChange = {
                            rating = i
                            showTextArea = true
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
            // mostrar área de texto e botão de confirmação se a classificação de estrelas for dada
            if (showTextArea) {
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = comentario,
                    onValueChange = { comentario = it },
                    label = { Text("Deixe seu comentário (opcional)") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = {
                        showTextArea = false
                    },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("Confirmar")
                }
            }
        }
    }
}
