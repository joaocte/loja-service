package br.com.curso.service.model

import java.math.BigDecimal

data class VeiculoResponse( val id : Long,
                            val modelo : String,
                            val marca : String,
                            val anoFabricacao : String,
                            val anoModelo  : String,
                            val placa : String,
                            val valor : BigDecimal
                            )
