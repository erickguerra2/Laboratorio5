package com.ejemplo1.laboratorio5

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ejemplo1.laboratorio5.ui.theme.Laboratorio5Theme

data class Event(val name: String, val location: String)

@Composable
fun EventListScreen(navController: NavHostController) {
    val events = listOf(
        Event("Tomorrowland Belgica", "Boom"),
        Event("Tomorrowland Brazil", "Rio de Janeiro"),
        Event("Tomorrowland Mexico", "Tulum")
    )

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Listado de Lugares",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        LazyColumn {
            items(events) { event ->
                EventListItem(event)
                Divider(color = Color.LightGray, thickness = 1.dp)
            }
        }
    }
}

@Composable
fun EventListItem(event: Event) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = event.name,
                style = MaterialTheme.typography.bodyLarge,
            )
            Text(
                text = event.location,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        }
        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = "Arrow Forward",
            tint = Color.Gray
        )
    }
}

