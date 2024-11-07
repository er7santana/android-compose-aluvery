package br.com.shaft.aluvery.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.shaft.aluvery.dao.ProductDao
import br.com.shaft.aluvery.models.Product
import br.com.shaft.aluvery.sampledata.sampleCandies
import br.com.shaft.aluvery.sampledata.sampleDrinks
import br.com.shaft.aluvery.sampledata.sampleProducts
import br.com.shaft.aluvery.sampledata.sampleSections
import br.com.shaft.aluvery.ui.screens.HomeScreen
import br.com.shaft.aluvery.ui.screens.HomeScreenUiState
import br.com.shaft.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {

    private val dao = ProductDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(onFabClick = {
                startActivity(Intent(this, ProductFormActivity::class.java))
            }) {
                val products = dao.products()
                HomeScreen(products)
            }
        }
    }

}

@Composable
fun App(onFabClick: () -> Unit = {}, content: @Composable () -> Unit = {}) {
    AluveryTheme {
        Surface {
            Scaffold(floatingActionButton = {
                FloatingActionButton(onClick = { onFabClick() }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Adicionar")
                }
            }) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    content()
                }
            }
        }
    }
}

@Preview
@Composable
private fun AppPreview() {
    App() {
        HomeScreen(HomeScreenUiState(sections = sampleSections))
    }
}