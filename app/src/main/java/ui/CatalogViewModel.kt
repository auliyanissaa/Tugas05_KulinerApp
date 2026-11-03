package com.example.kulinerapp.ui

import androidx.lifecycle.ViewModel
import com.example.kulinerapp.Kuliner
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CatalogViewModel : ViewModel() {

    // MutableStateFlow private agar hanya ViewModel yang bisa mengubah isinya (UDF principle)
    private val _uiState = MutableStateFlow(CatalogUiState())

    // StateFlow read-only yang akan dibaca oleh Compose UI
    val uiState: StateFlow<CatalogUiState> = _uiState.asStateFlow()

    init {
        // Memuat data awal kuliner (mengambil data dari data list yang sudah ada)
        loadInitialData()
    }

    private fun loadInitialData() {
        // Contoh data awal kuliner Jakarta (bisa disesuaikan dengan data kuliner kamu sebelumnya)
        val initialList = listOf(
            Kuliner(id = 1, nama = "Nasi Goreng Kambing Kebon Sirih", kategori = "Makanan Berat", harga = 35000, lokasi = "Menteng, Jakarta Pusat"),
            Kuliner(id = 2, nama = "Soto Betawi H. Husein", kategori = "Makanan Berat", harga = 40000, lokasi = "Manggarai, Jakarta Selatan"),
            Kuliner(id = 3, nama = "Kerak Telor Kemayoran", kategori = "Camilan", harga = 25000, lokasi = "Kemayoran, Jakarta Pusat")
        )

        _uiState.update { currentState ->
            currentState.copy(kulinerList = initialList)
        }
    }

    // Contoh event untuk memperbarui pencarian/filter
    fun onSearchQueryChanged(query: String) {
        _uiState.update { currentState ->
            currentState.copy(searchQuery = query)
        }
    }

    // --- FUNGSI TAMBAHAN UNTUK MENAMBAH KULINER BARU DARI FORM ---
    fun addKuliner(nama: String, lokasi: String) {
        val newItem = Kuliner(
            id = (_uiState.value.kulinerList.maxOfOrNull { it.id } ?: 0) + 1,
            nama = nama,
            kategori = "Kuliner Baru",
            harga = 25000,
            lokasi = lokasi,
            deskripsi = "Tempat kuliner baru yang ditambahkan via form."
        )

        _uiState.update { currentState ->
            currentState.copy(
                kulinerList = currentState.kulinerList + newItem
            )
        }
    }
}