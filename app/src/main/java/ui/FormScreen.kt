package com.example.kulinerapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormScreen(
    onBackClick: () -> Unit,
    onSaveClick: (String, String) -> Unit,
    onCancelClick: () -> Unit
) {
    var nama by remember { mutableStateOf("") }
    var lokasi by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tambah Kuliner Baru") }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = nama,
                onValueChange = { nama = it },
                label = { Text("Nama Kuliner") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = lokasi,
                onValueChange = { lokasi = it },
                label = { Text("Lokasi") },
                modifier = Modifier.fillMaxWidth()
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = { onSaveClick(nama, lokasi) },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Simpan")
                }

                OutlinedButton(
                    onClick = onCancelClick,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Batal")
                }
            }
        }
    }
}