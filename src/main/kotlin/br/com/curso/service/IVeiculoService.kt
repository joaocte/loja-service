package br.com.curso.service

import br.com.curso.service.model.VeiculoResponse
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client("http://localhost:8080")
interface IVeiculoService {
    @Get("/veiculos/{id}")
    fun obterVeiculoPorId(@PathVariable id: Long) : VeiculoResponse
}