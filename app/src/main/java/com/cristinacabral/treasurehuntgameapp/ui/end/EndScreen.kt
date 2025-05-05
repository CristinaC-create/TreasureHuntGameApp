
package com.cristinacabral.treasurehuntgameapp.ui.end

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun EndScreen(navController: NavHostController, score: Int = 0) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFFB3E5FC), Color(0xFF81D4FA))
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("🎉 Congratulations!", fontSize = 28.sp, color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))
            Text("You found the treasure!", fontSize = 20.sp, color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Your Score: $score", fontSize = 22.sp, color = Color.Yellow)
            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = { navController.navigate("start") }) {
                Text("Play Again")
            }
        }
    }
}