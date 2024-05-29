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

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.Bookmarks
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.lunchtray.ui.theme.md_theme_light_tertiary

@Composable
fun TelaInicial(
    onStartOrderButtonClicked: () -> Unit,
    onScreenMuseumClicked: () -> Unit,
    onScreenShoplicked: () -> Unit,
    onScreenTicketsClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
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
                        .padding(vertical = 30.dp)
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
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 150.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    BoxNavegacao(
                        onClick = onScreenMuseumClicked,
                        backgroundColor = Color(0xFFBBBBBB),
                        icon = Icons.Default.AccountBalance
                    )
                    BoxNavegacao(
                        onClick = onScreenShoplicked,
                        backgroundColor = Color(0xFFBBBBBB),
                        icon = Icons.Default.AddShoppingCart
                    )
                    BoxNavegacao(
                        onClick = onScreenTicketsClicked,
                        backgroundColor = Color(0xFFBBBBBB),
                        icon = Icons.Default.Bookmarks
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
        onScreenMuseumClicked = {},
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
            onScreenMuseumClicked = {},
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
            onScreenMuseumClicked = {},
            onScreenShoplicked = {},
            onScreenTicketsClicked = {},
        )
    }
}


