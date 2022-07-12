package br.com.curso.domain

import java.math.BigDecimal

data class Venda (
    val id: Long,
    val nomeCliente : String,
    val veiculos : List<Veiculo>,
    val valor : BigDecimal,
    val parcelas : List<Parcela>
)