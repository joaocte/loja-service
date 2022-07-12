package br.com.curso.infrastructure.model

import java.math.BigDecimal

data class VendaModel (
    val id: Long,
    val nomeCliente : String,
    val veiculos : List<VeiculoModel>,
    val valor : BigDecimal,
    val parcelas : List<ParcelaModel>
)