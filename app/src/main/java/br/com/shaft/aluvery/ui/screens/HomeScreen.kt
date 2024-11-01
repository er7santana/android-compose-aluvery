package br.com.shaft.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.shaft.aluvery.R
import br.com.shaft.aluvery.models.Product
import br.com.shaft.aluvery.ui.components.ProductsSection
import java.math.BigDecimal

@Composable
fun HomeScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState(),)
            .padding(top = 16.dp, bottom = 48.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ProductsSection(listOf(
            Product(
                "Hamburguer",
                BigDecimal(14.99),
                R.drawable.burger
            ),
            Product(
                "Batata frita",
                BigDecimal(19.99),
                R.drawable.fries
            ),
            Product(
                "Pizza",
                BigDecimal(24.99),
                R.drawable.pizza
            ),
        ))
        ProductsSection(listOf(
            Product(
                "Hamburguer",
                BigDecimal(14.99),
                R.drawable.burger
            ),
            Product(
                "Batata frita",
                BigDecimal(19.99),
                R.drawable.fries
            ),
            Product(
                "Pizza",
                BigDecimal(24.99),
                R.drawable.pizza
            ),
        ))
        ProductsSection(listOf(
            Product(
                "Hamburguer",
                BigDecimal(14.99),
                R.drawable.burger
            ),
            Product(
                "Batata frita",
                BigDecimal(19.99),
                R.drawable.fries
            ),
            Product(
                "Pizza",
                BigDecimal(24.99),
                R.drawable.pizza
            ),
        ))
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}