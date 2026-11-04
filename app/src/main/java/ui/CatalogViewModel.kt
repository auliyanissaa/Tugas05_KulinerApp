package com.example.kulinerapp.ui
import com.example.kulinerapp.Kuliner
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CatalogViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CatalogUiState())
    val uiState: StateFlow<CatalogUiState> = _uiState.asStateFlow()

    init {
        loadInitialData()
    }

    private fun loadInitialData() {
        // Mengisi data awal kuliner beserta deskripsinya agar sesuai dengan model
        val initialList = listOf(
            Kuliner(
                id = 1,
                nama = "Kambing Kebon Sirih",
                kategori = "Makanan Berat",
                harga = 35000,
                lokasi = "Menteng, Jakarta Pusat",
                deskripsi = "Sate dan gulai kambing legendaris yang empuk dan kaya rempah."
            ),
            Kuliner(
                id = 2,
                nama = "Soto H. Husein",
                kategori = "Makanan Berat",
                harga = 40000,
                lokasi = "Manggarai, Jakarta Selatan",
                deskripsi = "Soto tangkar sapi legendaris dengan kuah santan gurih."
            ),
            Kuliner(
                id = 3,
                nama = "Bubur Kemayoran",
                kategori = "Camilan",
                harga = 25000,
                lokasi = "Kemayoran, Jakarta Pusat",
                deskripsi = "Bubur ayam hangat dengan suwiran ayam melimpah."
            )
        )

        _uiState.update { currentState ->
            currentState.copy(kulinerList = initialList)
        }
    }

    fun addKuliner(nama: String, lokasi: String) {
        val newItem = Kuliner(
            id = (_uiState.value.kulinerList.maxOfOrNull { it.id } ?: 0) + 1,
            nama = nama,
            kategori = "Makanan Berat", // Bisa disesuaikan
            harga = 15000, // Bisa disesuaikan
            lokasi = lokasi,
            deskripsi = "Kuliner baru ditambahkan."
        )

        _uiState.update { currentState ->
            currentState.copy(kulinerList = currentState.kulinerList + newItem)
        }
    }
}