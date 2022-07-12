package br.com.curso.service.client.redis

import br.com.curso.extension.GenericExtensionFunction
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.inject.Singleton
import redis.clients.jedis.Jedis
import redis.clients.jedis.JedisPool
import redis.clients.jedis.JedisPoolConfig

@Singleton
class RedisClient(val objectMapper: ObjectMapper)
{
    private val host: String = "127.0.0.1"
    private val port : Int = 6379
    val resource :  Jedis = JedisPool(JedisPoolConfig(), host, port).resource

    fun <T : Any> set(t: T)
    {
        var id = GenericExtensionFunction.ReadInstanceProperty<Long>(t,"id")

        if(!resource.exists(id.toString()))
            resource.set(id.toString(), objectMapper.writeValueAsString(t))
    }
    inline fun <reified T> get(id: String) : T
    {
        val veiculoJson = resource.get(id.toString())

        return objectMapper.readValue(veiculoJson, T::class.java)
    }

}