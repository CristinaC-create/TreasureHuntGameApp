
package com.cristinacabral.treasurehuntgameapp.ui.end

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun EndScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Congratulations!", fontSize = 28.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text("You found the treasure!", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { navController.navigate("start") }) {
            Text("Play Again")
        }
    }
}