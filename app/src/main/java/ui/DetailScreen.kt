package com.example.kulinerapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kulinerapp.Kuliner

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    kuliner: Kuliner?,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detail Kuliner") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Kembali")
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            // Menangani non-happy path / kondisi data tidak ditemukan (invalid ID)
            if (kuliner == null) {
                Text(
                    text = "Data kuliner tidak ditemukan atau ID tidak valid.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.error
                )
            } else {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = kuliner.nama, style = MaterialTheme.typography.headlineMedium)
                    Text(text = "Kategori: ${kuliner.kategori}", style = MaterialTheme.typography.bodyLarge)
                    Text(text = "Harga: Rp ${kuliner.harga}", style = MaterialTheme.typography.bodyLarge)
                    Text(text = "Lokasi: ${kuliner.lokasi}", style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = kuliner.deskripsi, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}