package br.com.curso.infrastructure.model

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.serde.annotation.SerdeImport
import io.micronaut.serde.annotation.Serdeable
import java.math.BigDecimal


@MappedEntity("venda")
@Serdeable.Deserializable
@Serdeable.Serializable
data class VendaModel (@field:Id @GeneratedValue
    val id: String?,
    val nomeCliente : String,
    val veiculo : VeiculoModel,
    val valor : BigDecimal,
    val parcelas : List<ParcelaModel>
)