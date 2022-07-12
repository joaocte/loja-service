package br.com.curso.controller.request

import java.math.BigDecimal

data class RealizarVendaRequest(

    val nomeCliente : String,
    val idVeiculos : List<Long>,
    val numeroParcelas : Long
    )