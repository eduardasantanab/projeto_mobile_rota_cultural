package com.example.lunchtray.ui




import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lunchtray.R
import com.example.lunchtray.ui.theme.LunchTrayTheme
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContactPhone
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource




@Composable
fun TelaContato(
    modifier: Modifier = Modifier
) {


    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        ContatoItem(label = "Endereço", value = "123 Rota, Recife, Pernambuco")
        ContatoItem(label = "Telefone", value = "+55 81 12345678")
        ContatoItem(label = "Email", value = "rotacultural@email.com")


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                BotaoHiperlink(
                    icon = Icons.Default.ContactPhone,
                    backgroundColor = Color(0xFFEABC17),
                    link = "https://roteiro-cultural.vercel.app/#sessao2"
                )
            }
        }
    }
}




@Composable
fun BotaoHiperlink(
    link: String,
    backgroundColor: Color,
    icon: ImageVector
) {
    val uriHandler = LocalUriHandler.current
    Box(
        modifier = Modifier
            .size(50.dp)
            .clickable {
                uriHandler.openUri(link)
            }
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(16.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.Black
        )
    }
}




@Composable
fun ContatoItem(label: String, value: String) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = label, fontWeight = FontWeight.Bold)
        Text(text = value)
    }
}


@Preview
@Composable
fun TelaContatoPreview() {
    LunchTrayTheme(darkTheme = false) {
        TelaContato()
    }
}


@Preview
@Composable
fun TelaContatoDarkThemePreview() {
    LunchTrayTheme(darkTheme = true) {
        TelaContato()
    }
}

