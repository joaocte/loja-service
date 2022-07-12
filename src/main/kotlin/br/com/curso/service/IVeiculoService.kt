package br.com.curso.service

import br.com.curso.service.model.VeiculoResponse
import io.micronaut.http.annotation.PathVariable


interface IVeiculoService
 {
     fun obterVeiculoPorId(@PathVariable id: Long) : VeiculoResponse
}