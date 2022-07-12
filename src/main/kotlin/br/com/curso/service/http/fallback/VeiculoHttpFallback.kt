package br.com.curso.service.http.fallback

import br.com.curso.service.client.httpClient.IVeiculoClient
import br.com.curso.service.model.VeiculoResponse
import com.fasterxml.jackson.databind.ObjectMapper
import io.micronaut.retry.annotation.Fallback
import redis.clients.jedis.JedisPool
import redis.clients.jedis.JedisPoolConfig

@Fallback
class VeiculoHttpFallback (private  val objectMapper: ObjectMapper) : IVeiculoClient {
    override fun obterVeiculoPorId(id: Long): VeiculoResponse {
        println("FallBack")
        val jedisPool = JedisPool(JedisPoolConfig(),"127.0.0.1",6379)
        val resource = jedisPool.resource
        val veiculoJson = resource.get(id.toString())

        return objectMapper.readValue(veiculoJson, VeiculoResponse::class.java)

    }
}