package com.starter.anny.ui.bottomnav.explore.model

import androidx.annotation.DrawableRes

data class ExploreItemModel(
    @DrawableRes val image: Int,
    val itemName: String,
    val isActive: Boolean

)