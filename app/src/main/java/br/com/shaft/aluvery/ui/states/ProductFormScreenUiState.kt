package br.com.shaft.aluvery.ui.states

data class ProductFormScreenUiState(
    val url: String = "",
    val name: String = "",
    val price: String = "",
    val description: String = "",
    val isPriceError: Boolean = false,
    val onUrlValueChange: (String) -> Unit = {},
    val onNameValueChange: (String) -> Unit = {},
    val onPriceValueChange: (String) -> Unit = {},
    val onDescriptionValueChange: (String) -> Unit = {},
    val onSaveClick: () -> Unit = {}
) {
    fun isShowImage(): Boolean {
        return url.isNotBlank()
    }
}