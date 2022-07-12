package br.com.curso.domain

import java.math.BigDecimal
import java.time.LocalDate

data class Parcela (
    val numeroParcela : Long,
    val valorParcela : BigDecimal,
    val dataVencimento : LocalDate
        )