package com.troevpopke.feature_details.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.troevpopke.feature_details.navigation.DetailsScreen

class DetailsViewModel(
    handle: SavedStateHandle,
) : ViewModel() {

    private val route = handle.toRoute<DetailsScreen>()
}
