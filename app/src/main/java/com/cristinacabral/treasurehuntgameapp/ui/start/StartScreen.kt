package com.cristinacabral.treasurehuntgameapp.ui.start

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


// Shared Gradient
val unifiedGradient = Brush.verticalGradient(
    colors = listOf(Color(0xFFB3E5FC), Color(0xFF81D4FA))
)

// StartScreen.kt
@Composable
fun StartScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(unifiedGradient),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("\uD83C\uDFF4\u200D\u2620\uFE0F Welcome to the Hunt!", fontSize = 32.sp, color = Color.White)
            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = { navController.navigate("hunt") },
                modifier = Modifier
                    .height(60.dp)
                    .width(220.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF0288D1),
                    contentColor = Color.White
                )
            ) {
                Text("Start Adventure", fontSize = 18.sp)
            }
        }
    }
}
