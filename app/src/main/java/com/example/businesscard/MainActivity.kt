package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Businesscard()
                }
            }
        }
    }
}

@Composable
fun Businesscard() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2AB0A3)),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .heightIn(min = 600.dp)
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(140.dp)
                        .background(Color.Gray, shape = CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text("Vương Quốc Huy", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text("Student", fontSize = 16.sp, color = Color.Gray)
                Spacer(modifier = Modifier.height(180.dp))
                ContactInfo(iconId = R.drawable.ic_location, text = "Ngu Hanh Son - Da Nang")
                ContactInfo(iconId = R.drawable.ic_email, text = "huyvq.23itb@vku.udn.vn")
                ContactInfo(iconId = R.drawable.ic_phone, text = "0123456789")
            }
        }
    }
}

@Composable
fun ContactInfo(iconId: Int, text: String) {
    Row(
        modifier = Modifier.padding(vertical = 4.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        Image(
            painter = painterResource(id = iconId),
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text, fontSize = 15.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Businesscard()
    }
}