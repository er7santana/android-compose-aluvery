package br.com.shaft.aluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.shaft.aluvery.R
import br.com.shaft.aluvery.extensions.toBrazilianCurrency
import br.com.shaft.aluvery.models.Product
import br.com.shaft.aluvery.ui.theme.AluveryTheme
import br.com.shaft.aluvery.ui.theme.Indigo400Light
import coil3.compose.AsyncImage

@Composable
fun CardProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    elevation: Dp = 4.dp,
    isExpanded: Boolean = false
) {
    Surface(
        modifier
            .fillMaxWidth()
            .heightIn(150.dp)
            .background(Color.White),
        shape = RoundedCornerShape(15.dp),
        shadowElevation = elevation
        ) {

        var expanded by rememberSaveable { mutableStateOf(isExpanded) }

        Column(
            Modifier
                .clickable { expanded = !expanded }
        ) {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                placeholder = painterResource(id = R.drawable.ic_launcher_background),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(Indigo400Light)
                    .padding(16.dp)
            ) {
                Text(
                    text = product.name,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = product.price.toBrazilianCurrency(),
                    fontWeight = FontWeight.SemiBold
                )
            }
            if (expanded) {
                product.description?.let { description ->
                    if (description.isNotBlank()) {
                        Text(
                            text = product.description,
                            Modifier
                                .padding(16.dp),
//                        maxLines = if (expanded) Int.MAX_VALUE else 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun CardProductItemPreview() {
    AluveryTheme {
        Surface {
            CardProductItem(
                product = Product(
                    name = "Product Name",
                    price = 100.0.toBigDecimal(),
                    image = "https://www.example.com/image.jpg",
                )
            )
        }
    }
}

@Preview
@Composable
private fun CardProductItemWithDescriptionPreview() {
    AluveryTheme {
        Surface {
            CardProductItem(
                product = Product(
                    name = "Product Name",
                    price = 100.0.toBigDecimal(),
                    image = "https://www.example.com/image.jpg",
                    description = LoremIpsum(50).values.first()
                )
            )
        }
    }
}
@Preview
@Composable
private fun CardProductItemWithDescriptionExpandedPreview() {
    AluveryTheme {
        Surface {
            CardProductItem(
                product = Product(
                    name = "Product Name",
                    price = 100.0.toBigDecimal(),
                    image = "https://www.example.com/image.jpg",
                    description = LoremIpsum(50).values.first(),
                ),
                isExpanded = true
            )
        }
    }
}