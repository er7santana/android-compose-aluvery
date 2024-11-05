package br.com.shaft.aluvery.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.shaft.aluvery.R
import br.com.shaft.aluvery.extensions.toBrazilianCurrency
import br.com.shaft.aluvery.models.Product
import br.com.shaft.aluvery.ui.theme.AluveryTheme
import java.math.BigDecimal

@Composable
fun ProductItem(product: Product) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp
    ) {

        Column(
            Modifier
                .heightIn(250.dp, 300.dp)
                .width(200.dp)
                .verticalScroll(rememberScrollState())
        ) {
            val imageSize = 100.dp
            Box(modifier = Modifier
                .height(imageSize)
                .background(brush = Brush.horizontalGradient(listOf(MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.secondary)))
                .fillMaxWidth()

            ) {
                Image(
                    // TODO: ajustar imagem do produto
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    Modifier
                        .size(imageSize)
                        .offset(y = (imageSize / 2))
                        .clip(shape = CircleShape)
                        .align(BottomCenter)
                        .border(2.dp, Color.White, shape = CircleShape),
                    contentScale = androidx.compose.ui.layout.ContentScale.Crop
                )
            }
            Spacer(Modifier.height(imageSize/2))
            Column(Modifier.fillMaxSize()) {
                Column(Modifier.padding(16.dp)) {
                    Text(
                        product.name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight(700),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        product.price.toBrazilianCurrency(),
                        Modifier.padding(top = 8.dp),
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
    AluveryTheme {
        Surface {
            ProductItem(
                Product(
                    name = LoremIpsum(50).values.first(),
                    price = BigDecimal(14.99),
                )
            )
        }
    }
}
