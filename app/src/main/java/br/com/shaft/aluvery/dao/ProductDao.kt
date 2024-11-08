package br.com.shaft.aluvery.dao

import androidx.compose.runtime.mutableStateListOf
import br.com.shaft.aluvery.models.Product
import br.com.shaft.aluvery.sampledata.sampleProducts
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.toList

class ProductDao {

    companion object {
        // Exemplo de como iniciar um mutableStateListOf com um array de objetos
//        private val products = mutableStateListOf(*sampleProducts.toTypedArray())

        private val products = MutableStateFlow<List<Product>>(emptyList())
    }

    fun products(): StateFlow<List<Product>> = products.asStateFlow()

    fun save(product: Product) {
        products.value += product
    }
}