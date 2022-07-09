package br.com.curso.application.`in`

import java.math.BigDecimal

data class RealizarVendaCommand(
    val nomeCliente : String,
    val idVeiculos : List<Long>,
    val valorCompra : BigDecimal,
    val numeroParcelas : Int
    )