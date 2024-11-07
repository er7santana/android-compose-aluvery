package br.com.shaft.aluvery.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import br.com.shaft.aluvery.dao.ProductDao
import br.com.shaft.aluvery.ui.screens.ProductFormScreen
import br.com.shaft.aluvery.ui.theme.AluveryTheme

class ProductFormActivity: ComponentActivity() {

    private val dao = ProductDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    ProductFormScreen(Modifier, onSaveClick = { product ->
                        dao.save(product)
                        finish()
                    })
                }
            }
        }
    }
}