package br.com.shaft.aluvery.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.shaft.aluvery.models.Product
import br.com.shaft.aluvery.sampledata.sampleProducts
import br.com.shaft.aluvery.ui.theme.AluveryTheme

@Composable
fun AllProductsGrid(products: List<Product>) {
    LazyVerticalGrid(
//        columns = GridCells.Adaptive(minSize = 140.dp),
        columns = GridCells.Fixed(2),
        Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item(span = {
            GridItemSpan(maxLineSpan)
        }) {
            Text("Todos produtos",
                Modifier.fillMaxWidth(),
                fontSize = 30.sp,
                fontWeight = FontWeight(400)
            )
        }

        items(products) { product ->
            ProductItem(product)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AllProductsGridPreview() {
    AluveryTheme {
        Surface {
            AllProductsGrid(products = sampleProducts)
        }
    }
}