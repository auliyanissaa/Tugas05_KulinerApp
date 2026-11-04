package com.example.kulinerapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kulinerapp.Kuliner

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    uiState: CatalogUiState,
    onKulinerClick: (Int) -> Unit,
    onAddClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Katalog Kuliner") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddClick) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Tambah Kuliner")
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Menangani non-happy path jika data kosong/empty state
            if (uiState.kulinerList.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = androidx.compose.ui.Alignment.Center
                ) {
                    Text(text = "Belum ada data kuliner.", style = MaterialTheme.typography.bodyLarge)
                }
            } else {
                // Menampilkan minimal 8 item menggunakan LazyColumn sesuai ketentuan tugas
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(uiState.kulinerList) { kuliner ->
                        KulinerItemCard(
                            kuliner = kuliner,
                            onClick = { onKulinerClick(kuliner.id) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun KulinerItemCard(
    kuliner: Kuliner,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(text = kuliner.nama, style = MaterialTheme.typography.titleMedium)
            Text(text = kuliner.kategori, style = MaterialTheme.typography.bodyMedium)
            Text(text = "Rp ${kuliner.harga}", style = MaterialTheme.typography.bodySmall)
        }
    }
}