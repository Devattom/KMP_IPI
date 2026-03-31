package com.amonteiro.a03_kmp_mprolead_g1.presentation.ui.screens

import a03_kmp_mprolead_g1.composeapp.generated.resources.Res
import a03_kmp_mprolead_g1.composeapp.generated.resources.error
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.amonteiro.a03_kmp_mprolead_g1.data.remote.PhotographerDTO
import com.amonteiro.a03_kmp_mprolead_g1.presentation.viewmodel.MainViewModel
import org.jetbrains.compose.resources.painterResource

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
            PictureRowItem(data = it)
        }
    }
}

@Composable //Composable affichant 1 élément
fun PictureRowItem(modifier: Modifier = Modifier, data: PhotographerDTO) {

    Row(modifier = modifier.fillMaxWidth()) {

        //Permission Internet nécessaire
        AsyncImage(
            model = data.photoUrl,
            //Pour aller le chercher dans string.xml R de votre package com.nom.projet
            //contentDescription = getString(R.string.picture_of_cat),
            //En dur
            contentDescription = "une photo de chat",
            contentScale = ContentScale.FillWidth,

            //Pour toto.png. Si besoin de choisir l'import pour la classe R, c'est celle de votre package
            //Image d'échec de chargement qui sera utilisé par la preview
            error = painterResource(Res.drawable.error),
            //Image d'attente.
            //placeholder = painterResource(R.drawable.toto),

            onError = { println(it) },
            modifier = Modifier
                .heightIn(max = 100.dp)
                .widthIn(max = 100.dp)
        )
        Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Text(text = data.stageName, fontSize = 20.sp, color = Color.Black)
            Text(text = data.story.take(20) + "...", fontSize = 14.sp, color = Color.Blue)
        }
    }
}