package br.com.curso.controller.request

import java.math.BigDecimal

data class RealizarVendaRequest(

    val nomeCliente : String,
    val idVeiculo : Long,
    val numeroParcelas : Long
    )