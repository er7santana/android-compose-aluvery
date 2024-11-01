package br.com.shaft.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
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
import br.com.shaft.aluvery.extensions.toBrazilianCurrency
import br.com.shaft.aluvery.models.Product
import br.com.shaft.aluvery.ui.theme.AluveryTheme
import br.com.shaft.aluvery.ui.theme.Purple40
import br.com.shaft.aluvery.ui.theme.Purple80
import br.com.shaft.aluvery.ui.theme.Teal200
import java.math.BigDecimal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            AluveryTheme {
                Surface {
                    ProductsSection(listOf(
                        Product(
                            "Product 1",
                            BigDecimal(14.99),
                            R.drawable.ic_launcher_background
                        ),
                        Product(
                            "Product 2",
                            BigDecimal(19.99),
                            R.drawable.ic_launcher_background
                        ),
                        Product(
                            "Product 3",
                            BigDecimal(24.99),
                            R.drawable.ic_launcher_background
                        ),
                        Product(
                            "Product 4",
                            BigDecimal(29.99),
                            R.drawable.ic_launcher_background
                        ),
                        Product(
                            "Product 5",
                            BigDecimal(34.99),
                            R.drawable.ic_launcher_background
                        ),
                        Product(
                            "Product 6",
                            BigDecimal(39.99),
                            R.drawable.ic_launcher_background
                        ),
                        Product(
                            "Product 7",
                            BigDecimal(44.99),
                            R.drawable.ic_launcher_background
                        ),
                        Product(
                            "Product 8",
                            BigDecimal(49.99),
                            R.drawable.ic_launcher_background
                        ),
                        Product(
                            "Product 9",
                            BigDecimal(54.99),
                            R.drawable.ic_launcher_background
                        ),
                        Product(
                            "Product 10",
                            BigDecimal(59.99),
                            R.drawable.ic_launcher_background
                        ),
                    ))
                }
            }

        }
    }
}

@Composable
fun ProductsSection(products: List<Product>) {
    Column {
        Text(
            "Promoções",
            Modifier.padding(
                start = 16.dp,
                top = 16.dp,
                end = 16.dp
            ),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )

        Row(
            Modifier
                .padding(
                    top = 8.dp,
                    bottom = 16.dp
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
                .background(brush = Brush.horizontalGradient(listOf(Purple40, Teal200)))
                .fillMaxWidth()

            ) {
                Image(
                    painter = painterResource(product.image),
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
        ProductItem(
            product = Product(
                LoremIpsum(50).values.first(),
                BigDecimal(14.99),
                R.drawable.ic_launcher_background
            )
        )
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
