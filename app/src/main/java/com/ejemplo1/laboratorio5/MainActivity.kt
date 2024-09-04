package com.ejemplo1.laboratorio5

import EventDetailScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.ejemplo1.laboratorio5.ui.theme.Laboratorio5Theme

import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio5Theme {
                var showProfile by remember { mutableStateOf(true) }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = { Text(text = "TodoEventos") },
                            navigationIcon = {
                                IconButton(onClick = {
                                    // Alternar entre mostrar el contenido principal o el perfil
                                    showProfile = !showProfile
                                }) {
                                    Icon(
                                        imageVector = Icons.Filled.Menu,
                                        contentDescription = "Menú"
                                    )
                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    if (showProfile) {
                        ProfileScreen()
                    } else {
                        MainContent(modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}

