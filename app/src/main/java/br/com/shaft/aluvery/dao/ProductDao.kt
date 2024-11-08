package br.com.shaft.aluvery.dao

import br.com.shaft.aluvery.models.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

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