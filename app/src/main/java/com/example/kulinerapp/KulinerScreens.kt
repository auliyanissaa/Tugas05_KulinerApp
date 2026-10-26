package com.example.kulinerapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    kulinerList: List<Kuliner>,
    onItemClick: (Int) -> Unit,
    onAddClick: () -> Unit
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(onClick = onAddClick) {
                    Icon(Icons.Default.Add, contentDescription = "Tambah Kuliner")
                }
            }
        ) { padding ->
            Column(modifier = Modifier.padding(padding).padding(16.dp)) {
                Text(text = "Katalog Kuliner Jakarta", style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(16.dp))
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(kulinerList, key = { it.id }) { item ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { onItemClick(item.id) },
                            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(text = item.nama, style = MaterialTheme.typography.titleMedium)
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(text = "${item.kategori} • Rp ${item.harga}", style = MaterialTheme.typography.bodyMedium)
                                Text(text = item.lokasi, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.outline)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DetailScreen(
    kuliner: Kuliner?,
    onBackClick: () -> Unit
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Button(onClick = onBackClick) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Kembali")
                Spacer(modifier = Modifier.width(4.dp))
                Text("Kembali")
            }
            Spacer(modifier = Modifier.height(16.dp))
            if (kuliner == null) {
                Text(text = "Data Kuliner tidak ditemukan!", style = MaterialTheme.typography.titleMedium)
            } else {
                Text(text = kuliner.nama, style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Kategori: ${kuliner.kategori}", style = MaterialTheme.typography.titleMedium)
                Text(text = "Harga: Rp ${kuliner.harga}", style = MaterialTheme.typography.titleMedium)
                Text(text = "Lokasi: ${kuliner.lokasi}", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Deskripsi:", style = MaterialTheme.typography.titleSmall)
                Text(text = kuliner.deskripsi, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Composable
fun FormScreen(
    onSaveClick: (String, String) -> Unit,
    onCancelClick: () -> Unit
) {
    var namaText by remember { mutableStateOf("") }
    var lokasiText by remember { mutableStateOf("") }
    val isFormValid = namaText.isNotBlank() && lokasiText.isNotBlank()

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = "Tambah Tempat Kuliner", style = MaterialTheme.typography.titleLarge)
            OutlinedTextField(
                value = namaText,
                onValueChange = { namaText = it },
                label = { Text("Nama Tempat / Kuliner") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            OutlinedTextField(
                value = lokasiText,
                onValueChange = { lokasiText = it },
                label = { Text("Lokasi / Alamat") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                OutlinedButton(onClick = onCancelClick) {
                    Text("Batal")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { onSaveClick(namaText, lokasiText) },
                    enabled = isFormValid
                ) {
                    Text("Simpan")
                }
            }
        }
    }
}