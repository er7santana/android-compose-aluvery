package br.com.shaft.aluvery.ui.screens

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import br.com.shaft.aluvery.ui.states.ProductFormScreenUiState
import br.com.shaft.aluvery.ui.theme.AluveryTheme
import br.com.shaft.aluvery.ui.viewmodels.ProductFormScreenViewModel
import coil3.compose.AsyncImage

@Composable
fun ProductFormScreen(
    modifier: Modifier = Modifier,
    viewModel: ProductFormScreenViewModel,
    onSaveClick: () -> Unit = {}
) {

    val state by viewModel.uiState.collectAsState()
    ProductFormScreen(
        modifier = modifier,
        state = state,
        onSaveClick = {
            viewModel.save()
            onSaveClick()
        }
    )
}

@Composable
fun ProductFormScreen(
    modifier: Modifier = Modifier,
    state: ProductFormScreenUiState = ProductFormScreenUiState(),
    onSaveClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {

        Text(
            "Criando o produto",
            fontSize = 28.sp
        )

        if (state.isShowImage()) {
            AsyncImage(
                model = state.url,
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
            state.url,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Url da imagem")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Uri,
                imeAction = ImeAction.Next
            ),
            onValueChange = { state.onUrlValueChange(it) }
        )
        TextField(
            state.name,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Nome")
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
            onValueChange = { state.onNameValueChange(it) }
        )
        TextField(
            state.price,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Preço")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            ),
            isError = state.isPriceError,
            onValueChange = { state.onPriceValueChange(it) }
        )
        if (state.isPriceError) {
            Text(
                text = "Preço deve ser um número decimal",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        TextField(
            state.description,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(100.dp),
            label = {
                Text("Descrição")
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences,
            ),
            onValueChange = { state.onDescriptionValueChange(it) }
        )
        Button(onClick = {
            onSaveClick()
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
            ProductFormScreen(state = ProductFormScreenUiState())
        }
    }
}