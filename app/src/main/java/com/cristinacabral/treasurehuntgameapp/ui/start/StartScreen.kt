package com.cristinacabral.treasurehuntgameapp.ui.start

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.cristinacabral.treasurehuntgameapp.ui.basescreen.BaseScreen  // ✅ Correct import

@Composable
fun StartScreen(navController: NavHostController) {
    BaseScreen {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Treasure Hunt", fontSize = 32.sp)
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = { navController.navigate("hunt") }) {
                Text("Start Hunt")
            }
        }
    }
}