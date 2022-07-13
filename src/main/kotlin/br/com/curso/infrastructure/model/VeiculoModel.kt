package br.com.curso.infrastructure.model

import io.micronaut.data.annotation.Id
import io.micronaut.serde.annotation.Serdeable
import java.math.BigDecimal


@Serdeable.Deserializable
@Serdeable.Serializable
data class VeiculoModel(

    val id : Long,
                   val modelo : String,
                   val marca : String,
                   val anoFabricacao : String,
                   val anoModelo  : String,
                   val placa : String,
                   val valor : BigDecimal
)