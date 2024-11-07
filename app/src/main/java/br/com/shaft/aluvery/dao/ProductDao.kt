package br.com.shaft.aluvery.dao

import androidx.compose.runtime.mutableStateListOf
import br.com.shaft.aluvery.models.Product
import br.com.shaft.aluvery.sampledata.sampleProducts

class ProductDao {

    companion object {
        // Exemplo de como iniciar um mutableStateListOf com um array de objetos
//        private val products = mutableStateListOf(*sampleProducts.toTypedArray())

        private val products = mutableStateListOf<Product>()
    }

    fun products(): List<Product> {
        return products.toList()
    }

    fun save(product: Product) {
        products.add(product)
    }
}