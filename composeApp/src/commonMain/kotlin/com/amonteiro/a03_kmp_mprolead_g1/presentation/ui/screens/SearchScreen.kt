package com.amonteiro.a03_kmp_mprolead_g1.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.amonteiro.a03_kmp_mprolead_g1.presentation.viewmodel.MainViewModel

@Preview(showBackground = true, showSystemUi = true, uiMode = 2)
@Composable
fun SearchScreenPreview() {
    //Il faut remplacer NomVotreAppliTheme par le thème de votre application
    //Utilisé par exemple dans MainActivity.kt sous setContent {...}
    MaterialTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            SearchScreen(modifier = Modifier.padding(innerPadding))
        }
    }
}

@Composable
fun SearchScreen(modifier: Modifier = Modifier, mainViewModel: MainViewModel = MainViewModel()) {
    Column(modifier= modifier) {
        println("SearchScreen()")
        Text(text = "Text1",fontSize = 20.sp, modifier = Modifier.fillMaxWidth().background(Color.Red).clickable{})
        Spacer(Modifier.size(8.dp))
        Text(text = "Text2",fontSize = 14.sp)

        val list = mainViewModel.dataList.collectAsStateWithLifecycle().value

        list.forEach {
            PictureRowItem(it.stageName)
        }
    }
}

@Composable
fun PictureRowItem(text :String){
    Text(text = text,fontSize = 20.sp, color = Color.Blue)
}