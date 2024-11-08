package br.com.shaft.aluvery.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import br.com.shaft.aluvery.ui.screens.ProductFormScreen
import br.com.shaft.aluvery.ui.theme.AluveryTheme
import br.com.shaft.aluvery.ui.viewmodels.ProductFormScreenViewModel

class ProductFormActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    val viewModel by viewModels<ProductFormScreenViewModel>()
                    ProductFormScreen(Modifier, viewModel, onSaveClick = {
                        finish()
                    })
                }
            }
        }
    }
}