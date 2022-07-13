package br.com.curso.producer

import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaClient
interface IVendaProducer {

    @Topic("ms-vendas")
    fun send(@KafkaKey eventId: String, event:String)
}