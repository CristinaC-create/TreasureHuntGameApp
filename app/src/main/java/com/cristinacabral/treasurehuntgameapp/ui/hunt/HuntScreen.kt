
package com.cristinacabral.treasurehuntgameapp.ui.hunt

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.cristinacabral.treasurehuntgameapp.R
import com.cristinacabral.treasurehuntgameapp.ui.basescreen.BaseScreen
import com.cristinacabral.treasurehuntgameapp.ui.clue.Clue

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

    var currentIndex by remember { mutableStateOf(0) }

    LaunchedEffect(currentIndex) {
        if (currentIndex >= clues.size) {
            navController.navigate("end")
        }
    }

    if (currentIndex >= clues.size) return

    val clue = clues[currentIndex]

    BaseScreen {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Current Location:", fontSize = 24.sp)
            Text(clue.location, fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = clue.imageResId),
                contentDescription = clue.location,
                modifier = Modifier
                    .size(250.dp)
                    .padding(16.dp)
            )

            Text("Hint:", fontSize = 20.sp)
            Text(clue.hint, fontSize = 18.sp, fontStyle = androidx.compose.ui.text.font.FontStyle.Italic)
            Spacer(modifier = Modifier.height(32.dp))

            Button(onClick = { currentIndex++ }) {
                Text("Next Clue")
            }
        }
    }
}

@Composable
fun Clue(x0: String, x1: String, x2: Int) {
    TODO("Not yet implemented")
}