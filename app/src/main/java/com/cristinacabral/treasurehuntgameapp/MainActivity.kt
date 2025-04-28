package com.cristinacabral.treasurehuntgameapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cristinacabral.treasurehuntgameapp.ui.hunt.HuntScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TreasureHuntApp()
        }
    }
}

@Composable
fun TreasureHuntApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "start") {
        composable("start") { StartScreen(navController = navController) }
        composable("hunt") { HuntScreen(navController = navController) } // ✅ HERE
        composable("end") { EndScreen(navController = navController) }
    }

}

@Composable
fun StartScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
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

@Composable
fun HuntScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Current Location: City Hall", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Hint: Find the large clock near the steps!", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { navController.navigate("end") }) {
            Text("Next Clue")
        }
    }
}

@Composable
fun EndScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
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