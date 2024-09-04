package com.ejemplo1.laboratorio5

import androidx.compose.foundation.Image
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

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text(
                text = "Your favorites",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

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
                        supportingText = titleAndText.second
                    )
                }
            }
        }

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
                supportingText = titleAndText.second
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun EventCard(
    imageResId: Int,
    title: String,
    supportingText: String
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .width(160.dp)
            .height(200.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "Event Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Text(
                text = supportingText,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    }
}
