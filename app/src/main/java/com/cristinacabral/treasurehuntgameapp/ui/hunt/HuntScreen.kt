package com.cristinacabral.treasurehuntgameapp.ui.hunt

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.cristinacabral.treasurehuntgameapp.R
import com.cristinacabral.treasurehuntgameapp.ui.clue.Clue

val unifiedGradient = Brush.verticalGradient(
    colors = listOf(Color(0xFFB3E5FC), Color(0xFF81D4FA))
)

@Composable
fun HuntScreen(navController: NavHostController) {
    val clues = listOf(
        Clue("Victoria Park", "Find the old bandstand!", R.drawable.victoria_park),
        Clue("Covenant Garden Market", "Seek the rainbow mural inside.", R.drawable.covenant_garden_marktet),
        Clue("Canada Life Place", "Near the main entrance lights.", R.drawable.canada_life_place),
        Clue("Museum London", "Look for a sculpture outside.", R.drawable.muesum_london),
        Clue("SpringBank Park", "At the Storybook Gardens gate.", R.drawable.springbank_park),
        Clue("Western University Gates", "Find the lion statues.", R.drawable.university_western_gates),
        Clue("Banting House", "Near the flame of hope monument.", R.drawable.banting_house),
        Clue("The Grand Theatre", "Under the classic theatre sign.", R.drawable.grand_theatre),
        Clue("Harris Park", "Where the river meets the trails.", R.drawable.harris_park),
        Clue("Gibbons Park", "Next to the footbridge.", R.drawable.gibbons_park),
        Clue("Labatt Park", "Oldest baseball diamond’s gate.", R.drawable.labbatt_park),
        Clue("Mason ville Place", "Under the clock tower entrance.", R.drawable.masonville_place),
        Clue("Fanshawe Pioneer Village", "At the old general store.", R.drawable.fanshawe_pioneer_village),
        Clue("Aeolian Hall", "Beneath the music sign.", R.drawable.aeolian_hall),
        Clue("Blackfriars Bridge", "Cross the old iron bridge.", R.drawable.blackfriars_bridge),
        Clue("Forks of the Thames", "Near the boat launch ramp.", R.drawable.forks_of_the_thames),
        Clue("Wortley Village", "Where the old post office stands.", R.drawable.wortley_village),
        Clue("Eldon House", "In the Victorian garden.", R.drawable.eldon_house),
        Clue("Victoria Hospital", "Find the healing garden.", R.drawable.victoria_hospital),
        Clue("Ivey Park", "Where the willow trees weep.", R.drawable.ivey_park)
    )

    var currentIndex by remember { mutableIntStateOf(0) }
    var userAnswer by remember { mutableStateOf("") }

    LaunchedEffect(currentIndex) {
        if (currentIndex >= clues.size) {
            navController.navigate("end")
        }
    }

    if (currentIndex >= clues.size) return

    val clue = clues[currentIndex]

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(listOf(Color(0xFFB3E5FC), Color(0xFF81D4FA)))
            )
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "🌟 Treasure Hunt Adventure!",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF004D40)
            )

            Text(
                text = "Clue ${currentIndex + 1} of ${clues.size}",
                fontSize = 16.sp,
                color = Color.DarkGray
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.95f))
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Location: ${clue.location}", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(8.dp))

                    Image(
                        painter = painterResource(id = clue.imageResId),
                        contentDescription = clue.location,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text("Hint: ${clue.hint}", fontStyle = FontStyle.Italic)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Answer Box
            OutlinedTextField(
                value = userAnswer,
                onValueChange = {
                    val it = null
                    userAnswer = it.toString()
                },
                label = { Text(text = "Please type your answer here...") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = MaterialTheme.shapes.medium)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = {
                    userAnswer = ""
                    currentIndex++
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF009688))
            ) {
                Text("Next Clue", color = Color.White)
            }
        }
    }
}