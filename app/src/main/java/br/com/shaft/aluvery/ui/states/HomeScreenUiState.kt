package br.com.shaft.aluvery.ui.states

import br.com.shaft.aluvery.models.Product

data class HomeScreenUiState(
    val sections: Map<String, List<Product>> = emptyMap(),
    val filteredProducts: List<Product> = emptyList(),
    val searchText: String = "",
    val onSearchChange: (String) -> Unit = {}) {

    fun isShowSections(): Boolean {
        return searchText.isBlank()
    }
}