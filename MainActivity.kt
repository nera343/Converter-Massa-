package com.example.konversimassa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VolumeToMassApp()
        }
    }
}

@Composable
fun VolumeToMassApp() {
    var volumeInput by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    // Rumus: 1 liter air ≈ 1 kg
    fun convertVolumeToMass(volume: Double): Double {
        return volume * 1.0
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Konversi Volume ke Massa Air", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = volumeInput,
            onValueChange = { volumeInput = it },
            label = { Text("Masukkan Volume (liter)") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val volume = volumeInput.toDoubleOrNull()
            if (volume != null) {
                val mass = convertVolumeToMass(volume)
                result = "Massa Air: $mass kg"
            } else {
                result = "Input tidak valid!"
            }
        }) {
            Text("Konversi")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = result, style = MaterialTheme.typography.bodyLarge)
    }
}
