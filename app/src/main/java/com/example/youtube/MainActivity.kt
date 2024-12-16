package com.example.youtube

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YoutubeTheme {
                Scaffold(
                    topBar = { TopBar() },
                    bottomBar = { BottomNavigationBar() }
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
            IconButton(onClick = { },
                modifier = Modifier.padding(end = 10.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.cast_24),
                    contentDescription = "Ajustes",
                    tint = Color.White
                )
            }
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(end = 10.dp)) {
                BadgedBox(badge = { Badge { Text("9+") } }) {
                    Icon(
                        painter = painterResource(id = R.drawable.notifications_24),
                        contentDescription = "N",
                        tint = Color.White
                    )
                }
            }

            IconButton(onClick = {  }) {
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
        Text(text = label, color = Color.White, fontSize = 10.sp)
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(10.dp)
    ) {
        CategoriesSection()

        VideoItem(
            title = "Hay viajes que son mejores en un Airbnb.",
            thumbnailRes = R.drawable.paris
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedButton(
                onClick = {  },
                modifier = Modifier
                    .weight(1f)
                    .height(35.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
            ) {
                Text(
                    text = "Mirar",
                    color = Color(0xFF009DCF)
                )
            }

            Button(
                onClick = { },
                modifier = Modifier
                    .weight(1f)
                    .height(35.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF009DCF))
            ) {
                Text(text = "Reservar",
                    color = Color.Black)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

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
                    modifier = Modifier.padding(start = 4.dp),
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Row(modifier = Modifier.fillMaxWidth()) {

            Box(modifier = Modifier
                .weight(1f)
                .height(350.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bromas),
                    contentDescription = "El bromas",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Mira el trailer completo ahora mismo",
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(8.dp),
                    color = Color.White,
                    fontSize = 12.sp,
                    lineHeight = 14.sp
                )
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp),
                    tint = Color.White
                )
            }

            Box(modifier = Modifier
                .weight(1f)
                .height(350.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mundo),
                    contentDescription = "Descripción de la imagen 2",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Hola mundo en diferentes lenguajes de programación",
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(8.dp),
                    color = Color.White,
                    fontSize = 12.sp,
                    lineHeight = 14.sp
                )
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp),
                    tint = Color.White
                )
            }
        }

    }
}


@SuppressLint("InvalidColorHexValue")
@Composable
fun CategoriesSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        IconButton(
            onClick = { },
            modifier = Modifier.size(48.dp).clip(RectangleShape),
            colors = IconButtonDefaults.iconButtonColors(containerColor = Color(0xFF352B2B))
        ) {
            Icon(
                painter = painterResource(id = R.drawable.explore_24),
                contentDescription = "Notificaciones",
                tint = Color.White
            )
        }


        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(5.dp),
        ) {
            Text("Todos")
        }
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 4.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF352B2B)),
            shape = RoundedCornerShape(5.dp)
        ) {
            Text("Novedad")
        }
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 4.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF352B2B)),
            shape = RoundedCornerShape(5.dp)
        ) {
            Text("Música")
        }
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF352B2B)),
            shape = RoundedCornerShape(5.dp)
        ) {
            Text("En tiempo real")
        }
    }
}

@Composable
fun VideoItem(title: String, thumbnailRes: Int) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Image(
            painter = painterResource(id = thumbnailRes),
            contentDescription = title,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(R.drawable.airbnb),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White,
                    fontSize = 11.sp,)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "¿Por que quedarse en la zona turistica si podran ir a un Airbnb?",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Gray,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Patroncinado",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White,
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Bold
                )

            }
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "User Icon",
                tint = Color(Color.White.value)
            )
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMainActivity() {
    YoutubeTheme {
        MainContent()
    }
}
