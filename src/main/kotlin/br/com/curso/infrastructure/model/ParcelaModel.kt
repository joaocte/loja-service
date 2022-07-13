package br.com.curso.infrastructure.model

import io.micronaut.data.annotation.Id
import io.micronaut.serde.annotation.Serdeable
import java.math.BigDecimal
import java.time.LocalDate
@Serdeable.Deserializable
@Serdeable.Serializable
data class ParcelaModel (
    val numeroParcela : Long,
    val valorParcela : BigDecimal,
    val dataVencimento : LocalDate
        )