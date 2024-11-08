package br.com.shaft.aluvery.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.shaft.aluvery.dao.ProductDao
import br.com.shaft.aluvery.models.Product
import br.com.shaft.aluvery.sampledata.sampleCandies
import br.com.shaft.aluvery.sampledata.sampleDrinks
import br.com.shaft.aluvery.sampledata.sampleProducts
import br.com.shaft.aluvery.ui.states.HomeScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel: ViewModel() {

    private val dao = ProductDao()

    private val _uiState: MutableStateFlow<HomeScreenUiState> = MutableStateFlow(
        HomeScreenUiState()
    )
    val uiState get() = _uiState.asStateFlow()


    init {
        _uiState.update { currentState ->
            currentState.copy(onSearchChange = {
                _uiState.value = _uiState.value.copy (
                    searchText = it,
                    filteredProducts = filteredProducts(it)
                )
            })
        }

        viewModelScope.launch {
            dao.products().collect { products ->
                val sections = mapOf(
                    "Todos os produtos" to products,
                    "Promoções" to sampleDrinks + sampleCandies,
                    "Doces" to sampleDrinks,
                    "Bebidas" to sampleCandies
                )
                _uiState.value = _uiState.value.copy(sections = sections, filteredProducts = filteredProducts(_uiState.value.searchText))
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
            sampleProducts.filter(containsInNameOrDescription(_uiState.value.searchText)) +
                    dao.products().value.filter(containsInNameOrDescription(_uiState.value.searchText))
        } else emptyList()
    }
}