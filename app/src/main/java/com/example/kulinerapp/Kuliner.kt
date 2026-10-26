package com.example.kulinerapp

import kotlinx.serialization.Serializable

@Serializable
data class Kuliner(
    val id: Int,
    val nama: String,
    val kategori: String,
    val harga: Int,
    val lokasi: String,
    val deskripsi: String
)

val dummyKulinerList = listOf(
    Kuliner(1, "Nasi Goreng Kambing Kebon Sirih", "Makanan Berat", 35000, "Menteng, Jakarta Pusat", "Nasi goreng kambing legendaris dengan bumbu rempah khas yang kaya rasa."),
    Kuliner(2, "Soto Betawi H. Husein", "Makanan Berat", 40000, "Setiabudi, Jakarta Selatan", "Soto kuah santan gurih dengan isian daging sapi empuk dan jeroan segar."),
    Kuliner(3, "Kerak Telor Kemayoran", "Jajanan", 25000, "Kemayoran, Jakarta Pusat", "Makanan tradisional Betawi berbahan ketan putih, telur bebek, dan serundeng gurih."),
    Kuliner(4, "Gado-Gado Bon-Bin", "Makanan Berat", 30000, "Cikini, Jakarta Pusat", "Gado-gado legendaris dengan bumbu kacang halus dan sayuran segar pilihan."),
    Kuliner(5, "Es Ragusa Es Italia", "Minuman / Dessert", 25000, "Gambir, Jakarta Pusat", "Es krim buatan tangan gaya Italia tertua di Jakarta yang beroperasi sejak 1932."),
    Kuliner(6, "Bakmi GM Sunda", "Makanan Berat", 38000, "Thamrin, Jakarta Pusat", "Bakmi legendaris dengan tekstur mi tipis dan pangsit goreng yang krispi."),
    Kuliner(7, "Sate Khas Senayan", "Makanan Berat", 60000, "Kebayoran Baru, Jakarta Selatan", "Sate ayam dengan bumbu kacang super halus khas racikan resto legendaris."),
    Kuliner(8, "Kopi Tuku Cipete", "Cafe / Minuman", 20000, "Cipete, Jakarta Selatan", "Pioneer Kopi Kenangan Mantan (Kopi Aren) lokal yang hits dan ramah kantong.")
)