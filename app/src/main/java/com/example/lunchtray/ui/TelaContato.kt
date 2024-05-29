package com.example.lunchtray.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.lunchtray.R
import com.example.lunchtray.ui.theme.LunchTrayTheme

@Composable
fun TelaContato(
    onStartOrderButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {

}

@Composable
fun TelaContatoApp() {

}


@Preview
@Composable
fun TelaContatoPreview() {
    LunchTrayTheme(darkTheme = false) {
        TelaContatoApp()
    }
}

@Preview
@Composable
fun TelaContatoDarkThemePreview() {
    LunchTrayTheme(darkTheme = true) {
        TelaContatoApp()
    }
}
