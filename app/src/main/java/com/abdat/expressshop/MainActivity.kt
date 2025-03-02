package com.abdat.expressshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abdat.expressshop.main.presentation.ui.feature.home.HomeScreen
import com.abdat.expressshop.main.presentation.ui.feature.home.HomeScreenUiState
import com.abdat.expressshop.main.presentation.ui.feature.home.HomeVM
import com.abdat.expressshop.main.presentation.ui.feature.home.components.homeUiState
import com.abdat.expressshop.main.presentation.ui.theme.ExpressShopTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val vm: HomeVM = koinViewModel()
            ExpressShopTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val state = vm.uiState.collectAsStateWithLifecycle()
                    HomeScreen(state = state.value, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExpressShopTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            HomeScreen(
                state = homeUiState,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
