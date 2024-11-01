package br.com.shaft.aluvery.sampledata

import br.com.shaft.aluvery.R
import br.com.shaft.aluvery.models.Product
import java.math.BigDecimal

val sampleProducts = listOf(
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
)