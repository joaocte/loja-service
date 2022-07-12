package br.com.curso.infrastructure.model

import java.math.BigDecimal
import java.time.LocalDate

data class ParcelaModel (
    val numeroParcela : Long,
    val valorParcela : BigDecimal,
    val dataVencimento : LocalDate
        )