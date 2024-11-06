package br.com.shaft.aluvery.ui.activities

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.shaft.aluvery.R
import br.com.shaft.aluvery.models.Product
import br.com.shaft.aluvery.ui.theme.AluveryTheme
import coil3.compose.AsyncImage
import java.math.BigDecimal

private const val TAG = "ProductFormScreen"

class ProductFormActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    ProductFormScreen(Modifier)
                }
            }
        }
    }
}

@Composable
fun ProductFormScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {

        var url by remember { mutableStateOf("") }
        var name by remember { mutableStateOf("") }
        var price by remember { mutableStateOf("") }
        var isPriceError by remember { mutableStateOf(false) }
        var description by remember { mutableStateOf("") }

        Text(
            "Criando o produto",
            fontSize = 28.sp
        )

        if (url.isNotBlank()) {
            AsyncImage(
                model = url,
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(R.drawable.placeholder),
                error = painterResource(R.drawable.placeholder)
            )
        }

        TextField(
            url,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Url da imagem")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Uri,
                imeAction = ImeAction.Next
            ),
            onValueChange = { url = it }
        )
        TextField(
            name,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Nome")
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
            onValueChange = { name = it }
        )
        TextField(
            price,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Preço")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            ),
            isError = isPriceError,
            onValueChange = {
                isPriceError = try {
                    BigDecimal(it)
                    false
                } catch (e:IllegalArgumentException) {
                    it.isNotEmpty()
                }
                price = it
            }
        )
        if (isPriceError) {
            Text(
                text = "Preço deve ser um número decimal",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        TextField(
            description,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(100.dp),
            label = {
                Text("Descrição")
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences,
            ),
            onValueChange = { description = it }
        )
        Button(onClick = {
            val convertedPrice = try {
                BigDecimal(price)
            } catch (e: NumberFormatException) {
                BigDecimal.ZERO
            }
            val product = Product(
                name = name,
                image = url,
                price = convertedPrice,
                description = description
            )
            Log.i(TAG, "ProductFormScreen: $product")
        }, Modifier.fillMaxWidth()) {
            Text("Salvar")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ProductFormScreenPreview() {
    AluveryTheme {
        Surface {
            ProductFormScreen()
        }
    }
}