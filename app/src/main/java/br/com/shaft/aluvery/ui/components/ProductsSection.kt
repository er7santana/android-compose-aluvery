package br.com.shaft.aluvery.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.shaft.aluvery.R
import br.com.shaft.aluvery.models.Product
import br.com.shaft.aluvery.ui.theme.AluveryTheme
import java.math.BigDecimal


@Composable
fun ProductsSection(products: List<Product>) {
    Column {
        Text(
            "Promoções",
            Modifier.padding(
                horizontal = 16.dp
            ),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )

        Row(
            Modifier
                .padding(
                    top = 8.dp,
                )
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
            ,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            products.forEach { product ->
                ProductItem(product)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductsSectionPreview() {
    AluveryTheme {
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