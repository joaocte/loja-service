package br.com.curso.infrastructure.model

import java.math.BigDecimal

class VeiculoModel(val id : Long,
                   val modelo : String,
                   val marca : String,
                   val anoFabricacao : String,
                   val anoModelo  : String,
                   val placa : String,
                   val valor : BigDecimal
)