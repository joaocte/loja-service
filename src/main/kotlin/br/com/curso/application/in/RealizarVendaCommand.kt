package br.com.curso.application.`in`

import java.math.BigDecimal

data class RealizarVendaCommand(
    val nomeCliente : String,
    val idVeiculo : Long,
    val numeroParcelas : Long
    )
