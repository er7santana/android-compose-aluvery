package br.com.shaft.aluvery.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.shaft.aluvery.dao.ProductDao
import br.com.shaft.aluvery.models.Product
import br.com.shaft.aluvery.sampledata.sampleCandies
import br.com.shaft.aluvery.sampledata.sampleDrinks
import br.com.shaft.aluvery.sampledata.sampleProducts
import br.com.shaft.aluvery.ui.states.HomeScreenUiState
import kotlinx.coroutines.launch

class HomeScreenViewModel: ViewModel() {

    private val dao = ProductDao()

    var uiState: HomeScreenUiState by mutableStateOf(HomeScreenUiState(
        onSearchChange = {
            uiState = uiState.copy(searchText = it, filteredProducts = filteredProducts(it))
        }
    ))
        private set

    init {
        viewModelScope.launch {
            dao.products().collect { products ->
                val sections = mapOf(
                    "Todos os produtos" to products,
                    "Promoções" to sampleDrinks + sampleCandies,
                    "Doces" to sampleDrinks,
                    "Bebidas" to sampleCandies
                )
                uiState = uiState.copy(sections = sections, filteredProducts = filteredProducts(uiState.searchText))
            }
        }
    }

    private fun containsInNameOrDescription(searchText: String) = { product: Product ->
        product.name.contains(searchText, ignoreCase = true) || product.description?.contains(
            searchText, ignoreCase = true
        ) ?: false
    }

    private fun filteredProducts(searchText: String): List<Product> {
        return if (searchText.isNotBlank()) {
            sampleProducts.filter(containsInNameOrDescription(uiState.searchText)) +
                    dao.products().value.filter(containsInNameOrDescription(uiState.searchText))
        } else emptyList()
    }
}