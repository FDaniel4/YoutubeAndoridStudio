package com.example.youtube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.youtube.ui.theme.YoutubeTheme
import androidx.compose.foundation.border
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.draw.clip

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YoutubeTheme {
                Scaffold(
                    topBar = { TopBar() },  // Barra de navegación superior
                    bottomBar = { BottomNavigationBar() } // Barra de navegación inferior
                ) { innerPadding ->
                    MainContent(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Image(
                painter = painterResource(id = R.drawable.logo_y),
                contentDescription = "YouTube Logo",
                modifier = Modifier.size(110.dp)
            )
        },
        navigationIcon = {  },
        actions = {
            // Ícono de cast
            IconButton(onClick = { /* Acción de ajustes */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.cast_24),
                    contentDescription = "Ajustes",
                    tint = Color.White
                )
            }
            // Ícono de notificaciones
            IconButton(onClick = { /* Acción de notificaciones */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.notifications_24),
                    contentDescription = "Notificaciones",
                    tint = Color.White
                )
            }
            // Ícono de busqueda
            IconButton(onClick = { /* Acción de búsqueda */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.search_24),
                    contentDescription = "Buscar",
                    tint = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.White
        )
    )
}



@Composable
fun BottomNavigationBar() {
    BottomAppBar(containerColor = Color.Black) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            BottomNavigationItem(iconRes = R.drawable.home_24, label = "Principal")
            BottomNavigationItem(iconRes = R.drawable.icons8_youtube_shorts_24, label = "Shorts")
            BottomNavigationItem(iconRes = R.drawable.add_circle_24, label = "")
            BottomNavigationItem(iconRes = R.drawable.subscriptions_24, label = "Suscripciones")
            BottomNavigationItem(iconRes = R.drawable.account_circle_24, label = "Perfil")
        }
    }
}

@Composable
fun BottomNavigationItem(iconRes: Int, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(painter = painterResource(id = iconRes), contentDescription = label, modifier = Modifier.size(24.dp), tint = Color.White)
        Text(text = label, color = Color.White)
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp) // Agregar padding opcional
    ) {
        // Sección de categorías
        CategoriesSection()

        // Lista de videos
        VideoItem(
            title = "Hay viajes que son mejores en un Airbnb.",
            description = "",
            thumbnailRes = R.drawable.paris // Ejemplo de imagen de video
        )

        // Fila para los botones
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .weight(1f) // Para ocupar el mismo ancho
                    .padding(end = 8.dp),
                    //.background(Color.Blue)
                colors = ButtonDefaults.buttonColors(contentColor = Color.White)
            ) {
                Text(text = "Mirar")
            }

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .weight(1f) // Para ocupar el mismo ancho
                    .padding(start = 8.dp),
                  //  .background(Color.Red),
                colors = ButtonDefaults.buttonColors(contentColor = Color.White)
            ) {
                Text(text = "Reservar")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        // Sección de texto e ícono
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icons8_youtube_shorts_24),
                    contentDescription = "Descripción del ícono",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Red
                )
                Text(
                    text = "Shorts",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }

        // Sección de imágenes en fila
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.bromas),
                contentDescription = "Descripción de la imagen 1",
                modifier = Modifier
                    .weight(1f)
                    .height(350.dp),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(id = R.drawable.mundo),
                contentDescription = "Descripción de la imagen 2",
                modifier = Modifier
                    .weight(1f)

                    .height(350.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}


@Composable
fun CategoriesSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {


        Button(onClick = { /* Acción de Todos */ }) {
            Image(
                painter = painterResource(id = R.drawable.explore_24),
                contentDescription = "Todos",
                modifier = Modifier.size(24.dp),
                contentScale = ContentScale.Crop
            )
        }
        Button(onClick = { /* Acción de Todos */ }) {
            Text("Todos")
        }
        Button(onClick = { /* Acción de Novedad */ }) {
            Text("Novedad")
        }
        Button(onClick = { /* Acción de Música */ }) {
            Text("Músic")
        }
    }
}

@Composable
fun VideoItem(title: String, description: String, thumbnailRes: Int) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Image(
            painter = painterResource(id = thumbnailRes),
            contentDescription = title,
            modifier = Modifier
                .fillMaxWidth() // Cambia a fillMaxWidth
                .height(200.dp), // Ajusta la altura según lo necesites
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(R.drawable.airbnb),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(text = title, style = MaterialTheme.typography.bodyLarge, color = Color.White) // Cambia el color aquí

                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewMainActivity() {
    YoutubeTheme {
        MainContent()

    }
}
