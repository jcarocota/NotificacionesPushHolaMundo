package com.ebc.notificacionespushholamundo

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.ebc.notificacionespushholamundo.ui.theme.NotificacionesPushHolaMundoTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //Traer el estado del permiso
            var tengoPermiso by remember {
                mutableStateOf(
                    ContextCompat.checkSelfPermission(
                        this,
                        Manifest.permission.POST_NOTIFICATIONS
                    ) == PackageManager.PERMISSION_GRANTED
                )
            }

            //Preguntar al usuario si me da permiso de notificar
            val permisoLaucher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.RequestPermission(),
                onResult = { meDioPermiso ->
                    tengoPermiso = meDioPermiso
                }
            )

            LaunchedEffect(key1 = true) {
                permisoLaucher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }


            NotificacionesPushHolaMundoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BotonesPrueba(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BotonesPrueba(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val notificacionService = NotificacionService(context)

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {notificacionService.lanzarNotificacionBasica()}
        ) {
            Text("Notificación básica")
        }
        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {notificacionService.lanzarNotificacionGrande()}
        ) {
            Text("Notificación grande")
        }
        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {}
        ) {
            Text("Notificación inbox")
        }
        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {}
        ) {
            Text("Notificación Imagen")
        }
        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {}
        ) {
            Text("Notificación con worker")
        }
    }
}

