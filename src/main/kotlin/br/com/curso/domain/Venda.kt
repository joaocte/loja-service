package br.com.curso.domain

import java.math.BigDecimal

data class Venda (
    val id: String?,
    val nomeCliente : String,
    val veiculo : Veiculo,
    val valor : BigDecimal,
    val parcelas : List<Parcela>
)