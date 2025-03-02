package com.abdat.expressshop.main.presentation.ui.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.abdat.expressshop.main.presentation.ui.feature.home.components.HomeContent
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    state: HomeScreenUiState,
    modifier: Modifier = Modifier,
) {
    if (state.isLoading) {
        Box(
            modifier = modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {

        HomeContent(
            featured = state.featured,
            popularProducts = state.popularProducts,
            categories = state.categories,
            loadingState = state.isLoading,
            errorState = null,
            onClick = {  }
        )
    }

}

