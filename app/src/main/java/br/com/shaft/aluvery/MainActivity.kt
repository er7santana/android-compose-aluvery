package br.com.shaft.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import br.com.shaft.aluvery.sampledata.sampleProducts
import br.com.shaft.aluvery.sampledata.sampleSections
import br.com.shaft.aluvery.ui.components.AllProductsGrid
import br.com.shaft.aluvery.ui.screens.HomeScreen
import br.com.shaft.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    AluveryTheme {
        Surface {
            HomeScreen(sampleSections)
//            AllProductsGrid(sampleProducts)
        }
    }
}