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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.shaft.aluvery.sampledata.sampleSections
import br.com.shaft.aluvery.ui.components.CardProductItem
import br.com.shaft.aluvery.ui.components.ProductsSection
import br.com.shaft.aluvery.ui.components.SearchTextField
import br.com.shaft.aluvery.ui.states.HomeScreenUiState
import br.com.shaft.aluvery.ui.theme.AluveryTheme
import br.com.shaft.aluvery.ui.viewmodels.HomeScreenViewModel

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel) {

    val state = viewModel.uiState
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