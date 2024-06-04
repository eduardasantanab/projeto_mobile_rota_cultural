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

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lunchtray.R
import com.example.lunchtray.ui.theme.LunchTrayTheme
import androidx.compose.material3.ButtonDefaults
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.Bookmarks
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.sp
import com.example.lunchtray.ui.theme.md_theme_light_tertiary

@Composable
fun TelaInicial(
    onStartOrderButtonClicked: () -> Unit,
    onScreenStarClicked: () -> Unit,
    onScreenShoplicked: () -> Unit,
    onScreenTicketsClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .align(Alignment.TopCenter)
                        .background(color = md_theme_light_tertiary)
                )
                Box(
                    modifier = Modifier
                        .size(500.dp)
                        .height(3.dp)
                        .background(
                            color = md_theme_light_tertiary,
                            shape = CircleShape
                        )
                )
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(180.dp)
                        .align(Alignment.Center)
                )
                Button(
                    onClick = onStartOrderButtonClicked,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(vertical = 30.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEABC17))
                ) {
                    Text(
                        stringResource(R.string.start_order),
                        style = MaterialTheme.typography.titleMedium,
                    )
                }

            }
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_medium))
            ) {
                Spacer(modifier = Modifier.height(40.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    BoxNavegacao(
                        onClick = onScreenStarClicked,
                        backgroundColor = Color(0xFFE4E4E4),
                        icon = Icons.Default.Star
                    )
                    BoxNavegacao(
                        onClick = onScreenShoplicked,
                        backgroundColor = Color(0xFFE4E4E4),
                        icon = Icons.Default.AddShoppingCart
                    )
                    BoxNavegacao(
                        onClick = onScreenTicketsClicked,
                        backgroundColor = Color(0xFFE4E4E4),
                        icon = Icons.Default.Bookmarks
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 30.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(R.string.main_menu_title),
                        style = MaterialTheme.typography.titleMedium.copy(fontSize = 28.sp),
                    )
                }
                // Imagem do Instituto Ricardo Brenannd
                Image(
                    painter = painterResource(id = R.drawable.instituto_brennand),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(250.dp)
                        .padding(start = 8.dp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.brennand),
                        style = MaterialTheme.typography.titleMedium.copy(fontSize = 20.sp),
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = stringResource(R.string.brennand_descricao),
                        style = MaterialTheme.typography.titleMedium.copy(fontSize = 14.sp),
                    )
                }
                // Imagem da Oficina de Cerâmica do Brenannd
                Spacer(modifier = Modifier.height(40.dp))
                Image(
                    painter = painterResource(id = R.drawable.oficina_ceramica_brennand),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(300.dp)
                        .padding(start = 8.dp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.oficina_brennand),
                        style = MaterialTheme.typography.titleMedium.copy(fontSize = 20.sp),
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = stringResource(R.string.oficina_brennand_descricao),
                        style = MaterialTheme.typography.titleMedium.copy(fontSize = 14.sp),
                    )
                }
                // Imagem do Museu Paço do Frevo
                Spacer(modifier = Modifier.height(40.dp))
                Image(
                    painter = painterResource(id = R.drawable.paco_frevo),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(300.dp)
                        .padding(start = 8.dp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.paco_frevo),
                        style = MaterialTheme.typography.titleMedium.copy(fontSize = 20.sp),
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = stringResource(R.string.paco_frevo_descricao),
                        style = MaterialTheme.typography.titleMedium.copy(fontSize = 14.sp),
                    )
                }
                // Imagem do Museu Cais do Sertão
                Spacer(modifier = Modifier.height(40.dp))
                Image(
                    painter = painterResource(id = R.drawable.cais_do_sertao),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.cais_sertao),
                        style = MaterialTheme.typography.titleMedium.copy(fontSize = 20.sp),
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = stringResource(R.string.cais_sertao_descricao),
                        style = MaterialTheme.typography.titleMedium.copy(fontSize = 14.sp),
                    )
                }
                // Imagem Museu da Cidade do Recife
                Spacer(modifier = Modifier.height(40.dp))
                Image(
                    painter = painterResource(id = R.drawable.cidade_do_recife),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(300.dp)
                        .padding(start = 8.dp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.cidade_do_recife),
                        style = MaterialTheme.typography.titleMedium.copy(fontSize = 20.sp),
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = stringResource(R.string.cidade_do_recife_descricao),
                        style = MaterialTheme.typography.titleMedium.copy(fontSize = 14.sp),
                    )
                }
                // Imagem Museu do Homem do Nordeste
                Spacer(modifier = Modifier.height(40.dp))
                Image(
                    painter = painterResource(id = R.drawable.homem_do_nordeste2),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(300.dp)
                        .padding(start = 8.dp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.homem_nordeste),
                        style = MaterialTheme.typography.titleMedium.copy(fontSize = 20.sp),
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = stringResource(R.string.homem_nordeste_descricao),
                        style = MaterialTheme.typography.titleMedium.copy(fontSize = 14.sp),
                    )
                }
                // Imagem Museu Gilberto Freyre
                Spacer(modifier = Modifier.height(40.dp))
                Image(
                    painter = painterResource(id = R.drawable.gilberto_freyre),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(300.dp)
                        .padding(start = 8.dp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.gilberto_freyre),
                        style = MaterialTheme.typography.titleMedium.copy(fontSize = 20.sp),
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = stringResource(R.string.gilberto_freyre_descricao),
                        style = MaterialTheme.typography.titleMedium.copy(fontSize = 14.sp),
                    )
                }
            }
        }
    }
}

@Composable
fun BoxNavegacao(onClick: () -> Unit, backgroundColor: Color, icon: ImageVector) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .clickable { onClick() }
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(16.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFFEABC17)
        )
    }
}

@Preview
@Composable
fun TelaInicialPreview(){
    TelaInicial(
        onStartOrderButtonClicked = {},
        onScreenStarClicked = {},
        onScreenShoplicked = {},
        onScreenTicketsClicked = {},
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .fillMaxSize()
    )

}

@Preview
@Composable
fun TelaInicialThemePreview() {
    LunchTrayTheme(darkTheme = false) {
        TelaInicial(
            onStartOrderButtonClicked = {},
            onScreenStarClicked = {},
            onScreenShoplicked = {},
            onScreenTicketsClicked = {},
        )
    }
}

@Preview
@Composable
fun TelaInicialDarkThemePreview() {
    LunchTrayTheme(darkTheme = true) {
        TelaInicial(
            onStartOrderButtonClicked = {},
            onScreenStarClicked = {},
            onScreenShoplicked = {},
            onScreenTicketsClicked = {},
        )
    }
}
