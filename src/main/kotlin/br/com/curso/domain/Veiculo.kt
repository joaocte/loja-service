package br.com.curso.domain

import java.math.BigDecimal

class Veiculo(val id : Long,
              val modelo : String,
              val marca : String,
              val anoFabricacao : String,
              val anoModelo  : String,
              val placa : String,
              val valor : BigDecimal
)