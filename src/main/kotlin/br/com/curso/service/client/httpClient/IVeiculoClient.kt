package br.com.curso.service.client.httpClient

import br.com.curso.service.model.VeiculoResponse
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.micronaut.retry.annotation.CircuitBreaker

@Client("veiculo-service")
@CircuitBreaker
interface IVeiculoClient {
    @Get("/veiculos/{id}")
    fun obterVeiculoPorId(@PathVariable id: Long) : VeiculoResponse
}