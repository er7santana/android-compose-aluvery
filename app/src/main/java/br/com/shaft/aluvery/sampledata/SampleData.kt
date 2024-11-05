package br.com.shaft.aluvery.sampledata

import br.com.shaft.aluvery.R
import br.com.shaft.aluvery.models.Product
import java.math.BigDecimal

val sampleCandies = listOf(
    Product(
        name = "Chocolate",
        price = BigDecimal("3.99"),
        image = "https://firebasestorage.googleapis.com/v0/b/alura-square-f83d3.firebasestorage.app/o/aluvery%2Fchocolate.jpeg?alt=media&token=63cb5f17-d6f9-49cb-873b-57b9b83c1e7a",
    ),
    Product(
        name = "Sorvete",
        price = BigDecimal("5.99"),
        image = "https://firebasestorage.googleapis.com/v0/b/alura-square-f83d3.firebasestorage.app/o/aluvery%2Fsorvete.jpeg?alt=media&token=965fa040-53d0-42be-865a-e2972dc85581",
    ),
    Product(
        name = "Bolo",
        price = BigDecimal("11.99"),
        image = "https://firebasestorage.googleapis.com/v0/b/alura-square-f83d3.firebasestorage.app/o/aluvery%2Fbolo.jpeg?alt=media&token=1cada7a1-c1f1-48a6-903b-1cc34e71c07c",
    )
)
val sampleDrinks = listOf(
    Product(
        name = "Cerveja",
        price = BigDecimal("5.99"),
        image = "https://firebasestorage.googleapis.com/v0/b/alura-square-f83d3.firebasestorage.app/o/aluvery%2Fcerveja.jpeg?alt=media&token=a6573315-1125-4c63-a5b0-6abd797eb850",
    ),
    Product(
        name = "Refrigerante",
        price = BigDecimal("4.99"),
        image = "https://firebasestorage.googleapis.com/v0/b/alura-square-f83d3.firebasestorage.app/o/aluvery%2Frefrigerante.jpeg?alt=media&token=c051536e-d3f6-43c5-b01c-0c6d7fad0344"
    ),
    Product(
        name = "Suco",
        price = BigDecimal("7.99"),
        image = "https://firebasestorage.googleapis.com/v0/b/alura-square-f83d3.firebasestorage.app/o/aluvery%2Fsuco.jpeg?alt=media&token=25831723-db29-4145-be4a-a4883da9c644"
    ),
    Product(
        name = "Água",
        price = BigDecimal("2.99"),
        image = "https://firebasestorage.googleapis.com/v0/b/alura-square-f83d3.firebasestorage.app/o/aluvery%2Fagua.jpeg?alt=media&token=5f5c97b2-a541-48ea-ad60-cd55a4ab2d14"
    )
)

val sampleProducts = listOf(
    Product(
        "Hamburguer",
        BigDecimal(14.99),
        image = "https://firebasestorage.googleapis.com/v0/b/alura-square-f83d3.firebasestorage.app/o/aluvery%2Fhamburger.jpeg?alt=media&token=c2eb5ab7-5a83-432d-ab12-a1efbfaca2bf"
    ),
    Product(
        "Batata frita",
        BigDecimal(19.99),
        image = "https://firebasestorage.googleapis.com/v0/b/alura-square-f83d3.firebasestorage.app/o/aluvery%2Fbatata-frita.jpeg?alt=media&token=ab7c303e-1a92-4671-ad27-7c4d2a08f6cc"
    ),
    Product(
        "Pizza",
        BigDecimal(24.99),
        image = "https://firebasestorage.googleapis.com/v0/b/alura-square-f83d3.firebasestorage.app/o/aluvery%2Fpizza.jpeg?alt=media&token=2daa6979-b337-46b4-a4fb-dbec83c228a1"
    ), *sampleDrinks.toTypedArray(), *sampleCandies.toTypedArray()
)

val sampleSections = mapOf(
    "Promoções" to sampleProducts,
    "Doces" to sampleCandies,
    "Bebidas" to sampleDrinks
)