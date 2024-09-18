package com.ejemplo1.laboratorio5

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainContent(navController: NavController, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Lista de favoritos
        item {
            Text(
                text = "Your favorites",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        // Eventos en LazyRow
        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(listOf(
                    Pair(R.drawable.imagen1, "Title 1" to "Supporting text 1"),
                    Pair(R.drawable.imagen2, "Title 2" to "Supporting text 2"),
                )) { (imageResId, titleAndText) ->
                    EventCard(
                        imageResId = imageResId,
                        title = titleAndText.first,
                        supportingText = titleAndText.second,
                        onClick = {
                            // Navegar a la pantalla de detalles del evento
                            navController.navigate("event_detail_screen")
                        }
                    )
                }
            }
        }

        // Lista de todos los conciertos
        item {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "All Concerts",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        items(listOf(
            Pair(R.drawable.imagen1, "Title 5" to "Supporting text 5"),
        )) { (imageResId, titleAndText) ->
            EventCard(
                imageResId = imageResId,
                title = titleAndText.first,
                supportingText = titleAndText.second,
                onClick = {
                    // Navegar a la pantalla de detalles del evento
                    navController.navigate("event_detail_screen")
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun EventCard(
    imageResId: Int,
    title: String,
    supportingText: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(8.dp),
    ) {
        Column {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier.height(120.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = title, style = MaterialTheme.typography.titleMedium)
            Text(text = supportingText, style = MaterialTheme.typography.bodySmall)
        }
    }
}
