package com.ejemplo1.laboratorio5

import EventDetailScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import com.ejemplo1.laboratorio5.ui.theme.Laboratorio5Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio5Theme {
                val navController = rememberNavController()
                val drawerState = rememberDrawerState(DrawerValue.Closed)
                val scope = rememberCoroutineScope()

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        // Contenido del menú de hamburguesa
                        DrawerContent(navController)
                    }
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {
                            CenterAlignedTopAppBar(
                                title = { Text(text = "TodoEventos") },
                                navigationIcon = {
                                    IconButton(onClick = {
                                        scope.launch { drawerState.open() }
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
                        NavHost(
                            navController = navController,
                            startDestination = "main_content",
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            // Pantalla principal
                            composable("main_content") {
                                MainContent(navController = navController)
                            }
                            // Pantalla de perfil
                            composable("profile_screen") {
                                ProfileScreen()
                            }
                            // Pantalla de lista de eventos
                            composable("event_list_screen") {
                                EventListScreen(navController)
                            }
                            // Pantalla de detalles del evento
                            composable("event_detail_screen") {
                                EventDetailScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DrawerContent(navController: NavController) {
    Column(
        modifier = Modifier
            .background(Color(0xFFF0E0E0))
    ) {

        TextButton(onClick = { navController.navigate("main_content") }) {
            Text("Main Content")
        }
        TextButton(onClick = { navController.navigate("profile_screen") }) {
            Text("Profile")
        }
        TextButton(onClick = { navController.navigate("event_list_screen") }) {
            Text("Event List")
        }
    }
}
