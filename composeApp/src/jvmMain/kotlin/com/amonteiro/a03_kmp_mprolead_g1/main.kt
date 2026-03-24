package com.amonteiro.a03_kmp_mprolead_g1

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "A03_kmp_mprolead_g1",
    ) {
        App()
    }
}