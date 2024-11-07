package br.com.shaft.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.shaft.aluvery.models.Product
import br.com.shaft.aluvery.sampledata.sampleCandies
import br.com.shaft.aluvery.sampledata.sampleDrinks
import br.com.shaft.aluvery.sampledata.sampleProducts
import br.com.shaft.aluvery.sampledata.sampleSections
import br.com.shaft.aluvery.ui.components.CardProductItem
import br.com.shaft.aluvery.ui.components.ProductsSection
import br.com.shaft.aluvery.ui.components.SearchTextField
import br.com.shaft.aluvery.ui.theme.AluveryTheme

class HomeScreenUiState(
    val sections: Map<String, List<Product>> = emptyMap(),
    val filteredProducts: List<Product> = emptyList(),
    val searchText: String = "",
    val onSearchChange: (String) -> Unit = {}) {

    fun isShowSections(): Boolean {
        return searchText.isBlank()
    }
}

@Composable
fun HomeScreen(products: List<Product>) {
    val sections = mapOf(
        "Todos produtos" to products,
        "Promoções" to sampleDrinks + sampleCandies,
        "Doces" to sampleCandies,
        "Bebidas" to sampleDrinks,
    )

    var searchText by remember { mutableStateOf("") }

    fun containsInNameOrDescription() = { product: Product ->
        product.name.contains(searchText, ignoreCase = true) || product.description?.contains(
            searchText, ignoreCase = true
        ) ?: false
    }

    val filteredProducts = remember(searchText, products) {
        if (searchText.isNotBlank()) {
            sampleProducts.filter(containsInNameOrDescription()) +
                    products.filter(containsInNameOrDescription())
        } else emptyList()
    }

    val state = remember(products, searchText) { HomeScreenUiState(
        sections = sections,
        filteredProducts = filteredProducts,
        searchText = searchText,
        onSearchChange = { searchText = it }
    ) }
    HomeScreen(state)
}

@Composable
fun HomeScreen(
    state: HomeScreenUiState = HomeScreenUiState(),
) {
    Column {

        SearchTextField(state.searchText, onSearchChange = state.onSearchChange)

        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (state.isShowSections()) {
                for (section in state.sections) {
                    val title = section.key
                    val products = section.value
                    item {
                        ProductsSection(title, products)
                    }
                }
            } else {
                items(state.filteredProducts) { product ->
                    CardProductItem(product, Modifier.padding(horizontal = 16.dp))
                }
            }

            item {
                Spacer(modifier = Modifier.size(16.dp))
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(HomeScreenUiState(sections = sampleSections))
        }
    }
}
@Preview(showSystemUi = true)
@Composable
private fun HomeScreenWithSearchTextPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(state = HomeScreenUiState(sections = sampleSections, filteredProducts = emptyList(), "Abacaxi"))
        }
    }
}