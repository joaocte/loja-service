package br.com.curso.service

import br.com.curso.service.client.httpClient.IVeiculoClient
import br.com.curso.service.client.redis.RedisClient
import br.com.curso.service.model.VeiculoResponse
import io.micronaut.http.annotation.PathVariable
import jakarta.inject.Singleton

@Singleton
class VeiculoService (
    private val client : IVeiculoClient,
    private val redisClient: RedisClient
) : IVeiculoService
{

    override fun obterVeiculoPorId(@PathVariable id: Long) : VeiculoResponse{
        var veiculo = client.obterVeiculoPorId(id)
        redisClient.set(veiculo)
        return veiculo
    }
}