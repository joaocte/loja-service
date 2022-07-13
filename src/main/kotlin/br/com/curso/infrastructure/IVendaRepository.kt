package br.com.curso.infrastructure

import br.com.curso.infrastructure.model.VendaModel
import io.micronaut.data.mongodb.annotation.MongoRepository
import io.micronaut.data.repository.CrudRepository

@MongoRepository()
interface IVendaRepository : CrudRepository<VendaModel, String> {
}