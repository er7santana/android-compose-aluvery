package br.com.shaft.aluvery.ui.viewmodels

import androidx.lifecycle.ViewModel
import br.com.shaft.aluvery.ui.states.ProductFormScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.math.BigDecimal

class ProductFormScreenViewModel : ViewModel() {

    private val _uiState: MutableStateFlow<ProductFormScreenUiState> = MutableStateFlow(
        ProductFormScreenUiState()
    )
    val uiState get() = _uiState.asStateFlow()

    init {
        _uiState.update { currentState ->
            currentState.copy(
                onUrlValueChange = { url ->
                    _uiState.value = _uiState.value.copy(url = url)
                },
                onNameValueChange = { name ->
                    _uiState.value = _uiState.value.copy(name = name)
                },
                onPriceValueChange = { value ->
                    val isPriceError = try {
                        BigDecimal(value)
                        false
                    } catch (e: IllegalArgumentException) {
                        value.isNotEmpty()
                    }
                    _uiState.value = _uiState.value.copy(price = value, isPriceError = isPriceError)
                },
                onDescriptionValueChange = { description ->
                    _uiState.value = _uiState.value.copy(description = description)
                },
                onSaveClick = {
//                    val convertedPrice = try {
//                        _uiState.value.price.toDouble()
//                    } catch (e: NumberFormatException) {
//                        0.0
//                    }
//                    val product = Product(
//                        name = _uiState.value.name,
//                        image = _uiState.value.url,
//                        price = convertedPrice,
//                        description = _uiState.value.description
//                    )
                }
            )
        }
    }
}