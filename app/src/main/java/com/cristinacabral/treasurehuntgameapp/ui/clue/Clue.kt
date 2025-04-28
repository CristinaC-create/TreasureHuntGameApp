package com.cristinacabral.treasurehuntgameapp.ui.clue


import androidx.annotation.DrawableRes

data class Clue(
    val location: String,
    val hint: String,
    @DrawableRes val imageResId: Int
)