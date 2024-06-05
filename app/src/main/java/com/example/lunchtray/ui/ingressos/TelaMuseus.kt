package com.example.lunchtray.ui.ingressos

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lunchtray.R
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

data class Museum(
    val id: Int,
    val name: String,
    val description: String,
    val imageRes: Int,
    val ticketPrice: Double
)

@Composable
fun TelaMuseus(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = { navController.popBackStack() },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEABC17)),
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Voltar")
        }
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
                "Casa preservada do escritor Gilberto Freyre em Apipucos, com objetos e livros originais.",
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
                R.drawable.museu_malakoff,
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

        MuseumList(museums = museums) { selectedMuseum ->
            navController.navigate("TelaConfirmaMuseu/${selectedMuseum.id}")
        }
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
