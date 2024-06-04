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

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.lunchtray.R
import com.example.lunchtray.ui.theme.md_theme_background_yellow



@Composable
fun TelaLojaProdutos() {

    val (isVisible, setIsVisible) = remember { mutableStateOf(false) }


    val context = LocalContext.current
    val phoneNumber = "55XXXXXXXXXXX "
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally)
        {

            if (!isVisible) {

                Button(

                    onClick = { setIsVisible(true) },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEABC17))
                   
                ) {
                    Text(text = "Entrar na loja PE")
                }
            } else {
                Column {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .shadow(elevation = 5.dp, shape = RoundedCornerShape(16.dp))
                                .background(
                                    Color(0xFFE4E4E4),
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .width(180.dp)
                                .height(330.dp)
                                .padding(16.dp)
                        ) {

                            Image(
                                painter = painterResource(id = R.drawable.livro_historia),
                                contentDescription = null,
                                modifier = Modifier
                                    //.fillMaxWidth()
                                    .size(140.dp)
                                    .padding(start = 8.dp)

                            )


                            Text(
                                modifier = Modifier
                                    .padding(top = 30.dp)
                                    .align(Alignment.Center),
                                text = "Livro História"

                            )

                            Text(
                                modifier = Modifier
                                    .padding(top = 90.dp)
                                    .align(Alignment.Center),
                                text = "Apenas  20$ Reais",


                                )

                            Button(

                                onClick = {

                                    val uri = Uri.parse("https://wa.me/$phoneNumber")
                                    val intent = Intent(Intent.ACTION_VIEW, uri)
                                    startActivity(context, intent, null)
                                },
                                modifier = Modifier
                                    .width(120.dp)
                                    .padding(5.dp)
                                    .height(35.dp)

                                    .align(Alignment.BottomCenter), shape = RoundedCornerShape(6.dp),
                                colors = ButtonDefaults.buttonColors(Color.Green)

                            ) {
                                Text("Contato")
                            }

                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Box(
                            modifier = Modifier
                                .shadow(elevation = 5.dp, shape = RoundedCornerShape(16.dp))
                                .background(
                                    Color(0xFFE4E4E4),
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .width(180.dp)
                                .padding(16.dp)
                                .height(300.dp)


                        ) {

                            Image(
                                painter = painterResource(id = R.drawable.livro_sebastiao),
                                contentDescription = null,
                                modifier = Modifier
                                    //.fillMaxWidth()
                                    .size(140.dp)
                                    .padding(start = 8.dp)
                            )

                            Text(
                                modifier = Modifier
                                    .padding(top = 30.dp)
                                    .align(Alignment.Center),
                                text = "Livro Sebastião"

                            )

                            Text(
                                modifier = Modifier
                                    .padding(top = 90.dp)
                                    .align(Alignment.Center),
                                text = "Apenas  30$ Reais",


                                )

                            Button(

                                onClick = {

                                    val uri = Uri.parse("https://wa.me/$phoneNumber")
                                    val intent = Intent(Intent.ACTION_VIEW, uri)
                                    startActivity(context, intent, null)
                                },
                                modifier = Modifier
                                    .width(120.dp)
                                    .padding(5.dp)
                                    .height(35.dp)

                                    .align(Alignment.BottomCenter), shape = RoundedCornerShape(6.dp),
                                colors = ButtonDefaults.buttonColors(Color.Green)

                            ) {
                                Text("Contato")
                            }
                        }
                    }

                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .shadow(elevation = 5.dp, shape = RoundedCornerShape(16.dp))
                                .background(
                                    Color(0xFFE4E4E4),
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .width(180.dp)
                                .height(330.dp)
                                .padding(16.dp)
                        ) {

                            Image(
                                painter = painterResource(id = R.drawable.livro_artista),
                                contentDescription = null,
                                modifier = Modifier
                                    //.fillMaxWidth()
                                    .size(140.dp)
                                    .padding(start = 8.dp)
                            )


                            Text(
                                modifier = Modifier
                                    .padding(top = 8.dp)
                                    .align(Alignment.Center),
                                text = "Livro do artista"

                            )

                            Text(
                                modifier = Modifier
                                    .padding(top = 90.dp)
                                    .align(Alignment.Center),
                                text = "Apenas  40$ Reais",


                                )

                            Button(

                                onClick = {

                                    val uri = Uri.parse("https://wa.me/$phoneNumber")
                                    val intent = Intent(Intent.ACTION_VIEW, uri)
                                    startActivity(context, intent, null)
                                },
                                modifier = Modifier
                                    .width(120.dp)
                                    .padding(5.dp)
                                    .height(35.dp)

                                    .align(Alignment.BottomCenter), shape = RoundedCornerShape(6.dp),
                                colors = ButtonDefaults.buttonColors(Color.Green)

                            ) {
                                Text("Contato")
                            }

                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Box(
                            modifier = Modifier
                                .shadow(elevation = 5.dp, shape = RoundedCornerShape(16.dp))

                                .background(
                                    Color(0xFFE4E4E4),
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .width(180.dp)
                                .padding(16.dp)
                                .height(300.dp)


                        ) {


                            Image(
                                painter = painterResource(id = R.drawable.livro_tarsila),
                                contentDescription = null,
                                modifier = Modifier
                                    //.fillMaxWidth()
                                    .size(140.dp)
                                    .padding(start = 8.dp)

                            )

                            Text(
                                modifier = Modifier
                                    .padding(start = 8.dp)
                                    .align(Alignment.Center),
                                text = "Livro Tarsila",


                                )

                            Text(
                                modifier = Modifier
                                    .padding(top = 90.dp)
                                    .align(Alignment.Center),
                                text = "Apenas  50$ Reais",


                                )

                            Button(

                                onClick = {

                                    val uri = Uri.parse("https://wa.me/$phoneNumber")
                                    val intent = Intent(Intent.ACTION_VIEW, uri)
                                    startActivity(context, intent, null)
                                },
                                modifier = Modifier
                                    .width(120.dp)
                                    .padding(5.dp)
                                    .height(35.dp)

                                    .align(Alignment.BottomCenter), shape = RoundedCornerShape(6.dp),
                                colors = ButtonDefaults.buttonColors(Color.Green)

                            ) {
                                Text("Contato")
                            }
                        }
                    }
                }
            }

        }
    }



}





@Preview
@Composable
private fun LojaScreenPreview() {
    TelaLojaProdutos()
}





