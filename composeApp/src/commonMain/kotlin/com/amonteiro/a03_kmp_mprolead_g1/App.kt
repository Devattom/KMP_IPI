package com.amonteiro.a03_kmp_mprolead_g1

import a03_kmp_mprolead_g1.composeapp.generated.resources.Res
import a03_kmp_mprolead_g1.composeapp.generated.resources.compose_multiplatform
import a03_kmp_mprolead_g1.composeapp.generated.resources.error
import a03_kmp_mprolead_g1.composeapp.generated.resources.my_label
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource


@Preview
@Composable
fun App() {
    MaterialTheme {
        //SearchScreen()

        var showContent by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text("Compose: $greeting ")
                    Text(stringResource(Res.string.my_label))
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Image(painterResource(Res.drawable.error), null)
                }
            }
        }
    }
}