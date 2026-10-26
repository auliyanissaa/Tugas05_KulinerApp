# Katalog Kuliner Jakarta 🍜

Aplikasi katalog kuliner modern berbasis Android yang dibangun menggunakan **Kotlin** dan **Jetpack Compose**. Aplikasi ini dirancang untuk menampilkan daftar tempat kuliner khas dan populer di Jakarta, lengkap dengan navigasi *type-safe*, tampilan detail informasi, serta formulir interaktif untuk menambah data kuliner baru.

Project ini dibuat untuk memenuhi **Tugas 05 Mata Kuliah Pemrograman Bergerak**.

---

## 📌 Tema Aplikasi

**Katalog Kuliner Jakarta** adalah aplikasi *mobile* interaktif yang memfasilitasi pengguna dalam menjelajahi berbagai rekomendasi tempat makan dan hidangan kuliner di area Jakarta. 

---

## ✨ Fitur-Fitur Utama

* **Daftar Kuliner (Home Screen):** Menampilkan daftar rekomendasi tempat kuliner dalam bentuk kartu list yang responsif menggunakan `LazyColumn`.
* **Detail Kuliner (Detail Screen):** Menampilkan informasi rinci mengenai tempat kuliner yang dipilih, mencakup nama, kategori, estimasi harga, lokasi/alamat lengkap, serta deskripsi hidangan.
* **Form Tambah Kuliner (Form Screen):** Formulir interaktif dengan validasi input (*real-time button state*) untuk menambahkan data tempat kuliner baru ke dalam daftar.
* **Navigasi Type-Safe:** Menggunakan Jetpack Navigation Compose versi terbaru dengan pendekatan *type-safe routing* berbasis `@Serializable` data class/object.

---

## 🗺️ Daftar Rute / Destination

Aplikasi ini terdiri dari 3 destinasi utama yang dikelola melalui `NavHost`:

| Destination Route | Class / Object | Deskripsi & Parameter |
| :--- | :--- | :--- |
| **Home** | `Screen.Home` | Halaman utama yang memuat daftar katalog kuliner. |
| **Detail** | `Screen.Detail(kulinerId: Int)` | Halaman detail informasi kuliner. Menerima argumen *type-safe* `kulinerId` (`Int`). |
| **Form** | `Screen.Form` | Halaman formulir input tempat/kuliner baru. |

---

## 🚀 Cara Menjalankan Project (Clone & Build)

Ikuti langkah-langkah berikut untuk menjalankan project ini di komputer lokal Anda:

1. **Clone Repository**
   Buka terminal/command prompt dan jalankan perintah:
   ```bash
   git clone https://github.com/auliyanissaa/Tugas05_KulinerApp.git
   ```

2. **Buka Project di Android Studio**
   * Jalankan **Android Studio** (disarankan versi *Hedgehog*, *Iguana*, *Jellyfish*, atau yang lebih baru).
   * Pilih menu **Open** dan pilih direktori folder `Tugas05_KulinerApp`.

3. **Gradle Sync**
   Tunggu beberapa saat hingga proses **Gradle Sync** dan *indexing* selesai secara otomatis. Pastikan komputer terhubung ke internet.

4. **Jalankan Aplikasi**
   * Pilih Virtual Device / Emulator Android (Minimum **Android 8.0 / API Level 26**) atau sambungkan perangkat fisik melalui USB Debugging.
   * Klik tombol **Run (▶)** atau tekan `Shift + F10`.

---

## ⚠️ Known Limitations

* **In-Memory State Only:** Data kuliner disimpan menggunakan *in-memory state* (`mutableStateListOf`), sehingga data baru yang ditambahkan melalui *Form* hanya bertahan selama sesi aplikasi aktif dan akan ter-reset saat aplikasi ditutup (*re-launch*).
* **Belum Ada Persistence/Backend:** Aplikasi belum terhubung ke *database* lokal (*Room*) maupun *REST API / Cloud Server*.

---

## 👤 Pengembang

* **Nama:** Auliya Nissa
* **Repository:** [https://github.com/auliyanissaa/Tugas05_KulinerApp](https://github.com/auliyanissaa/Tugas05_KulinerApp)
