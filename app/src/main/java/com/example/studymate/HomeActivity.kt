package com.example.studymate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Purple = Color(0xFF6C63FF)
private val Pale = Color(0xFFF7F4FF)
private val Ink = Color(0xFF24213A)
private val Muted = Color(0xFF77748B)

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { StudyMateHome() }
    }
}

@Composable
fun StudyMateHome() {
    val tasks = listOf(
        "Mengerjakan tugas Pemrograman Framework" to "Hari ini • 19.00",
        "Membaca materi IMK" to "Besok • 10.00",
        "Persiapan presentasi Project Charter" to "Jumat • 13.00"
    )
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize().background(Pale).padding(20.dp)
        ) {
            Text("Halo, teman belajar! 👋", fontSize = 25.sp, fontWeight = FontWeight.Bold, color = Ink)
            Text("Yuk, atur kegiatanmu hari ini.", fontSize = 14.sp, color = Muted,
                modifier = Modifier.padding(top = 6.dp, bottom = 20.dp))
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(containerColor = Purple)
            ) {
                Column(Modifier.padding(20.dp)) {
                    Text("Fokus hari ini", color = Color.White, fontSize = 15.sp)
                    Text("3 tugas menunggu", color = Color.White, fontSize = 24.sp,
                        fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 6.dp))
                    Text("Sedikit demi sedikit, pasti selesai.", color = Color.White.copy(alpha = 0.9f),
                        modifier = Modifier.padding(top = 6.dp))
                }
            }
            Text("Daftar tugas", fontSize = 20.sp, fontWeight = FontWeight.Bold,
                color = Ink, modifier = Modifier.padding(top = 24.dp, bottom = 12.dp))
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(tasks) { task ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier.size(42.dp).background(Color(0xFFE9E6FF), RoundedCornerShape(12.dp)),
                                contentAlignment = Alignment.Center
                            ) { Text("✓", color = Purple, fontSize = 20.sp, fontWeight = FontWeight.Bold) }
                            Column(Modifier.padding(start = 12.dp).weight(1f)) {
                                Text(task.first, color = Ink, fontWeight = FontWeight.SemiBold, fontSize = 15.sp)
                                Text(task.second, color = Muted, fontSize = 12.sp,
                                    modifier = Modifier.padding(top = 5.dp))
                            }
                        }
                    }
                }
            }
            Spacer(Modifier.height(12.dp))
            Text("Beranda  •  Tugas  •  Profil", color = Purple, fontWeight = FontWeight.SemiBold,
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(12.dp))
        }
    }
}